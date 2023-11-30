package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ListadeCompras tiene metodos para almacenar todas las compras hechas en el sistema y
 * obtener las estadisticas(moda,media,mediana)
 * 
 * @author Esteban Arevalo
 */

public class ListadeCompras {
	
private ArrayList<Compra>ListadeCompras;
	/**
	 * Crea la lista de compras que almacena todas las compras hechas
	 */
	public ListadeCompras() {
		ListadeCompras = new ArrayList<Compra>();
	}
	/**
	 * Agrega una compra a la lista
	 * @param compra Almacenada en la lista
	 */
	 public void agregarCompra(Compra compra) {
		 ListadeCompras.add(compra);
	 }
	/**
	 * Obtiene la lista en su estado actual 
	 * @return devuelve la lista de compras
	 */
	public ArrayList<Compra> getListadeCompras() {
		return ListadeCompras;
	}
	/**
	 * Establece la lista de compras
	 * @param listadeCompras Le da un nuevo estado a la lista	
	 */
	public void setListadeCompras(ArrayList<Compra> listadeCompras) {
		ListadeCompras = listadeCompras;
	}
	/**
	 * Cuenta todos los objetos y cuantas veces se repite basandose en su nombre
	 * @return devuelve un Map con todos los nombres encontrados junto a un Integer que
	 * cuantas veces se repitio
	 */
	public Map<String, Integer> contarComprasConMismoNombre() {
	   
	        Map<String, Integer> contadorNombres = new HashMap<>();

	    
	        for (Compra compra : ListadeCompras) {
	           
	            String nombreCompra = compra.getNombre();

	         
	            contadorNombres.put(nombreCompra, contadorNombres.getOrDefault(nombreCompra, 0) + 1);
	        }
	        return contadorNombres;
		}
			/**
			 * Calcula la media basado en las cantidades que se repitio
			 * @param cantidades indica cuantas veces se repitio un producto
			 * @return devuelve el double de la media
			 */
		  public double calcularMedia(List<Integer> cantidades) {
		        int sum = 0;
		        for (int cantidad : cantidades) {
		            sum += cantidad;
		        }
		        return (double) sum / cantidades.size();
		    }
		 /**
		  * Calcula la mediana de las cantidades
		  * @param cantidades indica cuantas veces se repitio un producto
		  * 
		  * @return devuele el entero que indica la mediana
		  */
		    public int calcularMediana(List<Integer> cantidades) {
		        int size = cantidades.size();
		        if (size % 2 == 0) {
		            int mid1 = cantidades.get(size / 2 - 1);
		            int mid2 = cantidades.get(size / 2);
		            return (mid1 + mid2) / 2;
		        } else {
		            return cantidades.get(size / 2);
		        }
		    }
		    /**
		     * Encuentra el producto mas vendido
		     * @param contadorNombres se usa para saber cuantas beces estan los nombres repetidos
		     * 
		     * @return devuelve el String indicando el nombre del producto mas vendido
		     */
		    public String calcularModa(Map<String, Integer> contadorNombres) {
		        String moda = null;
		        int maxCount = 0;

		        for (Map.Entry<String, Integer> entry : contadorNombres.entrySet()) {
		            int count = entry.getValue();
		            if (count > maxCount) {
		                maxCount = count;
		                moda = entry.getKey();
		            }
		        }

		        return moda;
		    }
}
