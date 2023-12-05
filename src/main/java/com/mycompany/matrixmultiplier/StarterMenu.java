package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.Interfaces.IOperations;
import com.mycompany.matrixmultiplier.Interfaces.IServer;
import com.mycompany.matrixmultiplier.UI.ListPanel;
import com.mycompany.matrixmultiplier.UI.Menu;
import com.mycompany.matrixmultiplier.UI.FinalResults;
import com.mycompany.matrixmultiplier.Models.Struct_Ejecution;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StarterMenu extends JFrame{
    
    IServer i_server;
    Registry rmii;
    IOperations i_operations;
    
    private JFrame frame;
    private JPanel MenuPanel;
    
    private JButton RUN_BUTTON;
    private Menu menu = new Menu();
    
    private FinalResults finalResults = new FinalResults();
    private JPanel finalPanel = new JPanel();
    private SizeMatrixPanel sizeMatrixPanel = new SizeMatrixPanel();
    
    private ListPanel listPanel = new ListPanel();
    private Struct_Ejecution struct_Ejecution;

    private int[][] Grid1, Grid2, Grid3;
    
    private int MATRIX_SIZE = 10;
    
    private boolean isREADTXTMATRIX = false;
    
    private JButton readMatrix;
    
    public StarterMenu()
    { 
        try{
            
            rmii = LocateRegistry.getRegistry(GlobalValues.IP, 2000);
            i_server = (IServer) rmii.lookup("Cliente");
            
            i_server.mensaje(i_operations);
            GlobalValues.SetID(i_server.getId() );

            System.out.print("Usuario: " + GlobalValues.ID);
            
        }catch(Exception e)
        {
             e.printStackTrace();
        }
        
        initialize();
    }
    
    public void initialize()
    {
        frame = new JFrame();
        this.frame.setTitle("Multiplicador de matrices");
        this.frame.setDefaultCloseOperation(StarterMenu.EXIT_ON_CLOSE);
        this.frame.setSize(800,180);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setLayout(new BorderLayout(5, 5));
        
        MenuPanel = new JPanel();
        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        
        RUN_BUTTON = RUNBUTTON();
        
        MenuPanel.add(RUN_BUTTON);
        MenuPanel.add(sizeMatrixPanel);
        MenuPanel.add(menu.getGrid());
        
        finalPanel = finalResults.getFinalMenuPanel();
        MenuPanel.add(finalPanel);
        MenuPanel.add(listPanel);
        
        frame.add(MenuPanel, BorderLayout.NORTH);
        this.frame.setVisible(true);
    }
    
    private JButton RUNBUTTON()
    {
        JButton button = new JButton("RUN");
        button.setMargin(new Insets(10, 10, 10, 10));
        button.setFocusable(false);
        button.setBackground(Color.RED);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IgualizerValues();
                RUN_Calculation();
                
                try
                {
                     GlobalValues.SetMatix3(i_server.getMatrix3());
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
                finalResults.setValues(GlobalValues.Grid1, GlobalValues.Grid2,GlobalValues.Grid3);
                finalResults.activateShow();
                JOptionPane.showMessageDialog(null,"Tam: " + MATRIX_SIZE + "\n" +menu.values());
            }
        });
        
        return button;
    }
    
    private void IgualizerValues()
    {
        if(!isREADTXTMATRIX)
        {
            readMatrix.setBackground(null);
            MATRIX_SIZE = sizeMatrixPanel.getSizeMatrix();
            GlobalValues.SetMatix1(RandomiceMatrix.SetValues(MATRIX_SIZE));
            GlobalValues.SetMatix2(RandomiceMatrix.SetValues(MATRIX_SIZE));
        }
    }
    
    private void RUN_Calculation()
    {
        isREADTXTMATRIX = false;
        long startTime = 0, endTime = 0;
        try {
            // Buscar el servicio remoto
            
            GlobalValues.SetNumClients(i_server.getId() );
            System.out.print("ID: " + GlobalValues.ID + " | Total: " + GlobalValues.numClients);
            
            Multiplier multiplier = new Multiplier();
            
            if(menu.getTypeOf().secuential)
            {
                startTime = System.nanoTime();
                Grid3 = multiplier.secuential(GlobalValues.Grid1, GlobalValues.Grid2);
                GlobalValues.SetMatix3(Grid3);
                endTime = System.nanoTime();
                System.out.print("\nSecuencial\n\t" + (endTime - startTime));
                setValuesIntoList(false, (endTime - startTime));
            }

            if (menu.getTypeOf().concurrent)
            {
                startTime = System.nanoTime();
                Grid3 = multiplier.concurrent(GlobalValues.Grid1, GlobalValues.Grid2, menu.getTypeOf().numOfThreads);
                GlobalValues.SetMatix3(Grid3);
                endTime = System.nanoTime();
                System.out.print("\nConcurrente\n\t" + (endTime - startTime));
                setValuesIntoList(true, (endTime - startTime));
            }
            
            i_server.setMatrix1(GlobalValues.Grid1);
            i_server.setMatrix2(GlobalValues.Grid2);
            i_server.setMatrix3(GlobalValues.Grid3);
            
            i_server.horaDelChambing(GlobalValues.ID);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    private void setValuesIntoList(boolean isConcurrent, long time)
    {
        struct_Ejecution = new Struct_Ejecution(
                isConcurrent, 
                menu.getTypeOf().numOfThreads, 
                MATRIX_SIZE, time);
        
        listPanel._setValues(struct_Ejecution);
    }

    public class SizeMatrixPanel extends JPanel {
        private JLabel label;
        private JTextField textField;

        public SizeMatrixPanel() {
            label = new JLabel("Tamaño Matriz");
            textField = new JTextField(1);
            readMatrix = ButtonReadMatrix();
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(label);
            add(textField);
            add(readMatrix);
        }

        public int getSizeMatrix() {
            try {
                int size = Integer.parseInt(textField.getText()) >= 2 ? Integer.parseInt(textField.getText()) : 10;
                return size > 5000 ? 5000 : size;
            } catch (NumberFormatException e) {
                return 10;
            }
        }
        
        public JButton ButtonReadMatrix()
        {
            JButton buttonReadMatrix = new JButton("Leer matriz");
            buttonReadMatrix.setFocusable(false);
            
            buttonReadMatrix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isREADTXTMATRIX = true;
                readMatrix.setBackground(Color.CYAN);
                Grid1 = ReadTxt.ReadFileTxt("Matrix_1.txt");
                GlobalValues.SetMatix1(Grid1);
                Grid2 = ReadTxt.ReadFileTxt("Matrix_2.txt");
                GlobalValues.SetMatix2(Grid2);
                //value3 = ReadTxt.ReadFileTxt("MatrixFinal.txt");
            }
        });            
            return buttonReadMatrix;
        }
    }
}
