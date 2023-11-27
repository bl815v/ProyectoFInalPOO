package model;

public class Pareja extends Persona{
	
	private String nombre;
	private String correo;
	private String genero;
	private int credito;
	private int deuda;
	private Sede sededecompra;
	private String Horario[][];
	
	
	public Pareja(String nombre, String user, String rol, String contraseña,String correo, 
			String genero, int credito, int deuda, String horario[][], Sede sededecompra) {
	super(user,rol,contraseña);
	this.nombre=nombre;
	this.correo=correo;
	this.genero=genero;
	this.credito=credito;
	this.Rol=rol;
	this.clave=contraseña;
	this.credito=credito;
	this.deuda=deuda;
	this.Horario=horario;
	this.sededecompra=sededecompra;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public int getCredito() {
		return credito;
	}


	public void setCredito(int credito) {
		this.credito = credito;
	}


	public int getDeuda() {
		return deuda;
	}


	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}


	public String[][] getHorario() {
		return Horario;
	}


	public void setHorario(String[][] horario) {
		Horario = horario;
	}
	
	

}
