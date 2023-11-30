package com.mycompany.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

public interface ICallback_Client extends Remote {
    void receiveMessage(String message) throws RemoteException;
    String getUsername() throws RemoteException;
}
