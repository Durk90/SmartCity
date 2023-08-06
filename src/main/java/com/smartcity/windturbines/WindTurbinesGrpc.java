package com.smartcity.windturbines;

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

import com.smartcity.solarpanels.GenerateEnergyRequest;

/**
 * <pre>
 * Interface exported by the Wind Turbines service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: WindTurbine.proto")
public final class WindTurbinesGrpc {

  private WindTurbinesGrpc() {}

  public static final String SERVICE_NAME = "windturbines.WindTurbines";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartcity.windturbines.GenerateEnergyRequest,
      com.smartcity.windturbines.GenerateEnergyResponse> getGenerateEnergyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generateEnergy",
      requestType = com.smartcity.windturbines.GenerateEnergyRequest.class,
      responseType = com.smartcity.windturbines.GenerateEnergyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartcity.windturbines.GenerateEnergyRequest,
      com.smartcity.windturbines.GenerateEnergyResponse> getGenerateEnergyMethod() {
    io.grpc.MethodDescriptor<com.smartcity.windturbines.GenerateEnergyRequest, com.smartcity.windturbines.GenerateEnergyResponse> getGenerateEnergyMethod;
    if ((getGenerateEnergyMethod = WindTurbinesGrpc.getGenerateEnergyMethod) == null) {
      synchronized (WindTurbinesGrpc.class) {
        if ((getGenerateEnergyMethod = WindTurbinesGrpc.getGenerateEnergyMethod) == null) {
          WindTurbinesGrpc.getGenerateEnergyMethod = getGenerateEnergyMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.windturbines.GenerateEnergyRequest, com.smartcity.windturbines.GenerateEnergyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "windturbines.WindTurbines", "generateEnergy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.windturbines.GenerateEnergyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.windturbines.GenerateEnergyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WindTurbinesMethodDescriptorSupplier("generateEnergy"))
                  .build();
          }
        }
     }
     return getGenerateEnergyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WindTurbinesStub newStub(io.grpc.Channel channel) {
    return new WindTurbinesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WindTurbinesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WindTurbinesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WindTurbinesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WindTurbinesFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the Wind Turbines service.
   * </pre>
   */
  public static abstract class WindTurbinesImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateEnergy(com.smartcity.windturbines.GenerateEnergyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.windturbines.GenerateEnergyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateEnergyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateEnergyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartcity.windturbines.GenerateEnergyRequest,
                com.smartcity.windturbines.GenerateEnergyResponse>(
                  this, METHODID_GENERATE_ENERGY)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the Wind Turbines service.
   * </pre>
   */
  public static final class WindTurbinesStub extends io.grpc.stub.AbstractStub<WindTurbinesStub> {
    private WindTurbinesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WindTurbinesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WindTurbinesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WindTurbinesStub(channel, callOptions);
    }

    /**
     */
    public void generateEnergy(com.smartcity.windturbines.GenerateEnergyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.windturbines.GenerateEnergyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateEnergyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the Wind Turbines service.
   * </pre>
   */
  public static final class WindTurbinesBlockingStub extends io.grpc.stub.AbstractStub<WindTurbinesBlockingStub> {
    private WindTurbinesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WindTurbinesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WindTurbinesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WindTurbinesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartcity.windturbines.GenerateEnergyResponse generateEnergy(com.smartcity.windturbines.GenerateEnergyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateEnergyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the Wind Turbines service.
   * </pre>
   */
  public static final class WindTurbinesFutureStub extends io.grpc.stub.AbstractStub<WindTurbinesFutureStub> {
    private WindTurbinesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WindTurbinesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WindTurbinesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WindTurbinesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartcity.windturbines.GenerateEnergyResponse> generateEnergy(
        com.smartcity.windturbines.GenerateEnergyRequest request) {
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
    private final WindTurbinesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WindTurbinesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_ENERGY:
          serviceImpl.generateEnergy((com.smartcity.windturbines.GenerateEnergyRequest) request,
              (io.grpc.stub.StreamObserver<com.smartcity.windturbines.GenerateEnergyResponse>) responseObserver);
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

  private static abstract class WindTurbinesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WindTurbinesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartcity.windturbines.WindTurbinesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WindTurbines");
    }
  }

  private static final class WindTurbinesFileDescriptorSupplier
      extends WindTurbinesBaseDescriptorSupplier {
    WindTurbinesFileDescriptorSupplier() {}
  }

  private static final class WindTurbinesMethodDescriptorSupplier
      extends WindTurbinesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WindTurbinesMethodDescriptorSupplier(String methodName) {
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
      synchronized (WindTurbinesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WindTurbinesFileDescriptorSupplier())
              .addMethod(getGenerateEnergyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
