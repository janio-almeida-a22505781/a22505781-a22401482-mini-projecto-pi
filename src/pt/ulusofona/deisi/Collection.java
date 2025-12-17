package pt.ulusofona.deisi;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Representa uma coleção de itens (por exemplo, músicas, filmes ou livros).
 * Cada coleção tem um tipo e uma lista de itens associados.
 */
public class Collection {

    /**
     * Tipo da coleção (ex.: "Músicas", "Filmes", "Livros").
     */
    String tipo;

    /**
     * Lista de itens pertencentes à coleção.
     */
    ArrayList<Item> items;

    /**
     * Constrói uma coleção vazia com o tipo especificado.
     *
     * @param tipo tipo da coleção
     */
    public Collection(String tipo) {
        this.tipo = tipo;
        this.items = new ArrayList<>();
    }

    /**
     * Constrói uma coleção com um tipo e uma lista de itens já existente.
     *
     * @param tipo  tipo da coleção
     * @param items lista de itens da coleção
     */
    public Collection(String tipo, ArrayList<Item> items) {
        this.tipo = tipo;
        this.items = items;
    }

    /**
     * Adiciona um novo item à coleção.
     *
     * @param titulo    título do item
     * @param genero    género do item
     * @param descricao descrição do item
     */
    public void addItem(String titulo, String genero, String descricao) {
        Item item = new Item(titulo, "tipo", genero, descricao);
        items.add(item);
    }

    /**
     * Remove um item da coleção com base no seu título.
     * Se existirem vários itens com o mesmo título, todos serão removidos.
     *
     * @param itemTitulo título do item a remover
     */
    public void removeItem(String itemTitulo) {
        items.removeIf(i -> i.getTitulo().equals(itemTitulo));
    }

    /**
     * Obtém o tipo da coleção.
     *
     * @return tipo da coleção
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da coleção.
     *
     * @param tipo novo tipo da coleção
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtém a lista de itens da coleção.
     *
     * @return lista de itens
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Define a lista de itens da coleção.
     *
     * @param items nova lista de itens
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Gera uma coleção padrão de músicas com itens pré-definidos.
     *
     * @return uma coleção do tipo "Músicas" com itens de exemplo
     */
    public static Collection gerarCollectionDefault() {
        return new Collection(
                "Músicas",
                new ArrayList<>(Arrays.asList(
                        new Item("Bohemian Rhapsody"),
                        new Item("Smells Like Teen Spirit"),
                        new Item("Billie Jean"),
                        new Item("Bohemian Rhapsody"),
                        new Item("Imagine"),
                        new Item("Sweet Child O' Mine"),
                        new Item("Hey Jude"),
                        new Item("Rolling in the Deep"),
                        new Item("Shape of You"),
                        new Item("Lose Yourself")
                ))
        );
    }
}
