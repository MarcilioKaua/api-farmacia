package com.printf.apifarmacia.controller.relatorios;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.printf.apifarmacia.model.entities.Cliente;
import com.printf.apifarmacia.model.entities.Medicamento;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class RelatorioMedicamentos {

    private List<Medicamento> listaMedicamentos;

    public RelatorioMedicamentos(List<Medicamento> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("User ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nome Medicamento", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Bula", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Categoria", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Preco", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Quantidade em estoque", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Medicamento user : listaMedicamentos) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getNomeMedicamento());
            table.addCell(user.getBula());
            table.addCell(String.valueOf(user.getCategoria()));
            table.addCell(String.valueOf(user.getPreco()));
            table.addCell(String.valueOf(user.getQuantidadeEstoque()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Lista de Medicamentos", font);
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
