package listadodePersonas;

import java.util.ArrayList;

import model.Usuario;

public class ListaDeUsuarios {
private ArrayList<Usuario>ListadeUsuarios;
	
	public ListaDeUsuarios() {
		ListadeUsuarios= new ArrayList<Usuario>();
		Usuario x = new Usuario("David","dvd", "Usuario", "123", "davidfgl", "Masculino", 1000000);
		ListadeUsuarios.add(x);
	
	}
	
	
	
	
	
	
public Usuario buscarUsuario(String User) {
		
		for (Usuario usuario:ListadeUsuarios) {
			if (usuario.getUser()==User) {
				return usuario;				
			}else {
				System.out.println("No existe el usuario");
			}
		}
		return null;
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
