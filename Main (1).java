import java.util.*;
public class Main {
    static String[] board;
    static String turn;

    // CheckWinner method
    static String checkWinner() {
        for (int a = 0; a < 24; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[1] + board[2] + board[3];
                    break;
                case 2:
                    line = board[4] + board[5] + board[6];
                    break;
                case 3:
                    line = board[5] + board[6] + board[7];
                    break;
                case 4:
                    line = board[8] + board[9] + board[10];
                    break;
                case 5:
                    line = board[9] + board[10] + board[11];
                    break;
                case 6:
                    line = board[12] + board[13] + board[14];
                    break;
                case 7:
                    line = board[13] + board[14] + board[15];
                    break;
                case 8:
                    line = board[0] + board[4] + board[8];
                    break;
                case 9:
                    line = board[4] + board[8] + board[12];
                    break;
                case 10:
                    line = board[1] + board[5] + board[9];
                    break;
                case 11:
                    line = board[5] + board[9] + board[13];
                    break;
                case 12:
                    line = board[2] + board[6] + board[10];
                    break;
                case 13:
                    line = board[6] + board[10] + board[14];
                    break;
                case 14:
                    line = board[3] + board[7] + board[11];
                    break;
                case 15:
                    line = board[7] + board[11] + board[15];
                    break;
                case 16:
                    line = board[0] + board[5] + board[10];
                    break;
                case 17:
                    line = board[5] + board[10] + board[15];
                    break;
                case 18:
                    line = board[1] + board[6] + board[11];
                    break;
                case 19:
                    line = board[2] + board[5] + board[8];
                    break;
                case 20:
                    line = board[3] + board[6] + board[9];
                    break;
                case 21:
                    line = board[6] + board[9] + board[12];
                    break;
                case 22:
                    line = board[7] + board[10] + board[13];
                    break;
                case 23:
                    line = board[4] + board[9] + board[14];
                    break;
            }
            //For X winner
            if (line.equals("XXX"))
                return "X";
                // For O winner
            else if (line.equals("OOO"))
                return "O";
        }

        for (int a = 0; a < 16; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
//            if no one win
            else if (a == 15)
                return "draw";
        }

        // To enter the X Or O at the exact place on board.
        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }

    // To print the board for the first time with block homes
    static void firstPrintBoard() {
        int r1, r2, r3;
        Random r = new Random();
        // Generate 3 random numbers for block homes
        r1 = r.nextInt(16);
        r2 = r.nextInt(16);
        while (r2 == r1)
            r2 = r.nextInt(16);
        r3 = r.nextInt(16);
        while (r3 == r2 || r3 == r1)
            r3 = r.nextInt(16);
        for (int i = 0; i < 16; i++) {
            if (r1 == i || r2 == i || r3 == i)
                board[i] = "#";
        }
        System.out.println("|---|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " | " + board[3] + " | ");
        System.out.println("|---------------|");
        System.out.println("| " + board[4] + " | "
                + board[5] + " | " + board[6]
                + " | " + board[7] + " | ");
        System.out.println("|---------------|");
        System.out.println("| " + board[8] + " | "
                + board[9] + "| " + board[10]
                + "| " + board[11] + "|");
        System.out.println("|---------------|");
        System.out.println("| " + board[12] + "| "
                + board[13] + "| " + board[14]
                + "| " + board[15] + "|");
        System.out.println("|---|---|---|---|");
    }
//    to print the board for the rest of the game
    static void printBoard() {
        System.out.println("|---|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " | " + board[3] + " | ");
        System.out.println("|---------------|");
        System.out.println("| " + board[4] + " | "
                + board[5] + " | " + board[6]
                + " | " + board[7] + " | ");
        System.out.println("|---------------|");
        System.out.println("| " + board[8] + " | "
                + board[9] + "| " + board[10]
                + "| " + board[11] + "|");
        System.out.println("|---------------|");
        System.out.println("| " + board[12] + "| "
                + board[13] + "| " + board[14]
                + "| " + board[15] + "|");
        System.out.println("|---|---|---|---|");
    }

    static int rePlay () {
        Scanner input = new Scanner(System.in);
        System.out.println("If you want play again , enter R ; else print any key to Exit:");
        String play = input.next();
       if( play.equals("R"))
            return 0;
            else
                return 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new String[17];
        turn = "X";
        String winner = null;
        boolean again=true;

        System.out.println("Please enter that you want play with Another person or Bot\n 1-Another Person\n 2-Bot\n 3-Exit\n");
        int y = in.nextInt();
//        if user enter wrong number
        while (!(y == 1 || y == 2 || y == 3)) {
            System.out.println("Please enter correct number");
            y = in.nextInt();
        }
        switch (y) {
            case 1:
                System.out.println("Welcome to 4x4 Tic Tac Toe.");
                while (again == true ) {
                    winner = null;
                    for (int a = 0; a < 17; a++)
                        board[a] = String.valueOf(a + 1);
                    firstPrintBoard();

                    System.out.println(turn + " will play first. Enter a slot number to place " + turn  + " in:");
                    while (winner == null) {
                        int numInput;

                        // Exception handling.If it is not in range from 1 to 16. then it will show you an error "Invalid input."
                        try {
                            numInput = in.nextInt();
                            if (!(numInput > 0 && numInput <= 16)) {
                                System.out.println("Invalid input; re-enter slot number:");
                                continue;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input; re-enter slot number:");
                            continue;
                        }

                        // decide the turn.
                        if (board[numInput - 1].equals(
                                String.valueOf(numInput))) {
                            board[numInput - 1] = turn;

                            if (turn.equals("X"))
                                turn = "O";
                            else
                                turn = "X";

                            printBoard();
                            winner = checkWinner();
                        } else
                            System.out.println("Slot already taken; re-enter slot number:");
                    }
                    // If no one win or lose from both player x and O. then here is the logic to print "draw".
                    if (winner.equalsIgnoreCase("draw"))
                        System.out.println("It's a draw! Thanks for playing.");

                        // For winner -to display Congratulations! message.
                    else
                        System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
                    if (rePlay() == 1)
                        again = false;
                }
                    break;

            //  play with Bot
            case 2:
                System.out.println("Welcome to 4x4 Tic Tac Toe.");
                while (again == true ) {
                    winner = null;
                    for (int a = 0; a < 17; a++)
                        board[a] = String.valueOf(a + 1);
                    firstPrintBoard();

                    System.out.println(turn + " will play first. Enter a slot number to place " + turn + " in:");
                    while (winner == null) {
                        int numInput;
                        if (turn.equals("X"))
                            numInput = in.nextInt();
                            //  for Bot
                        else {
                            int rand;
                            Random r = new Random();
                            rand = r.nextInt(17);
                            numInput = rand;
                        }
                        //The try statement allows you to define a block of code to be tested for errors while it is being executed.
                        try {
                            if (!(numInput > 0 && numInput <= 16)) {
                                System.out.println("Invalid input; re-enter slot number:");
                                continue;
                            }
                        }
                        // The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
                        catch (InputMismatchException e) {
                            System.out.println("Invalid input; re-enter slot number:");
                            continue;
                        }
                        // decide the turn of players
                        if (board[numInput - 1].equals(
                                String.valueOf(numInput))) {
                            board[numInput - 1] = turn;

                            if (turn.equals("X"))
                                turn = "O";
                            else
                                turn = "X";

                            printBoard();
                            winner = checkWinner();
                        }
                    }

                    // If no one win or lose from both player x and O. then here is the logic to print "draw".
                    if (winner.equalsIgnoreCase("draw"))
                        System.out.println("It's a draw! Thanks for playing.");

                        // For winner -to display Congratulations! message.
                    else
                        System.out.println("Congratulations! " + winner  + "'s have won! Thanks for playing.");
                    if (rePlay() == 1)
                        again = false;
                }
                break;
            case 3:
                System.out.printf("App closed");
        }
    }
}