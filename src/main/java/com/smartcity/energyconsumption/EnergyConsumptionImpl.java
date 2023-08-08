package com.smartcity.energyconsumption;

import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class EnergyConsumptionImpl extends EnergyConsumptionGrpc.EnergyConsumptionImplBase {

    private double availableEnergy = 0.0; // Initial available energy
    private JmDNS jmdns;
    private ServiceInfo serviceInfo;

    public EnergyConsumptionImpl() {
        try {
            jmdns = JmDNS.create();
            serviceInfo = ServiceInfo.create("_energyconsumption._tcp.local.", "EnergyConsumptionService", 50052, "Energy Consumption Service");
            jmdns.registerService(serviceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consumeEnergy(ConsumeEnergyRequest request, StreamObserver<ConsumeEnergyResponse> responseObserver) {
        double energyAmount = request.getEnergyAmount();

        if (availableEnergy >= energyAmount) {
            availableEnergy -= energyAmount;
            ConsumeEnergyResponse response = ConsumeEnergyResponse.newBuilder().setSuccess(true).build();
            responseObserver.onNext(response);
        } else {
            ConsumeEnergyResponse response = ConsumeEnergyResponse.newBuilder().setSuccess(false).build();
            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }

    public void shutdown() {
        jmdns.unregisterService(serviceInfo);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        EnergyConsumptionImpl energyConsumptionService = new EnergyConsumptionImpl();

        int port = 50052; // Set the port number
        Server server = ServerBuilder.forPort(port)
            .addService(energyConsumptionService) // Add the Energy Consumption service
            .build();
        server.start();

        System.out.println("Energy Consumption Server started on port " + port);

        // The server will continue running until it is explicitly shut down.
        server.awaitTermination();

        // Shutdown the JmDNS service when the gRPC server is shut down
        energyConsumptionService.shutdown();
    }
}
