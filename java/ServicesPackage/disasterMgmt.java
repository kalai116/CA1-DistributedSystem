/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

import generated.grpc.disastermanagement.disasterRecoveryRequest;
import generated.grpc.disastermanagement.disasterMgmtGrpc;
import generated.grpc.disastermanagement.disasterMgmtGrpc.disasterMgmtImplBase;
import generated.grpc.disastermanagement.disasterRecoveryResponse;
import generated.grpc.disastermanagement.waterLevelRequest;
import generated.grpc.disastermanagement.waterLevelResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.logging.Logger;
import io.grpc.*;

/**
 *
 * @author Prasanna
 */
public class disasterMgmt extends disasterMgmtImplBase{
    //Logger simply helps to update the status and helps in detecting errors
    //its private bcoz its used only in this class
    //its final bcoz 
    private static final Logger logger 
            = Logger.getLogger
        (disasterMgmt.class.getName());
    public static void main(String[] args) throws IOException {
        //creating object 
        disasterMgmt dmServer = new disasterMgmt();
        
        int port = 50053;
        try{
            Server server = ServerBuilder.forPort(port)
                    .addService(dmServer) //connect the service to server
                    .build() //helps to create the server 
                    .start();  //helps to receive the request from client
            logger.info("Server started, open to receive request" + port);
            System.out.println("Lighting Service, ready to serve" + port);
            //Using jmDNS registration to register the service           
            ServiceReg serverRegistry = ServiceReg.getInstance();
            serverRegistry.registerService("_grpc_tcp_local", "disaster", port, "Server warns you when you reach warning level");
            
            //ensures the server stop only when terminated
            //server will stop immediately after starting incase this is not declared
           
            server.awaitTermination();
            
            
        }catch (IOException e){
            //inout/output error handling, print auto generated error
            e.printStackTrace();
        }catch (InterruptedException e){
            //happens if any interruption during service
            //print auto generated error
            e.printStackTrace();
            //the status exception helps to display the exact reaso for 
            //the exception 
        }catch(StatusRuntimeException e){
            e.getStatus();
        }
    }
    /* 
    //building the service
    //receive the request to turn on light
    //returns with a response action turning on the light
    */
    @Override
    public void waterLevel(waterLevelRequest request, StreamObserver<waterLevelResponse> response){
        //As the below are already set in proto just calling the variables
        //declaring it to be used
        int wlinMeter = request.getWlinMeter();
        int warningLevel = request.getWarningLevel();
        //below responses are not initialised in the proto 
        //hence initialising all the 3 to be used 
        String notification;    
        boolean safeMode = false;    
        boolean conMonitor = false;  
        if(wlinMeter >= warningLevel){
            notification = "You have reached the danger level" + wlinMeter;
            safeMode = true;
            conMonitor = true;       
        }else {
            notification = "You are safe";
        }
        waterLevelResponse wlResponse = waterLevelResponse.newBuilder()
                .setNotification(notification)
                .setSafeMode(safeMode)
                .setConMonitor(conMonitor).build();
        response.onNext(wlResponse);
        response.onCompleted();
    }
    @Override
    //in client streaming server receives all  the request coming from the client
    //creates a new observer as return below declares new observer 
    //which lets the the server receive request onNext
    //its an anonymous class, it can be called requestObserver
    public StreamObserver <disasterRecoveryRequest> disasterRecovery (StreamObserver <disasterRecoveryResponse> responseObserver){
        return new StreamObserver<disasterRecoveryRequest> () {
            String location = " ";
            int numPeople = 0;
            boolean needRecovery = false;
            @Override
            public void onNext(disasterRecoveryRequest request){
                //getting the location and numpeople and assigning to the variable
                location = request.getLocation();
                numPeople = request.getNumPeople();
                //using if statement ensuuring that when location 
                //is not empty and numpeople is atleast 1
                //recovery is needed and boolean changes to true
                if(!location.isEmpty() && numPeople >=1){
                    needRecovery = true;
                }            
            }
            @Override
            public void onError(Throwable e){
                //sends default exeception message
            }
            @Override
            //At the onNext stage we only gathered the information
            //as client keep sending requests once all the requests are in 
            //onComplete is the stage where the actual action is taken 
            //in our case oonce we receive the ocation and numPeople 
            //its by default triggers the emegency recovery 
            public void onCompleted(){
                boolean recovery = false;
                //as and when the location and numpeople sent 
                //recovery is enabled to true telling them help is on its way
                
                do{
                     recovery = true;
                     System.out.println("Help is on its way");
                  }while(needRecovery == true);
                
                disasterRecoveryResponse response = disasterRecoveryResponse.newBuilder()
                        .setRecovery(recovery)
                        .build();
                //the server communicates with client only once using 
                //responseObserver onNext
                //as its inbuuilt in grpc that in client streaming 
                //reply or response is only once
                responseObserver.onNext(response);
                
                //onComplete simply signals server its finished
                responseObserver.onCompleted();              
            }
        };
    }
    class disastermgmtInteceptor implements ServerInterceptor {
        @Override
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall
        (ServerCall<ReqT, RespT> call, 
                Metadata headers, ServerCallHandler<ReqT, RespT> next) {
            logger.info("Received following Metadata: " + headers);
            return next.startCall(call, headers);
        } 
    }
}
