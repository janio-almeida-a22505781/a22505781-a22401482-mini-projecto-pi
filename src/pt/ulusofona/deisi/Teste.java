import pt.ulusofona.deisi.Collection;

class Teste {

    @Test
    void deveTerItens() {
        Collection collectionDefault = Collection.gerarCollectionDefault();

        assertEquals(collectionDefault.getItems(), 10);
    }

    @Test
    void deveTerTipo() {
        Collection collectionDefault = Collection.gerarCollectionDefault();

        assertEquals(collectionDefault.getTipo(), "Músicas");
    }

    @Test
    void construtorComTipo() {
        Collection collectionTeste = new Collection("Teste");

        assertNotNull(collectionTeste.getTipo());
        assertEquals(collectionTeste.getItems(), 0);
    }
}
