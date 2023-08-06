package com.smartcity.solarpanels;

import io.grpc.stub.StreamObserver;


public class SolarPanelsImpl extends SolarPanelsGrpc.SolarPanelsImplBase {

    @Override
    public void generateEnergy(GenerateEnergyRequest request, StreamObserver<GenerateEnergyResponse> responseObserver) {
        double sunExposure = request.getSunExposure();

        // Simulate energy generation based on sun exposure
        double energyGenerated = sunExposure * 10; // A simple linear relationship 

        GenerateEnergyResponse response = GenerateEnergyResponse.newBuilder().setEnergyGenerated(energyGenerated).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
