package org.example;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome; // são exclusivos da classe Restaurante
    private Integer avaliacao;
    private List<Item> cardapio;

    public Restaurante(String nome, Integer avaliacao) { // Construtor que inicializa o objeto
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.cardapio = new ArrayList<>();
    }

    public void addItem(Item item) {
        cardapio.add(item);
    }

    public void Menu() { // Print do menu principal
        System.out.println("Restaurante: " + nome + " (Avaliação: " + avaliacao + ")");
        System.out.println("Cardápio:");
        for (Item item : cardapio) {
            System.out.println("- " + item.getNome() + ": " + item.getPreco());
        }
    }

    public String getNome() { // Recupera o valor da variável sem precisar acessá-lo diretamente, já que é um valor privado.
        return nome;
    }
}