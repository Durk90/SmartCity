package com.smartcity.energystorage;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;

public class EnergyStorageServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create an instance of EnergyStorageImpl
        EnergyStorageImpl energyStorageService = new EnergyStorageImpl();

        // Create and start the gRPC server for Energy Storage service
        int port = 50051; // Set the port number
        Server server = ServerBuilder.forPort(port)
            .addService(energyStorageService) // Add the Energy Storage service
            .build();
        server.start();

        System.out.println("Energy Storage Server started on port " + port);

        // Register the service with JmDNS
        registerWithJmDNS(port);

        // Add shutdown hook to ensure proper cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Energy Storage server...");
            energyStorageService.shutdown();
        }));

        // Keep the main thread alive by waiting indefinitely
        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }

    // Register the service with JmDNS
    private static void registerWithJmDNS(int port) {
        try {
            JmDNS jmdns = JmDNS.create();
            ServiceInfo serviceInfo = ServiceInfo.create("_energystorage._tcp.local.", "EnergyStorageService", port, "Energy Storage Service");
            jmdns.registerService(serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
