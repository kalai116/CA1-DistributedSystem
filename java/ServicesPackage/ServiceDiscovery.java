/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

import generated.grpc.disastermanagement.disasterMgmtGrpc;
import generated.grpc.lightingcontrol.LightingControlGrpc;
import generated.grpc.lightingcontrol.LightingControlGrpc.LightingControlBlockingStub;
import generated.grpc.lightingcontrol.LightingControlGrpc.LightingControlStub;
import generated.grpc.lightingcontrol.turnOnLightRequest;
import generated.grpc.lightingcontrol.turnOnLightResponse;
import generated.grpc.disastermanagement.disasterRecoveryRequest;
import generated.grpc.disastermanagement.disasterMgmtGrpc;
import generated.grpc.disastermanagement.disasterMgmtGrpc.disasterMgmtBlockingStub;
import generated.grpc.disastermanagement.disasterMgmtGrpc.disasterMgmtStub;
import generated.grpc.disastermanagement.disasterRecoveryResponse;
import generated.grpc.disastermanagement.waterLevelRequest;
import generated.grpc.disastermanagement.waterLevelResponse;
import generated.grpc.motionalert.motionAlertNotiRequest;
import generated.grpc.motionalert.MotionAlertNdActionGrpc;
import generated.grpc.motionalert.MotionAlertNdActionGrpc.MotionAlertNdActionBlockingStub;
import generated.grpc.motionalert.MotionAlertNdActionGrpc.MotionAlertNdActionStub;
import generated.grpc.motionalert.motionAlertNotiResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.net.UnknownHostException;
import java.io.IOException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.net.InetAddress;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import io.grpc.*;

/**
 *
 * @author Prasanna
 */
public class ServiceDiscovery {
    //LightingControl
    private LightingControlGrpc.LightingControlBlockingStub syncStub;
    //disasterMgmt
    private disasterMgmtGrpc.disasterMgmtStub asyncStub;
    //Motion alert
    //had to rename as both using the non blocking stub
    private MotionAlertNdActionGrpc.MotionAlertNdActionStub MAstub;
    private ServiceInfo info;
    private class SDServiceListener  implements ServiceListener {
        @Override
        public void serviceAdded (ServiceEvent event) {
            ServiceInfo info = event.getInfo();
            if(info.hasData()){
                //gethostaddress is deprecated but still usable however
                //due to the version of java it states its not reliable
                System.out.println("has Data " + info.getHostAddress().toString());
            }
            System.out.println("Service Added: " + event.getInfo());
        }
        @Override
        public void serviceRemoved (ServiceEvent event){
            System.out.println("Service Removed: " + event.getInfo());
        }
        @Override
        public void serviceResolved (ServiceEvent event){
            //the individual event calls serviceinfo using method
            //getinfo simply gets service info
            System.out.println("Service Resolved: " + event.getInfo());
            //declaring and creating object for serviceinfo
            //returns all the parameters in the registerservice
            ServiceInfo info = event.getInfo();
            //declaring the port using getport method for the service
            //declaring each parameters in the register service, port
            int port = info.getPort();
            //declaring the service name and calling the info 
            //using getinfo method
            //declaring each parameters in the register service, port
            String serviceName = info.getName();
            //the service name is the name we may think the client 
            //may use instead of the the url 
            //however we can decide whether to call this method or not 
            
            //We are using if statement to link the discovery 
            //to the client services we are using servicename to 
            //call the discovery method
            if(serviceName.contains("Lighting Control") ){
                ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();         
                syncStub = LightingControlGrpc.newBlockingStub(channel);
                turnOnLightRequest request = turnOnLightRequest.newBuilder()
                .setNumLight1(true)
                .build();
                syncStub.turnOnLight(request);
            }  
            if(serviceName.contains("disaster")){
                
                ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();              
                asyncStub = disasterMgmtGrpc.newStub(channel);
                waterLevelRequest waterLevelRequestrequest = waterLevelRequest.newBuilder()
                .setWlinMeter(1)
                .setWarningLevel(100)
                .build();
                //as disaster has water level and disaster recovery declared both together
                StreamObserver<disasterRecoveryResponse> responseObserver = null;
                //asyncStub.waterLevel;
                asyncStub.disasterRecovery(responseObserver);
                
            }
            if(serviceName.contains("Motion alert")){
                 ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();
                 MAstub = MotionAlertNdActionGrpc.newStub(channel);
                 motionAlertNotiResponse response = null;
                StreamObserver<motionAlertNotiResponse> responseObserver = null;
                responseObserver.onNext(response); 
                 MAstub.motionAlertNoti(responseObserver);
            }
        }    
    }
    public static void main(String[] args) throws InterruptedException{
        try{
            //creating JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Client: InetAddress.getLocalHost(): " + InetAddress.getLocalHost());
            
            //sleep time
            Thread.sleep(20000);
        }catch (UnknownHostException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
