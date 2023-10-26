package com.mycompany.matrixmultiplier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FinalResults extends JPanel {
    private JButton enviarTxt, mostrar;
    private JPanel finalMenuPanel;
    private int[][] value1, value2, value3;
    private int size = 0;
    
    public FinalResults() {
        initialize();
    }
    
    public FinalResults(int[][] value1, int[][] value2, int[][] value3){
        setValues(value1, value2, value3);
        initialize();
    }

    public void initialize() {
        finalMenuPanel = new JPanel();
        finalMenuPanel.setLayout(new BoxLayout(finalMenuPanel, BoxLayout.Y_AXIS));
        
        JPanel panelRadioButtons = new JPanel();
        panelRadioButtons.setLayout(new BoxLayout(panelRadioButtons, BoxLayout.X_AXIS));

        enviarTxt = new JButton("Enviarlo a un txt");
        mostrar = new JButton("Visualizar");

        mostrar.setEnabled(false);
        enviarTxt.setEnabled(false);
        
        enviarTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTxt.CreateFileTxt(value1, "Matrix_1.txt");
                CreateTxt.CreateFileTxt(value2, "Matrix_2.txt");
                CreateTxt.CreateFileTxt(value3, "MatrixFinal.txt");
            }
        });

        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(size < 101)
                    {
                        MenuGrids newFrame = new MenuGrids(value1, value2, value3);
                        newFrame.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Muy Grande mejor metelo a un txt");
                    }
                }catch( Exception ex )
                {
                    JOptionPane.showMessageDialog(null, "Aguanta ando lento");
                }
            }
        });

        finalMenuPanel.add(enviarTxt);
        finalMenuPanel.add(mostrar);
    }
    
    public JPanel getFinalMenuPanel(){ return finalMenuPanel; }
    public void activateShow()
    {
        mostrar.setEnabled(true);
        enviarTxt.setEnabled(true);
    }
    
    public void setValues(int[][] value1, int[][] value2, int[][] value3)
    {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.size = value3[0].length;
    }
}