package pt.ulusofona.deisi;

public class Main {
    static String apiKey = "sk-TDYYkqfy9CTTEMzW9KjmKg";
    static String url = "https://modelos.ai.ulusofona.pt/v1/completions";
    static String model = "gpt-4-turbo";
    static boolean useHack = true;
    public static void main(String[] args) {

        int i = LLMCollection.askUserForChoice();
    }
}
