package model;

public class Pareja extends Persona{
	
	private String nombre;
	private String correo;
	private String genero;
	private int credito;
	private int deuda;
	private Sede sededecompra;
	private int Horario[][];
	private Usuario usuario;
	
	
	public Pareja(String nombre, String user, String rol, String contraseña,String correo, 
			String genero, int credito, int deuda, int horario[][], Sede sededecompra, Usuario usuario) {
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
	this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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


	public int[][] getHorario() {
		return Horario;
	}


	public void setHorario(int[][] horario) {
		Horario = horario;
	}


	public Sede getSededecompra() {
		return sededecompra;
	}


	public void setSededecompra(Sede sededecompra) {
		this.sededecompra = sededecompra;
	}

}
