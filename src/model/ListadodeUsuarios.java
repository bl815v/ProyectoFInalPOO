package model;

import java.util.ArrayList;

/**
 * La clase ListadodeUsuarios gestiona una lista de usuarios y proporciona métodos para acceder a la lista.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class ListadodeUsuarios {

    private ArrayList<Usuario> ListadeUsuarios;

    /**
     * Constructor que inicializa la lista de usuarios.
     */
    public ListadodeUsuarios() {
        ListadeUsuarios = new ArrayList<>();
    }

    /**
     * Busca un usuario por su nombre de usuario en la lista de usuarios.
     * 
     * @param usuario El nombre de usuario a buscar.
     * @return El usuario encontrado o null si no se encuentra.
     */
    public Usuario buscarUsuario(String usuario) {
        Usuario encontrada = null;
        for (Usuario x : ListadeUsuarios) {
            if (x.getUser().equals(usuario)) {
                encontrada = x;
            }
        }
        return encontrada;
    }

    /**
     * Agrega un usuario a la lista de usuarios si no existe un usuario con el mismo nombre de usuario.
     * 
     * @param usuario El usuario a agregar.
     * @return true si el usuario se agregó correctamente, false si ya existe un usuario con el mismo nombre de usuario.
     */
    public boolean agregarUsuario(Usuario usuario) {
        Usuario aux = buscarUsuario(usuario.getUser());

        if (aux == null) {
            ListadeUsuarios.add(usuario);
            return true;
        }
        return false;
    }

    /**
     * Verifica si hay un correo electrónico repetido en la lista de usuarios.
     * 
     * @param correo El correo electrónico a verificar.
     * @return true si el correo electrónico ya existe en la lista, false si no.
     */
    public boolean correoRepetido(String correo) {
        if (ListadeUsuarios.isEmpty()) {
            return false;
        }
        for (Usuario usuario : ListadeUsuarios) {
            if (!usuario.getCorreo().equals(correo)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si hay un nombre de usuario repetido en la lista de usuarios.
     * 
     * @param user El nombre de usuario a verificar.
     * @return true si el nombre de usuario ya existe en la lista, false si no.
     */
    public boolean usuarioRepetido(String user) {
        if (ListadeUsuarios.isEmpty()) {
            return false;
        }
        for (Usuario usuario : ListadeUsuarios) {
            if (!usuario.getUser().equals(user)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Obtiene la lista de usuarios.
     * 
     * @return La lista de usuarios.
     */
    public ArrayList<Usuario> getListadeUsuarios() {
        return ListadeUsuarios;
    }

    /**
     * Establece la lista de usuarios.
     * 
     * @param listadeUsuarios La lista de usuarios a establecer.
     */
    public void setListadeUsuarios(ArrayList<Usuario> listadeUsuarios) {
        ListadeUsuarios = listadeUsuarios;
    }
}
