/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import com.itextpdf.text.DocumentException;
import gbc.comp3095.assignment2.models.Ingredient;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public interface ExportService {
    void CartPDFExporter(Set<Ingredient> cart);
    void exportPdf(HttpServletResponse response) throws DocumentException, IOException;
}
