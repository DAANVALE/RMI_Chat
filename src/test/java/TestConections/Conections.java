package TestConections;

import com.mycompany.matrixmultiplier.GlobalValues;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;

import java.util.logging.Logger;


public class Conections {
    static private final Logger LOGGER = Logger.getLogger("TestConections.Conections");

    String obtenerIP() throws UnknownHostException {
        
        try {
            Conections checkIP = new Conections();
            System.out.println("La IP de su compuradora es " + checkIP.obtenerIP());
            MyIpGlobal.changeIp(checkIP.obtenerIP());
        
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