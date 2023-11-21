package model;

public class Compra extends Producto {
	
	private Usuario Comprador;
	private Hora HoradeCompra;
	

	public Compra(String nombre, String img, double precio, Usuario comprador, Hora horadecompra) {
		super(nombre, img, precio);
		
		this.Nombre=nombre;
		this.Img=img;
		this.Precio=precio;
		this.Comprador=comprador;
		this.HoradeCompra=horadecompra;
		
	}

}
