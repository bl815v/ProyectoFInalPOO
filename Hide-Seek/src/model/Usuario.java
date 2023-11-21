package model;

public class Usuario extends Persona{
	
	private String Nombre;
	private String Correo;
	private String Genero;
	private int Credito;
	
	
	public Usuario(String nombre, String user, String rol, String contraseña,String correo, String genero, int credito) {
	super(user,rol,contraseña);
	this.Nombre=nombre;
	this.Correo=correo;
	this.Genero=genero;
	this.Credito=credito;
	this.Rol=rol;
	this.Contraseña=contraseña;
	this.Credito=credito;
	
	
	}


	public String getCorreo() {
		return Correo;
	}


	public void setCorreo(String correo) {
		Correo = correo;
	}


	public String getGenero() {
		return Genero;
	}


	public void setGenero(String genero) {
		Genero = genero;
	}


	public int getCredito() {
		return Credito;
	}


	public void setCredito(int credito) {
		Credito = credito;
	}
	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	
	

}
