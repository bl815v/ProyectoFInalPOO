package model;

import java.util.ArrayList;

public class ListadeParejas {
private ArrayList<Pareja>listadeParejas;
	
	public  ListadeParejas() {
	
		listadeParejas= new ArrayList<Pareja>();
		Pareja x = new Pareja(null, null, null, null, null, null, 0, 0, null);
		listadeParejas.add(x);
	
	}
	
	public Pareja buscarParejas(String usuario) {
		Pareja encontrada = null;
		for(Pareja x : listadeParejas) {
			if(x.getUser().equals(usuario)) {
				encontrada = x;
			}
		}
		return encontrada;
	}
	
	
	public boolean agregarParejas(Pareja usuario) {
		
		Pareja aux = buscarParejas(usuario.getUser());
		
		if (aux==null) {
			listadeParejas.add(usuario);
			return true;
		}		
		return false;
	}
	
	public boolean correoRepetido(String correo) {
		for (Pareja usuario:listadeParejas) {
			if (!usuario.getCorreo().equals(correo)) {
				return false;	
				
			}
		}
		return true;		
	}
	
	public boolean usuarioRepetido(String user) {
		for (Pareja usuario:listadeParejas) {
			if (!usuario.getUser().equals(user)) {
				return false;	
				
			}
		}
		return true;		
	}

	public ArrayList<Pareja> getListadeParejas() {
		return listadeParejas;
	}

	public void setListadeParejas(ArrayList<Pareja> listadeParejas) {
		this.listadeParejas = listadeParejas;
	}
	
	

}
