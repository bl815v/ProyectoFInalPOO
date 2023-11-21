package model;

import java.util.ArrayList;

import model.Usuario;

public class Listado {
private ArrayList<Usuario>ListadeUsuarios;
	
	public Listado() {
		ListadeUsuarios= new ArrayList<Usuario>();
		Usuario x = new Usuario("David DD", "dvd", "Usuario", "123", "davidfgl", "Masculino", 1000000);
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

	public ArrayList<Usuario> getListadeUsuarios() {
		return ListadeUsuarios;
	}

	public void setListadeUsuarios(ArrayList<Usuario> listadeUsuarios) {
		ListadeUsuarios = listadeUsuarios;
	}
	
	
}
