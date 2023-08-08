package com.smartcity.energystorage;

import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class EnergyStorageImpl extends EnergyStorageGrpc.EnergyStorageImplBase {

    private double storedEnergy = 0.0;
    private JmDNS jmdns;
    private ServiceInfo serviceInfo;

    public EnergyStorageImpl() {
        try {
            jmdns = JmDNS.create();
            serviceInfo = ServiceInfo.create("_energystorage._tcp.local.", "EnergyStorageService", 50051, "Energy Storage Service");
            jmdns.registerService(serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeEnergy(StoreEnergyRequest request, StreamObserver<StoreEnergyResponse> responseObserver) {
        double energyAmount = request.getEnergyAmount();
        storedEnergy += energyAmount;

        StoreEnergyResponse response = StoreEnergyResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void shutdown() {
        jmdns.unregisterService(serviceInfo);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        EnergyStorageImpl energyStorageService = new EnergyStorageImpl();

        int port = 50051; // Set the port number
        Server server = ServerBuilder.forPort(port)
            .addService(energyStorageService) // Add the Energy Storage service
            .build();
        server.start();

        System.out.println("Energy Storage Server started on port " + port);

        // Add shutdown hook to ensure proper cleanup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Energy Storage server...");
            energyStorageService.shutdown();
        }));

        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();
    }
}
