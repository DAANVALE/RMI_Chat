package com.mycompany.matrixmultiplier;

public class Multiplier {    
    public static int[][] _multiplier(int[][] grid1, int[][] grid2)
    {
        int[][] grid3 = new int[grid1.length][grid2[0].length];
        for(int i = 0; i < grid2.length; i++)
        {
            if((i % 100) == 0)
                System.out.print((i / 100) + ": a\n");
            for(int j = 0; j < grid2[0].length; j++)
                {
                int suma = 0;
                for (int k = 0; k < grid2.length; k++) 
                {
                    suma += grid1[i][k] * grid2[k][j];
                }
                grid3[i][j] = suma;
            }
        }
        return grid3;
    }
}
