package model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
/**
 * GeneradorPDF tiene metodos para crear y guardar un PDF insertando y ajustando una
 * imagen y agregando el texto para mostrar las estadisticas 
 * 
 * @Esteban Arevalo
 */
public class GeneradorPDF {
	/**
	 * 
	 * @param moda String que mostrara el producto mas vendido
	 * @param media double que indicara la media de las ventas
	 * @param mediana int que indicara la mediana de las ventas
	 * 
	 */
    public  void crearPDF(String moda,double media,int mediana) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                
                PDImageXObject pdImage = PDImageXObject.createFromFile("chart.png", document);
                contentStream.drawImage(pdImage, 100, 400, 400, 200);
                float textX = 100; 
                float textY = 250; 
                float fontSize=12;
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
            document.save("Informe.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
