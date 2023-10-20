package com.mycompany.matrixmultiplier;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DynamicGrid1 extends JFrame{
    
    private int size, cubicsize;
    private int[] data;
    private int[][] dataMatrix;
    private JPanel grid;
    
    public DynamicGrid1(int[] data)
    {
        _setData(data);
        draw();
    }
    
    public DynamicGrid1(int [][] dataMatrix)
    {
        _setDataMatrix(dataMatrix);
        draw();
    }
    
    private void draw_test()
    {
        setLayout(new GridLayout(size,size));
        JLabel[] label = new JLabel[cubicsize];
        
        for(int i = 0; i < cubicsize; i++)
        {
            label[i] = Model(data[i]);
            add(label[i]);
        }
    }
    
    private void draw()
    {
        grid = new JPanel(new GridLayout(size, size));
        JScrollPane scrollPane = new JScrollPane(grid);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JLabel[][] label = new JLabel[size][size];
        
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++){
                
            label[i][j] = Model(dataMatrix[i][j]);
            
            int color = 0;
            int r=0;
            int g=0;
            int b=0;
            
            if(dataMatrix[i][j] >= -10 && dataMatrix[i][j] <= 10)
            {
                int aux = dataMatrix[i][j];
                if(aux < 0)
                {
                    aux = 0 - aux;
                }
                color = 255 - (25 * aux);
                r = color; g = color; b = color;
            }
            
            label[i][j].setOpaque(true);
            label[i][j].setBackground( new Color(r,g,b));
            grid.add(label[i][j]);
            }
        }
        
        getContentPane().add(scrollPane);

        setTitle("Mostrar Layout");
        setSize(50, 50); // Ajusta el tamaño según tus necesidades
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public JLabel Model(int value)
    {
        JLabel model = new JLabel(" " + value + " ",JLabel.CENTER);
        model.setFont(new Font("Courier New", Font.ITALIC, 15));
        //model.setSize(50, 50);
        model.setForeground(Color.blue);
        return model;
    }
    
    public int _getSize(){ return size; }
    public void _setSize(int size)
    { 
        this.size = size; 
        this.cubicsize = (int) Math.pow(size,2);
        this.data = new int[cubicsize];
        this.dataMatrix = new int[size][size];
        
        randomizedValues();
        
    }
    
    public int[] _getData(){ return data; }
    public void _setData(int[] data)
    { 
        this.data = data;
        this.cubicsize = data.length;
        this.size = (int) Math.sqrt(data.length);
        this.dataMatrix = parser(data);
    }
    
    public int[][] _getDataMatrix() { return dataMatrix; }
    public void _setDataMatrix(int [][] dataMatrix)
    {
        this.dataMatrix = dataMatrix;
        this.cubicsize = dataMatrix.length * dataMatrix[0].length;
        this.size = dataMatrix.length;
        this.data = parser(dataMatrix);
    }
    
    private void randomizedValues()
    {
//        for(int i = 0; i < cubicsize; i++)
//        {
//            data[i] = (int) (Math.random() * 10);
//        }
//        
//        dataMatrix = parser(data);    
        dataMatrix = RandomiceMatrix.SetValues(size);
        data = parser(dataMatrix);
    }
    
    public int[][] parser(int[] value)
    {
        int value_size = (int) Math.sqrt(value.length);
        int[][] exit = new int [value_size][value_size];
        
        int index = 0;
        for(int i = 0; i < value_size; i++)
        {
            for(int j = 0; j < value_size; j++)
            {
                exit[i][j] = value[index];
                index++;
            }
        }
        
        return exit;
    }
    public int[] parser(int [][] value)
    {
        int value_size = value.length * value[0].length;
        int[] exit = new int[value_size];
        
        int index = 0;
        for(int i = 0; i < value.length; i++)
        {
            for(int j = 0; j < value[0].length; j++)
            {
                exit[index] = value[i][j];
                index++;
            }
        }
        
        return exit;
    }
}
