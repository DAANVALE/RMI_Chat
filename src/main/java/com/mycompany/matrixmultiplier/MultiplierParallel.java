package com.mycompany.matrixmultiplier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MultiplierParallel {
    public static int[][] multiply(int[][] grid1, int[][] grid2, int numOfThreads) 
    {
        int[][] grid3 = new int[grid1.length][grid2[0].length];

        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);

        try {
            for (int i = 0; i < grid1.length; i++) {
                final int row = i;
                Future<?> future = executorService.submit(() -> {
                    for (int j = 0; j < grid2[0].length; j++) {
                        int sum = 0;
                        for (int k = 0; k < grid2.length; k++) {
                            sum += grid1[row][k] * grid2[k][j];
                        }
                        grid3[row][j] = sum;
                    }
                });
            }
        } finally {
            executorService.shutdown();
        }

        return grid3;
    }
}
