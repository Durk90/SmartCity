package com.smartcity.energyconsumption;

import com.smartcity.energyconsumption.EnergyConsumptionGrpc.EnergyConsumptionImplBase;

import io.grpc.stub.StreamObserver;

public class EnergyConsumptionImpl extends EnergyConsumptionImplBase {

  private double availableEnergy = 100.0; // Initial available energy

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
}
