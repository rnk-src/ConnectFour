package connectFourGame;

public class Connect {
    private String[][] board = new String[6][7];
    private String player1Name;
    private String player2Name;

    public Connect(String p1Name, String p2Name){
        player1Name = p1Name;
        player2Name = p2Name;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                board[r][c] = "_";
            }
        }
    }

    public String getPlayer1Name(){
        return player1Name;
    }

    public void player1Move(int row, int col){
        board[row][col] = "O";
    }

    public void player2Move(int row, int col){
        board[row][col] = "X";
    }

    public String getPlayer2Name(){
        return player2Name;
    }

    public int availRow(int col){
        int avail = 5;
        while (board[avail][col].equals("_") == false){
            avail--;
        }
        return avail;
    }

    public String topOfCol(int col){
        return board[0][col];
    }

    public boolean boardIsFull(){
        int i = 0;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if (board[r][c].equals("_")){
                    i++;
                }
            }
        }
        if (i == 0){
            return true;
        }
        return false;
    }

    public void printBoard(){
        for(int i = 0; i < 35; i++){
            System.out.print("_");
        }
        System.out.println("");
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                System.out.print("|_" + board[r][c] + "_|");
            }
            System.out.println("");
        }
    }

    public static void instructions(){
        System.out.println("-------------------------------\nInstructions:\nWelcome to Connect Four! In this strategy game, your goal is to make 4 of your pieces\n" +
                "in a horizontal, vertical, or diagonal manner before the other player. The first player will use \"O's\",\n" +
                "and the second player will use \"X's\". May the best player win!\n-------------------------------");
    }
}
