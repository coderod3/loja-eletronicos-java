package org.example.model;

import org.example.loja.Estoque;

import java.util.ArrayList;
import java.util.List;


public class Carrinho {
    private final List<ItemCarrinho> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade){
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        this.produtos.add(item);
    }

    public void adicionarProduto(int idProduto, int quantidade){
        Produto produto = new Estoque().getProdutoPorId(idProduto);
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        this.produtos.add(item);
    }

    public void removerProduto(Produto produto) {
        produtos.removeIf(item -> item.getProduto().equals(produto));
    }

    public void removerProduto(int idProduto) {
        this.produtos.removeIf(item -> item.getProduto().getId() == idProduto);
    }

    public double getTotal(){
        double total = 0;
        for (ItemCarrinho item : this.produtos){
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void gerarNota(){
        double total = 0;
        System.out.printf("%n----------------- Nota -----------------%n");
        for (ItemCarrinho item : produtos){
            String nome = item.getProduto().getNome();
            double preco = item.getProduto().getPreco();
            int quantidade = item.getQuantidade();
            double subtotal = preco * quantidade;
            total += subtotal;
            System.out.println(item.getProduto().toString() + " Total: " + subtotal);
            //System.out.println(nome + " " + preco + " " + quantidade + " " + subtotal);
        }

        System.out.printf("%nTotal: %.2f%n", total);
    }

    // getter
    public List<ItemCarrinho> getProdutos() {
        return produtos;
    }
}
