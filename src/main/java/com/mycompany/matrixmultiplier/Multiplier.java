package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.Interfaces.IOperations;
import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multiplier {
    
    int startRow = 0;
    int finalRow = 0;
    
    protected Multiplier() throws RemoteException
    {
        super();
    }
    
    public int[][] secuential(int[][] grid1, int[][] grid2)
    {
        grid1 = GlobalValues.Grid1; 
        grid2 = GlobalValues.Grid2;
        int[][] grid3 = new int[grid1.length][grid2[0].length];
        
        //System.out.print(" L:" + grid1.length + ": NC:" + GlobalValues.numClients + " : ID" + GlobalValues.numClients);
        
        getStartFinalRows(grid1.length);
        
        for (int i = startRow; i <= finalRow; i++) 
        {
            final int row = i;
            for (int j = 0; j < grid2[0].length; j++) 
            {
                int sum = 0;
                for (int k = 0; k < grid2.length; k++) 
                {
                    sum += grid1[row][k] * grid2[k][j];
                }
                grid3[row][j] = sum;
            }
        }
        return grid3;
    }
    
    public int[][] concurrent(int[][] grid1, int[][] grid2, int numOfThreads)
    {
        int[][] grid3 = new int[grid1.length][grid2[0].length];

        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        
        //System.out.print(" L:" + grid1.length + ": NC:" + GlobalValues.numClients + " : ID" + GlobalValues.numClients);
        
        getStartFinalRows(grid1.length);
        
        try {
            List<Callable<Void>> tasks = new ArrayList<>();

            for (int i = startRow; i <= finalRow; i++) {
                final int row = i;
                Callable<Void> task = () -> {
                    for (int j = 0; j < grid2[0].length; j++) {
                        int sum = 0;
                        for (int k = 0; k < grid2.length; k++) {
                            sum += grid1[row][k] * grid2[k][j];
                        }
                        grid3[row][j] = sum;
                    }
                    return null;
                };
                tasks.add(task);
            }

            List<Future<Void>> futures = executorService.invokeAll(tasks);

            for (Future<Void> future : futures) {
                future.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        return grid3;
    }
    
    public void getStartFinalRows(int legth)
    {
        int RPC = legth / GlobalValues.numClients;
        int Sobrante = legth % GlobalValues.numClients;

        int start = 0;
        for (int i = 0; i < GlobalValues.numClients; i++) 
        {
            int extra = i < Sobrante ? 1 : 0;
            
            startRow = start;
            finalRow = start + RPC - 1 + extra;
            
            if((GlobalValues.ID - 1) == i)
            {
                return;
            }
            
            start = finalRow + 1;
        }
    }
}