package model;

import java.util.ArrayList;

public class ListadodeUsuarios {
private ArrayList<Usuario>ListadeUsuarios;
	
	public ListadodeUsuarios() {
		ListadeUsuarios= new ArrayList<Usuario>();
		Usuario x = new Usuario("David Garcia", "dvd", "Usuario", "123", "davidfgl@gmail.com", "Masculino", 10000, 500000, 0);
		ListadeUsuarios.add(x);
	
	}
	
	public Usuario buscarUsuario(String usuario) {
		Usuario encontrada = null;
		for(Usuario x : ListadeUsuarios) {
			if(x.getUser().equals(usuario)) {
				encontrada = x;
			}
		}
		return encontrada;
	}
	
	
	public boolean agregarUsuario(Usuario usuario) {
		
		Usuario aux = buscarUsuario(usuario.getUser());
		
		if (aux==null) {
			ListadeUsuarios.add(usuario);
			return true;
		}		
		return false;
	}
	
	public boolean correoRepetido(String correo) {
		if(ListadeUsuarios.isEmpty()) {
			return false;
		}
		for (Usuario usuario:ListadeUsuarios) {
			if (!usuario.getCorreo().equals(correo)) {
				return false;	
			}
		}
		return true;		
	}
	
	public boolean usuarioRepetido(String user) {
		if(ListadeUsuarios.isEmpty()) {
			return false;
		}
		for (Usuario usuario:ListadeUsuarios) {
			if (!usuario.getUser().equals(user)) {
				return false;			
			}
		}
		return true;		
	}

	public ArrayList<Usuario> getListadeUsuarios() {
		return ListadeUsuarios;
	}

	public void setListadeUsuarios(ArrayList<Usuario> listadeUsuarios) {
		ListadeUsuarios = listadeUsuarios;
	}
	
	
}
