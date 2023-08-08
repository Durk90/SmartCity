package com.smartcity.solarpanels;

import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SolarPanelsImpl extends SolarPanelsGrpc.SolarPanelsImplBase {

    private JmDNS jmdns;
    private ServiceInfo serviceInfo;

    public SolarPanelsImpl() {
        try {
            jmdns = JmDNS.create();
            serviceInfo = ServiceInfo.create("_solarpanels._tcp.local.", "SolarPanelsService", 50053, "Solar Panels Service");
            jmdns.registerService(serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateEnergy(GenerateEnergyRequest request, StreamObserver<GenerateEnergyResponse> responseObserver) {
        double sunExposure = request.getSunExposure();

        // Simulate energy generation based on sun exposure
        double energyGenerated = sunExposure * 10; // Simulate power conversion  

        GenerateEnergyResponse response = GenerateEnergyResponse.newBuilder().setEnergyGenerated(energyGenerated).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void shutdown() {
        jmdns.unregisterService(serviceInfo);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SolarPanelsImpl solarPanelsService = new SolarPanelsImpl();

        int port = 50053; // Set the port number
        Server server = ServerBuilder.forPort(port)
            .addService(solarPanelsService) // Add the Solar Panels service
            .build();
        server.start();

        System.out.println("Solar Panels Server started on port " + port);

        // Add shutdown hook to ensure proper cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Solar Panels server...");
            solarPanelsService.shutdown();
        }));

        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }
}
