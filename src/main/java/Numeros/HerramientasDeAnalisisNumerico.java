package Numeros;

public class HerramientasDeAnalisisNumerico {

    public static int sumaNumerosNaturales(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumaNumerosNaturales(n - 1);
        }
    }
    public static void listaNumerosEnRango(int inicio, int fin) {
        if (inicio > fin) {
            return;
        } else {
            System.out.println(inicio);
            listaNumerosEnRango(inicio + 1, fin);
        }
    }

    public static int potencia(int base, int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }

    public static int encuentraMaximo(int[] datos) {
        int maximo = datos[0];
        for (int i = 1; i < datos.length; i++) {
            if (datos[i] > maximo) {
                maximo = datos[i];
            }
        }
        return maximo;
    }
}