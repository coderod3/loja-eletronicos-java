package org.example.model;

public abstract class Produto {
    private int id;
    private String nome;
    private String marca;
    private String modelo;
    private double preco;
    private String especificacoes;

    public Produto(int id, String nome, String marca, String modelo, double preco, String especificacoes) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.especificacoes = especificacoes;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s", marca, nome, modelo);
    }


    // getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

}
