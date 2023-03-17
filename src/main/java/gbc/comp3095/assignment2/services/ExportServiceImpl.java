/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import gbc.comp3095.assignment2.models.Ingredient;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Service
public class ExportServiceImpl implements ExportService {
    private Set<Ingredient> cart;

    public void CartPDFExporter(Set<Ingredient> cart) {
        this.cart = cart;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);

        cell.setPhrase(new Phrase("ID"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Description"));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Ingredient i : cart) {
            table.addCell(String.valueOf(i.getId()));
            table.addCell(String.valueOf(i.getName()));
            table.addCell(String.valueOf(i.getDescription()));
        }
    }
    public void exportPdf(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.BLACK);

        Paragraph para = new Paragraph("Shopping Cart",font);
        para.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(para);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(10);
        table.setWidths(new float[] {1.5f, 3.0f, 7.5f});

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
