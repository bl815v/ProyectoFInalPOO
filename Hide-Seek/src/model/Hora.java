package model;

import java.time.LocalTime;

public class Hora {
	
    private LocalTime horaExacta;

    public Hora() {
        this.horaExacta = LocalTime.now();
    }

    public LocalTime obtenerHoraExacta() {
        return horaExacta;
    }
}
