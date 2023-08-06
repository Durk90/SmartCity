package com.smartcity.windturbines;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class WindTurbinesServer {
    private static Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create an instance of WindTurbinesImpl
        WindTurbinesImpl windTurbinesService = new WindTurbinesImpl();

        // Create and start the gRPC server for Wind Turbines service
        int port = 50054; // Set the desired port number
        server = ServerBuilder.forPort(port)
            .addService(windTurbinesService) // Add the Wind Turbines service
            .build();
        server.start();

        System.out.println("Wind Turbines Server started on port " + port);

        // Keep the main thread alive by waiting indefinitely
        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }
}
