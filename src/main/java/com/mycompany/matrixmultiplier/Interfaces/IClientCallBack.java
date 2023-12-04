package com.mycompany.matrixmultiplier.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IClientCallBack extends Remote{
    public void getId(int id, int numClients) throws RemoteException;
    public void takeMatrix(int[][] mtx1, int[][] mtx2) throws RemoteException;
    public void takeResults(int [][] mtx3) throws RemoteException;
}
