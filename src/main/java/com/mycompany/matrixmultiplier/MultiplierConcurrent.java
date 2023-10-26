package com.mycompany.matrixmultiplier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiplierConcurrent {
    public static int[][] multiply(int[][] grid1, int[][] grid2, int numOfThreads) 
    {
        int[][] grid3 = new int[grid1.length][grid2[0].length];

        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);

        try {
            List<Callable<Void>> tasks = new ArrayList<>();

            for (int i = 0; i < grid1.length; i++) {
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
}

//public class MultiplierConcurrent {
//    public static int[][] multiply(int[][] grid1, int[][] grid2, int numOfThreads) 
//    {
//        int[][] grid3 = new int[grid1.length][grid2[0].length];
//
//        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
//
//        try {
//            for (int i = 0; i < grid1.length; i++) {
//                final int row = i;
//                executorService.execute(() -> {
//                    for (int j = 0; j < grid2[0].length; j++) {
//                        int sum = 0;
//                        for (int k = 0; k < grid2.length; k++) {
//                            sum += grid1[row][k] * grid2[k][j];
//                        }
//                        grid3[row][j] = sum;
//                    }
//                });
//            }
//        } finally {
//            executorService.shutdown();
//        }
//
//        return grid3;
//    }
//}
