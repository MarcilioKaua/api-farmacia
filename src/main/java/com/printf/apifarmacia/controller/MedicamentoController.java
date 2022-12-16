package com.printf.apifarmacia.controller;

import com.lowagie.text.DocumentException;
import com.printf.apifarmacia.controller.relatorios.RelatorioClientes;
import com.printf.apifarmacia.controller.relatorios.RelatorioMedicamentos;
import com.printf.apifarmacia.model.entities.Cliente;
import com.printf.apifarmacia.model.entities.Medicamento;
import com.printf.apifarmacia.model.repositories.MedicamentoRespository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class MedicamentoController {

    @Autowired
    MedicamentoRespository medicamentoRespository;

    @GetMapping("/mostrarMedicamentos")
    public ResponseEntity<List<Medicamento>> mostrarMedicamentos(){
        List<Medicamento> lista = medicamentoRespository.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/mostrarMedicamentos/{id}")
    public ResponseEntity<Optional<Medicamento>> mostrarMedicamentoId(@PathVariable Long id){
        Optional<Medicamento> medicamento = medicamentoRespository.findById(id);
        return ResponseEntity.ok().body(medicamento);
    }

    @PostMapping("/salvarMedicamento")
    public void salvarMedicamento(@RequestBody Medicamento medicamento){
        medicamentoRespository.save(medicamento);
    }

    @PutMapping("/atualizarMedicamento")
    public void atualizarMedicamento(@RequestBody Medicamento medicamento){
        medicamentoRespository.save(medicamento);
    }

    @DeleteMapping("deletarMedicamento/{id}")
    public ResponseEntity<Void> deletarMedicamento(@PathVariable Long id){
        medicamentoRespository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/medicamentos/exportar")
    public void exportarPDF(HttpServletResponse resposta) throws DocumentException, IOException {
        resposta.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=medicamentos.pdf";

        resposta.setHeader(headerKey, headerValue);

        List<Medicamento> listaMedicamento = medicamentoRespository.findAll();

        RelatorioMedicamentos exporter = new RelatorioMedicamentos(listaMedicamento);
        exporter.export(resposta);
    }

}
