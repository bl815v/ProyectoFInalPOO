package model;

import java.util.ArrayList;

public class ListadeParejas {
private ArrayList<Pareja>listadeParejas;
	
	public  ListadeParejas() {
	
		listadeParejas= new ArrayList<Pareja>();
		//Pareja x = new Pareja("nombre", "1", "Pareja", "clavefinal", "correo", "genero", 1, 0, new int[6][6],  new Sede("Calle 94f bis #77-55", "Sede Cortijo"));
		//listadeParejas.add(x);
	
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
		if(listadeParejas.isEmpty()) {
			return false;
		}
		for (Pareja pareja:listadeParejas) {
			if (!pareja.getCorreo().equals(correo)) {
				return false;			
			}
		}
		return true;		
	}
	
	public boolean usuarioRepetido(String user) {
		if(listadeParejas.isEmpty()) {
			return false;
		}
		for (Pareja pareja:listadeParejas) {
			if (!pareja.getUser().equals(user)) {
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
