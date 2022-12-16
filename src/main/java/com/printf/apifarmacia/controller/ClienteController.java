package com.printf.apifarmacia.controller;

import com.lowagie.text.DocumentException;
import com.printf.apifarmacia.controller.relatorios.RelatorioClientes;
import com.printf.apifarmacia.model.entities.Cliente;
import com.printf.apifarmacia.model.repositories.ClienteRespository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    ClienteRespository clienteRespository;
    @GetMapping("/mostrarClientes")
    public ResponseEntity<List<Cliente>> mostrarClientes(){
        List<Cliente> lista = clienteRespository.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/mostrarClientes/{id}")
    public ResponseEntity<Optional<Cliente>> mostrarClienteId(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRespository.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping("/salvarCliente")
    public void salvarCliente(@RequestBody Cliente cliente){
        clienteRespository.save(cliente);
    }

    @PutMapping("/atualizarCliente")
    public void atualizarCliente(@RequestBody Cliente cliente){
        clienteRespository.save(cliente);
    }

    @DeleteMapping("deletarCliente/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteRespository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clientes/exportar")
    public void exportarPDF(HttpServletResponse resposta) throws DocumentException, IOException {
        resposta.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=clientes.pdf";

        resposta.setHeader(headerKey, headerValue);

        List<Cliente> listaCliente = clienteRespository.findAll();

        RelatorioClientes exporter = new RelatorioClientes(listaCliente);
        exporter.export(resposta);
    }
}
