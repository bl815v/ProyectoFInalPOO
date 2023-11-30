package model;

/**
 * La clase abstracta Horarios proporciona métodos estáticos para gestionar horarios.
 * 
 * @author David Garcia
 * @version 1.0
 */
public abstract class Horarios {

    /**
     * Crea un nuevo horario inicializado con todos los valores en 0.
     * 
     * @return Un nuevo horario.
     */
    public static int[][] nuevoHorario() {
        int[][] horario = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                horario[i][j] = 0;
            }
        }
        return horario;
    }

    /**
     * Verifica si hay algún valor igual a 1 en el horario.
     * 
     * @param horario El horario a verificar.
     * @return true si hay al menos un valor igual a 1, false de lo contrario.
     */
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

    /**
     * Valida si hay al menos un valor igual a 1 en el horario de pareja.
     * 
     * @param horarioPareja El horario de pareja a validar.
     * @return true si hay al menos un valor igual a 1, false de lo contrario.
     */
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
