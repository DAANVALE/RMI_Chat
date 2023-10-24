package com.mycompany.matrixmultiplier;

public class Multiplier {    
    public static int[][] _multiplier(int[][] grid1, int[][] grid2)
    {
        int[][] grid3 = new int[grid1.length][grid2[0].length];
        for (int i = 0; i < grid1.length; i++) 
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
}
