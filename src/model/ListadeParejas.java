package model;

import java.util.ArrayList;

/**
 * La clase ListadeParejas gestiona una lista de parejas y proporciona métodos para realizar operaciones en la lista.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class ListadeParejas {

    private ArrayList<Pareja> listadeParejas;

    /**
     * Constructor que inicializa la lista de parejas.
     */
    public ListadeParejas() {
        listadeParejas = new ArrayList<>();
    }

    /**
     * Busca una pareja en la lista por su usuario.
     * 
     * @param usuario El usuario de la pareja a buscar.
     * @return La pareja encontrada, o null si no se encuentra.
     */
    public Pareja buscarParejas(String usuario) {
        Pareja encontrada = null;
        for (Pareja x : listadeParejas) {
            if (x.getUser().equals(usuario)) {
                encontrada = x;
            }
        }
        return encontrada;
    }

    /**
     * Verifica si el usuario tiene otra pareja con el mismo día y hora.
     * 
     * @param usuario El usuario para el cual se realiza la verificación.
     * @param dia     El día a verificar.
     * @param hora    La hora a verificar.
     * @return true si el usuario tiene otra pareja con el mismo día y hora, false de lo contrario.
     */
    public boolean tieneOtraParejaConMismoDiaYHora(Usuario usuario, String dia, int hora) {
        for (Pareja otraPareja : listadeParejas) {
            if (!otraPareja.getUsuario().getUser().equals(usuario.getUser()) && otraPareja.getDia().equals(dia)
                    && otraPareja.getHora() == hora) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega una pareja a la lista si no existe previamente.
     * 
     * @param usuario La pareja a agregar.
     * @return true si la pareja se agrega exitosamente, false si ya existe en la lista.
     */
    public boolean agregarParejas(Pareja usuario) {
        Pareja aux = buscarParejas(usuario.getUser());
        if (aux == null) {
            listadeParejas.add(usuario);
            return true;
        }
        return false;
    }

    /**
     * Verifica si un correo ya está registrado en la lista de parejas.
     * 
     * @param correo El correo a verificar.
     * @return true si el correo ya está registrado, false de lo contrario.
     */
    public boolean correoRepetido(String correo) {
        if (listadeParejas.isEmpty()) {
            return false;
        }
        for (Pareja pareja : listadeParejas) {
            if (!pareja.getCorreo().equals(correo)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si un usuario ya está registrado en la lista de parejas.
     * 
     * @param user El usuario a verificar.
     * @return true si el usuario ya está registrado, false de lo contrario.
     */
    public boolean usuarioRepetido(String user) {
        if (listadeParejas.isEmpty()) {
            return false;
        }
        for (Pareja pareja : listadeParejas) {
            if (!pareja.getUser().equals(user)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Obtiene la lista de parejas.
     * 
     * @return La lista de parejas.
     */
    public ArrayList<Pareja> getListadeParejas() {
        return listadeParejas;
    }

    /**
     * Establece la lista de parejas.
     * 
     * @param listadeParejas La lista de parejas a establecer.
     */
    public void setListadeParejas(ArrayList<Pareja> listadeParejas) {
        this.listadeParejas = listadeParejas;
    }
}
