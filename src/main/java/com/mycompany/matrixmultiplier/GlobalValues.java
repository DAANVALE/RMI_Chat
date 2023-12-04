package com.mycompany.matrixmultiplier;

public class GlobalValues {
    
    public static String IP = "127.0.0.1";
    
    public static int numClients;
    public static int ID;
    
    public static int[][] Grid1;
    public static int[][] Grid2;
    public static int[][] Grid3;
    
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
}
