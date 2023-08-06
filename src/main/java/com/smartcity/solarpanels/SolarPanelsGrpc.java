package com.smartcity.solarpanels;

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
 * Interface exported by the Solar Panels service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SolarPanel.proto")
public final class SolarPanelsGrpc {

  private SolarPanelsGrpc() {}

  public static final String SERVICE_NAME = "solarpanels.SolarPanels";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartcity.solarpanels.GenerateEnergyRequest,
      com.smartcity.solarpanels.GenerateEnergyResponse> getGenerateEnergyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generateEnergy",
      requestType = com.smartcity.solarpanels.GenerateEnergyRequest.class,
      responseType = com.smartcity.solarpanels.GenerateEnergyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartcity.solarpanels.GenerateEnergyRequest,
      com.smartcity.solarpanels.GenerateEnergyResponse> getGenerateEnergyMethod() {
    io.grpc.MethodDescriptor<com.smartcity.solarpanels.GenerateEnergyRequest, com.smartcity.solarpanels.GenerateEnergyResponse> getGenerateEnergyMethod;
    if ((getGenerateEnergyMethod = SolarPanelsGrpc.getGenerateEnergyMethod) == null) {
      synchronized (SolarPanelsGrpc.class) {
        if ((getGenerateEnergyMethod = SolarPanelsGrpc.getGenerateEnergyMethod) == null) {
          SolarPanelsGrpc.getGenerateEnergyMethod = getGenerateEnergyMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.solarpanels.GenerateEnergyRequest, com.smartcity.solarpanels.GenerateEnergyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "solarpanels.SolarPanels", "generateEnergy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.solarpanels.GenerateEnergyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.solarpanels.GenerateEnergyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SolarPanelsMethodDescriptorSupplier("generateEnergy"))
                  .build();
          }
        }
     }
     return getGenerateEnergyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SolarPanelsStub newStub(io.grpc.Channel channel) {
    return new SolarPanelsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SolarPanelsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SolarPanelsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SolarPanelsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SolarPanelsFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the Solar Panels service.
   * </pre>
   */
  public static abstract class SolarPanelsImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateEnergy(com.smartcity.solarpanels.GenerateEnergyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.solarpanels.GenerateEnergyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateEnergyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateEnergyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartcity.solarpanels.GenerateEnergyRequest,
                com.smartcity.solarpanels.GenerateEnergyResponse>(
                  this, METHODID_GENERATE_ENERGY)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the Solar Panels service.
   * </pre>
   */
  public static final class SolarPanelsStub extends io.grpc.stub.AbstractStub<SolarPanelsStub> {
    private SolarPanelsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SolarPanelsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SolarPanelsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SolarPanelsStub(channel, callOptions);
    }

    /**
     */
    public void generateEnergy(com.smartcity.solarpanels.GenerateEnergyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.solarpanels.GenerateEnergyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateEnergyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the Solar Panels service.
   * </pre>
   */
  public static final class SolarPanelsBlockingStub extends io.grpc.stub.AbstractStub<SolarPanelsBlockingStub> {
    private SolarPanelsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SolarPanelsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SolarPanelsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SolarPanelsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartcity.solarpanels.GenerateEnergyResponse generateEnergy(com.smartcity.solarpanels.GenerateEnergyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateEnergyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the Solar Panels service.
   * </pre>
   */
  public static final class SolarPanelsFutureStub extends io.grpc.stub.AbstractStub<SolarPanelsFutureStub> {
    private SolarPanelsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SolarPanelsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SolarPanelsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SolarPanelsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartcity.solarpanels.GenerateEnergyResponse> generateEnergy(
        com.smartcity.solarpanels.GenerateEnergyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateEnergyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_ENERGY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SolarPanelsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SolarPanelsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_ENERGY:
          serviceImpl.generateEnergy((com.smartcity.solarpanels.GenerateEnergyRequest) request,
              (io.grpc.stub.StreamObserver<com.smartcity.solarpanels.GenerateEnergyResponse>) responseObserver);
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

  private static abstract class SolarPanelsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SolarPanelsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartcity.solarpanels.SolarPanelsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SolarPanels");
    }
  }

  private static final class SolarPanelsFileDescriptorSupplier
      extends SolarPanelsBaseDescriptorSupplier {
    SolarPanelsFileDescriptorSupplier() {}
  }

  private static final class SolarPanelsMethodDescriptorSupplier
      extends SolarPanelsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SolarPanelsMethodDescriptorSupplier(String methodName) {
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
      synchronized (SolarPanelsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SolarPanelsFileDescriptorSupplier())
              .addMethod(getGenerateEnergyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
