package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.Interfaces.IOperations;
import com.mycompany.matrixmultiplier.Interfaces.IServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Operations extends UnicastRemoteObject implements IOperations{

    IServer i_server;
    Registry rmii;
    
    int[][] Grid1, Grid2, Grid3;
    
    protected Operations() throws RemoteException
    {
        try{       

            rmii = LocateRegistry.getRegistry(GlobalValues.IP, 2000);

        }catch(Exception e){
             e.printStackTrace();
        }
    }

    @Override
    public void takeValues() throws RemoteException {
        GlobalValues.SetMatix1(i_server.getMatrix1() );
        GlobalValues.SetMatix2(i_server.getMatrix2() );
        
        GlobalValues.SetStruct_Ejecution(i_server.getStructEjecution());
        GlobalValues.SetStruct_TypeOf(i_server.getTypeOfMult());
        
        GlobalValues.SetNumClients(i_server.getNumClients());
        
    }

    @Override
    public int[][] multiply(int[][] matrix1, int[][] matrix2) throws RemoteException {
        
        if( GlobalValues.Grid1 == matrix1 && GlobalValues.Grid2 == matrix2)
        {
            return GlobalValues.Grid3;
        }
        
        takeValues();
        
        
        System.out.print("fuiste de ayuda hermano <3");
        
        Multiplier multiplier = new Multiplier();
        long startTime = 0, endTime = 0;
        
        if(GlobalValues.structTypeOfMult.secuential)
        {
            startTime = System.nanoTime();
            Grid3 = multiplier.secuential(GlobalValues.Grid1, GlobalValues.Grid2);
            GlobalValues.SetMatix3(Grid3);
            endTime = System.nanoTime();
            System.out.print("\nSecuencial\n\t" + (endTime - startTime));
        }

        if (GlobalValues.structTypeOfMult.concurrent)
        {
            startTime = System.nanoTime();
            Grid3 = multiplier.concurrent(GlobalValues.Grid1, GlobalValues.Grid2, GlobalValues.structEjecution.numOfThreads);
            GlobalValues.SetMatix3(Grid3);
            endTime = System.nanoTime();
            System.out.print("\nConcurrente\n\t" + (endTime - startTime));
        }

        return Grid3;
    }
    
}
