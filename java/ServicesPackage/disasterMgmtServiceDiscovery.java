/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicesPackage;

import java.net.UnknownHostException;
import java.io.IOException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.net.InetAddress;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

/**
 *
 * @author Prasanna
 */
public class disasterMgmtServiceDiscovery {
    //declaring it otside bcoz i need to use them in the client to 
    //integrate jmdnsdicovery to the client 
    private ServiceInfo info;
    private static class disasterMgmtServiceListener  implements ServiceListener {
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
            if(serviceName == "disaster"){
                //URL info from httpclient disastermgmt
                System.out.println("Service found" + serviceName);
                //the getNiceTextString method actual puts in a tidy and readable manner 
                //to the client
                //= is used as delimiter to seperate left and right side 
                //targeting the 1st index of the array where left is 0th index and 
                //after the equal sign is 1st index as we are targeting the
                //path we use [1]
                String path = info.getNiceTextString().split("=")[1];
                String url = "http://localhost: " + port + "/" + path; 
                System.out.println("Service " + serviceName + " resolved at: " + url);
                HTTPClientdisastermgmt.request(url);
            }  
        }    
    }
    public static void main(String[] args) throws InterruptedException{
        try{
            //creating JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Client: InetAddress.getLocalHost(): " + InetAddress.getLocalHost());
            jmdns.addServiceListener("http._tcp.localhost. ", new disasterMgmtServiceListener());
            
            //sleep time
            Thread.sleep(20000);
        }catch (UnknownHostException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
