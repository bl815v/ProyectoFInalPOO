package model;

/**
 * La clase Usuario representa a un usuario en el sistema.
 * Contiene atributos como nombre, correo, género, crédito, deuda y sobrecupo,
 * y métodos para acceder y modificar estos atributos.
 * Esta clase es utilizada para representar a los usuarios del sistema.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class Usuario extends Persona {

    /**
     * El nombre del usuario.
     */
    private String nombre;

    /**
     * El correo electrónico del usuario.
     */
    private String correo;

    /**
     * El género del usuario.
     */
    private String genero;

    /**
     * El crédito disponible para el usuario.
     */
    private int credito;

    /**
     * La deuda acumulada del usuario.
     */
    private int deuda;

    /**
     * El sobrecupo del usuario.
     */
    private int sobrecupo;

    /**
     * Constructor para la clase Usuario.
     * 
     * @param nombre     El nombre del usuario.
     * @param user       El nombre de usuario del usuario.
     * @param rol        El rol del usuario.
     * @param contraseña La contraseña del usuario.
     * @param correo     El correo electrónico del usuario.
     * @param genero     El género del usuario.
     * @param credito    El crédito disponible para el usuario.
     * @param deuda      La deuda acumulada del usuario.
     * @param sobrecupo  El sobrecupo del usuario.
     */
    public Usuario(String nombre, String user, String rol, String contraseña, String correo, String genero, int credito,
            int deuda, int sobrecupo) {
        super(user, rol, contraseña);
        this.nombre = nombre;
        this.correo = correo;
        this.genero = genero;
        this.credito = credito;
        this.Rol = rol;
        this.clave = contraseña;
        this.credito = credito;
        this.deuda = deuda;
        this.sobrecupo = sobrecupo;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param correo El nuevo correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el género del usuario.
     * 
     * @return El género del usuario.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     * 
     * @param genero El nuevo género del usuario.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el crédito disponible para el usuario.
     * 
     * @return El crédito disponible para el usuario.
     */
    public int getCredito() {
        return credito;
    }

    /**
     * Establece el crédito disponible para el usuario.
     * 
     * @param credito El nuevo crédito disponible para el usuario.
     */
    public void setCredito(int credito) {
        this.credito = credito;
    }

    /**
     * Obtiene la deuda acumulada del usuario.
     * 
     * @return La deuda acumulada del usuario.
     */
    public int getDeuda() {
        return deuda;
    }

    /**
     * Establece la deuda acumulada del usuario.
     * 
     * @param deuda La nueva deuda acumulada del usuario.
     */
    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    /**
     * Obtiene el sobrecupo del usuario.
     * 
     * @return El sobrecupo del usuario.
     */
    public int getSobrecupo() {
        return sobrecupo;
    }

    /**
     * Establece el sobrecupo del usuario.
     * 
     * @param sobrecupo El nuevo sobrecupo del usuario.
     */
    public void setSobrecupo(int sobrecupo) {
        this.sobrecupo = sobrecupo;
    }
}
