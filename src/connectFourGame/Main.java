package connectFourGame;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isDone = false;
        String playAgain = "yes";
        Connect board;
        System.out.print("Would you like to see the instructions for the game? If so, please type \"Yes\": ");
        Scanner scan = new Scanner(System.in);
        String instInp = (scan.nextLine()).toLowerCase();
        if (instInp.equals("yes")){
           Connect.instructions();
        }
        while (playAgain.equals("yes")){
            System.out.print("\nAlright, before we begin, we would like to know what you would like to be called!\nIf you wish to go with the default names, please type in \"/n\": ");
            scan = new Scanner(System.in);
            String nameChoice = scan.nextLine();
            if (nameChoice.equals("/n")){
                board = new Connect("Player 1", "Player 2");
            }
            else{
                System.out.print("What would you like to be called, Player 1: ");
                scan = new Scanner(System.in);
                String p1 = scan.nextLine();
                System.out.print("What would you like to be called, Player 2: ");
                scan = new Scanner(System.in);
                String p2 = scan.nextLine();
                board = new Connect(p1, p2);
            }
            System.out.println("\n\nLet the game begin!\n\n");
            board.printBoard();
            while (isDone == false){
                scan = new Scanner(System.in);
                System.out.print("Which column would you like to go to, " + board.getPlayer1Name() + ": ");
                int p1Col = scan.nextInt();
                while(p1Col - 1 < 0 || p1Col - 1 > 6 || board.topOfCol(p1Col-1).equals("_") == false){
                    scan = new Scanner(System.in);
                    System.out.print("Which column would you like to go to, " + board.getPlayer1Name() + ": ");
                    p1Col = scan.nextInt();
                }
                board.player1Move(board.availRow(p1Col-1), p1Col-1);
                board.printBoard();
                if(board.checkWins("O")){
                    System.out.println(board.getPlayer1Name() + " has won the game! Congratulations!");
                    break;
                }
                if(board.boardIsFull()){
                    System.out.println("The board is now full. No more moves can be made.");
                    break;
                }
                scan = new Scanner(System.in);
                System.out.print("Which column would you like to go to, " + board.getPlayer2Name() + ": ");
                int p2Col = scan.nextInt();
                while(p2Col - 1 < 0 || p2Col - 1 > 6 || board.topOfCol(p2Col-1).equals("_") == false){
                    scan = new Scanner(System.in);
                    System.out.print("Which column would you like to go to, " + board.getPlayer2Name() + ": ");
                    p2Col = scan.nextInt();
                }
                board.player2Move(board.availRow(p2Col-1), p2Col-1);
                board.printBoard();
                if(board.checkWins("X")){
                    System.out.println(board.getPlayer2Name() + " has won the game! Congratulations!");
                    break;
                }
                if(board.boardIsFull()){
                    System.out.println("The board is now full. No more moves can be made.");
                    break;
                }
            }
            System.out.println("\nBoth players must input their decision to play again. If you wish to play another game,\n" +
                    "please type in \"Yes\".");
            System.out.print("\nDo you wish to play another game, " + board.getPlayer1Name() + ": ");
            scan = new Scanner(System.in);
            String play1Again = scan.nextLine().toLowerCase();
            System.out.print("\nDo you wish to play another game, " + board.getPlayer2Name() + ": ");
            scan = new Scanner(System.in);
            String play2Again = scan.nextLine().toLowerCase();
            if (play1Again.equals("yes") && play2Again.equals("yes")){
                playAgain = "yes";
            }
            else{
                playAgain = "no";
            }
        }
        System.out.println("\n\nThank you for playing Connect 4! We really hope you enjoyed it.");
    }
}
