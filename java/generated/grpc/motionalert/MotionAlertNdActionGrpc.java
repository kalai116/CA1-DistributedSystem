package generated.grpc.motionalert;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: MotionAlert.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MotionAlertNdActionGrpc {

  private MotionAlertNdActionGrpc() {}

  public static final String SERVICE_NAME = "motionalert.MotionAlertNdAction";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.motionalert.motionAlertNotiRequest,
      generated.grpc.motionalert.motionAlertNotiResponse> getMotionAlertNotiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "motionAlertNoti",
      requestType = generated.grpc.motionalert.motionAlertNotiRequest.class,
      responseType = generated.grpc.motionalert.motionAlertNotiResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.motionalert.motionAlertNotiRequest,
      generated.grpc.motionalert.motionAlertNotiResponse> getMotionAlertNotiMethod() {
    io.grpc.MethodDescriptor<generated.grpc.motionalert.motionAlertNotiRequest, generated.grpc.motionalert.motionAlertNotiResponse> getMotionAlertNotiMethod;
    if ((getMotionAlertNotiMethod = MotionAlertNdActionGrpc.getMotionAlertNotiMethod) == null) {
      synchronized (MotionAlertNdActionGrpc.class) {
        if ((getMotionAlertNotiMethod = MotionAlertNdActionGrpc.getMotionAlertNotiMethod) == null) {
          MotionAlertNdActionGrpc.getMotionAlertNotiMethod = getMotionAlertNotiMethod =
              io.grpc.MethodDescriptor.<generated.grpc.motionalert.motionAlertNotiRequest, generated.grpc.motionalert.motionAlertNotiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "motionAlertNoti"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.motionalert.motionAlertNotiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.motionalert.motionAlertNotiResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MotionAlertNdActionMethodDescriptorSupplier("motionAlertNoti"))
              .build();
        }
      }
    }
    return getMotionAlertNotiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MotionAlertNdActionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MotionAlertNdActionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MotionAlertNdActionStub>() {
        @java.lang.Override
        public MotionAlertNdActionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MotionAlertNdActionStub(channel, callOptions);
        }
      };
    return MotionAlertNdActionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MotionAlertNdActionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MotionAlertNdActionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MotionAlertNdActionBlockingStub>() {
        @java.lang.Override
        public MotionAlertNdActionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MotionAlertNdActionBlockingStub(channel, callOptions);
        }
      };
    return MotionAlertNdActionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MotionAlertNdActionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MotionAlertNdActionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MotionAlertNdActionFutureStub>() {
        @java.lang.Override
        public MotionAlertNdActionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MotionAlertNdActionFutureStub(channel, callOptions);
        }
      };
    return MotionAlertNdActionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MotionAlertNdActionImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<generated.grpc.motionalert.motionAlertNotiRequest> motionAlertNoti(
        io.grpc.stub.StreamObserver<generated.grpc.motionalert.motionAlertNotiResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMotionAlertNotiMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMotionAlertNotiMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                generated.grpc.motionalert.motionAlertNotiRequest,
                generated.grpc.motionalert.motionAlertNotiResponse>(
                  this, METHODID_MOTION_ALERT_NOTI)))
          .build();
    }
  }

  /**
   */
  public static final class MotionAlertNdActionStub extends io.grpc.stub.AbstractAsyncStub<MotionAlertNdActionStub> {
    private MotionAlertNdActionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotionAlertNdActionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MotionAlertNdActionStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<generated.grpc.motionalert.motionAlertNotiRequest> motionAlertNoti(
        io.grpc.stub.StreamObserver<generated.grpc.motionalert.motionAlertNotiResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMotionAlertNotiMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class MotionAlertNdActionBlockingStub extends io.grpc.stub.AbstractBlockingStub<MotionAlertNdActionBlockingStub> {
    private MotionAlertNdActionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotionAlertNdActionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MotionAlertNdActionBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class MotionAlertNdActionFutureStub extends io.grpc.stub.AbstractFutureStub<MotionAlertNdActionFutureStub> {
    private MotionAlertNdActionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotionAlertNdActionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MotionAlertNdActionFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MOTION_ALERT_NOTI = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MotionAlertNdActionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MotionAlertNdActionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MOTION_ALERT_NOTI:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.motionAlertNoti(
              (io.grpc.stub.StreamObserver<generated.grpc.motionalert.motionAlertNotiResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MotionAlertNdActionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MotionAlertNdActionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.motionalert.MotionAlertImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MotionAlertNdAction");
    }
  }

  private static final class MotionAlertNdActionFileDescriptorSupplier
      extends MotionAlertNdActionBaseDescriptorSupplier {
    MotionAlertNdActionFileDescriptorSupplier() {}
  }

  private static final class MotionAlertNdActionMethodDescriptorSupplier
      extends MotionAlertNdActionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MotionAlertNdActionMethodDescriptorSupplier(String methodName) {
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
      synchronized (MotionAlertNdActionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MotionAlertNdActionFileDescriptorSupplier())
              .addMethod(getMotionAlertNotiMethod())
              .build();
        }
      }
    }
    return result;
  }
}
