/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

import generated.grpc.disastermanagement.disasterRecoveryRequest;
import generated.grpc.disastermanagement.disasterMgmtGrpc;
import generated.grpc.disastermanagement.disasterMgmtGrpc.disasterMgmtBlockingStub;
import generated.grpc.disastermanagement.disasterMgmtGrpc.disasterMgmtStub;
import generated.grpc.disastermanagement.disasterRecoveryResponse;
import generated.grpc.disastermanagement.waterLevelRequest;
import generated.grpc.disastermanagement.waterLevelResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.time.LocalTime;
import java.util.Iterator;
import java.net.UnknownHostException;
import java.io.IOException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.net.InetAddress;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import ServicesPackage.HTTPClientdisastermgmt;

/**
 *
 * @author Prasanna
 */
public class disasterMgmtClient {
    //declaring a non blocking stub for asynchronous call
    private static disasterMgmtStub asyncStub;
    //blocking stub for synchronous call
    private static disasterMgmtBlockingStub syncStub;
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        //non blocking stub is for asynchronous calls
        //bi-di, client and server streaming uses non blocking 
        //as it wont be efficient with blocking stub to wait for the 
        //ful response to load from server
        asyncStub = disasterMgmtGrpc.newStub(channel);
        syncStub = disasterMgmtGrpc.newBlockingStub(channel);
        getwaterLevel();
        requestdisasterRecovery(); 
        
        disasterMgmtServiceDiscovery discoveryService = new disasterMgmtServiceDiscovery();
        
        
        
    }
    //Server Streaming - Asynchronous 
    //rpc waterLevel (waterLevelRequest) returns (stream waterLevelResponse)
    //This is an asynchronous streaming method
    //the client does not wait for the response hence we add sleep time
    //to show its processing 
    private static void getwaterLevel(){
        System.out.println("Server Streaming Asynchronous -  getwaterLevel");
        waterLevelRequest waterLevelRequestrequest = waterLevelRequest.newBuilder()
                .setWlinMeter(1)
                .setWarningLevel(100)
                .build();
        StreamObserver <waterLevelResponse> responseObserver = new StreamObserver <waterLevelResponse> (){
            @Override
            public void onNext(waterLevelResponse value){
                System.out.println("Client received" + value.getSafeMode() +
                        value.getNotification() + value.getConMonitor());
            }
            @Override
            //exception is extended until the complete method
            public void onError(Throwable e){
                e.printStackTrace();
            }
            
            @Override
            public void onCompleted(){
                System.out.println("Client received completed");
            }         
        };
        
        //calling the async stub
        asyncStub.waterLevel(waterLevelRequestrequest, responseObserver);
        
        //declaring sleep just to show its processing, when we get straight
        //answer it may not look legit 
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            //prints default
            //below helps to find and trace where the error is
            e.printStackTrace();
        }
    }
    //Client Streaming 
        //client sends details of location which changes with time
        //locations sent will be series of it 
        //server sends response with a recovery being true means on
        //client calls for the method service disasterMgmt
        //rpc disasterRecovery (stream disasterRecoveryRequest) returns (disasterRecoveryResponse) {}
        
    private static void requestdisasterRecovery() throws InterruptedException{
        //setup responseObserver
        System.out.println("Client Streaming - requestdisasterRecovery");
        StreamObserver <disasterRecoveryResponse> responseObserver = new StreamObserver <disasterRecoveryResponse> (){
            @Override
            //We expecting for only one response from the server
            //using an exception we need to ensure only one response is
            //received
            public void onNext(disasterRecoveryResponse response){
                System.out.println("Response from server: " +response.getRecovery());
            }
            
            @Override
            public void onError(Throwable e){
                e.printStackTrace();
            }
            @Override
            public void onCompleted(){
                System.out.println("Stream completed");
            }
        };
        //client opens the interaction using aSynchronous stub
        //client initiates responseObserver and receive requestObserver
        //using requestObserver client uses onNext method to send request
        StreamObserver <disasterRecoveryRequest> requestObserver = asyncStub.disasterRecovery(responseObserver);
        try{
            requestObserver.onNext(disasterRecoveryRequest.newBuilder().setLocation("Dublin1").setNumPeople(5).build());
            //setting sleep to see the process 
            Thread.sleep(500);
            requestObserver.onNext(disasterRecoveryRequest.newBuilder().setLocation("Dublin10").setNumPeople(5).build());
            //setting sleep to see the process 
            Thread.sleep(500);
            
            requestObserver.onNext(disasterRecoveryRequest.newBuilder().setLocation("Dublin11").setNumPeople(5).build());
            //setting sleep to see the process 
            Thread.sleep(500);
            
            requestObserver.onNext(disasterRecoveryRequest.newBuilder().setLocation("Dublin13").setNumPeople(5).build());
            //setting sleep to see the process 
            Thread.sleep(500);
            
            requestObserver.onNext(disasterRecoveryRequest.newBuilder().setLocation("Dublin24").setNumPeople(5).build());
            //setting sleep to see the process 
            Thread.sleep(500);
            
            requestObserver.onNext(disasterRecoveryRequest.newBuilder().setLocation("Dublin8").setNumPeople(5).build());
            //setting sleep to see the process 
            Thread.sleep(500);
            
            //when no more request comes in
            requestObserver.onCompleted();
            
            Thread.sleep(10000);
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        }catch(InterruptedException t){
            t.printStackTrace();
        }
    }
}
