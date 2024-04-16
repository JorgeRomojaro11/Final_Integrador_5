package InformacionCientifica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuscadorEnTextos {
    public static class ResultadoBusqueda {
        public int conteo;
        public List<Integer> lineas;

        public ResultadoBusqueda() {
            this.conteo = 0;
            this.lineas = new ArrayList<>();
        }
    }

    public static ResultadoBusqueda buscarPalabraLineal(String rutaArchivo, String palabra) throws IOException {
        ResultadoBusqueda resultado = new ResultadoBusqueda();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 1;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(palabra)) {
                    resultado.conteo++;
                    resultado.lineas.add(numeroLinea);
                }
                numeroLinea++;
            }
        }
        return resultado;
    }
}