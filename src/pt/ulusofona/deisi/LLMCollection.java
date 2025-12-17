package pt.ulusofona.deisi;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Responsável por processar o input do usuário e tratar a resposta do modelo LLM.
 */
public class LLMCollection {

    static String apiKey = "sk-TDYYkqfy9CTTEMzW9KjmKg";
    static String url = "https://modelos.ai.ulusofona.pt/v1/completions";
    static String model = "gpt-4-turbo";
    static boolean useHack = true;

    static int askUserForChoice() throws IOException, NoSuchAlgorithmException, InterruptedException, KeyManagementException {

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

            System.out.println("Escolha a sua opção:");
            System.out.println("1) Adicionar item a coleção");
            System.out.println("2) Remover item da coleção");
            System.out.println("3) Listar itens da coleção, ordenados por titulo");
            System.out.println("4) Recomendação com base no mood");
            System.out.println("5) Sair");

            texto1 = sc.nextLine();
            option = Integer.parseInt(texto1);

            processOption(option);
        } while (option != 5);

        return option;
    }

    public static void processOption(int option) throws IOException, NoSuchAlgorithmException, InterruptedException, KeyManagementException {
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                pedirSugestao();
                break;
            case 5:
                break;
        }
    }

    public static void pedirSugestao() throws IOException, NoSuchAlgorithmException, InterruptedException, KeyManagementException {
        LLMInteractionEngine llm = new LLMInteractionEngine(url, apiKey, model, useHack);

        Collection collectionDefault = new Collection(
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


        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o seu mood atual ? (triste, feliz, empolgado ...)");
        String texto = sc.nextLine();
        String prompt = collectionDefault.getItems().toString() +". Estou me sentindo " + texto + " me recomende uma música baseada nessa lista das músicas que eu gosto(me de somente o nome da música e nada mais, não escreva aspas nem simples)";

        String resposta = llm.sendPrompt(prompt);

        System.out.println(resposta);

        resposta = JSONUtils.getJsonString(resposta, "text");

        System.out.println(resposta);
    }
}
