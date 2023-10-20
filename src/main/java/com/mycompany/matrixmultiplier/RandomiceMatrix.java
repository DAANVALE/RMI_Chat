package com.mycompany.matrixmultiplier;

public class RandomiceMatrix {
    public static int[][] SetValues(int size)
    {
        int[][] setValues = new int[size][size];
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                setValues[i][j] = (int) ((Math.random() * 20) - 10);
            } 
        }
        return setValues;
    } 
}
