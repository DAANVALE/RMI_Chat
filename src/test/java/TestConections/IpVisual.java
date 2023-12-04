package TestConections;

import com.mycompany.matrixmultiplier.UI.Menu;
import com.mycompany.matrixmultiplier.StarterMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class IpVisual extends JFrame{
    
    static private final Logger LOGGER = Logger.getLogger("TestConections.Conections");
    
    JFrame frame = new JFrame();
    
    JPanel myPanel = new JPanel();
    JButton ShowMyIp = new JButton();
    JButton ChangeMyIp = new JButton();
    JLabel ipIs = new JLabel(MyIpGlobal.myIp);
    
    IpVisual()
    {
        initailize();
    }
    
    private void initailize()
    {
        this.frame = new JFrame();
        this.frame.setTitle("Multiplicador de matrices");
        this.frame.setDefaultCloseOperation(StarterMenu.EXIT_ON_CLOSE);
        this.frame.setSize(800,130);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setLayout(new BorderLayout(5, 5));
        
        this.ShowMyIp = NewButton();
        this.ChangeMyIp = ChangeIp();
        
        this.myPanel.add(ipIs);
        this.myPanel.add(ShowMyIp);
        this.myPanel.add(ChangeMyIp);
        this.frame.add(myPanel); 
        
        
        this.frame.setVisible(true);
    }
    
    private JButton NewButton()
    {
        JButton button = new JButton("GET IP");
        button.setMargin(new Insets(10, 10, 10, 10));
        button.setFocusable(false);
        button.setBackground(Color.RED);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,MyIpGlobal.myIp);
            }
        });
        
        return button;
    }
    
    private JButton ChangeIp()
    {
        JButton button = new JButton("ChangeIp");
        button.setMargin(new Insets(10, 10, 10, 10));
        button.setFocusable(false);
        button.setBackground(Color.RED);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conections checkIP = new Conections();
                    System.out.println("La IP de su compuradora es " + checkIP.obtenerIP());
                    MyIpGlobal.changeIp(checkIP.obtenerIP());
                } catch (UnknownHostException ex) {
                    LOGGER.log(Level.SEVERE, "Error al consultar el Host");
                    LOGGER.log(Level.SEVERE, null, ex);
                }  
            }
        });
        
        return button;
    }
}
