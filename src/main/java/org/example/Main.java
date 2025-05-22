package org.example;

import org.example.loja.Estoque;
import org.example.model.Produto;
import org.example.model.Cliente;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // criar, adicionar, remover, ver total, gerar nota
        Cliente cliente = new Cliente("Romario", "email@gmail.com", "1699732432", "Rua Almirante Barroso, 1044, Serra azul - SP");

        cliente.getCarrinho().adicionarProduto(1, 2);
        cliente.getCarrinho().adicionarProduto(2, 1);
        cliente.getCarrinho().adicionarProduto(3, 2);

        //System.out.println(cliente.getCarrinho().getTotal());
        cliente.getCarrinho().gerarNota();

        cliente.getCarrinho().removerProduto(1);

        //System.out.println(cliente.getCarrinho().getTotal());
        cliente.getCarrinho().gerarNota();



    }
}