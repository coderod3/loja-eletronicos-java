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

    public boolean removerProduto(Produto produto) {
        return produtos.removeIf(item -> item.getProduto().equals(produto));
    }

    public boolean removerProdutoPorId(int idProduto) {
        return this.produtos.removeIf(item -> item.getProduto().getId() == idProduto);
    }


    public double getTotal(){
        double total = 0;
        for (ItemCarrinho item : this.produtos){
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void gerarNota(String nomeCliente){
        double total = 0;
        System.out.printf("%n----------------- Nota -----------------%n");
        System.out.println("Cliente: " + nomeCliente);
        if (!this.produtos.isEmpty()) {
            for (ItemCarrinho item : produtos) {
                String nome = item.getProduto().getNome();
                double preco = item.getProduto().getPreco();
                int quantidade = item.getQuantidade();
                double subtotal = preco * quantidade;
                total += subtotal;
                System.out.println(item.getProduto().toString() + " (" + quantidade + "x) - " + " Total: " + subtotal);
            }

            System.out.printf("%nTotal: %.2f%n", total);
        }else {
            System.out.println("\nO carrinho se encontra vazio.");
        }
    }

    // getter
    public List<ItemCarrinho> getProdutos() {
        return produtos;
    }
}
