package model;

public class Sede {
	
	String Direccion, Nombre;
	
	public Sede(String direccion, String nombre) {
		this.Direccion=direccion;
		this.Nombre=nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	

}
