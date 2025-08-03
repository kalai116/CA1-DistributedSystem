/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

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
public class disasterMgmtServiceReg {
    //public class disasterServiceRegistration{
    //As the file name is already in the service name hence couldnt
    //declare the service registration 
    //below is the ServiceRegistration for the server
        private static JmDNS jmdns;       
        private static disasterMgmtServiceReg theRegister;
        
        //we are integrating jmDNS so that the client can connect 
        //or find the service automatically
        //it uses Singleton as only one controller responsible for 
        //all the service. Constructor is private here because
        //each time the method is called an instance gets created 
        //exceptions to catch if any invalid or a diff port is called 
        //which doesnot exist 
        private disasterMgmtServiceReg()throws UnknownHostException, IOException {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Register: InetAddress.getLocalHost()" + InetAddress.getLocalHost());
            
        }
        public static disasterMgmtServiceReg getInstance()throws IOException {
            if(theRegister == null){
                theRegister = new disasterMgmtServiceReg ();
            }
            return theRegister;
        }
        //service call the registerService to register thermselves 
        //so that when client the client can find it
        public void registerService (String type, String name, int port, String text) throws IOException{
            //building a service description for registring with JmDNS
            //Parameters excepted are:
            //type - exact name of the service  for eg https._tcp.local
            //name - not an exact URL but a name like Irish Cuisine
            //port - the port the service uses to run
            //text - simple description of the service like I crave for Irish Cuisine
            //declaring the parameters to the service info  
            ServiceInfo serviceinfo = ServiceInfo.create(type, name, port, text);
            //registring the service to jmdns
            jmdns.registerService(serviceinfo);
            System.out.println("Registered Service " + serviceinfo.toString());
        }
}
