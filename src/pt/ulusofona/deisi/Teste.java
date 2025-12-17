package pt.ulusofona.deisi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Teste {

    @Test
    public void deveTerItens() {
        Collection collectionDefault = Collection.gerarCollectionDefault();
        assertEquals(collectionDefault.getItems().size(), 10);
    }

    @Test
    public void deveTerTipo() {
        Collection collectionDefault = Collection.gerarCollectionDefault();

        assertEquals(collectionDefault.getTipo(), "Músicas");
    }

    @Test
    public void construtorComTipo() {
        Collection collectionTeste = new Collection("Teste");

        assertNotNull(collectionTeste.getTipo());
        assertEquals(collectionTeste.getItems().size(), 0);
    }

    @Test
    public void construtorCompleto() {
        Collection collectionTeste = new Collection("Teste", new ArrayList<>(Arrays.asList(
                new Item("Bohemian Rhapsody")
        )));

        assertNotNull(collectionTeste.getTipo());
        assertEquals(collectionTeste.getItems().size(), 1);
        assertEquals(collectionTeste.getItems().getFirst().toString(), "Bohemian Rhapsody");
    }

    @Test
    public void adicionarItem() {
        Collection collectionDefault = Collection.gerarCollectionDefault();

        collectionDefault.addItem("Teste", "Musica", "descricao");

        assertEquals(collectionDefault.getItems().size(), 11);
    }

    @Test
    public void removerItem() {
        Collection collectionDefault = Collection.gerarCollectionDefault();

        collectionDefault.removeItem("Bohemian Rhapsody");

        assertEquals(collectionDefault.getItems().size(), 8);
    }
}
