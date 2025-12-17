import pt.ulusofona.deisi.Collection;

class Teste {

    @Test
    void deveTerItens() {
        Collection collectionDefault = Collection.gerarCollectionDefault();

        assertEquals(collectionDefault.getItems(), 10);
    }
}
