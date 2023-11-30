package model;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

import org.jfree.data.category.DefaultCategoryDataset;


/**
 * GeneradorImagen tiene metodos usados para crear y guardar una un grafico PNG
 * con los datos guardados en una dataset 
 *  
 *  @Esteban Arevalo
 */
public class GeneradorImagen {
		
	/**
	 * Crea un grafico a base del dataset y establece las categorias 
	 * y sus componentes
	 * @param dataset usada para cargar los datos neecesarios para graficar
	 */
    public void generarGrafica(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
            "Productos vendidos",
            "Productos",
            "Cantidad",
            dataset
        );
        try {
            ChartUtils.saveChartAsPNG(new File("chart.png"), chart, 800, 600);
        }catch(IOException e) {
        }
        	
        }

}
