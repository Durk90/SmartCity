package com.smartcity.energystorage;

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
 * Interface exported by the Energy Storage service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: EnergyStorage.proto")
public final class EnergyStorageGrpc {

  private EnergyStorageGrpc() {}

  public static final String SERVICE_NAME = "energystorage.EnergyStorage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartcity.energystorage.StoreEnergyRequest,
      com.smartcity.energystorage.StoreEnergyResponse> getStoreEnergyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "storeEnergy",
      requestType = com.smartcity.energystorage.StoreEnergyRequest.class,
      responseType = com.smartcity.energystorage.StoreEnergyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartcity.energystorage.StoreEnergyRequest,
      com.smartcity.energystorage.StoreEnergyResponse> getStoreEnergyMethod() {
    io.grpc.MethodDescriptor<com.smartcity.energystorage.StoreEnergyRequest, com.smartcity.energystorage.StoreEnergyResponse> getStoreEnergyMethod;
    if ((getStoreEnergyMethod = EnergyStorageGrpc.getStoreEnergyMethod) == null) {
      synchronized (EnergyStorageGrpc.class) {
        if ((getStoreEnergyMethod = EnergyStorageGrpc.getStoreEnergyMethod) == null) {
          EnergyStorageGrpc.getStoreEnergyMethod = getStoreEnergyMethod = 
              io.grpc.MethodDescriptor.<com.smartcity.energystorage.StoreEnergyRequest, com.smartcity.energystorage.StoreEnergyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "energystorage.EnergyStorage", "storeEnergy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.energystorage.StoreEnergyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartcity.energystorage.StoreEnergyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EnergyStorageMethodDescriptorSupplier("storeEnergy"))
                  .build();
          }
        }
     }
     return getStoreEnergyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnergyStorageStub newStub(io.grpc.Channel channel) {
    return new EnergyStorageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnergyStorageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EnergyStorageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnergyStorageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EnergyStorageFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the Energy Storage service.
   * </pre>
   */
  public static abstract class EnergyStorageImplBase implements io.grpc.BindableService {

    /**
     */
    public void storeEnergy(com.smartcity.energystorage.StoreEnergyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.energystorage.StoreEnergyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStoreEnergyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStoreEnergyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartcity.energystorage.StoreEnergyRequest,
                com.smartcity.energystorage.StoreEnergyResponse>(
                  this, METHODID_STORE_ENERGY)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the Energy Storage service.
   * </pre>
   */
  public static final class EnergyStorageStub extends io.grpc.stub.AbstractStub<EnergyStorageStub> {
    private EnergyStorageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyStorageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyStorageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyStorageStub(channel, callOptions);
    }

    /**
     */
    public void storeEnergy(com.smartcity.energystorage.StoreEnergyRequest request,
        io.grpc.stub.StreamObserver<com.smartcity.energystorage.StoreEnergyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStoreEnergyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the Energy Storage service.
   * </pre>
   */
  public static final class EnergyStorageBlockingStub extends io.grpc.stub.AbstractStub<EnergyStorageBlockingStub> {
    private EnergyStorageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyStorageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyStorageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyStorageBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartcity.energystorage.StoreEnergyResponse storeEnergy(com.smartcity.energystorage.StoreEnergyRequest request) {
      return blockingUnaryCall(
          getChannel(), getStoreEnergyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the Energy Storage service.
   * </pre>
   */
  public static final class EnergyStorageFutureStub extends io.grpc.stub.AbstractStub<EnergyStorageFutureStub> {
    private EnergyStorageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyStorageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyStorageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyStorageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartcity.energystorage.StoreEnergyResponse> storeEnergy(
        com.smartcity.energystorage.StoreEnergyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStoreEnergyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STORE_ENERGY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnergyStorageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnergyStorageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STORE_ENERGY:
          serviceImpl.storeEnergy((com.smartcity.energystorage.StoreEnergyRequest) request,
              (io.grpc.stub.StreamObserver<com.smartcity.energystorage.StoreEnergyResponse>) responseObserver);
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

  private static abstract class EnergyStorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnergyStorageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartcity.energystorage.EnergyStorageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EnergyStorage");
    }
  }

  private static final class EnergyStorageFileDescriptorSupplier
      extends EnergyStorageBaseDescriptorSupplier {
    EnergyStorageFileDescriptorSupplier() {}
  }

  private static final class EnergyStorageMethodDescriptorSupplier
      extends EnergyStorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnergyStorageMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnergyStorageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnergyStorageFileDescriptorSupplier())
              .addMethod(getStoreEnergyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
