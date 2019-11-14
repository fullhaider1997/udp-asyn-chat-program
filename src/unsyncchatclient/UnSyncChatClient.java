/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsyncchatclient;

import java.net.*; 
import java.io.*; 
import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnSyncChatClient {

       static DatagramSocket ss;
       static InetAddress ip;
       static Thread ssend;
       static Thread sreceive;
       private static String ip1;
       private static  int portnumber;
       private static String message;
       public static boolean isPressed;
       
       public static void Message(String str){
           UnSyncChatClient.message = str;
           System.out.println("wwwwwwwClient input:" +UnSyncChatClient.message );
       }
    
       
       public static void haider(setup st){
        UnSyncChatClient.portnumber= st.portFromSetup();
           try {
               UnSyncChatClient.ip = InetAddress.getByName(UnSyncChatClient.ip1);
           } catch (UnknownHostException ex) {
               Logger.getLogger(UnSyncChatClient.class.getName()).log(Level.SEVERE, null, ex);
           }
               System.out.println("getinformation on port " + UnSyncChatClient.portnumber);
               System.out.println("getinformation on address "+ UnSyncChatClient.ip1);
         
               System.out.println("Sucesssfull: ip address :"+ UnSyncChatClient.ip);
          
       
           try {
               ss = new DatagramSocket(UnSyncChatClient.portnumber);
               System.out.println("successful: port num is "+ ss.getPort());
          
           } catch (SocketException ex) {
               System.out.println("Error: port num is "+ ss.getPort());
               Logger.getLogger(UnSyncChatClient.class.getName()).log(Level.SEVERE, null, ex);
           }
               
           
        
      
     }
        public static void buttonIs(boolean state) throws InterruptedException{
         
         UnSyncChatClient.isPressed = true;
            System.out.print("bool stat is "+ UnSyncChatClient.isPressed);
          
         // with a nested runnable class definition 
         ssend = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
                    System.out.println("client:");
                   
                    System.out.println("getting ready to send:" + UnSyncChatClient.message);
                    
                        synchronized (this) 
                        { 
                            byte[] sd = new byte[1000]; 
  
                            // scan new message to send 
                            sd =  UnSyncChatClient.message.getBytes(); 
                            DatagramPacket sp = new DatagramPacket(sd, sd.length, ip, 1234); 
  
                            // send the new packet 
                            ss.send(sp); 
  
                            String msg = new String(sd); 
                            System.out.println("client says: "
                                               + msg); 
  
                            // exit condition 
                            if ((msg).equals("bye")) { 
                                System.out.println("client"
                                                   + " exiting... "); 
                                 
                            } 
                            System.out.println("Waiting for"
                                               + " server response... "); 
                         
                    } 
                } 
                catch (Exception e) { 
                    System.out.println("Exception occured"); 
                } 
            } 
        }); 
        Thread sreceive; 
        sreceive = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
                    
                        synchronized (this) 
                        { 
  
                            byte[] rd = new byte[1000]; 
  
                            // Receive new message 
                            DatagramPacket sp1 
                                = new DatagramPacket( 
                                    rd, 
                                    rd.length); 
                         ss.receive(sp1); 
  
                            // Convert byte data to string 
                            String msg 
                                = (new String(rd)).trim(); 
                            System.out.println("server ("
                                               + sp1.getPort() 
                                               + "):"
                                               + " "
                                               + msg); 
                            
                            GUI gui = new GUI();
                            gui.setrecievedMessage(msg);
                            // Exit condition 
                            if (msg.equals("bye")) { 
                                System.out.println("client"
                                                   + " connection closed."); 
                                
                            }
                            
                        
                    } 
                } 
                catch (Exception e) { 
                    System.out.println("Exception occured"); 
                } 
            } 
        }); 
          ssend.start(); 
          sreceive.start();
          ssend.join(); 
          sreceive.join();
        
     }
   
      
       
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        
        GUI gui = new GUI();
     
        gui.setVisible(true);
       
       
        System.out.println("Running UnSyncChatClient.java");
        System.out.println("Client is Up....");
      
      
      
      
       
    
       
            
                   
             
        
       
  
       
  
    
       
         
     
      
    } 
    
}

        
        
    
    

