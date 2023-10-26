package com.mycompany.matrixmultiplier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateTxt {
    public static void CreateFileTxt(int[][] listaMatrix, String nombreArchivo) {
        
        int size = listaMatrix.length;
        ArrayList<String> listaString = new ArrayList<String>();
        for(int i = 0; i < size; i++){
            listaString.add(i + " {");
            for(int j = 0; j < size; j++){
                listaString.add(Integer.toString(listaMatrix[i][j]));
                if(j != (size-1))
                {
                    listaString.add(",");
                }
            }
            listaString.add("} \n");
        }
        
        try {
            FileWriter archivo = new FileWriter(nombreArchivo);

            BufferedWriter escritor = new BufferedWriter(archivo);

            for(String i : listaString)
            {
                escritor.write(i);
            }

            escritor.close();
            System.out.print("\nEl archivo se ha creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
