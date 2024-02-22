package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Restaurante> restaurantes = new ArrayList<>();
        Scanner x = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("Menu Principal:");
            System.out.println("1. Cadastrar restaurante");
            System.out.println("2. Listar restaurantes");
            System.out.println("3. Cadastrar item no menu de um restaurante");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = x.nextLine();

            if (opcao.equals("1")) {
                System.out.print("Digite o nome do restaurante: ");
                String nome_restaurante = x.nextLine();
                System.out.print("Digite a avaliacao do restaurante: ");
                int avaliacao_restaurante = x.nextInt();
                x.nextLine();
                Restaurante restaurante = new Restaurante(nome_restaurante, avaliacao_restaurante);
                restaurantes.add(restaurante); // Adiciona na lista de restaurantes
                System.out.println("Restaurante " + nome_restaurante + " cadastrado com sucesso!");
            } else if (opcao.equals("2")) {
                if (!restaurantes.isEmpty()) {
                    System.out.println("Restaurantes cadastrados:");
                    for (int i = 0; i < restaurantes.size(); i++) {
                        System.out.println(i + ":");
                        restaurantes.get(i).Menu();
                    }
                } else {
                    System.out.println("Não há restaurantes cadastrados!");
                }
            } else if (opcao.equals("3")) {
                System.out.print("Escolha o número do restaurante para adicionar um item ao menu: ");
                int escolha = x.nextInt(); // Número do restaurante
                x.nextLine();
                if (escolha >= 0 && escolha < restaurantes.size()) { // Verifica se o número do restaurante está dentro da lista
                    Restaurante restauranteEscolhido = restaurantes.get(escolha);
                    System.out.print("Digite o nome do item: ");
                    String nome_item = x.nextLine();
                    System.out.print("Digite o preço do item: ");
                    String preco_item = x.nextLine();
                    restauranteEscolhido.addItem(new Item(nome_item, preco_item));
                    System.out.println("Item " + nome_item + " adicionado ao menu do restaurante " + restauranteEscolhido.getNome() + "!");
                } else {
                    System.out.println("Restaurante não encontrado!");
                }
            } else if (opcao.equals("4")) {
                System.out.println("Obrigado por utilizar o sistema de cadastro de restaurantes!");
                x.close();
                return;
            } else {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}