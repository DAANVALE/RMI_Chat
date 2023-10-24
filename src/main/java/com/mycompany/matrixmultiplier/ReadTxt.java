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
                    continue; // Ignorar líneas en blanco
                }

                String[] elementos = linea.split("[{},\\s]+"); // Dividir la línea por comas, llaves y espacios
                int numColumnas = elementos.length - 1; // Restar 1 para excluir el índice

                if (matriz == null) {
                    matriz = new int[numColumnas][numColumnas];
                }

                for (int columna = 1; columna <= numColumnas; columna++) {
                    matriz[fila][columna - 1] = Integer.parseInt(elementos[columna]);
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
