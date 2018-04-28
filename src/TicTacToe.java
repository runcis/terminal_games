import java.util.Scanner;

public class TicTacToe
{

    private static char[][] board = new char[3][3];

    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Play Tic-Tac-Toe");
        System.out.println("");

        initBoard();
        displayBoard();
        System.out.println("Press O or X to start game.");
        int g = 0;
        //while(checkWinX() || checkWinY()) {
        do {
            System.out.println("press enter");
            String key = keyboard.next();
            boolean tick = g%2==1;

            if(tick){

                System.out.println("\"X\"Choose your position(row, column)");
                int pos1 = keyboard.nextInt();
                if (pos1 == 0 || pos1 == 1 || pos1 == 2) {
                    int pos2 = keyboard.nextInt();
                    if (pos2 == 0 || pos2 == 1 || pos2 == 2) {
                        if(board[pos1][pos2] == ' ') {
                            board[pos1][pos2] = 'X';
                            displayBoard();
                        }
                    } else {
                        System.out.println("Ievadīt tikai 0-2");
                    }
                } else {
                    System.out.println("Ievadīt tikai 0-2");
                }

            }//else System.out.println("\"X\"Choose your position(row, column)");g++;
            if (tick != true) {
                System.out.println("\"O\"Choose your position(row, column)");
                int pos = keyboard.nextInt();

                if (pos == 0 || pos == 1 || pos == 2) {
                    int pos1 = keyboard.nextInt();
                    if (pos1 == 0 || pos1 == 1 || pos1 == 2) {
                        if(board[pos][pos1] == ' '){
                        board[pos][pos1] = 'O';
                        displayBoard();
                        }
                    } else {
                        System.out.println("Ievadīt tikai 0-2");
                    }
                } else {
                    System.out.println("Ievadīt tikai 0-2");
                }

            }g++;
      /*  if (key.equals("O") || key.equals("o")) {

                    System.out.println("\"O\"Choose your position(row, column)");
                    int pos = keyboard.nextInt();
                    if (pos == 0 || pos == 1 || pos == 2) {
                        int pos1 = keyboard.nextInt();
                        if (pos1 == 0 || pos1 == 1 || pos1 == 2) {
                            board[pos][pos1] = 'O';
                            displayBoard();
                        } else {
                            System.out.println("Ievadīt tikai 0-2");
                        }
                    } else {
                        System.out.println("Ievadīt tikai 0-2");
                    }

            }
            else if (key.equals("X") || key.equals("x")) {

            System.out.println("\"O\"Choose your position(row, column)");
            int pos = keyboard.nextInt();
            if(pos == 0 || pos == 1 || pos == 2) {
                int pos1 = keyboard.nextInt();
                if(pos1 == 0 || pos1 == 1 || pos1 == 2) {
                    board[pos][pos1] = 'X';
                    displayBoard();
                } else{System.out.println("Ievadīt tikai 0-2");}
            }else{System.out.println("Ievadīt tikai 0-2");}
        } else {
            System.out.println("Ievadīt tikai O vai X");
        }*/
        }while(checkWinX() || checkWinY());
        if(checkWinX()){
        System.out.println("Congrats, X won");}
        else if(checkWinY()){
            System.out.println("Congrats, O won");}
            else if(checkTie()) System.out.println("Congrats, it is a tie");



    }

    public static void initBoard()
    {
        // fills up the board with blanks
        for ( int r=0; r<3; r++ )
            for ( int c=0; c<3; c++ )
                board[r][c] = ' ';
    }


    public static void displayBoard()
    {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }


    /*public static void displayBoard2()
    {
        for ( int r=0; r<3; r++ )
        {
            System.out.print("\t"+r+" ");
            for ( int c=0; c<3; c++ )
            {
                System.out.print( board[r][c] + " " );
            }
            System.out.println();
        }
        System.out.println("\t  0 1 2 ");
    }*/







    private static boolean checkWinX() {

      boolean temp;
      {
          int h =0;
          temp = false;
          for (int i = 0; i < board.length; i++) {
              for (int j = 0; j < board[i].length; j++) {
                  if (board[i][j] == 'x') {
                      h++;
                  } else if (board[i][j] == 'X') {
                      h++;

                  }else if (board[i][i] == 'X' || board[i][i]=='x'){
                      h++;
                  }
              }
          }
          if (h<3)
          {temp = true;
          }
          return temp;
      }
  }

    private static boolean checkTie() {

        boolean temp;
        {
            int h =0;
            temp = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'x'  || board[i][j]=='o') {
                        h++;
                    } else if (board[i][j] == 'X'  || board[i][j]=='O') {
                        h++;

                    }else if (board[i][i] == 'X' || board[i][i]=='x' || board[i][i]=='o' || board[i][i]=='O'){
                        h++;
                    }
                }
            }
            if (h==9)
            {temp = true;
            }
            return temp;
        }
    }

    private static boolean checkWinY() {
        boolean temp;
        {
            int h =0;
            temp =false;
            for(int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if(board[i][j] == 'o'){
                        h++;
                    }else if(board[i][j] == 'O'){
                        h++;
                }else if (board[i][i] == 'O' || board[i][i]=='o'){
                        h++;
                    }
            }
        }
            if (h<3){
                temp = true;
            }
        return temp;
    }}/*
    private static boolean checkWin() {

        for ( int r=0; r<3; r++ ) {
            int g = 0;
            for (int c = 0; c < 3; c++)
                if (board[r][c] != ' ') {
                    g++;
                }
        }
    }*/
}