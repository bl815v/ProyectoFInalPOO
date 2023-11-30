package model;

import java.time.LocalTime;

/**
 * La clase Hora proporciona un método estático para obtener la hora exacta.
 * 
 * @author David Garcia
 * @version 1.0
 */
public abstract class Hora {

    /** Representa la hora exacta en el momento de la creación del objeto. */
    private static LocalTime horaExacta;

    /**
     * Constructor de la clase Hora. Inicializa la horaExacta con la hora actual.
     */
    @SuppressWarnings("static-access")
    public Hora() {
        this.horaExacta = LocalTime.now();
    }

    /**
     * Obtiene la hora exacta en el momento de la llamada.
     * 
     * @return La hora exacta.
     */
    public static LocalTime obtenerHoraExacta() {
        return horaExacta;
    }
}
