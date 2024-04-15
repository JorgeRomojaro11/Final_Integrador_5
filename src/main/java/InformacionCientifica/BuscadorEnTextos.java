package InformacionCientifica;

import java.io.*;
import java.util.*;

public class BuscadorEnTextos {
    public static boolean buscarPalabraLineal(String rutaArchivo, String palabra) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String linea;

        while ((linea = reader.readLine()) != null) {
            if (linea.contains(palabra)) {
                return true;
            }
        }

        reader.close();
        return false;
    }

    public static boolean buscarPalabraBinaria(String rutaArchivo, String palabra) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        ArrayList<String> lineas = new ArrayList<>();
        String linea;

        while ((linea = reader.readLine()) != null) {
            lineas.add(linea);
        }

        Collections.sort(lineas);

        int indice = Collections.binarySearch(lineas, palabra);
        reader.close();

        return indice >= 0;
    }
}