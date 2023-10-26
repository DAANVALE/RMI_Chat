package com.mycompany.matrixmultiplier;

public class Struct_Ejecution {
    public boolean isConcurrent = false;
    public int numOfThreads = 1;
    public int size;
    public long time;
    
    public Struct_Ejecution(){}
    
    public Struct_Ejecution(boolean isConcurrent, int numOfThreads, int size, long time)
    {
        this.isConcurrent = isConcurrent;
        this.numOfThreads = numOfThreads;
        this.size = size;
        this.time = time;
    }
}
