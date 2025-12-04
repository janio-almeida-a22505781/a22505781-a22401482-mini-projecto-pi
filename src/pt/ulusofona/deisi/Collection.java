package pt.ulusofona.deisi;

import java.util.ArrayList;

public class Collection {
    String tipo;
    ArrayList<Item> items;

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
    /*Estou "...", me recomende uma música baseada nessa lista das músicas que eu gosto(me de somente o nome da música):
     1) ...

     Estou "...", me recomende uma música dessa lista das músicas que eu gosto(me de somente o nome da música):
     1) ...
     */
}
