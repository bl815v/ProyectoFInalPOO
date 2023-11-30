package model;

import java.util.ArrayList;

/**
 * La clase ListadeSedes gestiona una lista de sedes y proporciona métodos para acceder a la lista.
 * Inicializa la lista con algunas sedes predefinidas.
 * 
 * @author David Garcia
 * @version 1.0
 */
public class ListadeSedes {

    private ArrayList<Sede> listadeSedes;

    /**
     * Constructor que inicializa la lista de sedes con algunas sedes predefinidas.
     */
    public ListadeSedes() {
        listadeSedes = new ArrayList<>();

  
    }

    /**
     * Busca una sede por su nombre en la lista de sedes.
     * 
     * @param nombre El nombre de la sede a buscar.
     * @return La sede encontrada o null si no se encuentra.
     */
    public Sede buscarSede(String nombre) {
        Sede encontrada = null;
        for (Sede x : listadeSedes) {
            if (x.getNombre().equals(nombre)) {
                encontrada = x;
            }
        }
        return encontrada;
    }

    /**
     * Agrega una sede a la lista de sedes si no existe una sede con el mismo nombre.
     * 
     * @param sede La sede a agregar.
     * @return true si la sede se agregó correctamente, false si ya existe una sede con el mismo nombre.
     */
    public boolean agregarSede(Sede sede) {
        Sede aux = buscarSede(sede.getNombre());

        if (aux == null) {
            listadeSedes.add(sede);
            return true;
        }
        return false;
    }

    /**
     * Obtiene la lista de sedes.
     * 
     * @return La lista de sedes.
     */
    public ArrayList<Sede> getListadeSedes() {
        return listadeSedes;
    }

    /**
     * Establece la lista de sedes.
     * 
     * @param listadeSedes La lista de sedes a establecer.
     */
    public void setListadeSedes(ArrayList<Sede> listadeSedes) {
        this.listadeSedes = listadeSedes;
    }
}
