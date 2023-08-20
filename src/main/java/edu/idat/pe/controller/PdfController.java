package edu.idat.pe.controller;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.idat.pe.model.Encuentro;
import edu.idat.pe.model.Jornada;
import edu.idat.pe.service.EncuentroService;
import edu.idat.pe.service.JornadaService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PdfController {
	@Autowired
    private JornadaService jornadaService;

    @Autowired
    private EncuentroService encuentroService;

    @GetMapping("/generar-pdf-fixture")
    public void generarPdfFixture(@RequestParam("idTorneo") Integer idTorneo, HttpServletResponse response) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            List<Jornada> jornadas = jornadaService.obtenerJornadasPorTorneo(idTorneo);
            float yPosition = page.getMediaBox().getHeight() - 50;
            
         // Agregar el logo en el encabezado
            try (InputStream logoInputStream = PdfController.class.getClassLoader().getResourceAsStream("static/imagenes/logo.jpg")) {
                PDImageXObject logoImage = PDImageXObject.createFromByteArray(document, IOUtils.toByteArray(logoInputStream), "logo");
                float logoWidth = 100; 
                float logoHeight = 60; 
                float logoX = page.getMediaBox().getWidth() - 120; 
                float logoY = page.getMediaBox().getHeight() - 70; 
                contentStream.drawImage(logoImage, logoX, logoY, logoWidth, logoHeight);
            } catch (IOException e) {
                e.printStackTrace();
            }


         // Texto  "Fixture del Torneo"
            float textWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("Fixture del Torneo") / 1000 * 20; 
            float textXCenter = (page.getMediaBox().getWidth() - textWidth) / 2;

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
            contentStream.newLineAtOffset(textXCenter, yPosition);
            contentStream.showText("Fixture del Torneo");
            contentStream.endText();
            yPosition -= 30;


            for (Jornada jornada : jornadas) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                contentStream.newLineAtOffset(100, yPosition);
                contentStream.showText("Jornada: " + jornada.getNumFecha());
                contentStream.endText();

                yPosition -= 25;

                List<Encuentro> encuentros = encuentroService.obtenerEncuentrosPorJornada(jornada.getIdJornada());

                // Dibujar la tabla de encuentros
                float tableTopY = yPosition;
                float tableWidth = page.getMediaBox().getWidth() - 200;
                float tableX = 100;
                float rowHeight = 20;

                // Cabeza de la tabla (Encabezado)
                contentStream.setNonStrokingColor(Color.GREEN);
                contentStream.addRect(tableX, tableTopY, tableWidth, rowHeight);
                contentStream.fill();
                contentStream.setNonStrokingColor(Color.BLACK);

                // Texto "Encuentros"
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
                float textX = tableX + (tableWidth / 2) - 40;
                float textY = tableTopY;
                contentStream.newLineAtOffset(textX, textY);
                contentStream.showText("Encuentros");
                contentStream.endText();

                // Filas de la tabla (Encuentros)
                textY -= 12;
                for (Encuentro encuentro : encuentros) {
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA, 12);
                    contentStream.newLineAtOffset(tableX + 10, textY);
                    contentStream.showText(encuentro.getEquipoLocal());
                    contentStream.endText();

                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA, 12);
                    contentStream.newLineAtOffset(tableX + (tableWidth / 2) - 15, textY);
                    contentStream.showText("vs");
                    contentStream.endText();

                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA, 12);
                    contentStream.newLineAtOffset(tableX + tableWidth - 80, textY);
                    contentStream.showText(encuentro.getEquipoVisita());
                    contentStream.endText();

                    textY -= rowHeight;
                }

                yPosition = textY - 10;
            }

            contentStream.close();
            
         // Agregar pie de página centrado
            String footerText = "Derechos de autor © 2023 - Championship Craft";
            float footerTextWidth = PDType1Font.HELVETICA.getStringWidth(footerText) / 1000 * 10;
            float centerX = (page.getMediaBox().getWidth() - footerTextWidth) / 2;
            float footerX = centerX;
            float footerY = 40;

            contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(footerX, footerY);
            contentStream.showText(footerText);
            contentStream.endText();
            contentStream.close();

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=fixture.pdf");
            document.save(response.getOutputStream());

            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
