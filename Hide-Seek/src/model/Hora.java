package model;

import java.time.LocalTime;

public abstract class Hora {
	
    private static LocalTime horaExacta;
    
    @SuppressWarnings("static-access")
	public Hora() {
        this.horaExacta = LocalTime.now();
    }

    public static LocalTime obtenerHoraExacta() {
        return horaExacta;
    }

    
    
}
