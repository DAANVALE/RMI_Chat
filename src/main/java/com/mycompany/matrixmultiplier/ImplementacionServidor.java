package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.Interfaces.IClientCallBack;
import com.mycompany.matrixmultiplier.Interfaces.IServer;
import com.mycompany.matrixmultiplier.Interfaces.IOperations;
import com.mycompany.matrixmultiplier.Models.Enums.ADD_REMOVE;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import javax.swing.JOptionPane;

public class ImplementacionServidor extends UnicastRemoteObject implements IServer {

    static int index = 0;

    ImplementacionServidor() throws RemoteException {

    }

    @Override
    public void mensaje() throws RemoteException {
        System.out.print("Cliente: " + (index + 1) + "Agregado");
        index++;
    }

    @Override
    public int getId() throws RemoteException {
        return index;
    }

    @Override
    public int getNumClients() throws RemoteException {
        return index;
    }
    
    
}
