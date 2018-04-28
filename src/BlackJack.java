import java.util.Random;
import java.util.Scanner;


public class BlackJack {



    public static void main(String[] args) {
        Random card = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to a blackjack table");
        System.out.println("");
        boolean cycle = true;
        while (cycle) {
        int score = 0;
        int first = card.nextInt(10)+2;
        int last = card.nextInt(10)+2;
        score = first + last;
        System.out.println("You get a " + first + " and a "+ last+".");
        System.out.println("Your total is " +score+".");
        System.out.println("");
        int dscore = 0;
        int dlast = card.nextInt(10)+2;
        int dfirst = card.nextInt(10)+2;
        dscore = dlast + dfirst;



        System.out.println("The dealer has a " +dfirst+" showing, and a hidden card.");
        System.out.println("");
        System.out.println("Would you like to \"hit\" or \"stay\"");
        String hs = in.next();

            if (hs.equals("hit") || hs.equals("HIT") || hs.equals("stay") || hs.equals("STAY")) {

                while (hs.equals("hit") || hs.equals("HIT")) {
                    int more = card.nextInt(10) + 2;
                    System.out.println("You drew a " + more);
                    score = score + more;
                    System.out.println("Your total is" + score);
                    System.out.println("");

                    if (score == 21) {
                        System.out.println("You WIN!");
                        cycle = false;
                        break;
                    } else if (score > 21) {

                        System.out.println("You overburned!");
                        cycle = false;
                        break;
                    }

                    System.out.println("Would you like to \"hit\" or \"stay\"");
                    hs = in.next();

                }
                if (cycle) {

                System.out.println("Okay, dealer's turn.");
                System.out.println("His hidden card was a " + dlast);
                System.out.println("His total was " + dscore);
                System.out.println("");

                    if(dscore <= 17) {
                        while(dscore <= 17){
                            int dmore = card.nextInt(10) + 2;
                            dscore = dscore + dmore;
                            System.out.println("Dealer chooses to hit.");
                            System.out.println("He draws a " + dmore);
                            System.out.println("His total is " + dscore);

                            System.out.println("");
                            if (score > dscore) {
                                System.out.println("You WIN!");
                            } else {
                                System.out.println("You Loose.");
                            }
                        }


                        if (dscore >= 22) {
                            System.out.println("Dealer overburned!");
                            System.out.println("");
                            System.out.println("You WIN!");
                            System.out.println("");

                        } else if (score == 21) {
                            System.out.println("Dealer Scores 21! You Loose.");

                        }

                    }else {

                        System.out.println("Dealer stays.");

                        System.out.println("Dealers total is " + dscore);
                        System.out.println("Your total is " + score);
                        System.out.println("");

                        if (score > dscore) {
                            System.out.println("You WIN!");
                        } else {
                            System.out.println("You Loose.");
                        }
                    }

                }
            } else {
                System.out.println("you must write \"hit\" or \"stay\" to continue");
                break;
            }
            System.out.println("Game Over!");
            System.out.println("");
            System.out.println("Play again? 1-yes; 2-no");
            int repeate = in.nextInt();
            if (repeate == 1){
                cycle = true;

            }else if(repeate == 2){
                cycle = false;
            }else{
                System.out.println("Fuck you");
                break;
            }

        }


    }

}
