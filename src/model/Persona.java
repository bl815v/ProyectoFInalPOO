package model;

public class Persona {
	
	protected String User;
	protected String Rol;
	protected String clave;
	
	public Persona(String user, String rol, String clave) {
		this.User=user;
		this.Rol=rol;
		this.clave=clave;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}

