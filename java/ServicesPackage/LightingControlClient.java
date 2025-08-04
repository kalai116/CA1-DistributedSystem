/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

import generated.grpc.lightingcontrol.turnOnLightResponse;
import generated.grpc.lightingcontrol.LightingControlGrpc;
import generated.grpc.lightingcontrol.LightingControlGrpc.LightingControlBlockingStub;
import generated.grpc.lightingcontrol.LightingControlGrpc.LightingControlStub;
import generated.grpc.lightingcontrol.turnOnLightRequest;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;
import io.grpc.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import io.grpc.Metadata.Key;
import io.jsonwebtoken.*;

/**
 *
 * @author Prasanna
 */
public class LightingControlClient {
    private static final Logger logger = Logger.getLogger(LightingControlClient.class.getName()); 
    //declaring a non blocking stub for asynchronous call
    private static LightingControlStub asyncStub;
    //blocking stub for synchronous call
    private static LightingControlBlockingStub syncStub;
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        //non blocking stub is for asynchronous calls
        //bi-di, client and server streaming uses non blocking 
        //as it wont be efficient with blocking stub to wait for the 
        //ful response to load from server
        //asyncStub = LightingControlGrpc.newStub(channel);
        syncStub = LightingControlGrpc.newBlockingStub(channel);
        getturnOnLight();
    }
    //Unary
    //rpc turnOnLight (turnOnLightRequest) returns (turnOnLightResponse)
    private static void getturnOnLight (){
        System.out.println("Unary: getturnOnLight");
        //this means the request is starting to build a new service
        //passing in the value in the set method and build method 
        //brings the object to an end and return    
        turnOnLightRequest request = turnOnLightRequest.newBuilder()
                .setNumLight1(true)
                .build();
        //creating object for response, read the request using the 
        //blocking stub 
        turnOnLightResponse response = syncStub.turnOnLight(request);
        System.out.println("As per request num light 1 turned on" );
    }
    static class LightingControlInteceptor implements ClientInterceptor {
        //gRPC helps to deal with metdata making it easier to be accessed 
        //by the server. inceptors are used to read and write data 
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
