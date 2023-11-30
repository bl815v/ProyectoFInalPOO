package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La clase Compra representa una transacción de compra de un producto.
 * Puede ser realizada por un usuario individual o una pareja.
 * Extiende de la clase Producto, heredando atributos como nombre, imagen y precio.
 *
 * @author David Garcia
 * @version 1.0
 */
public class Compra extends Producto {

    private Usuario Compradoru;
    private Pareja Compradorp;
    private Sede Sededondesecompra;
    String hora;
    LocalDate fecha;
    DayOfWeek diadecompra;

    /**
     * Constructor para la compra realizada por un usuario individual.
     *
     * @param nombre       Nombre del producto.
     * @param img          URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param comprador    Usuario que realiza la compra.
     * @param sededecompra Sede donde se realiza la compra.
     */
    public Compra(String nombre, String img, double precio, Usuario comprador, Sede sededecompra) {
        super(nombre, img, precio);

        this.Nombre = nombre;
        this.Img = img;
        this.Precio = precio;
        this.Compradoru = comprador;
        this.Sededondesecompra = sededecompra;
        this.fecha = LocalDate.now();
        this.hora = " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":"
                + LocalTime.now().getSecond();
        this.diadecompra = LocalDate.now().getDayOfWeek();
    }

    /**
     * Constructor para la compra realizada por una pareja.
     *
     * @param nombre       Nombre del producto.
     * @param img          URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param comprador    Pareja que realiza la compra.
     * @param sededecompra Sede donde se realiza la compra.
     */
    public Compra(String nombre, String img, double precio, Pareja comprador, Sede sededecompra) {
        super(nombre, img, precio);

        this.Nombre = nombre;
        this.Img = img;
        this.Precio = precio;
        this.Compradorp = comprador;
        this.Sededondesecompra = sededecompra;
        this.fecha = LocalDate.now();
        this.hora = " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":"
                + LocalTime.now().getSecond();
        this.diadecompra = LocalDate.now().getDayOfWeek();
    }

    /**
     * Obtiene el usuario que realizó la compra (en caso de compra individual).
     *
     * @return El usuario que realizó la compra.
     */
    public Usuario getCompradoru() {
        return Compradoru;
    }

    /**
     * Establece el usuario que realizó la compra (en caso de compra individual).
     *
     * @param compradoru El usuario que realizó la compra.
     */
    public void setCompradoru(Usuario compradoru) {
        Compradoru = compradoru;
    }

    /**
     * Obtiene la pareja que realizó la compra (en caso de compra por pareja).
     *
     * @return La pareja que realizó la compra.
     */
    public Pareja getCompradorp() {
        return Compradorp;
    }

    /**
     * Establece la pareja que realizó la compra (en caso de compra por pareja).
     *
     * @param compradorp La pareja que realizó la compra.
     */
    public void setCompradorp(Pareja compradorp) {
        Compradorp = compradorp;
    }

    /**
     * Obtiene la sede donde se realizó la compra.
     *
     * @return La sede donde se realizó la compra.
     */
    public Sede getSededondesecompra() {
        return Sededondesecompra;
    }

    /**
     * Establece la sede donde se realizó la compra.
     *
     * @param sededondesecompra La sede donde se realizó la compra.
     */
    public void setSededondesecompra(Sede sededondesecompra) {
        Sededondesecompra = sededondesecompra;
    }

    /**
     * Obtiene la hora en la que se realizó la compra.
     *
     * @return La hora de la compra en formato de cadena.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora en la que se realizó la compra.
     *
     * @param hora La hora de la compra en formato de cadena.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la fecha en la que se realizó la compra.
     *
     * @return La fecha de la compra.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realizó la compra.
     *
     * @param fecha La fecha de la compra.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el día de la semana en el que se realizó la compra.
     *
     * @return El día de la semana de la compra.
     */
    public DayOfWeek getDiadecompra() {
        return diadecompra;
    }

    /**
     * Establece el día de la semana en el que se realizó la compra.
     *
     * @param diadecompra El día de la semana de la compra.
     */
    public void setDiadecompra(DayOfWeek diadecompra) {
        this.diadecompra = diadecompra;
    }
}
