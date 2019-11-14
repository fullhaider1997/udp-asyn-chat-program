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
    public static void main(String[] args) throws IOException, InterruptedException 
    {
  
        
        GUI gui = new GUI();
        gui.setVisible(true);
        int i=0;
        
       System.out.println("Running UnSyncChatClient.java");
       System.out.println("Client is Up....");
       System.out.println("from client:" +gui.getAddress());
       System.out.println("from client: "+gui.getportnumber());
       ss = new DatagramSocket(gui.getportnumber());
       ip = InetAddress.getByName(gui.getAddress());
      
            
                   
                
        
        
                       

        // with a nested runnable class definition 
        Thread ssend = new Thread(new Runnable() { 
            @Override
            public void run() 
            { 
                try { 
                    System.out.print("client:");
                    Scanner sc = new Scanner(System.in); 
                    while (true) { 
                        synchronized (this) 
                        { 
                            byte[] sd = new byte[1000]; 
  
                            // scan new message to send 
                            sd = sc.nextLine().getBytes(); 
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
                                break; 
                            } 
                            System.out.println("Waiting for"
                                               + " server response... "); 
                        } 
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
                    while (true) { 
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
  
                            // Exit condition 
                            if (msg.equals("bye")) { 
                                System.out.println("client"
                                                   + " connection closed."); 
                                break; 
                            } 
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
}
        
        
    
    

