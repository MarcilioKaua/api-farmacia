package com.printf.apifarmacia.model.entities;

import jakarta.persistence.*;

@Entity(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nomeCliente;
    @Column
    private int quantidadeProdutoComprado;

    public Cliente(){
    }

    public Cliente(long id, String nomeCliente, int quantidadeProdutoComprado) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.quantidadeProdutoComprado = quantidadeProdutoComprado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeProdutoComprado() {
        return quantidadeProdutoComprado;
    }

    public void setQuantidadeProdutoComprado(int quantidadeProdutoComprado) {
        this.quantidadeProdutoComprado = quantidadeProdutoComprado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", quantidadeProdutoComprado=" + quantidadeProdutoComprado +
                '}';
    }
}
