package model;

import java.time.LocalTime;

public class Compra extends Producto {
	
	private Usuario Comprador;
	private LocalTime HoradeCompra;
	

	public Compra(String nombre, String img, double precio, Usuario comprador, LocalTime localTime) {
		super(nombre, img, precio);
		
		this.Nombre=nombre;
		this.Img=img;
		this.Precio=precio;
		this.Comprador=comprador;
		this.HoradeCompra=localTime;
	}


	public Usuario getComprador() {
		return Comprador;
	}


	public void setComprador(Usuario comprador) {
		Comprador = comprador;
	}


	public Hora getHoradeCompra() {
		return HoradeCompra;
	}


	public void setHoradeCompra(Hora horadeCompra) {
		HoradeCompra = horadeCompra;
	}
}
