package com.mycompany.matrixmultiplier.Models;

public class Struct_TypeOfMult {
    
    public boolean secuential = false;
    public boolean concurrent = false;
    public int numOfThreads = 1;
    
    public Struct_TypeOfMult()
    {
        secuential = true;
        concurrent = false;
        numOfThreads = 1;
    }
    
    public Struct_TypeOfMult(boolean secuential, boolean concurrent, int numOfThreads)
    {
        this.secuential = secuential;
        this.concurrent = concurrent;
        this.numOfThreads = numOfThreads;
    }
}
