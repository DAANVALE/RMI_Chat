package com.mycompany.matrixmultiplier.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DELL
 */
public interface IServer extends Remote{
    
    public void mensaje() throws RemoteException;
    
    public int getId() throws RemoteException;
    public int getNumClients() throws RemoteException;
    
}
    