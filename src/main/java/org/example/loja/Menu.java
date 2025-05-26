package org.example.loja;

import org.example.model.Cliente;
import org.example.model.Produto;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static Estoque estoque = new Estoque();

    public void init() {
        boolean reiniciar = true;

        while (reiniciar) {
            System.out.println("\n-------------------------------");
            System.out.println(" Bem-vindo ao Caixa Automático ");
            System.out.println("-------------------------------\n");

            System.out.print("Informe o seu nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o seu e-mail: ");
            String email = scanner.nextLine();

            Cliente cliente = new Cliente(nome, email);

            System.out.println("\nOlá, " + cliente.getNome() + "! Seja bem-vindo ao sistema.");

            int opcao;

            do {
                System.out.println("\n========= MENU =========");
                System.out.println("1. Ver os produtos disponíveis");
                System.out.println("2. Adicionar um produto ao carrinho");
                System.out.println("3. Remover um produto do carrinho");
                System.out.println("4. Gerar nota fiscal");
                System.out.println("5. Finalizar compra");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("\n--- Produtos Disponíveis ---");
                        for (Produto p : estoque.getProdutos()) {
                            System.out.println(p.getId() + " - " + p.toString());
                            //System.out.println(p.getId() + " - " + p.getNome() + " (" + p.getMarca() + ") - R$" + p.getPreco());
                        }
                        break;

                    case 2:
                        System.out.print("Digite o ID do produto que deseja adicionar: ");
                        int idAdicionar = scanner.nextInt();
                        Produto produtoAdicionar = estoque.getProdutoPorId(idAdicionar);

                        if (produtoAdicionar != null) {
                            System.out.print("Digite a quantidade: ");
                            int quantidade = scanner.nextInt();
                            cliente.getCarrinho().adicionarProduto(produtoAdicionar, quantidade);
                            System.out.println("Produto adicionado com sucesso!");
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                        break;

                    case 3:
                        System.out.print("Digite o ID do produto que deseja remover: ");
                        int idRemover = scanner.nextInt();
                        Produto produtoRemover = estoque.getProdutoPorId(idRemover);

                        if (produtoRemover != null) {
                            boolean removido = cliente.getCarrinho().removerProduto(produtoRemover);
                            if (removido) {
                                System.out.println("Produto removido do carrinho.");
                            } else {
                                System.out.println("Produto não encontrado no carrinho.");
                            }
                        } else {
                            System.out.println("Produto com ID " + idRemover + " não encontrado no estoque.");
                        }
                        break;

                    case 4:
                        cliente.getCarrinho().gerarNota(cliente.getNome());
                        break;

                    case 5:
                        System.out.println("\nCompra finalizada!");
                        cliente.getCarrinho().gerarNota(cliente.getNome());
                        System.out.println("\nObrigado por comprar conosco, " + cliente.getNome() + "!");
                        reiniciar = false;
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } while (opcao != 5);

            scanner.nextLine(); // consumir o enter deixado pelo scanner
        }
    }
}
