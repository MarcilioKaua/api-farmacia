package com.printf.apifarmacia.controller;

import com.lowagie.text.DocumentException;
import com.printf.apifarmacia.controller.relatorios.RelatorioClientes;
import com.printf.apifarmacia.controller.relatorios.RelatorioCompras;
import com.printf.apifarmacia.model.entities.Cliente;
import com.printf.apifarmacia.model.entities.Compra;
import com.printf.apifarmacia.model.repositories.ClienteRespository;
import com.printf.apifarmacia.model.repositories.CompraRespository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class CompraController {

    @Autowired
    CompraRespository compraRespository;
    @GetMapping("/mostrarCompras")
    public ResponseEntity<List<Compra>> mostrarCompra(){
        List<Compra> lista = compraRespository.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/mostrarCompras/{id}")
    public ResponseEntity<Optional<Compra>> mostrarCompraId(@PathVariable Long id){
        Optional<Compra> compra = compraRespository.findById(id);
        return ResponseEntity.ok().body(compra);
    }

    @PostMapping("/salvarCompra")
    public void salvarCompra(@RequestBody Compra compra){
        compraRespository.save(compra);
    }

    @PutMapping("/atualizarCompra")
    public void atualizarCompra(@RequestBody Compra compra){
        compraRespository.save(compra);
    }

    @DeleteMapping("deletarCompra/{id}")
    public ResponseEntity<Void> deletarCompra(@PathVariable Long id){
        compraRespository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/compras/exportar")
    public void exportarPDF(HttpServletResponse resposta) throws DocumentException, IOException {
        resposta.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=compras.pdf";

        resposta.setHeader(headerKey, headerValue);

        List<Compra> listaCompra = compraRespository.findAll();

        RelatorioCompras exporter = new RelatorioCompras(listaCompra);
        exporter.export(resposta);
    }
}
