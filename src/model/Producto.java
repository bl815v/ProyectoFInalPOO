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

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}
}
