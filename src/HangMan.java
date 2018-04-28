import java.util.Arrays;
import java.util.Scanner;

public class HangMan {




    public static void main( String[] args ) {

        System.out.println ( "Hello to hangman, you have 5 tries to for letters and 5 possible consecutive games to play!" );

        String[] wordArray = new String[]{"easy", "helicopter", "complicated", "wizards", "jazz"};
        String tempWord;
        String blankWord = "";
        String misses = "";
        boolean gameCheck = true;
        boolean check = true;
        boolean checkGuess;
        Scanner in = new Scanner(System.in);

        while(gameCheck){
            for(int i =0; i<=wordArray.length;i++)//   Loop through the list of words
            {
                tempWord = wordArray[i];
                String[] blankArray = new String[tempWord.length()];
                String blank = "_";
                for(int g = 0; g<blankArray.length; g++){    //  Loop through name to make blank
                    blankWord = blankWord+"_";
                    blankArray[g] = blank;
                    //tempWord.charAt(g);
                }


                    // NEW GAME \\

                do {
                    System.out.print("Word: ");
                    for(int hu =0; hu < blankArray.length; hu++)System.out.print(blankArray[hu] + " ");

                    System.out.println(" ");
                    System.out.println("Misses: " + misses);

                    System.out.println("Guess  a letter! ");

                    String guess = in.next();

                    System.out.println("+++++++++++++++++++++++++++++++++++++++ ");

                    System.out.println("Guess: " + guess);
                    checkGuess = true;                             //For checking whether to print missed guess
                    for (int k = 0; k < tempWord.length(); k++) {    //Loop name to check for guess

                        String chary = Character.toString ( tempWord.charAt ( k ) );
                        if (chary.equals(guess)) {
                                blankArray[k]=chary;
                                checkGuess = false;;
                        }
                    }
                    if (checkGuess){
                        misses = misses + " " + guess;
                    }

                    // Check for end of game
                    int test = 0;
                    for (int k = 0; k < tempWord.length(); k++) {
                        String chary = Character.toString ( tempWord.charAt ( k ) );
                        if (chary.equals(blankArray[k])) {
                            test++;
                        }
                    }
                    if (test == tempWord.length()){
                        check = false;
                    }
                    if (misses.length ()>10){
                        System.out.println ( "Too many misses you are dead!");
                        check = false;
                    }


                }while(check);
                System.out.println(" ");
                System.out.println("Game over");
                System.out.println(" ");

                System.out.println("Play again = y Quit = x");
                if (!in.next().equals("y")) gameCheck = false;
            }


        }
        }
}

