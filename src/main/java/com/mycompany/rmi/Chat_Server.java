package com.mycompany.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextArea;

public class Chat_Server extends UnicastRemoteObject implements IChat_Server {
    private Map<String, ICallback_Client> clients;

    public Chat_Server() throws RemoteException 
    {
        clients = new HashMap<>();
    }

    @Override
    public void registerClient(ICallback_Client client, String username) throws RemoteException 
    {
        clients.put(username, client);
        broadcastMessage(username + " connected");
    }

    private String getClientUsername(ICallback_Client client) throws RemoteException 
    {
    return client.getUsername();
    }

    @Override
    public void unregisterClient(ICallback_Client client) throws RemoteException {
        String username = getClientUsername(client);
        clients.remove(username);
    }

    @Override
    public void broadcastMessage(String message) throws RemoteException 
    {
        for (ICallback_Client client : clients.values()) 
        {
            client.receiveMessage(message);
        }
    }

    @Override
    public void sendDirectMessage(String sender, String receiver, String message) throws RemoteException 
    {
        ICallback_Client client = clients.get(receiver);

        if (client != null) {
            client.receiveMessage(sender + " whispers you: ~" + message + "~");
        }
    }
    
    public void connection(String Ip){
        try {
                IChat_Server chatService = new Chat_Server();

                LocateRegistry.createRegistry(9000);
                
                java.rmi.Naming.rebind("rmi://"+Ip+":9000/IChat_Server", chatService);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public static void main(String[] args) {
                try {
                IChat_Server chatService = new Chat_Server();

                LocateRegistry.createRegistry(9000);

                java.rmi.Naming.rebind("rmi://localhost:9000/IChat_Server", chatService);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
