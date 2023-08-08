package com.smartcity.solarpanels;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;

public class SolarPanelsServer {
    private static Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create an instance of SolarPanelsImpl
        SolarPanelsImpl solarPanelsService = new SolarPanelsImpl();

        // Create and start the gRPC server for Solar Panels service
        int port = 50053; // Set the port number
        server = ServerBuilder.forPort(port)
            .addService(solarPanelsService) // Add the Solar Panels service
            .build();
        server.start();

        System.out.println("Solar Panels Server started on port " + port);

        // Register the service with JmDNS
        registerWithJmDNS(port);

        // Add shutdown hook to ensure proper cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Solar Panels server...");
            solarPanelsService.shutdown();
            server.shutdown();
        }));

        // Keep the main thread alive by waiting indefinitely
        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }

    // Register the service with JmDNS
    private static void registerWithJmDNS(int port) {
        try {
            JmDNS jmdns = JmDNS.create();
            ServiceInfo serviceInfo = ServiceInfo.create("_solarpanels._tcp.local.", "SolarPanelsService", port, "Solar Panels Service");
            jmdns.registerService(serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
