package com.smartcity.solarpanels;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class SolarPanelsServer {
    private static Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create an instance of SolarPanelsImpl
        SolarPanelsImpl solarPanelsService = new SolarPanelsImpl();

        // Create and start the gRPC server for Solar Panels service
        int port = 50053; // Set the desired port number
        server = ServerBuilder.forPort(port)
            .addService(solarPanelsService) // Add the Solar Panels service
            .build();
        server.start();

        System.out.println("Solar Panels Server started on port " + port);

        // Keep the main thread alive by waiting indefinitely
        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }
}
