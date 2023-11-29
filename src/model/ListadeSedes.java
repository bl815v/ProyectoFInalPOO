package model;

import java.util.ArrayList;

public class ListadeSedes {
private ArrayList<Sede>listadeSedes;
	
	public ListadeSedes() {
		listadeSedes= new ArrayList<Sede>();
		Sede x = new Sede("Calle 94f bis #77-55", "Sede Cortijo");
		listadeSedes.add(x);
	
	}

	
	public ArrayList<Sede> getListadeSedes() {
		return listadeSedes;
	}

	public void setListadeSedes(ArrayList<Sede> listadeSedes) {
		this.listadeSedes = listadeSedes;
	}

}
