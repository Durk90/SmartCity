package com.smartcity.energyconsumption;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the Energy Consumption service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: EnergyConsumption.proto")
public final class EnergyConsumptionGrpc {

  private EnergyConsumptionGrpc() {}

  public static final String SERVICE_NAME = "energyconsumption.EnergyConsumption";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartcity.energyconsumption.ConsumeEnergyRequest,
      com.smartcity.energyconsumption.ConsumeEnergyResponse> getConsumeEnergyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "consumeEnergy",
      requestType = com.smartcity.energyconsumption.ConsumeEnergyRequest.class,
      responseType = com.smartcity.energyconsumption.ConsumeEnergyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartcity.energyconsumption.ConsumeEnergyRequest,
      com.smartcity.energyconsumption.ConsumeEnergyResponse> getConsumeEnergyMethod() {
    io.grpc.MethodDescriptor<com.smartcity.energyconsumption.ConsumeEnergyRequest, com.smartcity.energyconsumption.ConsumeEnergyResponse> getConsumeEnergyMethod;
    if ((getConsumeEnergyMethod = EnergyConsumptionGrpc.getConsumeEnergyMethod) == null) {
      synchronized (EnergyConsumptionGrpc.class) {
        if ((getConsumeEnergyMethod = EnergyConsumptionGrpc.getConsumeEnergyMethod) == null) {
          EnergyConsumptionGrpc.getConsumeEnergyMethod = getConsumeEnergyMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.energyconsumption.ConsumeEnergyRequest, com.smartcity.energyconsumption.ConsumeEnergyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "energyconsumption.EnergyConsumption", "consumeEnergy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.energyconsumption.ConsumeEnergyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.energyconsumption.ConsumeEnergyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EnergyConsumptionMethodDescriptorSupplier("consumeEnergy"))
                  .build();
          }
        }
     }
     return getConsumeEnergyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnergyConsumptionStub newStub(io.grpc.Channel channel) {
    return new EnergyConsumptionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnergyConsumptionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EnergyConsumptionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnergyConsumptionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EnergyConsumptionFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the Energy Consumption service.
   * </pre>
   */
  public static abstract class EnergyConsumptionImplBase implements io.grpc.BindableService {

    /**
     */
    public void consumeEnergy(com.smartcity.energyconsumption.ConsumeEnergyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.energyconsumption.ConsumeEnergyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getConsumeEnergyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConsumeEnergyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartcity.energyconsumption.ConsumeEnergyRequest,
                com.smartcity.energyconsumption.ConsumeEnergyResponse>(
                  this, METHODID_CONSUME_ENERGY)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the Energy Consumption service.
   * </pre>
   */
  public static final class EnergyConsumptionStub extends io.grpc.stub.AbstractStub<EnergyConsumptionStub> {
    private EnergyConsumptionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyConsumptionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyConsumptionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyConsumptionStub(channel, callOptions);
    }

    /**
     */
    public void consumeEnergy(com.smartcity.energyconsumption.ConsumeEnergyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.energyconsumption.ConsumeEnergyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConsumeEnergyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the Energy Consumption service.
   * </pre>
   */
  public static final class EnergyConsumptionBlockingStub extends io.grpc.stub.AbstractStub<EnergyConsumptionBlockingStub> {
    private EnergyConsumptionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyConsumptionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyConsumptionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyConsumptionBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartcity.energyconsumption.ConsumeEnergyResponse consumeEnergy(com.smartcity.energyconsumption.ConsumeEnergyRequest request) {
      return blockingUnaryCall(
          getChannel(), getConsumeEnergyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the Energy Consumption service.
   * </pre>
   */
  public static final class EnergyConsumptionFutureStub extends io.grpc.stub.AbstractStub<EnergyConsumptionFutureStub> {
    private EnergyConsumptionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyConsumptionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyConsumptionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyConsumptionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartcity.energyconsumption.ConsumeEnergyResponse> consumeEnergy(
        com.smartcity.energyconsumption.ConsumeEnergyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getConsumeEnergyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONSUME_ENERGY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnergyConsumptionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnergyConsumptionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONSUME_ENERGY:
          serviceImpl.consumeEnergy((com.smartcity.energyconsumption.ConsumeEnergyRequest) request,
              (io.grpc.stub.StreamObserver<com.smartcity.energyconsumption.ConsumeEnergyResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EnergyConsumptionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnergyConsumptionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartcity.energyconsumption.EnergyConsumptionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EnergyConsumption");
    }
  }

  private static final class EnergyConsumptionFileDescriptorSupplier
      extends EnergyConsumptionBaseDescriptorSupplier {
    EnergyConsumptionFileDescriptorSupplier() {}
  }

  private static final class EnergyConsumptionMethodDescriptorSupplier
      extends EnergyConsumptionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnergyConsumptionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EnergyConsumptionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnergyConsumptionFileDescriptorSupplier())
              .addMethod(getConsumeEnergyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
