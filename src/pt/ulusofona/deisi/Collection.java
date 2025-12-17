package pt.ulusofona.deisi;

import java.util.ArrayList;
import java.util.Arrays;

public class Collection {
    String tipo;
    ArrayList<Item> items;

    public Collection(String tipo) {
        this.tipo = tipo;
        this.items = new ArrayList<>();
    }

    public Collection(String tipo, ArrayList<Item> items) {
        this.tipo = tipo;
        this.items = items;
    }

    public void addItem(String titulo, String genero, String descricao) {
        Item item = new Item(titulo,"tipo", genero, descricao);
        items.add(item);
    }

    public void removeItem(String itemTitulo) {
        items.removeIf(i -> i.getTitulo().equals(itemTitulo));
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public static Collection gerarCollectionDefault() {
        return new Collection(
                "Músicas",
                new ArrayList<>(Arrays.asList(
                        new Item("Bohemian Rhapsody"),
                        new Item("Smells Like Teen Spirit") ,
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
