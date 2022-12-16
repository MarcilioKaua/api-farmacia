package com.printf.apifarmacia.controller.relatorios;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.printf.apifarmacia.model.entities.Cliente;
import com.printf.apifarmacia.model.entities.Compra;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class RelatorioCompras {

    private List<Compra> listaCompras;

    public RelatorioCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Compra ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Data da Compra", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Total da compra", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Cliente ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Medicamento ID", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Compra user : listaCompras) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(String.valueOf(user.getDataCompra()));
            table.addCell(String.valueOf(user.getTotalCompra()));
            table.addCell(String.valueOf(user.getTotalCompra()));
            table.addCell(String.valueOf(user.getIdCliente()));
            table.addCell(String.valueOf(user.getIdMedicamento()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Lista de Compras", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
