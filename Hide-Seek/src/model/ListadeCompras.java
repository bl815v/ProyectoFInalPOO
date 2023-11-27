package model;

import java.util.ArrayList;

public class ListadeCompras {
	
private ArrayList<Compra>ListadeCompras;
	
	 public ListadeCompras() {
		ListadeCompras = new ArrayList<Compra>();
		
	
	}
	 public void agregarCompra(Compra compra) {
		 ListadeCompras.add(compra);
	 }

	public ArrayList<Compra> getListadeCompras() {
		return ListadeCompras;
	}

	public void setListadeCompras(ArrayList<Compra> listadeCompras) {
		ListadeCompras = listadeCompras;
	}

	 
	 
	
	

}
