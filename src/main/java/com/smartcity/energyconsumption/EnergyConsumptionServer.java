package com.smartcity.energyconsumption;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class EnergyConsumptionServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create an instance of EnergyConsumptionImpl
        EnergyConsumptionImpl energyConsumptionService = new EnergyConsumptionImpl();

        // Create and start the gRPC server for Energy Consumption service
        int port = 50052; // Set the desired port number
        Server server = ServerBuilder.forPort(port)
            .addService(energyConsumptionService) // Add the Energy Consumption service
            .build();
        server.start();

        System.out.println("Energy Consumption Server started on port " + port);

        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }
}
