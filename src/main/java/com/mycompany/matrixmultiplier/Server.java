package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.Interfaces.IServer;
import com.mycompany.matrixmultiplier.Interfaces.IOperations;


import java.awt.Color;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Server extends JFrame {
    private JPanel panel = new JPanel();
    
    Server() {
        initComponents();
    }

    public void initComponents() {
        setTitle("SERVER");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createPanel();
        createServerInfoLabel();
        startRMIRegistry();

        setVisible(true);
    }

    private void startRMIRegistry() {
        try {
            Conections cx = new Conections();

            System.setProperty("java.rmi.server.hostname", GlobalValues.IP);
            Registry rmi = LocateRegistry.createRegistry(2000);
            System.out.println("Servidor Activo en: " + cx.obtenerIP());

            IServer serverActions = new ImplementacionServidor();
            rmi.rebind("Cliente", serverActions);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createPanel() {
        getContentPane().add(panel);
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);
    }

    private void createServerInfoLabel() {
        JLabel serverLabel = new JLabel();
        serverLabel.setBounds(10, 10, 200, 20);
        serverLabel.setText("Server Status: Active");
        panel.add(serverLabel);
    }

    public static void main(String[] args) {
        new Server();
    }
}