package academy.learnprogramming;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        PlayHangMan();

        while (true) {
            System.out.println( "Do you want to play again? (y or n)");
            String response = input.nextLine().toLowerCase();
            if (response.equals("y")) {
                PlayHangMan();
            } else {
                break;
            }
        }


    }


    public static void PlayHangMan() {

        System.out.println("Hello, lets play a game called Hangman. \nTry to guess the secret word. " +
                "\nYou get 4 guesses!");
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


        Scanner scan = new Scanner(System.in);

        String[] secretWord = new String[]{"C", "A", "T"};


        System.out.println("This word has " + secretWord.length + " letters. \nEnter a letter.");
        int attempts = 4;
        int rightGuesses = 0;
        int score =0;


        for (int i = 0; i <= secretWord.length; i++) {
            String guess = scan.nextLine();
            if (rightGuesses == 2) {
                System.out.println("Congratulations, you guessed the correct WORD." + Arrays.toString(secretWord));
                String fileName = "score.txt";
                try {
                    PrintWriter outPutScore = new PrintWriter(fileName);
                    outPutScore.println("Winner");
                    outPutScore.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            } else if (guess.equals("c")) {
                System.out.println("Great Job!, this word has ONE C. \n C _ _ .");
                attempts--;
                rightGuesses++;

            } else if (guess.equals("a")) {
                System.out.println("Great Job!, this word has ONE A. \n _ A _");
                attempts--;
                rightGuesses++;
            } else if (guess.equals("t")) {
                System.out.println("Great Job!, this word has ONE T. \n _ _ T");
                attempts--;
                rightGuesses++;


            } else {

                attempts--;
                if (attempts == 3) {
                    System.out.println("The letter you guessed is incorrect, you guessed the letter " + guess + ", you currently have " + attempts + " guesses left,  Please try again!");
                    System.out.println(
                            " +---+\n" +
                                    "\n" +
                                    "O   |\n" +
                                    "\n" +
                                    "    |\n" +
                                    "\n" +
                                    "    |\n" +
                                    "\n" +
                                    "    ===");
                } else if (attempts == 2) {
                    System.out.println("The letter you guessed is incorrect, you guessed the letter " + guess + ", you currently have " + attempts + " guesses left,  Please try again!");
                    System.out.println(
                            "+---+\n" +
                                    "\n" +
                                    "O   |\n" +
                                    "\n" +
                                    "|    |\n" +
                                    "\n" +
                                    "      |\n" +
                                    "\n" +
                                    "    ===");
                } else if (attempts == 1) {
                    System.out.println("The letter you guessed is incorrect, you guessed the letter " + guess + ", you currently have " + attempts + " guesses left,  Please try again!");
                    System.out.println(
                            "+---+\n" +
                                    "\n" +
                                    "O   |\n" +
                                    "\n" +
                                    "|    |\n" +
                                    "\n" +
                                    "|    |\n" +
                                    "\n" +
                                    "    ===");

                } else if (attempts == 0) {
                    System.out.println("The letter you guessed is incorrect, your guessed the letter " + guess + ", SORRY you ran out of tries!\n*******************GAME OVER ******************");
                    String fileName = "score.txt";
                    try {
                        PrintWriter outPutScore = new PrintWriter(fileName);
                        outPutScore.println("Loser");
                        outPutScore.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }


            }


        }
    }
}