package org.example.model;

public class Smartphone extends Produto {
    private int armazenamento;
    private boolean possui5G;

    public Smartphone(int id, String nome, String marca, String modelo, double preco, String especificacoes, int armazenamento, boolean possui5G) {
        super(id, nome, marca, modelo, preco, especificacoes);
        this.armazenamento = armazenamento;
        this.possui5G = possui5G;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (%dGB %s) %s - %.2f", armazenamento, possui5G ? " 5G" : "", this.getEspecificacoes(), this.getPreco());
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public boolean isPossui5G() {
        return possui5G;
    }

    public void setPossui5G(boolean possui5G) {
        this.possui5G = possui5G;
    }
}

