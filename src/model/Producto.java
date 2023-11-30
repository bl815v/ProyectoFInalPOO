package model;

/**
 * La clase Producto representa un artículo en el sistema que puede ser comprado.
 * Contiene atributos como nombre, precio e imagen, y métodos para acceder y modificar estos atributos.
 * Esta clase es utilizada para representar los productos disponibles en el sistema.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class Producto {

    /**
     * El nombre del producto.
     */
    protected String Nombre;

    /**
     * El precio del producto.
     */
    protected double Precio;

    /**
     * La ruta de la imagen asociada al producto.
     */
    protected String Img;

    /**
     * Constructor para la clase Producto.
     * 
     * @param nombre El nombre del producto.
     * @param img    La ruta de la imagen asociada al producto.
     * @param precio El precio del producto.
     */
    public Producto(String nombre, String img, double precio) {
        this.Nombre = nombre;
        this.Img = img;
        this.Precio = precio;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto.
     */
    public double getPrecio() {
        return Precio;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        Precio = precio;
    }

    /**
     * Obtiene la ruta de la imagen asociada al producto.
     * 
     * @return La ruta de la imagen.
     */
    public String getImg() {
        return Img;
    }

    /**
     * Establece la ruta de la imagen asociada al producto.
     * 
     * @param img La nueva ruta de la imagen.
     */
    public void setImg(String img) {
        Img = img;
    }
}
