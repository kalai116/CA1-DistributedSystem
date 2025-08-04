/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

import generated.grpc.lightingcontrol.turnOnLightResponse;
import generated.grpc.lightingcontrol.LightingControlGrpc;
import generated.grpc.lightingcontrol.LightingControlGrpc.LightingControlImplBase;
import generated.grpc.lightingcontrol.turnOnLightRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import java.util.List;
import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;
import io.grpc.*;
import io.grpc.Metadata.Key;
import io.jsonwebtoken.*;

/**
 *
 * @author Prasanna
 */
public class LightingControl extends LightingControlImplBase{
    //Logger simply helps to update the status and helps in detecting errors
    //its private bcoz its used only in this class
    //its final bcoz 
    private static final Logger logger 
            = Logger.getLogger
        (LightingControl.class.getName());
    public static void main(String[] args) {
        //creating object 
        LightingControl lcServer = new LightingControl();
        
        int port = 50051;
        try{
            Server server = ServerBuilder.forPort(port)
                    .addService(lcServer) //connect the service to server
                    .build() //helps to create the server 
                    .start();  //helps to receive the request from client
            logger.info("Server started, open to receive request " + port);
            System.out.println("Lighting Service, ready to serve at " + port);
            ServiceReg.getInstance().registerService("_grpc_tcp_local", "Lighting Control", port, "The service will turn on the light");
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
        }catch(StatusRuntimeException e){
            e.getStatus();
        }
    }
    /*
    building the service
    receive the request to turn on light
    returns with a response action turning on the light
    rpc TurnOnLight (turnOnLightRequest) returns (turnOnLightResponse)
    */
    @Override
    public void turnOnLight(turnOnLightRequest request, StreamObserver <turnOnLightResponse> response){
        
        //creating instance of the class and setting light number
        //as the numLight1 turn on option is one service alone to turn on
        //light number 1
        boolean numLight1 = request.getNumLight1();
        turnOnLightResponse turnOnLight = turnOnLightResponse.newBuilder()             
                .setLightNum(1)
                .setNumLight1(true)
                .build();
        response.onNext(turnOnLight);
        response.onCompleted();
        
    }
    class LightingControlInteceptor implements ServerInterceptor {
        @Override
        public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall
        (ServerCall<ReqT, RespT> call, 
                Metadata headers, ServerCallHandler<ReqT, RespT> next) {
            logger.info("Received following Metadata: " + headers);
            return next.startCall(call, headers);
        } 
    }
}
