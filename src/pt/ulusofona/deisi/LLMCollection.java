package pt.ulusofona.deisi;

public class LLMCollection {

    int askUserForChoice() {

        int collectionType;
        int option;

        do {
            System.out.println("Escolha o tipo da sua coleção: \n" +
                    "1) Filmes \n" +
                    "2) Jogos \n" +
                    "3) Musicas \n");

            // TO-DO: LER KEYBOARD
        } while (
                collectionType != CollectionType.fromCode(1).getCode() &&
                collectionType != CollectionType.fromCode(2).getCode() &&
                collectionType != CollectionType.fromCode(3).getCode());

        do {
            System.out.println("Escolha a sua opção:");
            System.out.println("1) Adicionar item a coleção");
            System.out.println("2) Remover item da coleção");
            System.out.println("3) Listar itens da coleção, ordenados por titulo");
            System.out.println("4) Recomendação com base no mood");
            System.out.println("5) Sair");


            // TO-DO: LER KEYBOARD
            // TO-DO:


            processOption(option);
        } while (option != 5);

        return option;
    }

    public static void processOption(int option) {
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
}
