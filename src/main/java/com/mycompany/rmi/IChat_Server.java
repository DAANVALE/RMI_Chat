/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

public interface IChat_Server extends Remote {
    void registerClient(ICallback_Client client, String username) throws RemoteException;
    void unregisterClient(ICallback_Client client) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;
    void sendDirectMessage(String sender, String receiver, String message) throws RemoteException;
}
