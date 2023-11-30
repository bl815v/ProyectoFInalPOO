package model;

/**
 * La clase Admin representa a un administrador en el sistema.
 * Extiende de la clase Persona, heredando atributos como usuario, rol y clave.
 *
 * @author David Garcia
 * @version 1.0
 */
public class Admin extends Persona {

    /**
     * Constructor de la clase Admin.
     *
     * @param user  El nombre de usuario del administrador.
     * @param rol   El rol del administrador.
     * @param clave La clave de acceso del administrador.
     */
    public Admin(String user, String rol, String clave) {
        super(user, rol, clave);
        this.User = user;
        this.Rol = rol;
        this.clave = clave;
    }
}
