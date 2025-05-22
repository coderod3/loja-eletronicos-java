package org.example.loja;

import org.example.model.Laptop;
import org.example.model.Produto;
import org.example.model.Smartphone;
import org.example.model.TV;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private final List<Produto> produtos;

    public Estoque(){
        this.produtos = new ArrayList<>();
        gerarProdutos();
    }

    private void gerarProdutos(){
        this.produtos.add(new TV(1, "OLED 4K", "LG","LIGHT", 1899.99, "IPS", 55, true));
        this.produtos.add(new Smartphone(2, "J8", "Samsung", "A3", 899.90, "Dual Chip", 256, true));
        this.produtos.add(new Laptop(3, "ThinkPad", "Lenovo", "X1", 4689.90, "Placa de video integrada", "I7 10º Geração", 512, 16, 14));
    }

    public List<Produto> getProdutos(){
        return produtos;
    }

    public Produto getProdutoPorId(int id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }


}
