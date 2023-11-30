package model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

/**
 * La clase GeneradorPDF contiene métodos para crear y guardar un PDF, insertando
 * y ajustando una imagen, así como agregando texto para mostrar estadísticas.
 * 
 * @author Anderson Esteban Arévalo Rodriguez
 * @version 1.0
 */
public class GeneradorPDF {

    /**
     * Crea un PDF con una imagen y texto que muestra estadísticas.
     * 
     * @param moda    Cadena que representa el producto más vendido.
     * @param media   Valor doble que indica la media de las ventas.
     * @param mediana Valor entero que indica la mediana de las ventas.
     */
    public void crearPDF(String moda, double media, int mediana) {
        try (PDDocument document = new PDDocument()) {
            // Crea una página en el documento PDF
            PDPage page = new PDPage();
            document.addPage(page);

            // Inicia el flujo de contenido para la página
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Carga una imagen desde el archivo "chart.png" y la coloca en la posición especificada
                PDImageXObject pdImage = PDImageXObject.createFromFile("chart.png", document);
                contentStream.drawImage(pdImage, 100, 400, 400, 200);

                // Configura la posición y el tamaño del texto
                float textX = 100;
                float textY = 250;
                float fontSize = 12;

                // Inicia el bloque de texto y muestra las estadísticas
                contentStream.beginText();
                contentStream.newLineAtOffset(textX, textY);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
                contentStream.showText("La moda es: " + moda);
                contentStream.newLineAtOffset(0, -fontSize);
                contentStream.showText("La media es: " + media);
                contentStream.newLineAtOffset(0, -fontSize);
                contentStream.showText("La mediana es: " + mediana);
                contentStream.endText();
            }

            // Guarda el documento PDF con el nombre "Informe.pdf"
            document.save("Informe.pdf");
        } catch (IOException e) {
            // Maneja las excepciones de IO, en este caso, imprime el seguimiento de la pila
            e.printStackTrace();
        }
    }
}
