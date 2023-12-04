package com.mycompany.matrixmultiplier.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IOperations extends Remote{
    public int[][] secuential(int[][] matrix1, int[][] matrix2) throws RemoteException;
    public int[][] concurrent(int[][] matrix1, int[][] matrix2) throws RemoteException;
    public int[][] concurrent(int[][] matrix1, int[][] matrix2, int numOfThreads) throws RemoteException;
    // public int[][] arregloM(ArrayList<int[][]> matrices);
}
