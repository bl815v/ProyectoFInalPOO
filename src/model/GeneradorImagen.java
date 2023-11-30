package model;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

import org.jfree.data.category.DefaultCategoryDataset;

/**
 * La clase GeneradorImagen contiene métodos para crear y guardar un gráfico PNG
 * con los datos almacenados en un conjunto de datos (dataset).
 * 
 * @author Anderson Esteban Arévalo Rodriguez
 * @version 1.0
 */
public class GeneradorImagen {

    /**
     * Genera un gráfico utilizando el conjunto de datos y establece las categorías
     * y sus componentes.
     * 
     * @param dataset Conjunto de datos utilizado para cargar la información necesaria
     *                para graficar.
     */
    public void generarGrafica(DefaultCategoryDataset dataset) {
        // Crea un gráfico de barras con el dataset proporcionado
        JFreeChart chart = ChartFactory.createBarChart("Productos vendidos", "Productos", "Cantidad", dataset);

        try {
            // Guarda el gráfico como una imagen PNG en el archivo "chart.png"
            ChartUtils.saveChartAsPNG(new File("chart.png"), chart, 800, 600);
        } catch (IOException e) {
            // Maneja las excepciones de IO, en este caso, imprime el seguimiento de la pila
            e.printStackTrace();
        }
    }
}
