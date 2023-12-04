package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.GlobalValues;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;

import java.util.logging.Logger;


public class Conections {
    static private final Logger LOGGER = Logger.getLogger("TestConections.Conections");

    String obtenerIP() throws UnknownHostException {
        
        try {
            InetAddress ip = InetAddress.getLocalHost();
            GlobalValues.ChageIP(ip.getHostAddress());
        }
        catch (UnknownHostException ex) {
            LOGGER.log(Level.SEVERE, "Error al consultar el Host");
            LOGGER.log(Level.SEVERE, null, ex);
        } 
        
        return GlobalValues.IP;
    }
}