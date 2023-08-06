package com.smartcity.energystorage;

import io.grpc.stub.StreamObserver;


public class EnergyStorageImpl extends EnergyStorageGrpc.EnergyStorageImplBase {

    private double storedEnergy = 0.0;

    @Override
    public void storeEnergy(StoreEnergyRequest request, StreamObserver<StoreEnergyResponse> responseObserver) {
        double energyAmount = request.getEnergyAmount();
        storedEnergy += energyAmount;

        StoreEnergyResponse response = StoreEnergyResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
