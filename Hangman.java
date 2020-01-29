//Ricky Liang
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class Hangman {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //finds a word out of the list
        String[] words = {"colliquial","transition","pause","alternate","control","circumscribe"};
        String word = words[new java.util.Random().nextInt(words.length)];
        //converts word into a hangmannable form
        char[] wordChar = word.toCharArray();
        String[] guessed = new String[wordChar.length];
        //initializes the array with *
        for(int i = 0; i < guessed.length; i++) {
            guessed[i] = "*";
        }

        int misses = 0;
            while(misses != 6 ) {
                //prints out the user input
                System.out.print("(Guess) Enter a letter in word ");
                //prints the ***s
                for(int i = 0; i < guessed.length; i++) {
                    System.out.print(guessed[i]);
                }
                char guess = input.next().charAt(0);
                ArrayList<Character> guessedRight = new ArrayList<Character>();
                for(int i = 0; i < wordChar.length; i++) {
                    if(wordChar[i] == guess) {
                        guessedRight.add(guess);
                        guessed[i] = Character.toString(guess);
                    }
                }
                if(guessedRight.size() == 0) {
                    misses++;
                    System.out.println(String.format("Wrong Choice! %s Guesses Left!", 6- misses));
                }

                ArrayList<Integer> amount = new ArrayList<Integer>();
                for(int i = 0; i < guessed.length; i++) {
                    if(guessed[i] == "*") {
                        amount.add(1);
                    }
                }
                if(amount.size() == 0) {
                 System.out.println(String.format("The word is %s. You missed %s times",word, misses));
                    break;
                }


                }

    }
}
