package com.mycompany.matrixmultiplier;

public class MatrixMultiplier {

    private DynamicGrid grid;
    
    public static void main(String[] args) {
        int size = 1000;
        int sizeGrid = 400;
        DynamicGrid grid = new DynamicGrid(size);
        grid.setTitle("Matriz");
        grid.setSize(sizeGrid * 2,sizeGrid);
        grid.setLocationRelativeTo(null);
        grid.setDefaultCloseOperation(grid.EXIT_ON_CLOSE);
        //grid.setVisible(true);
        
        Multiplier mult = new Multiplier(grid._getDataMatrix(), grid._getDataMatrix());
        int max = 0;
        
        System.out.print("[ \n");
        for(int i = 0; i < mult.getGrid_3().length; i++)
        {
            System.out.print("{");
            for(int j = 0; j < mult.getGrid_3()[0].length; j++)
            {
                System.out.print(mult.getGrid_3()[i][j] + ", ");
                if(max < mult.getGrid_3()[i][j])
                {
                    max = mult.getGrid_3()[i][j];
                }
            }
            System.out.print("},\n");
        }
        System.out.print("] \n " + max);
        
//        DynamicGrid grid2 = new DynamicGrid(mult.getGrid_3());
//        grid2.setTitle("End");
//        grid2.setSize(sizeGrid * 2,sizeGrid);
//        grid2.setLocationRelativeTo(null);
//        grid2.setDefaultCloseOperation(grid.EXIT_ON_CLOSE);
//        grid2.setVisible(true);
    }
}
