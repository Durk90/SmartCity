package com.smartcity.energystorage;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class EnergyStorageServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create an instance of EnergyStorageImpl
        EnergyStorageImpl energyStorageService = new EnergyStorageImpl();

        // Create and start the gRPC server for Energy Storage service
        int port = 50051; // Set the desired port number
        Server server = ServerBuilder.forPort(port)
            .addService(energyStorageService) // Add the Energy Storage service
            .build();
        server.start();

        System.out.println("Energy Storage Server started on port " + port);

        // Keep the main thread alive by waiting indefinitely
        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }
}
