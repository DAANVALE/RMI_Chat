package com.mycompany.matrixmultiplier;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;

public class MatrixMultiplier {
    
    public static void main(String[] args) {
        
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage beforeHeapMemoryUsage = mbean.getHeapMemoryUsage();
        
        int size = 100;
        int sizeGrid = 400;
        int[][] valor;
                
        valor = RandomiceMatrix.SetValues(size);
        int[][] mult = Multiplier._multiplier(valor, valor);
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.print("cores:" + cores + "\n");

        ArrayList<String> arrayList = new ArrayList<String>();
        
        for(int i = 0; i < size; i++){
            if((i % 100) == 0)
            {
                System.out.print((i / 100) + ": b\n");
            }
            arrayList.add("\n" + i + " {");
            for(int j = 0; j < size; j++){
                arrayList.add(Integer.toString(mult[i][j]));
            }
            arrayList.add("}");
        }
        arrayList.add("\n");
        
//        DynamicGrid grid1 = new DynamicGrid(valor, false);
//        grid1.setTitle("Matriz");
//        grid1.setSize(sizeGrid * 2,sizeGrid);
//        grid1.setLocationRelativeTo(null);
//        grid1.setDefaultCloseOperation(DynamicGrid.DISPOSE_ON_CLOSE);
//        grid1.setVisible(true);
//        
//        DynamicGrid grid2 = new DynamicGrid(valor, false);
//        grid2.setTitle("Matriz");
//        grid2.setSize(sizeGrid * 2,sizeGrid);
//        grid2.setLocationRelativeTo(null);
//        grid2.setDefaultCloseOperation(DynamicGrid.DISPOSE_ON_CLOSE);
//        grid2.setVisible(true);
//        
//        DynamicGrid grid3 = new DynamicGrid(mult, true);
//        grid3.setTitle("Matriz");
//        grid3.setSize(sizeGrid * 2,sizeGrid);
//        grid3.setLocationRelativeTo(null);
//        grid3.setDefaultCloseOperation(DynamicGrid.DISPOSE_ON_CLOSE);
//        grid3.setVisible(true);
        
       //System.out.print(arrayList + "\n");
        
        MemoryUsage afterHeapMemoryUsage = mbean.getHeapMemoryUsage();
        long consumed =  afterHeapMemoryUsage.getUsed() - beforeHeapMemoryUsage.getUsed();
        System.out.println("Total consumed Memory:" + consumed);
    }
}
