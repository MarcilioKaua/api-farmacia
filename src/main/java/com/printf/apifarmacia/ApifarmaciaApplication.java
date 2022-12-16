package com.printf.apifarmacia;

import com.printf.apifarmacia.controller.relatorios.Relatorio;
import com.printf.apifarmacia.controller.relatorios.RelatorioPDFSimples;
import com.printf.apifarmacia.model.entities.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApifarmaciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApifarmaciaApplication.class, args);
		
		//Parte de gerar PDF
		Cliente cliente = new Cliente(10, "Marcio Bonfim", 10);
		Relatorio relatorioSimples = new RelatorioPDFSimples(cliente);
		relatorioSimples.gerarCabecalho();
		relatorioSimples.imprimir();
	}
}
