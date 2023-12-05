package com.mycompany.matrixmultiplier.Models;

public class Struct_Ejecution {
    public boolean isConcurrent = false;
    public int numOfThreads = 1;
    public int size;
    public long time;
    
    public Struct_Ejecution()
    {
        this.isConcurrent = false;
        this.numOfThreads = 1;
        this.size = 1;
        this.time = 1;
    }
    
    public Struct_Ejecution(boolean isConcurrent, int numOfThreads, int size, long time)
    {
        this.isConcurrent = isConcurrent;
        this.numOfThreads = numOfThreads;
        this.size = size;
        this.time = time;
    }
}
