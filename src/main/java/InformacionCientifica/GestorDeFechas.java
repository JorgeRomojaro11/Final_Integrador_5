package InformacionCientifica;

import java.time.LocalDate;
import java.util.*;

public class GestorDeFechas {
    private List<LocalDate> fechas;

    public GestorDeFechas() {
        this.fechas = new ArrayList<>();
    }

    public void agregarFecha(LocalDate fecha) {
        this.fechas.add(fecha);
        Collections.sort(this.fechas);
    }

    public List<LocalDate> listarFechas() {
        return this.fechas;
    }
}