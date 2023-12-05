package com.mycompany.matrixmultiplier;

import com.mycompany.matrixmultiplier.Interfaces.IOperations;
import com.mycompany.matrixmultiplier.Interfaces.IServer;
import com.mycompany.matrixmultiplier.Models.Struct_Ejecution;
import com.mycompany.matrixmultiplier.Models.Struct_TypeOfMult;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImp extends UnicastRemoteObject implements IServer {

    static int index = 0;

    ServerImp() throws RemoteException {

    }
    
    public void mostrarDatosClienteEnServer(int[][] Matrix, int numMatrix)
    {
        System.out.print("\n Cliente manda la matriz: " + numMatrix + "\n");
    }
    

    @Override
    public void mensaje(IOperations op) throws RemoteException {
        index++;
        GlobalValues.addListClients(op, index);
    }

    @Override
    public int getId() throws RemoteException {
        return index;
    }

    @Override
    public int getNumClients() throws RemoteException {
        return index;
    }   

    @Override
    public void setMatrix1(int[][] Matrix) throws RemoteException {       
        mostrarDatosClienteEnServer(Matrix, 1);
        GlobalValues.SetMatix1(Matrix);
    }

    @Override
    public int[][] getMatrix1() throws RemoteException {
        return GlobalValues.Grid1;
    }

    @Override
    public void setMatrix2(int[][] Matrix) throws RemoteException {
        mostrarDatosClienteEnServer(Matrix, 2);
        GlobalValues.SetMatix2(Matrix);
    }

    @Override
    public int[][] getMatrix2() throws RemoteException {
        return GlobalValues.Grid2;
    }

    @Override
    public void setMatrix3(int[][] Matrix) throws RemoteException {
        mostrarDatosClienteEnServer(Matrix, 3);
        
        try
        {    
            if(GlobalValues.Grid3.length != Matrix.length)
            {
                GlobalValues.SetMatix3(Matrix);
                return;
            }
        }catch(Exception ex)
        {
            GlobalValues.SetMatix3(Matrix);
        }
        
        int[][] MyMatrixTemp = GlobalValues.Grid3;
        
        for(int i = 0; i < Matrix.length; i++)
        {
            for(int j = 0; j < Matrix.length; j++)
            {
                if(GlobalValues.Grid3[i][j] == 0)
                {
                    MyMatrixTemp[i][j] = Matrix[i][j];
                }
            }
        }
        
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length; j++) {
                System.out.print(MyMatrixTemp[i][j]);

                // Agregar una coma después de cada elemento, excepto el último en la fila
                if (j < Matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }

            // Agregar un salto de línea después de cada fila, excepto la última
            if (i < Matrix.length - 1) {
                System.out.println();
            }
        }
        
        GlobalValues.SetMatix3(MyMatrixTemp);
    }

    @Override
    public int[][] getMatrix3() throws RemoteException {
        return GlobalValues.Grid3;
    }

    @Override
    public void setTypeOfMult(Struct_TypeOfMult typeOfMult) throws RemoteException {
        GlobalValues.SetStruct_TypeOf(typeOfMult);
    }

    @Override
    public Struct_TypeOfMult getTypeOfMult() throws RemoteException {
        return GlobalValues.structTypeOfMult;
    }

    @Override
    public void setStructEjecution(Struct_Ejecution ejecution) throws RemoteException {
        GlobalValues.SetStruct_Ejecution(ejecution);
    }

    @Override
    public Struct_Ejecution getStructEjecution() throws RemoteException {
        return GlobalValues.structEjecution;
    }
    
    Registry rmii;
    
    @Override
    public void horaDelChambing( int idPatron ) throws RemoteException{
        try {

            int[][] finalResult = new int[GlobalValues.Grid1.length][GlobalValues.Grid2[0].length];

            for (int i = 0; i < GlobalValues.numClients; i++) {

                IOperations clientOp = GlobalValues.opList.get(i);
                finalResult = clientOp.multiply(GlobalValues.Grid1, GlobalValues.Grid2);
                setMatrix3(finalResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
