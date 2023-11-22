package model;

import java.util.ArrayList;

public class ListadeProductos {
private ArrayList<Producto>ListadeProductos;
	
	public ListadeProductos() {
		
		ListadeProductos=new ArrayList<Producto>();
		
		Producto huevo = new Producto("Huevo", "/image/huevo.png",450);
		ListadeProductos.add(huevo);
		Producto leche = new Producto("Leche", "/image/Leche.png",4500);
		ListadeProductos.add(leche);
		Producto aceite = new Producto("Aceite", "/image/Leche.png",8000);
		ListadeProductos.add(aceite);
		Producto arroz = new Producto("Arroz", "/image/Leche.png",3500);
		ListadeProductos.add(arroz);
		Producto frijol = new Producto("Frijol", "/image/Leche.png",5500);
		ListadeProductos.add(frijol);
		Producto tapabocas = new Producto("Tapabocas", "/image/Leche.png",1000);
		ListadeProductos.add(tapabocas);
		Producto alcohol = new Producto("Alcohol Desinfectante", "/image/Leche.png",2000);
		ListadeProductos.add(alcohol);
		Producto papel = new Producto("Papel Higienico", "/image/Leche.png",2500);
		ListadeProductos.add(papel);
		Producto papa = new Producto("Libra de papa", "/image/Leche.png",1000);
		ListadeProductos.add(papa);
		Producto lentejas = new Producto("Lentejas", "/image/Leche.png",1800);
		ListadeProductos.add(lentejas);
		

	}

	public ArrayList<Producto> getListadeProductos() {
		return ListadeProductos;
	}

	public void setListadeProductos(ArrayList<Producto> listadeProductos) {
		ListadeProductos = listadeProductos;
	}
	
	
	
}
