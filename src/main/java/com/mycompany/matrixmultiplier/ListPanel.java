/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matrixmultiplier;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListPanel extends JPanel {
    private DefaultListModel<String> listModel;
    private JList<String> lista;
    private Struct_Ejecution struct_Ejecution;
    
    public ListPanel() {
        listModel = new DefaultListModel<>();
        lista = new JList<>(listModel);
        lista.setVisibleRowCount(4); // Define el número de elementos visibles en la lista antes de que aparezca la barra de desplazamiento.

        JScrollPane scrollPane = new JScrollPane(lista);

        // Configura el diseño del panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void _setValues(Struct_Ejecution struct_Ejecution) {
        String isSecuential = ""; 
        String element = "";
        
        if(struct_Ejecution.isConcurrent)
        {
            isSecuential = "Concurrente: " + Integer.toString(struct_Ejecution.numOfThreads) + "hilos, de: ";
        }else
        {
            isSecuential = "Secuencial de: ";
        }
        
        element = isSecuential 
                + Integer.toString(struct_Ejecution.size) + "x" + Integer.toString(struct_Ejecution.size)
                + " en: " 
                + formatLargeNumber(struct_Ejecution.time);
        
        listModel.addElement(element);
    }
    
    public String formatLargeNumber(long time) {
        String[] suffix = new String[]{"nano", "micro", "mili", ""};
        int index = 0;
        
        double num = time;
        while (num >= 1000 && index < suffix.length - 1) {
            num /= 1000;
            index++;
        }
        
        NumberFormat nf = new DecimalFormat("##0.##");
        return nf.format(num) + " " + suffix[index] + " seg";
    }
}