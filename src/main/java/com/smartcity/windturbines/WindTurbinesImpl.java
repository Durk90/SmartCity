package com.smartcity.windturbines;

import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class WindTurbinesImpl extends com.smartcity.windturbines.WindTurbinesGrpc.WindTurbinesImplBase {

    private JmDNS jmdns;
    private ServiceInfo serviceInfo;

    public WindTurbinesImpl() {
        try {
            jmdns = JmDNS.create();
            serviceInfo = ServiceInfo.create("_windturbines._tcp.local.", "WindTurbinesService", 50054, "Wind Turbines Service");
            jmdns.registerService(serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateEnergy(GenerateEnergyRequest request, StreamObserver<GenerateEnergyResponse> responseObserver) {
        double windSpeed = request.getWindSpeed();

        // Simulate energy generation based on wind speed
        double energyGenerated = windSpeed * 15; // Simulate power conversion 

        GenerateEnergyResponse response = GenerateEnergyResponse.newBuilder().setEnergyGenerated(energyGenerated).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void shutdown() {
        jmdns.unregisterService(serviceInfo);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        WindTurbinesImpl windTurbinesService = new WindTurbinesImpl();

        int port = 50054; // Set the port number
        Server server = ServerBuilder.forPort(port)
            .addService(windTurbinesService) // Add the Wind Turbines service
            .build();
        server.start();

        System.out.println("Wind Turbines Server started on port " + port);

        // Add shutdown hook to ensure proper cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Wind Turbines server...");
            windTurbinesService.shutdown();
        }));

        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }
}
