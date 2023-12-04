package com.mycompany.matrixmultiplier;


import com.mycompany.matrixmultiplier.Interfaces.IClientCallBack;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientCallBackImp extends UnicastRemoteObject implements IClientCallBack{

    public ClientCallBackImp() throws RemoteException 
    {
        
    }
    
    public ClientCallBackImp(ArrayList<int[][]> listMat) throws RemoteException
    {
        GlobalValues.Grid1 = listMat.get(0).clone();
        GlobalValues.Grid2 = listMat.get(1).clone();
        
        if ( listMat.size() == 3 )
        {
            GlobalValues.Grid3 = listMat.get(2).clone();
        }
    }
    
    @Override
    public void getId(int id, int numClients) throws RemoteException {
        GlobalValues.SetID(id);
        GlobalValues.SetNumClients(numClients);
    }

    @Override
    public void takeMatrix(int[][] mtx1, int[][] mtx2) throws RemoteException {
        GlobalValues.Grid1 = mtx1.clone();
        GlobalValues.Grid2 = mtx2.clone();
    }

    @Override
    public void takeResults(int[][] mtx3) throws RemoteException {
        GlobalValues.Grid3 = mtx3.clone();
    }
    
}
