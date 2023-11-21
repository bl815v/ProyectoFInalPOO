package model;

public class Persona {
	
	protected String User;
	protected String Rol;
	protected String Contraseña;
	
	public Persona(String user, String rol, String contraseña) {
		
		this.User=user;
		this.Rol=rol;
		this.Contraseña=contraseña;

	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String rol) {
		Rol = rol;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
	

}

