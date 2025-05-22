package org.example.model;

public class TV extends Produto {
    private int tamanhoTela;
    private boolean isSmart;

    public TV(int id, String nome, String marca, String modelo, double preco, String especificacoes, int tamanhoTela, boolean isSmart) {
        super(id, nome, marca, modelo, preco, especificacoes);
        this.tamanhoTela = tamanhoTela;
        this.isSmart = isSmart;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %s\" %s %s - %.2f", tamanhoTela, isSmart ? "SmartTV" : "", this.getEspecificacoes(), this.getPreco());
    }


    public int getTamanhoTela() {
        return tamanhoTela;
    }

    public void setTamanhoTela(int tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }
}
