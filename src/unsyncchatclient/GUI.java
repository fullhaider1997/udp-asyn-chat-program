/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsyncchatclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
public class GUI extends javax.swing.JFrame {

    public static String address;
    public static int portnumber ;
    private String sendMessage;
    private  static String recievedMessage;
    private boolean buttonPressed;
    
    public String getAddress(){
        return address;
    }
     public String getsendMessage(){
        return sendMessage;
    }
      public static String getrecievedMessage(){
        return recievedMessage;
    }
      
        public void setMessage(String message){
        this.sendMessage = message;
    }
      public void setrecievedMessage(String message){
         this.recievedMessage = message;
    }
    
    public int getportnumber(){
        return portnumber;
    }
     public boolean getButtonIsEnable(){
        return buttonPressed;
    }
    
     public void setAddress(String address){
        this.address = address;
    }
     
    
    
    public void setPortnumber(int portnumber){
       this.portnumber = portnumber;
    }
    
    public void buttonIsEnable(boolean state){
        this.buttonPressed = state;
    }
    
   
    public GUI() {
        initComponents();
        
        portNumber.setText("5334");
        addressMachine.setText("LAPTOP-B719MUNI/192.168.77.1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        ActivateServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        portNumber = new javax.swing.JTextField();
        addressMachine = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        recievedText = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        sendText = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        togglebutton = new javax.swing.JButton();

        jScrollPane4.setViewportView(jTextPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ActivateServer.setText("Activate server");
        ActivateServer.setToolTipText("");
        ActivateServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivateServerActionPerformed(evt);
            }
        });

        jLabel1.setText("Ip address");

        jLabel2.setText("Port");

        recievedText.setColumns(20);
        recievedText.setRows(5);
        jScrollPane2.setViewportView(recievedText);

        jScrollPane1.setViewportView(sendText);

        jLabel3.setText("Recieved text");

        jLabel4.setText("Enter your text");

        togglebutton.setText("send");
        togglebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ActivateServer)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressMachine, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(portNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(togglebutton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActivateServer)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(portNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressMachine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(togglebutton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActivateServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivateServerActionPerformed
         
        if(ActivateServer.isEnabled())
        {
              
               
               setAddress(addressMachine.getText());
               setPortnumber(Integer.parseInt(portNumber.getText()));
               System.out.println("jframe: "+getAddress());
               System.out.println("jframe: "+getportnumber());
               setup st= new setup(Integer.parseInt(portNumber.getText()),addressMachine.getText());
               UnSyncChatClient client = new UnSyncChatClient();
               client.haider(st);
              
              
       
       }

    }//GEN-LAST:event_ActivateServerActionPerformed

    private void togglebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglebuttonActionPerformed
        // TODO add your handling code here:
           Boolean state = false;
            if(togglebutton.isEnabled()){
            UnSyncChatClient client = new UnSyncChatClient();
            try {
                System.out.println("kkkkkkkkkkkkkkkkkkkk jframe: "+ sendText.getText());
                client.Message( sendText.getText());
                client.buttonIs(true);
                state=true;
                
              
            } catch (InterruptedException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(state){
                
                System.out.println("from jframe recieved message:" +getrecievedMessage());
                recievedText.setText(getrecievedMessage() + "\n");
                
                state=false;
            }
    }//GEN-LAST:event_togglebuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActivateServer;
    private javax.swing.JTextField addressMachine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextField portNumber;
    private javax.swing.JTextArea recievedText;
    private javax.swing.JTextPane sendText;
    private javax.swing.JButton togglebutton;
    // End of variables declaration//GEN-END:variables
}
