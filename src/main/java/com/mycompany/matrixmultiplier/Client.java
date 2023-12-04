package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.Interfaces.IClientCallBack;
import java.net.MalformedURLException;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Client {
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    showIPInputDialog();
                    System.out.println("ip es: " + GlobalValues.IP );           
                    StarterMenu frame = new StarterMenu();
                }
            });
    }
    
     private static void showIPInputDialog() {
        // Crear un JOptionPane con un campo de entrada para la dirección IP
        String input = JOptionPane.showInputDialog(null, "Ingrese la dirección IP del cliente:");

        // Verificar si el usuario ingresó algo y actualizar la variable global
        if (input != null && !input.isEmpty()) {
            GlobalValues.IP = input;
        } else {
            // Manejar el caso en que el usuario haya cerrado la ventana sin ingresar una dirección IP
            System.out.println("Operación cancelada por el usuario.");
            System.exit(0);
        }
    }
}
