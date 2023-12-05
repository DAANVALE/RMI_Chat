package com.mycompany.matrixmultiplier.Interfaces;

import com.mycompany.matrixmultiplier.Models.Struct_TypeOfMult;
import com.mycompany.matrixmultiplier.Models.Struct_Ejecution;
import com.mycompany.matrixmultiplier.Operations;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public interface IServer extends Remote{
    
    public void mensaje(Registry rmi, IOperations op) throws RemoteException;
    
    public int getId() throws RemoteException;
    public int getNumClients() throws RemoteException;
    
    public void setTypeOfMult(Struct_TypeOfMult typeOfMult) throws RemoteException;
    public Struct_TypeOfMult getTypeOfMult() throws RemoteException;
    
    public void setStructEjecution(Struct_Ejecution ejecution) throws RemoteException;
    public Struct_Ejecution getStructEjecution() throws RemoteException;
    
    public void setMatrix1(int[][] Matrix) throws RemoteException;
    public int[][] getMatrix1() throws RemoteException;
    
    public void setMatrix2(int[][] Matrix) throws RemoteException;
    public int[][] getMatrix2() throws RemoteException;
    
    public void setMatrix3(int[][] Matrix) throws RemoteException;
    public int[][] getMatrix3() throws RemoteException;
    
    public void horaDelChambing(Registry rmii,int idPatron, int[][] grid1, int[][] grid2, int numClients) throws RemoteException;
    
}
    