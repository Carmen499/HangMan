package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, lets play a cool game called Hangman. \nTry to guess the word that Im currently thinking of. " +
                "\nYou get 7 guesses!");
        String board =
                "H A N G M A N\n" +
                        "\n" +
                        "+-----+\n" +
                        "\n" +
                        "      |\n" +
                        "\n" +
                        "      |\n" +
                        "\n" +
                        "      |\n" +
                        "\n" +
                        "    ===";

        System.out.println(board);

        System.out.println("Please guess a letter.");
        //String input = scan.nextLine();


    }
}
