package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.Interfaces.IOperations;
import com.mycompany.matrixmultiplier.Interfaces.IServer;
import com.mycompany.matrixmultiplier.Models.Struct_Ejecution;
import com.mycompany.matrixmultiplier.Models.Struct_TypeOfMult;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class GlobalValues {
    
    public static String IP = "127.0.0.1";
    
    public static int numClients;
    public static int ID;
    
    public static int[][] Grid1;
    public static int[][] Grid2;
    public static int[][] Grid3;
    
    public static Struct_Ejecution structEjecution;
    public static Struct_TypeOfMult structTypeOfMult;
    
    public static ArrayList<IOperations> opList; 
    
    public static void ChageIP(String newIP)
    {
        IP = newIP;
    }
    
    public static void SetID(int myClientId)
    {
        ID = myClientId;
    }
    
    public static void SetNumClients(int _numClients)
    {
        numClients = _numClients;
    }
    
    public static void SetMatix1(int[][] Matrix)
    {
        Grid1 = Matrix;
    }
    
    public static void SetMatix2(int[][] Matrix)
    {
        Grid2 = Matrix;
    }
    
    public static void SetMatix3(int[][] Matrix)
    {
        Grid3 = Matrix;
    }
    
    public static void SetStruct_Ejecution(Struct_Ejecution _structEjecution)
    {
        structEjecution = _structEjecution;
    }
    
    public static void SetStruct_TypeOf(Struct_TypeOfMult _structTypeOfMult)
    {
        structTypeOfMult = _structTypeOfMult;
    }
    
    public static void addListClients(IOperations op, int index)
    {
        try
        {
            IOperations operation = new Operations();
            java.rmi.Naming.rebind("rmi://"+GlobalValues.IP+":2000/Operations" + index, operation);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
