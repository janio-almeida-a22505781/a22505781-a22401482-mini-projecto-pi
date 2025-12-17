package pt.ulusofona.deisi;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Classe responsável por interagir com o utilizador através do terminal,
 * processar as opções escolhidas e comunicar com um modelo LLM para gerar
 * recomendações baseadas no estado de espírito (mood) do utilizador.
 */
public class LLMCollection {

    /**
     * Chave da API utilizada para autenticação no serviço LLM.
     */
    static String apiKey = "sk-TDYYkqfy9CTTEMzW9KjmKg";

    /**
     * URL do endpoint do serviço LLM.
     */
    static String url = "https://modelos.ai.ulusofona.pt/v1/completions";

    /**
     * Nome do modelo LLM a utilizar.
     */
    static String model = "gpt-4-turbo";

    /**
     * Indica se deve ser utilizado um modo alternativo (hack).
     */
    static boolean useHack = true;

    /**
     * Apresenta menus ao utilizador para escolher o tipo de coleção
     * e as operações a realizar sobre a mesma.
     *
     * @return opção final escolhida pelo utilizador
     *
     * @throws IOException em caso de erro de entrada/saída
     * @throws NoSuchAlgorithmException se o algoritmo de segurança não existir
     * @throws InterruptedException se a execução for interrompida
     * @throws KeyManagementException se ocorrer um erro na gestão de chaves
     */
    static int askUserForChoice()
            throws IOException, NoSuchAlgorithmException, InterruptedException, KeyManagementException {

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
            collectionType = CollectionType.fromCode(Integer.parseInt(texto), texto).getCode();

        } while (collectionType != 1 && collectionType != 2 && collectionType != 3);

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

    /**
     * Processa a opção escolhida pelo utilizador e executa a ação correspondente.
     *
     * @param option opção selecionada no menu
     *
     * @throws IOException em caso de erro de entrada/saída
     * @throws NoSuchAlgorithmException se o algoritmo de segurança não existir
     * @throws InterruptedException se a execução for interrompida
     * @throws KeyManagementException se ocorrer um erro na gestão de chaves
     */
    public static void processOption(int option)
            throws IOException, NoSuchAlgorithmException, InterruptedException, KeyManagementException {

        switch (option) {
            case 1:
                // Adicionar item à coleção
                break;
            case 2:
                // Remover item da coleção
                break;
            case 3:
                // Listar itens da coleção
                break;
            case 4:
                pedirSugestao();
                break;
            case 5:
                // Sair da aplicação
                break;
        }
    }

    /**
     * Solicita ao utilizador o seu estado de espírito (mood) e utiliza
     * um modelo LLM para recomendar uma música com base numa coleção
     * padrão de músicas favoritas.
     *
     * @throws IOException em caso de erro de entrada/saída
     * @throws NoSuchAlgorithmException se o algoritmo de segurança não existir
     * @throws InterruptedException se a execução for interrompida
     * @throws KeyManagementException se ocorrer um erro na gestão de chaves
     */
    public static void pedirSugestao()
            throws IOException, NoSuchAlgorithmException, InterruptedException, KeyManagementException {

        LLMInteractionEngine llm =
                new LLMInteractionEngine(url, apiKey, model, useHack);

        Collection collectionDefault = Collection.gerarCollectionDefault();

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
