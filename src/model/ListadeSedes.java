package model;

import java.util.ArrayList;

public class ListadeSedes {
private ArrayList<Sede>listadeSedes;
	
	public ListadeSedes() {
		listadeSedes= new ArrayList<Sede>();
		Sede x = new Sede("Calle 94f bis #77-55", "Sede Cortijo");
		listadeSedes.add(x);
	
	}
	
	public Sede buscarSede(String nombre) {
		Sede encontrada = null;
		for(Sede x : listadeSedes) {
			if(x.getNombre().equals(nombre)) {
				encontrada = x;
			}
		}
		return encontrada;
	}
	
	public boolean agregarSede(Sede sede) {
		
		Sede aux = buscarSede(sede.getNombre());
		
		if (aux==null) {
			listadeSedes.add(sede);
			return true;
		}		
		return false;
	}
	
	public ArrayList<Sede> getListadeSedes() {
		return listadeSedes;
	}

	public void setListadeSedes(ArrayList<Sede> listadeSedes) {
		this.listadeSedes = listadeSedes;
	}

}
