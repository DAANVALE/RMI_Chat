package com.mycompany.matrixmultiplier.Interfaces;

import com.mycompany.matrixmultiplier.Models.Struct_Ejecution;
import com.mycompany.matrixmultiplier.Models.Struct_TypeOfMult;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IOperations extends Remote{
    
    public int[][] multiply(int[][] matrix1, int[][] matrix2, int numClients) throws RemoteException;
    
    public void takeValues() throws RemoteException;
    public void takeResult(int [][] mtx3) throws RemoteException;
}
