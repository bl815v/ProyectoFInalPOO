package model;

public abstract class Horarios {

	
	public static int[][] nuevoHorario() {
		int[][] horario = new int[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				horario[i][j] = 0;
			}
		}
		return horario;
	}

	public static boolean horarioLibre(int[][] horario) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (horario[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean validarHorario(int[][] horarioPareja) {
	    for (int[] fila : horarioPareja) {
	        for (int valor : fila) {
	            if (valor == 1) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
}
