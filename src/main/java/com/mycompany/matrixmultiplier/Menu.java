package com.mycompany.matrixmultiplier;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Menu extends JPanel implements ChangeListener{
    
    private JPanel grid = new JPanel();
    private JCheckBox checkSecuencial, checkParalelo;
    private JTextField labelNumThreads;
    private Struct_TypeOfMult typeOf;
    private int MAX_THREADS = Runtime.getRuntime().availableProcessors();
    
    public Menu()
    {
        this.checkSecuencial = setCheckButton("secuencial");
        this.checkParalelo = setCheckButton("paralela");
        initialize();
    }
    
    public void initialize()
    {
        grid.setLayout(new BoxLayout(grid, BoxLayout.Y_AXIS));
        
        labelNumThreads = new JTextField("Num treads");
        labelNumThreads.setEnabled(false);
        
        grid.add(this.checkSecuencial);
        grid.add(this.checkParalelo);
        grid.add(this.labelNumThreads);
        setTypeOf();
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == checkParalelo) {
            if (checkParalelo.isSelected()) {
                labelNumThreads.setEnabled(true);
            } else {
                labelNumThreads.setEnabled(false);
            }
        }
    }
             
    public void stateChangedAll() 
    {
        if (checkSecuencial.isSelected()) 
        {
            typeOf.secuential = true;
        } else {
            typeOf.secuential = false;
        }
        if (checkParalelo.isSelected()) 
        {
            typeOf.parallel = true;
            labelNumThreads.setEnabled(true);
            setNumThreads();
        } else {
            typeOf.parallel = false;
            typeOf.numOfThreads = 1;
            labelNumThreads.setEnabled(false);
        }
        
        if(typeOf.secuential == false && typeOf.parallel == false)
        {
            typeOf.secuential = true;
            typeOf.numOfThreads = 1;
        }
    }
    
    public void setNumThreads()
    {
        try
        {
            typeOf.numOfThreads = Integer.parseInt(labelNumThreads.getText());
            typeOf.numOfThreads = typeOf.numOfThreads > MAX_THREADS ? MAX_THREADS : typeOf.numOfThreads;
            typeOf.numOfThreads = typeOf.numOfThreads < 1 ? 2 : typeOf.numOfThreads;
        }catch (NumberFormatException ex) {
            typeOf.numOfThreads = 2;
            JOptionPane.showMessageDialog(null," Invalido, seran: " + typeOf.numOfThreads);
        }
    }
    
    public Struct_TypeOfMult getTypeOf()
    {
        stateChangedAll();
        return typeOf; 
    }
    public void setTypeOf()
    {
        typeOf = new Struct_TypeOfMult(true,false,1);
    }
    
    private JCheckBox setCheckButton(String name)
    {
        JCheckBox check = new JCheckBox(name);
        check.setBounds(2,2,2,2);
        check.setFocusable(false);
        check.addChangeListener(this);
        return check;
    }
    
    public String values()
    {
        stateChangedAll();
        String secu = typeOf.secuential ? "verdadero" : "falso";
        String para = typeOf.parallel ? "verdadero" : "falso";
        String a = "\n secuential is: " + secu + 
                   "\n Parallel is: " + para +  
                   "\n Threads:" + typeOf.numOfThreads;
        return a;
    }
    
    public JPanel getGrid()
    {
        return grid;
    }
}
