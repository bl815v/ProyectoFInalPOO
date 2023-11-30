package model;

/**
 * La clase Sede representa una ubicación física en la que se pueden realizar compras.
 * Contiene atributos como dirección y nombre, y métodos para acceder y modificar estos atributos.
 * Esta clase es utilizada para representar las sedes disponibles en el sistema.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class Sede {

    /**
     * La dirección de la sede.
     */
    String Direccion;

    /**
     * El nombre de la sede.
     */
    String Nombre;

    /**
     * Constructor para la clase Sede.
     * 
     * @param direccion La dirección de la sede.
     * @param nombre    El nombre de la sede.
     */
    public Sede(String direccion, String nombre) {
        this.Direccion = direccion;
        this.Nombre = nombre;
    }

    /**
     * Obtiene la dirección de la sede.
     * 
     * @return La dirección de la sede.
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * Establece la dirección de la sede.
     * 
     * @param direccion La nueva dirección de la sede.
     */
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    /**
     * Obtiene el nombre de la sede.
     * 
     * @return El nombre de la sede.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Establece el nombre de la sede.
     * 
     * @param nombre El nuevo nombre de la sede.
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
