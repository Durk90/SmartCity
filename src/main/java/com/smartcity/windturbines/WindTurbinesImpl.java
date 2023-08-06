package com.smartcity.windturbines;

import io.grpc.stub.StreamObserver;


public class WindTurbinesImpl extends com.smartcity.windturbines.WindTurbinesGrpc.WindTurbinesImplBase {

    @Override
    public void generateEnergy(GenerateEnergyRequest request, StreamObserver<GenerateEnergyResponse> responseObserver) {
        double windSpeed = request.getWindSpeed();

        // Simulate energy generation based on wind speed
        double energyGenerated = windSpeed * 15; // A simple linear relationship (you can change this)

        GenerateEnergyResponse response = GenerateEnergyResponse.newBuilder().setEnergyGenerated(energyGenerated).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
