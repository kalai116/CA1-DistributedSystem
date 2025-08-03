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
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.time.LocalTime;
import java.util.Iterator;

/**
 *
 * @author Prasanna
 */
public class LightingControlClient {
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
        asyncStub = LightingControlGrpc.newStub(channel);
        syncStub = LightingControlGrpc.newBlockingStub(channel);
        getturnOnLight();
    }
    //Unary
    //rpc turnOnLight (turnOnLightRequest) returns (turnOnLightResponse)
    private static void getturnOnLight (){
        System.out.println("Unary: getturnOnLight");
        turnOnLightRequest request = turnOnLightRequest.newBuilder()
                .setNumLight1(true)
                .build();
        turnOnLightResponse response = syncStub.turnOnLight(request);
        System.out.println("As per request num light 1 turned on" );
    }
}
