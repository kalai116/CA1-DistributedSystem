/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

import generated.grpc.motionalert.motionAlertNotiRequest;
import generated.grpc.motionalert.MotionAlertNdActionGrpc;
import generated.grpc.motionalert.MotionAlertNdActionGrpc.MotionAlertNdActionBlockingStub;
import generated.grpc.motionalert.MotionAlertNdActionGrpc.MotionAlertNdActionStub;
import generated.grpc.motionalert.motionAlertNotiResponse;
import java.time.LocalTime;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;
import io.grpc.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Prasanna
 */
public class MotionAlertNdActionClient {
    private static final Logger logger = Logger.getLogger(MotionAlertNdActionClient.class.getName());
    //declaring a non blocking stub for asynchronous call
    private static MotionAlertNdActionStub asyncStub;
    //blocking stub for synchronous call
    private static MotionAlertNdActionBlockingStub syncStub;
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        //non blocking stub is for asynchronous calls
        //bi-di, client and server streaming uses non blocking 
        //as it wont be efficient with blocking stub to wait for the 
        //ful response to load from server
        asyncStub = MotionAlertNdActionGrpc.newStub(channel);
        //syncStub = MotionAlertNdActionGrpc.newBlockingStub(channel); 
        getmotionAlertNoti();
    }
    //Bi-Di
    //In motion alert each time the motion is detected the server 
    //sends the notification to user
    public static void getmotionAlertNoti() throws InterruptedException{
        //responseObserver creates a new object where client advices on 
        //the actiion required onNex, OnError and onComplete
        //responseObserver is kept open to receive once initiated it
        //passes the info to the server
        //server uses onNext to respond and onComplete it finishes 
        System.out.println("Bi-Directional - getmotionAlertNoti");
        StreamObserver <motionAlertNotiResponse> responseObserver = 
                new StreamObserver <motionAlertNotiResponse> (){
                    @Override
                    //Bi-Di will send and client receive multiple 
                    //replies from the server
                    public void onNext(motionAlertNotiResponse response){
                        System.out.println("Motion detected by the server" + response.getNotification());
                    }
                    @Override
                    public void onError(Throwable e){
                        //this exception holds error and exception together 
                        e.printStackTrace();
                    }
                    @Override
                    public void onCompleted(){
                        System.out.println("Stream completed");
                    }
                };
        
        //this part denotes the interaction between the asychronous stub
        //now using onNext client sends over the requests
        StreamObserver <motionAlertNotiRequest> requestObserver =
                asyncStub.motionAlertNoti(responseObserver);
        try{
            //multiple requests received from client
            requestObserver.onNext(motionAlertNotiRequest.newBuilder()
                    .setMotionNotification(true).setAction(true).build());
                    System.out.println("Client wish to monitor the motion and enable motion alert");
                    Thread.sleep(500);
            requestObserver.onNext(motionAlertNotiRequest.newBuilder()
                    .setMotionNotification(true).setAction(true).build());
                    System.out.println("Client wish to take action for the motion");
                    Thread.sleep(500);
            //client done sending all the requests
            requestObserver.onCompleted();
            
            //this is the time given for the server to respond 
            Thread.sleep(10000);
        }catch (RuntimeException e){
            //sends series of exception as and when required  
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
    }
    static class MotionAlertInterceptor implements ClientInterceptor {
        //gRPC helps to deal with metdata making it easier to be accessed 
        //by the server. inceptors are used to read and write data 
        //keep it generic for the request and response
        public <ReqT, RespS> 
            ClientCall <ReqT, RespS> 
        intercepCall (MethodDescriptor <ReqT, RespS> method, 
                CallOptions calloptions,Channel next) {
           return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, 
                   RespS> (next.newCall(method, calloptions)){
                       @Override
                       public void start (ClientCall.Listener <RespS> responseListener,
                               Metadata headers) {
                           headers.put(Metadata.Key.of("HOSTNAME", ASCII_STRING_MARSHALLER), "My_HOST");
                           super.start(responseListener, headers);
                       }
                   };
        }

        @Override
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> md, CallOptions co, Channel chnl) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
