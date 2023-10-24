package com.mycompany.matrixmultiplier;

import javax.swing.SwingUtilities;

public class MatrixMultiplier {
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    StarterMenu frame = new StarterMenu();
                }
            });
    }
}
