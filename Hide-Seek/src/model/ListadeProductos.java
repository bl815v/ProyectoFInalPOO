package model;

import java.util.ArrayList;

public class ListadeProductos {
private ArrayList<Producto>ListadeProductos;
	
	public ListadeProductos() {
		
		ListadeProductos=new ArrayList<Producto>();
		
		Producto x = new Producto("Huevo", "/image/huevo.png",450);
		Producto y = new Producto("Leche", "/image/Leche.png",4500);
		Producto z = new Producto("Aceite", "/image/Leche.png",8000);
		Producto a = new Producto("Arroz", "/image/Leche.png",3500);
		Producto b = new Producto("Frijol", "/image/Leche.png",5500);
		Producto c = new Producto("Tapabocas", "/image/Leche.png",1000);
		Producto d = new Producto("Alcohol Desinfectante", "/image/Leche.png",2000);
		Producto e = new Producto("Papel Higienico", "/image/Leche.png",2500);
		Producto f = new Producto("Libra de papa", "/image/Leche.png",1000);
		Producto g = new Producto("Lentejas", "/image/Leche.png",1800);


		
		ListadeProductos.add(x);
		ListadeProductos.add(y);

		
	}
	
}
