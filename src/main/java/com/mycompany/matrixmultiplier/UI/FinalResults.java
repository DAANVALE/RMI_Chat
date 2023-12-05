package com.mycompany.matrixmultiplier.UI;

import com.mycompany.matrixmultiplier.CreateTxt;
import com.mycompany.matrixmultiplier.GlobalValues;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FinalResults extends JPanel {
    
    private JButton enviarTxt, mostrar;
    private JPanel finalMenuPanel;
    private int size = 0;
    
    public FinalResults(){
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
                CreateTxt.CreateFileTxt(GlobalValues.Grid1, "Matrix_1.txt");
                CreateTxt.CreateFileTxt(GlobalValues.Grid2, "Matrix_2.txt");
                CreateTxt.CreateFileTxt(GlobalValues.Grid3, "MatrixFinal.txt");
            }
        });

        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(size < 101)
                    {
                        MenuGrids newFrame = new MenuGrids(GlobalValues.Grid1, GlobalValues.Grid2, GlobalValues.Grid3);
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
}