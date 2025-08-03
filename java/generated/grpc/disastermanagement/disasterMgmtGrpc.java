package generated.grpc.disastermanagement;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: DisasterManagement.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class disasterMgmtGrpc {

  private disasterMgmtGrpc() {}

  public static final String SERVICE_NAME = "disastermanagement.disasterMgmt";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.disastermanagement.waterLevelRequest,
      generated.grpc.disastermanagement.waterLevelResponse> getWaterLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "waterLevel",
      requestType = generated.grpc.disastermanagement.waterLevelRequest.class,
      responseType = generated.grpc.disastermanagement.waterLevelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.disastermanagement.waterLevelRequest,
      generated.grpc.disastermanagement.waterLevelResponse> getWaterLevelMethod() {
    io.grpc.MethodDescriptor<generated.grpc.disastermanagement.waterLevelRequest, generated.grpc.disastermanagement.waterLevelResponse> getWaterLevelMethod;
    if ((getWaterLevelMethod = disasterMgmtGrpc.getWaterLevelMethod) == null) {
      synchronized (disasterMgmtGrpc.class) {
        if ((getWaterLevelMethod = disasterMgmtGrpc.getWaterLevelMethod) == null) {
          disasterMgmtGrpc.getWaterLevelMethod = getWaterLevelMethod =
              io.grpc.MethodDescriptor.<generated.grpc.disastermanagement.waterLevelRequest, generated.grpc.disastermanagement.waterLevelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "waterLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.disastermanagement.waterLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.disastermanagement.waterLevelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new disasterMgmtMethodDescriptorSupplier("waterLevel"))
              .build();
        }
      }
    }
    return getWaterLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.disastermanagement.disasterRecoveryRequest,
      generated.grpc.disastermanagement.disasterRecoveryResponse> getDisasterRecoveryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "disasterRecovery",
      requestType = generated.grpc.disastermanagement.disasterRecoveryRequest.class,
      responseType = generated.grpc.disastermanagement.disasterRecoveryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.disastermanagement.disasterRecoveryRequest,
      generated.grpc.disastermanagement.disasterRecoveryResponse> getDisasterRecoveryMethod() {
    io.grpc.MethodDescriptor<generated.grpc.disastermanagement.disasterRecoveryRequest, generated.grpc.disastermanagement.disasterRecoveryResponse> getDisasterRecoveryMethod;
    if ((getDisasterRecoveryMethod = disasterMgmtGrpc.getDisasterRecoveryMethod) == null) {
      synchronized (disasterMgmtGrpc.class) {
        if ((getDisasterRecoveryMethod = disasterMgmtGrpc.getDisasterRecoveryMethod) == null) {
          disasterMgmtGrpc.getDisasterRecoveryMethod = getDisasterRecoveryMethod =
              io.grpc.MethodDescriptor.<generated.grpc.disastermanagement.disasterRecoveryRequest, generated.grpc.disastermanagement.disasterRecoveryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "disasterRecovery"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.disastermanagement.disasterRecoveryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.disastermanagement.disasterRecoveryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new disasterMgmtMethodDescriptorSupplier("disasterRecovery"))
              .build();
        }
      }
    }
    return getDisasterRecoveryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static disasterMgmtStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<disasterMgmtStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<disasterMgmtStub>() {
        @java.lang.Override
        public disasterMgmtStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new disasterMgmtStub(channel, callOptions);
        }
      };
    return disasterMgmtStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static disasterMgmtBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<disasterMgmtBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<disasterMgmtBlockingStub>() {
        @java.lang.Override
        public disasterMgmtBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new disasterMgmtBlockingStub(channel, callOptions);
        }
      };
    return disasterMgmtBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static disasterMgmtFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<disasterMgmtFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<disasterMgmtFutureStub>() {
        @java.lang.Override
        public disasterMgmtFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new disasterMgmtFutureStub(channel, callOptions);
        }
      };
    return disasterMgmtFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class disasterMgmtImplBase implements io.grpc.BindableService {

    /**
     */
    public void waterLevel(generated.grpc.disastermanagement.waterLevelRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.disastermanagement.waterLevelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWaterLevelMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<generated.grpc.disastermanagement.disasterRecoveryRequest> disasterRecovery(
        io.grpc.stub.StreamObserver<generated.grpc.disastermanagement.disasterRecoveryResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getDisasterRecoveryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWaterLevelMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                generated.grpc.disastermanagement.waterLevelRequest,
                generated.grpc.disastermanagement.waterLevelResponse>(
                  this, METHODID_WATER_LEVEL)))
          .addMethod(
            getDisasterRecoveryMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                generated.grpc.disastermanagement.disasterRecoveryRequest,
                generated.grpc.disastermanagement.disasterRecoveryResponse>(
                  this, METHODID_DISASTER_RECOVERY)))
          .build();
    }
  }

  /**
   */
  public static final class disasterMgmtStub extends io.grpc.stub.AbstractAsyncStub<disasterMgmtStub> {
    private disasterMgmtStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected disasterMgmtStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new disasterMgmtStub(channel, callOptions);
    }

    /**
     */
    public void waterLevel(generated.grpc.disastermanagement.waterLevelRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.disastermanagement.waterLevelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getWaterLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<generated.grpc.disastermanagement.disasterRecoveryRequest> disasterRecovery(
        io.grpc.stub.StreamObserver<generated.grpc.disastermanagement.disasterRecoveryResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getDisasterRecoveryMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class disasterMgmtBlockingStub extends io.grpc.stub.AbstractBlockingStub<disasterMgmtBlockingStub> {
    private disasterMgmtBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected disasterMgmtBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new disasterMgmtBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<generated.grpc.disastermanagement.waterLevelResponse> waterLevel(
        generated.grpc.disastermanagement.waterLevelRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getWaterLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class disasterMgmtFutureStub extends io.grpc.stub.AbstractFutureStub<disasterMgmtFutureStub> {
    private disasterMgmtFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected disasterMgmtFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new disasterMgmtFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WATER_LEVEL = 0;
  private static final int METHODID_DISASTER_RECOVERY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final disasterMgmtImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(disasterMgmtImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WATER_LEVEL:
          serviceImpl.waterLevel((generated.grpc.disastermanagement.waterLevelRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.disastermanagement.waterLevelResponse>) responseObserver);
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
        case METHODID_DISASTER_RECOVERY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.disasterRecovery(
              (io.grpc.stub.StreamObserver<generated.grpc.disastermanagement.disasterRecoveryResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class disasterMgmtBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    disasterMgmtBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.disastermanagement.DisasterManagementImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("disasterMgmt");
    }
  }

  private static final class disasterMgmtFileDescriptorSupplier
      extends disasterMgmtBaseDescriptorSupplier {
    disasterMgmtFileDescriptorSupplier() {}
  }

  private static final class disasterMgmtMethodDescriptorSupplier
      extends disasterMgmtBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    disasterMgmtMethodDescriptorSupplier(String methodName) {
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
      synchronized (disasterMgmtGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new disasterMgmtFileDescriptorSupplier())
              .addMethod(getWaterLevelMethod())
              .addMethod(getDisasterRecoveryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
