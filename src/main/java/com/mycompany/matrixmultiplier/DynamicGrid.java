package com.mycompany.matrixmultiplier;

import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DynamicGrid extends JPanel{
    
    public static JPanel draw(int dataMatrix[][])
    {
        return draw(dataMatrix,false);
    }
    
    public static JPanel draw(int dataMatrix[][], boolean isFinal)
    {
        int size = dataMatrix.length;
        JPanel grid = new JPanel(new GridLayout(size, size));
        JScrollPane scrollPane = new JScrollPane(grid);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JLabel[][] label = new JLabel[size][size];
        
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++){
                
                label[i][j] = Model(dataMatrix[i][j]);

                int color = 0;
                int r = 0;
                int g = 0;
                int b = 0;

                int aproxMax = size * 18;
                
                int aux = (dataMatrix[i][j] < 0) ? - dataMatrix[i][j] : dataMatrix[i][j];
                aux = (aux > aproxMax) ? aproxMax : aux;
                
                if(!isFinal)
                {
                    color = 255 - (25 * aux);
                    r = color; g = color; b = color;
                }
                else
                {
                    label[i][j].setForeground(Color.BLACK);
                    r = (int) (255 - (255 * aux / aproxMax));
                    g = (int) (255 * aux / aproxMax);
                    b = 0;
                    
                    if (dataMatrix[i][j] < 0) {
                        label[i][j].setForeground(Color.WHITE);
                        b = r;
                        r = g;
                        g = 0;
                    }
                }
                label[i][j].setOpaque(true);
                label[i][j].setBackground( new Color(r,g,b));
                grid.add(label[i][j]);
            }
        }
        return grid;
    }
     
    private static JLabel Model(int value)
    {
        JLabel model = new JLabel(" " + value + " ",JLabel.CENTER);
        model.setFont(new Font("Courier New", Font.ITALIC, 15));
        model.setForeground(Color.blue);
        return model;
    }
}