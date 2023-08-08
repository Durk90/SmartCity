package com.smartcity.energyconsumption;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;

public class EnergyConsumptionServer {
    private static Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create an instance of EnergyConsumptionImpl
        EnergyConsumptionImpl energyConsumptionService = new EnergyConsumptionImpl();

        // Create and start the gRPC server for Energy Consumption service
        int port = 50052; // Set the port number
        server = ServerBuilder.forPort(port)
            .addService(energyConsumptionService) // Add the Energy Consumption service
            .build();
        server.start();

        System.out.println("Energy Consumption Server started on port " + port);

        // Register the service with JmDNS
        registerWithJmDNS(port);

        // Keep the main thread alive by waiting indefinitely
        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }

    // Register the service with JmDNS
    private static void registerWithJmDNS(int port) {
        try {
            JmDNS jmdns = JmDNS.create();
            ServiceInfo serviceInfo = ServiceInfo.create("_energyconsumption._tcp.local.", "EnergyConsumptionService", port, "Energy Consumption Service");
            jmdns.registerService(serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
