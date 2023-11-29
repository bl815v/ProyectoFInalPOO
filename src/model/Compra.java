package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Compra extends Producto {
	
	private Usuario Comprador;
	private Sede Sededondesecompra;
	String hora;
	LocalDate fecha;
	DayOfWeek diadecompra;

	public Compra(String nombre, String img, double precio, Usuario comprador, Sede sededecompra) {
		super(nombre, img, precio);
		
		this.Nombre=nombre;
		this.Img=img;
		this.Precio=precio;
		this.Comprador=comprador;
		this.Sededondesecompra=sededecompra;
		this.fecha=LocalDate.now();
		this.hora=" " + LocalTime.now().getHour() + ":" +LocalTime.now().getMinute() + ":" +LocalTime.now().getSecond();
		this.diadecompra=LocalDate.now().getDayOfWeek();
		
		
	}

	public Usuario getComprador() {
		return Comprador;
	}

	public void setComprador(Usuario comprador) {
		Comprador = comprador;
	}

	public Sede getSededondesecompra() {
		return Sededondesecompra;
	}

	public void setSededondesecompra(Sede sededondesecompra) {
		Sededondesecompra = sededondesecompra;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public DayOfWeek getDiadecompra() {
		return diadecompra;
	}

	public void setDiadecompra(DayOfWeek diadecompra) {
		this.diadecompra = diadecompra;
	}
	
}