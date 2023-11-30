package model;

/**
 * La clase Pareja representa a una pareja en el sistema, que es una extensión de la clase Persona.
 * Contiene información específica de la pareja como nombre, correo, género, crédito, deuda, sede de compra,
 * hora y día de compra, y el usuario asociado.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class Pareja extends Persona {

    private String nombre;
    private String correo;
    private String genero;
    private int credito;
    private int deuda;
    private Sede sededecompra;
    private int hora;
    private String dia;
    private Usuario usuario;

    /**
     * Constructor para la clase Pareja.
     * 
     * @param nombre      El nombre de la pareja.
     * @param user        El nombre de usuario.
     * @param rol         El rol de la pareja.
     * @param contraseña  La contraseña de la pareja.
     * @param correo      El correo electrónico de la pareja.
     * @param genero      El género de la pareja.
     * @param credito     El crédito de la pareja.
     * @param deuda       La deuda de la pareja.
     * @param hora        La hora de compra de la pareja.
     * @param dia         El día de compra de la pareja.
     * @param sededecompra La sede de compra de la pareja.
     * @param usuario     El usuario asociado a la pareja.
     */
    public Pareja(String nombre, String user, String rol, String contraseña, String correo, String genero, int credito,
            int deuda, int hora, String dia, Sede sededecompra, Usuario usuario) {
        super(user, rol, contraseña);
        this.nombre = nombre;
        this.correo = correo;
        this.genero = genero;
        this.credito = credito;
        this.Rol = rol;
        this.clave = contraseña;
        this.credito = credito;
        this.deuda = deuda;
        this.sededecompra = sededecompra;
        this.usuario = usuario;
        this.hora = hora;
        this.dia = dia;
    }

    /**
     * Obtiene la hora de compra de la pareja.
     * 
     * @return La hora de compra.
     */
    public int getHora() {
        return hora;
    }

    /**
     * Establece la hora de compra de la pareja.
     * 
     * @param hora La nueva hora de compra.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el día de compra de la pareja.
     * 
     * @return El día de compra.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el día de compra de la pareja.
     * 
     * @param dia El nuevo día de compra.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Obtiene el usuario asociado a la pareja.
     * 
     * @return El usuario asociado.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a la pareja.
     * 
     * @param usuario El nuevo usuario asociado.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el nombre de la pareja.
     * 
     * @return El nombre de la pareja.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la pareja.
     * 
     * @param nombre El nuevo nombre de la pareja.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico de la pareja.
     * 
     * @return El correo electrónico de la pareja.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la pareja.
     * 
     * @param correo El nuevo correo electrónico de la pareja.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el género de la pareja.
     * 
     * @return El género de la pareja.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género de la pareja.
     * 
     * @param genero El nuevo género de la pareja.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el crédito de la pareja.
     * 
     * @return El crédito de la pareja.
     */
    public int getCredito() {
        return credito;
    }

    /**
     * Establece el crédito de la pareja.
     * 
     * @param credito El nuevo crédito de la pareja.
     */
    public void setCredito(int credito) {
        this.credito = credito;
    }

    /**
     * Obtiene la deuda de la pareja.
     * 
     * @return La deuda de la pareja.
     */
    public int getDeuda() {
        return deuda;
    }

    /**
     * Establece la deuda de la pareja.
     * 
     * @param deuda La nueva deuda de la pareja.
     */
    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    /**
     * Obtiene la sede de compra de la pareja.
     * 
     * @return La sede de compra de la pareja.
     */
    public Sede getSededecompra() {
        return sededecompra;
    }

    /**
     * Establece la sede de compra de la pareja.
     * 
     * @param sededecompra La nueva sede de compra de la pareja.
     */
    public void setSededecompra(Sede sededecompra) {
        this.sededecompra = sededecompra;
    }
}
