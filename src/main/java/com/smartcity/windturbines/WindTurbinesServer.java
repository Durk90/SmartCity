package com.smartcity.windturbines;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;

public class WindTurbinesServer {
    private static Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create an instance of WindTurbinesImpl
        WindTurbinesImpl windTurbinesService = new WindTurbinesImpl();

        // Create and start the gRPC server for Wind Turbines service
        int port = 50054; // Set the port number
        server = ServerBuilder.forPort(port)
            .addService(windTurbinesService) // Add the Wind Turbines service
            .build();
        server.start();

        System.out.println("Wind Turbines Server started on port " + port);

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
            ServiceInfo serviceInfo = ServiceInfo.create("_windturbines._tcp.local.", "WindTurbinesService", port, "Wind Turbines Service");
            jmdns.registerService(serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
