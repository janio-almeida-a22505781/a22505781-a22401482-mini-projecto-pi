package pt.ulusofona.deisi;

import java.util.Scanner;
/**
 * Responsável por processar o input do usuário e tratar a resposta do modelo LLM.
 */
public class LLMCollection {

    static int askUserForChoice() {

        int collectionType;
        int option;
        String texto;
        String texto1;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escolha o tipo da sua coleção: \n" +
                    "1) Filmes \n" +
                    "2) Jogos \n" +
                    "3) Musicas \n");
            texto = sc.nextLine();
            collectionType = CollectionType.fromCode(Integer.parseInt(texto),texto).getCode();

        } while (
                collectionType != 1 && collectionType != 2 && collectionType !=3
        );

        do {
            Scanner sc = new Scanner(System.in);
            texto1 = sc.nextLine();
            System.out.println("Escolha a sua opção:");
            System.out.println("1) Adicionar item a coleção");
            System.out.println("2) Remover item da coleção");
            System.out.println("3) Listar itens da coleção, ordenados por titulo");
            System.out.println("4) Recomendação com base no mood");
            System.out.println("5) Sair");

            option = Integer.parseInt(texto);

            processOption(option);
        } while (option != 5);

        return option;
    }

    public static void processOption(int option, Collection colecao) {
        switch (option) {
            case 1:
                colecao.addItem();
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
