package ADN;

public class AnalisisGenomico {

    public static int cuentaGenes(String adn) {
        int cuenta = 0;
        int indice = adn.indexOf("ATG");

        while (indice != -1) {
            cuenta++;
            indice = adn.indexOf("ATG", indice + 1);
        }

        return cuenta;
    }

    public static int calculaCombinacionesGeneticas(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculaCombinacionesGeneticas(n - 1);
        }
    }
}