package com.mycompany.matrixmultiplier;

public class Multiplier {
    
    private int[][] grid1, grid2, grid3; 
    
    public Multiplier(){}
    
    public Multiplier(int[][] grid_1, int[][] grid_2)
    {
        setGrids(grid_1, grid_2);
        _multiplier();
    }
    
    public void _multiplier()
    {
        for(int i = 0; i < grid2.length; i++)
        {
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
    }
    
    public void setGrids(int[][] grid_1, int[][] grid_2)
    {
        this.grid1 = grid_1;
        this.grid2 = grid_2;
        this.grid3 = new int[grid_1.length][grid_2[0].length];
    }
    
    public int[][] getGrid_1()
    {
        return grid1;
    }
    
    public int[][] getGrid_2()
    {
        return grid2;
    }
    
    public int[][] getGrid_3()
    {
        return grid3;
    }
}
