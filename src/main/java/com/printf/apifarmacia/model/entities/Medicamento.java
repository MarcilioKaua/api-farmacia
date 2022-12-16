package com.printf.apifarmacia.model.entities;

import com.printf.apifarmacia.model.entities.enums.Categoria;
import jakarta.persistence.*;

import java.util.Scanner;
@Entity(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nomeMedicamento;
    @Column
    private String bula;
    @Column
    private Categoria categoria;
    @Column
    private Double preco;
    @Column
    private int quantidadeEstoque;

    public Medicamento(){
    }

    public Medicamento(long id, String nomeMedicamento, String bula, Categoria categoria, Double preco, int quantidadeEstoque) {
        this.id = id;
        this.nomeMedicamento = nomeMedicamento;
        this.bula = bula;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getBula() {
        return bula;
    }

    public void setBula(String bula) {
        this.bula = bula;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
