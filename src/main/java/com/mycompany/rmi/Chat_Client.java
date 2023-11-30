package com.mycompany.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import javax.swing.JTextArea;

public class Chat_Client {
    IChat_Server chatService;
    
    public void startClient(String username, JTextArea jTextArea, String ip)
    {
        try 
        {
            String serverUrl = "rmi://"+ip+":9000/IChat_Server";
            
            chatService = (IChat_Server) Naming.lookup(serverUrl);

            Callback_Client clientCallback = new Callback_Client(username, jTextArea);
            chatService.registerClient(clientCallback, username);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String message, String username) throws RemoteException
    {
        chatService.broadcastMessage(username + ": " + message);
    }
    
    public void sendPrivate(String username, String privateuser, String message) throws RemoteException
    {
        chatService.sendDirectMessage(username, privateuser, message);
    }   
}
