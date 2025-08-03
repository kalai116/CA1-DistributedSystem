/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

import generated.grpc.motionalert.motionAlertNotiRequest;
import generated.grpc.motionalert.MotionAlertNdActionGrpc;
import generated.grpc.motionalert.MotionAlertNdActionGrpc.MotionAlertNdActionImplBase;
import generated.grpc.motionalert.motionAlertNotiResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
/**
 *
 * @author Prasanna
 */
public class MotionAlertNdAction extends MotionAlertNdActionImplBase{
        //Logger simply helps to update the status and helps in detecting errors
    //its private bcoz its used only in this class
    //its final bcoz 
    private static final Logger logger 
            = Logger.getLogger
        (MotionAlertNdAction.class.getName());
    public static void main(String[] args) {
        //creating object 
        MotionAlertNdAction motionAlServer = new MotionAlertNdAction();
        
        int port = 50051;
        try{
            Server server = ServerBuilder.forPort(port)
                    .addService(motionAlServer) //connect the service to server
                    .build() //helps to create the server 
                    .start();  //helps to receive the request from client
            logger.info("Server started, open to receive request" + port);
            System.out.println("Motion Alert server is ready to serve" + port);
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
        }
    }
    /* 
    //Over riding the proto to do as per what is expected from the server
    //Bi-Directional
    */
    @Override
    public StreamObserver<motionAlertNotiRequest> motionAlertNoti (StreamObserver <motionAlertNotiResponse> responseObserver){
        //the stream observer states that the server is ready to receive multiple requests
        //as we need the observer to keep receiving the request from the client 
        //server keeps returning to the client to denote its observing
        //the class is not named as this just does the work of observing for any request
        
        return new StreamObserver<motionAlertNotiRequest> (){
            @Override
            //whenever motion is detected each occurance gets saved 
            //notification sent to user alerting the motion
            //from the server side motion detected will be true 
            //whenever motion detected is true notification is sent 
            public void onNext(motionAlertNotiRequest request){
                //declaring variable to assign true value to the boolean                
                boolean alertEnabled = false;
                boolean ActionTaken = false;
                boolean motion = false;
                String notification = " ";
                //alertenabled is true hence below states 
                //MotionNotification is set to true
                alertEnabled = request.getMotionNotification();
                //below need to satisfy both alert and motion both shd be tru
                if(alertEnabled == true && motion == true ){                    
                    notification = "Caution!!! Motion detected";
                    //below states its true if need to declare it as 
                    //false need to put an ! before the request
                    if(request.getAction()){
                        ActionTaken = true;
                        //notification = "Required action has been taken";
                    }
                }else {
                    ActionTaken = false;
                }
                motionAlertNotiResponse response = motionAlertNotiResponse.newBuilder()
                        .setMotion(motion)
                        .setNotification(notification)
                        .setActionTaken(ActionTaken)
                        .build();
                responseObserver.onNext(response);    
            }
            @Override
            //we are declaring the onError method with a throwable exeception
            public void onError(Throwable e){
                //as we did not mention anything it throws the default message
            }
            @Override
            //tis is where the server stops receiving any further requests from client
            //final response is generated and communicate through
            //observer's (server) rsponse onNext 
            //this method informs the server this instance has come to an end
            public void onCompleted(){
                //informs the server this is end of the trail
                responseObserver.onCompleted();
            }
        };
    
    }
}
