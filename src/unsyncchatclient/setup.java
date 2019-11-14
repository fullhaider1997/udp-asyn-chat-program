/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsyncchatclient;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Haider
 */
public class setup {
    
      private static int port;
      private static String address;
      private boolean state;
    
     public int portFromSetup(){
         return port;
     }
     public String addressFromSetup(){
         return address;
     }
     setup(int port,String address)
      {
        
       
            System.out.println("setup client on port " + port);
            System.out.println("setup client on address "+ address);
        
      this.port = port;
      this.address = address;
     }
     
     setup(boolean state){
         
         
     }
     
     
   
}
  
    

    

