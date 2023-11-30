package model;

/**
 * La clase Persona es la clase base para representar a una persona en el sistema.
 * Contiene atributos comunes como nombre de usuario, rol y clave, y métodos para acceder y modificar estos atributos.
 * Esta clase es utilizada como clase base para las clases Usuario y Pareja.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class Persona {

    /**
     * El nombre de usuario de la persona.
     */
    protected String User;

    /**
     * El rol de la persona.
     */
    protected String Rol;

    /**
     * La clave (contraseña) de la persona.
     */
    protected String clave;

    /**
     * Constructor para la clase Persona.
     * 
     * @param user   El nombre de usuario de la persona.
     * @param rol    El rol de la persona.
     * @param clave  La clave (contraseña) de la persona.
     */
    public Persona(String user, String rol, String clave) {
        this.User = user;
        this.Rol = rol;
        this.clave = clave;
    }

    /**
     * Obtiene el nombre de usuario de la persona.
     * 
     * @return El nombre de usuario.
     */
    public String getUser() {
        return User;
    }

    /**
     * Establece el nombre de usuario de la persona.
     * 
     * @param user El nuevo nombre de usuario.
     */
    public void setUser(String user) {
        User = user;
    }

    /**
     * Obtiene el rol de la persona.
     * 
     * @return El rol de la persona.
     */
    public String getRol() {
        return Rol;
    }

    /**
     * Establece el rol de la persona.
     * 
     * @param rol El nuevo rol de la persona.
     */
    public void setRol(String rol) {
        Rol = rol;
    }

    /**
     * Obtiene la clave (contraseña) de la persona.
     * 
     * @return La clave de la persona.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Establece la clave (contraseña) de la persona.
     * 
     * @param clave La nueva clave de la persona.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
}
