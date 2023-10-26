package com.mycompany.matrixmultiplier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTxt {
    public static int[][] ReadFileTxt(String nombreArchivo) {
        int[][] matriz = null;
        try {

            String path = nombreArchivo;
            File archivo = new File(path);
            Scanner scanner = new Scanner(archivo);

            int fila = 0;

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (linea.isEmpty()) {
                    continue; 
                }

                String[] elementos = linea.split("[{},\\s]+");
                int numColumnas = elementos.length - 1;

                if (matriz == null) {
                    matriz = new int[numColumnas][numColumnas];
                }

                for (int columna = 0; columna < numColumnas; columna++) {
                    matriz[fila][columna] = Integer.parseInt(elementos[columna + 1]);
                    
                    if(matriz[fila][columna] != 0)
                    {
                        matriz[fila][columna] %= 10;
                    }
                }

                fila++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matriz;
    }
}
