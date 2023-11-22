package model;

import java.util.ArrayList;

public class ListadeProductos {
private ArrayList<Producto>ListadeProductos;
	
	public ListadeProductos() {
		
		ListadeProductos=new ArrayList<Producto>();
		
		Producto x = new Producto("Huevo", "/image/huevo.png",450);
		Producto y = new Producto("Leche", "/image/Leche.png",4500);
		Producto z = new Producto("Aceite", "/image/aceite.png",8000);
		Producto a = new Producto("Arroz", "/image/arroz.png",3500);
		Producto b = new Producto("Frijol", "/image/frijol.png",5500);
		Producto c = new Producto("Tapabocas", "/image/tapabocas.png",1000);
		Producto d = new Producto("Alcohol Desinfectante", "/image/alcohold.png",2000);
		Producto e = new Producto("Papel Higienico", "/image/papelhig.png",2500);
		Producto f = new Producto("Libra de papa", "/image/libradepapa.png",1000);
		Producto g = new Producto("Lentejas", "/image/lentejas.png",1800);

		ListadeProductos.add(x);
		ListadeProductos.add(y);
		ListadeProductos.add(a);
		ListadeProductos.add(b);
		ListadeProductos.add(c);
		ListadeProductos.add(d);
		ListadeProductos.add(e);
		ListadeProductos.add(f);
		ListadeProductos.add(g);
		ListadeProductos.add(z);	
	}
	
}
