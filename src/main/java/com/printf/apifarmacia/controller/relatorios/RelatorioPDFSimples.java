package com.printf.apifarmacia.controller.relatorios;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.printf.apifarmacia.model.entities.Cliente;
import com.printf.apifarmacia.model.entities.Medicamento;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class RelatorioPDFSimples implements Relatorio{

    private Cliente cliente;

    private Document documentoPDF;
    private String caminhoRelatorio = "RelatorioSimplesPDF.pdf";

    public RelatorioPDFSimples(Cliente cliente){
        this.cliente = cliente;
        this.documentoPDF = new Document();
        try {
            PdfWriter.getInstance(this.documentoPDF, new FileOutputStream(caminhoRelatorio));
            this.documentoPDF.open();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void gerarCabecalho() {
        Paragraph paragrafoTitulo = new Paragraph();
        paragrafoTitulo.setAlignment(Element.ALIGN_CENTER);
        paragrafoTitulo.add(new Chunk("RELATÓRIO DE VENDAS SIMPLES", new Font(Font.HELVETICA, 24)));

        this.documentoPDF.add(paragrafoTitulo);
        this.documentoPDF.add(new Paragraph(" "));
        Paragraph paragrafoId = new Paragraph();
        paragrafoId.setAlignment(Element.ALIGN_CENTER);
        paragrafoId.add(new Chunk(this.cliente.getNomeCliente().toString()));
        this.documentoPDF.add(paragrafoId);

        this.documentoPDF.add(new Paragraph(" "));
        this.documentoPDF.add(new Paragraph(" "));

        Paragraph paragrafoCliente = new Paragraph();
        paragrafoCliente.setAlignment(Element.ALIGN_CENTER);
        paragrafoCliente.add(new Chunk("Cliente: " + this.cliente.getNomeCliente(), new Font(Font.BOLD, 16)));
        this.documentoPDF.add(paragrafoCliente);

        Paragraph paragrafroSessao = new Paragraph("-------------------------------------------------------------------");
        paragrafroSessao.setAlignment(Element.ALIGN_CENTER);
        this.documentoPDF.add(paragrafroSessao);
        this.documentoPDF.add(new Paragraph(" "));
    }

    @Override
    public void gerarCorpo() {

    }

    @Override
    public void gerarRodape() {

    }

    @Override
    public void imprimir() {
        if (this.documentoPDF != null && this.documentoPDF.isOpen()){
            this.documentoPDF.close();
        }
    }
}
