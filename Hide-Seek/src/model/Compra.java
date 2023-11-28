package model;

import java.time.LocalTime;

public class Compra extends Producto {
	
	private Usuario Comprador;
	private Sede Sededondesecompra;

	public Compra(String nombre, String img, double precio, Usuario comprador, LocalTime localTime, Sede sededecompra) {
		super(nombre, img, precio);
		
		this.Nombre=nombre;
		this.Img=img;
		this.Precio=precio;
		this.Comprador=comprador;
		this.Sededondesecompra=sededecompra;
	}


	public Sede getSededondesecompra() {
		return Sededondesecompra;
	}


	public void setSededondesecompra(Sede sededondesecompra) {
		Sededondesecompra = sededondesecompra;
	}


	public Usuario getComprador() {
		return Comprador;
	}


	public void setComprador(Usuario comprador) {
		Comprador = comprador;
	}


}
