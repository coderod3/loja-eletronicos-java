package org.example.model;

public class Laptop extends Produto {
    private String processador;
    private int armazenamento;
    private int memoriaRam;
    private int tamanhoTela;

    public Laptop(int id, String nome, String marca, String modelo, double preco, String especificacoes, String processador, int armazenamento,
                  int memoriaRam, int tamanhoTela) {
        super(id, nome, marca, modelo, preco, especificacoes);
        this.processador = processador;
        this.memoriaRam = memoriaRam;
        this.armazenamento = armazenamento;
        this.tamanhoTela = tamanhoTela;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %s (%dGB %dRAM) %s\" %s - %.2f", processador, armazenamento, memoriaRam, tamanhoTela, this.getEspecificacoes(), this.getPreco());
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public int getTamanhoTela() {
        return tamanhoTela;
    }

    public void setTamanhoTela(int tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }
}
