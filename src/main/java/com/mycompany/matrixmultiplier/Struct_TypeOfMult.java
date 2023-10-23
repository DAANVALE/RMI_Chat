package com.mycompany.matrixmultiplier;

public class Struct_TypeOfMult {
    
    public boolean secuential = false;
    public boolean parallel = false;
    public int numOfThreads = 1;
    
    public Struct_TypeOfMult(){}
    
    public Struct_TypeOfMult(boolean secuential, boolean parallel, int numOfThreads)
    {
        this.secuential = secuential;
        this.parallel = parallel;
        this.numOfThreads = numOfThreads;
    }
}
