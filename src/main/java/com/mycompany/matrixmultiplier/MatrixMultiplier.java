package com.mycompany.matrixmultiplier;

public class MatrixMultiplier {

    private DynamicGrid grid;
    
    public static void main(String[] args) {
        int size = 100;
        int sizeGrid = 400;
        DynamicGrid grid = new DynamicGrid(size);
        grid.setTitle("Matriz");
        grid.setSize(sizeGrid * 2,sizeGrid);
        grid.setLocationRelativeTo(null);
        grid.setDefaultCloseOperation(grid.EXIT_ON_CLOSE);
        grid.setVisible(true);
    }
}
