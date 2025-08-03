package generated.grpc.lightingcontrol;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: LightingControl.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LightingControlGrpc {

  private LightingControlGrpc() {}

  public static final String SERVICE_NAME = "LightingControl.LightingControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.lightingcontrol.turnOnLightRequest,
      generated.grpc.lightingcontrol.turnOnLightResponse> getTurnOnLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "turnOnLight",
      requestType = generated.grpc.lightingcontrol.turnOnLightRequest.class,
      responseType = generated.grpc.lightingcontrol.turnOnLightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.lightingcontrol.turnOnLightRequest,
      generated.grpc.lightingcontrol.turnOnLightResponse> getTurnOnLightMethod() {
    io.grpc.MethodDescriptor<generated.grpc.lightingcontrol.turnOnLightRequest, generated.grpc.lightingcontrol.turnOnLightResponse> getTurnOnLightMethod;
    if ((getTurnOnLightMethod = LightingControlGrpc.getTurnOnLightMethod) == null) {
      synchronized (LightingControlGrpc.class) {
        if ((getTurnOnLightMethod = LightingControlGrpc.getTurnOnLightMethod) == null) {
          LightingControlGrpc.getTurnOnLightMethod = getTurnOnLightMethod =
              io.grpc.MethodDescriptor.<generated.grpc.lightingcontrol.turnOnLightRequest, generated.grpc.lightingcontrol.turnOnLightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "turnOnLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.lightingcontrol.turnOnLightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.lightingcontrol.turnOnLightResponse.getDefaultInstance()))
              .setSchemaDescriptor(new LightingControlMethodDescriptorSupplier("turnOnLight"))
              .build();
        }
      }
    }
    return getTurnOnLightMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightingControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightingControlStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightingControlStub>() {
        @java.lang.Override
        public LightingControlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightingControlStub(channel, callOptions);
        }
      };
    return LightingControlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightingControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightingControlBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightingControlBlockingStub>() {
        @java.lang.Override
        public LightingControlBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightingControlBlockingStub(channel, callOptions);
        }
      };
    return LightingControlBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightingControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LightingControlFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LightingControlFutureStub>() {
        @java.lang.Override
        public LightingControlFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LightingControlFutureStub(channel, callOptions);
        }
      };
    return LightingControlFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class LightingControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void turnOnLight(generated.grpc.lightingcontrol.turnOnLightRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.lightingcontrol.turnOnLightResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTurnOnLightMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTurnOnLightMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.lightingcontrol.turnOnLightRequest,
                generated.grpc.lightingcontrol.turnOnLightResponse>(
                  this, METHODID_TURN_ON_LIGHT)))
          .build();
    }
  }

  /**
   */
  public static final class LightingControlStub extends io.grpc.stub.AbstractAsyncStub<LightingControlStub> {
    private LightingControlStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightingControlStub(channel, callOptions);
    }

    /**
     */
    public void turnOnLight(generated.grpc.lightingcontrol.turnOnLightRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.lightingcontrol.turnOnLightResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTurnOnLightMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LightingControlBlockingStub extends io.grpc.stub.AbstractBlockingStub<LightingControlBlockingStub> {
    private LightingControlBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightingControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.grpc.lightingcontrol.turnOnLightResponse turnOnLight(generated.grpc.lightingcontrol.turnOnLightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTurnOnLightMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightingControlFutureStub extends io.grpc.stub.AbstractFutureStub<LightingControlFutureStub> {
    private LightingControlFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LightingControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.lightingcontrol.turnOnLightResponse> turnOnLight(
        generated.grpc.lightingcontrol.turnOnLightRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTurnOnLightMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TURN_ON_LIGHT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightingControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightingControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TURN_ON_LIGHT:
          serviceImpl.turnOnLight((generated.grpc.lightingcontrol.turnOnLightRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.lightingcontrol.turnOnLightResponse>) responseObserver);
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

  private static abstract class LightingControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightingControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.lightingcontrol.LightingControlImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightingControl");
    }
  }

  private static final class LightingControlFileDescriptorSupplier
      extends LightingControlBaseDescriptorSupplier {
    LightingControlFileDescriptorSupplier() {}
  }

  private static final class LightingControlMethodDescriptorSupplier
      extends LightingControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightingControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightingControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightingControlFileDescriptorSupplier())
              .addMethod(getTurnOnLightMethod())
              .build();
        }
      }
    }
    return result;
  }
}
