package com.printf.apifarmacia.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private LocalDate dataCompra = LocalDate.now();
    @Column
    private Double totalCompra;
    @Column
    private long idCliente;
    @Column
    private long idMedicamento;

    public Compra(){

    }

    public Compra(long id, LocalDate dataCompra, Double totalCompra, long cliente, long medicamento) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.totalCompra = totalCompra;
        this.idCliente = cliente;
        this.idMedicamento = medicamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
