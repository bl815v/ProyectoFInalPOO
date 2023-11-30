package model;

import java.util.ArrayList;

/**
 * La clase ListadeProductos gestiona una lista de productos y proporciona métodos para acceder a la lista.
 * Inicializa la lista con algunos productos predefinidos.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class ListadeProductos {

    private ArrayList<Producto> ListadeProductos;

    /**
     * Constructor que inicializa la lista de productos con algunos productos predefinidos.
     */
    public ListadeProductos() {
        ListadeProductos = new ArrayList<>();

        // Agregar algunos productos predefinidos
        Producto huevo = new Producto("Huevo", "/image/huevo.png", 450);
        ListadeProductos.add(huevo);
        Producto leche = new Producto("Leche", "/image/Leche.png", 4500);
        ListadeProductos.add(leche);
        Producto aceite = new Producto("Aceite", "/image/aceite.png", 8000);
        ListadeProductos.add(aceite);
        Producto arroz = new Producto("Arroz", "/image/arroz.png", 3500);
        ListadeProductos.add(arroz);
        Producto frijol = new Producto("Frijol", "/image/frijol.png", 5500);
        ListadeProductos.add(frijol);
        Producto tapabocas = new Producto("Tapabocas", "/image/tapabocas.png", 1000);
        ListadeProductos.add(tapabocas);
        Producto alcohol = new Producto("Alcohol Desinfectante", "/image/alcohold.png", 2000);
        ListadeProductos.add(alcohol);
        Producto papel = new Producto("Papel Higiénico", "/image/papelhig.png", 2500);
        ListadeProductos.add(papel);
        Producto papa = new Producto("Libra de papa", "/image/libradepapa.png", 1000);
        ListadeProductos.add(papa);
        Producto lentejas = new Producto("Lentejas", "/image/lentejas.png", 1800);
        ListadeProductos.add(lentejas);
    }

    /**
     * Obtiene la lista de productos.
     * 
     * @return La lista de productos.
     */
    public ArrayList<Producto> getListadeProductos() {
        return ListadeProductos;
    }

    /**
     * Establece la lista de productos.
     * 
     * @param listadeProductos La lista de productos a establecer.
     */
    public void setListadeProductos(ArrayList<Producto> listadeProductos) {
        ListadeProductos = listadeProductos;
    }
}
