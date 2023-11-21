package model;

public class Producto {
	
	protected String Nombre;
	protected double Precio;
	protected String Img;
	
	public Producto(String nombre, String img, double precio) {
		
		this.Nombre=nombre;
		this.Img=img;
		this.Precio=precio;
	}

}
