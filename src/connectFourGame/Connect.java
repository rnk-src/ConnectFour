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

    public boolean checkWins(String let){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length-3; c++){
                if(board[r][c].equals(let) && board[r][c+1].equals(let) && board[r][c+2].equals(let) && board[r][c+3].equals(let)){
                    return true;
                }
            }
        }
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c].equals(let) && board[r+1][c].equals(let) && board[r+2][c].equals(let) && board[r+3][c].equals(let)){
                    return true;
                }
            }
        }
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 4; c++){
                if(board[r][c].equals(let) && board[r+1][c+1].equals(let) && board[r+2][c+2].equals(let) && board[r+3][c+3].equals(let)){
                    return true;
                }
            }
        }
        for(int r = 5; r > 2; r--){
            for(int c = 0; c < 4; c++){
                if(board[r][c].equals(let) && board[r-1][c+1].equals(let) && board[r-2][c+2].equals(let) && board[r-3][c+3].equals(let)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWins2 (String let, int ro, int cl){
        return horizontalCheck(let,ro,cl) || verticalCheck(let,ro,cl) || diagonalCheck(let,ro,cl);
    }

    public boolean horizontalCheck(String let, int ro, int cl){
        int sum = 1;
        if(cl-3 < 0){
            for(int i = 0; i < cl; i++){
                if(board[ro][i].equals(let) == false){
                    break;
                }
                sum++;
            }
        }
        else{
            for(int i = cl-3; i < cl; i++){
                if(board[ro][i].equals(let) == false){
                    break;
                }
                sum++;
            }
        }
        if(cl+3 > 6){
            for(int i = 6; i > cl; i--){
                if(board[ro][i].equals(let) == false){
                    break;
                }
                sum++;
            }
        }
        else{
            for(int i = cl + 3; i > cl; i--){
                if(board[ro][i].equals(let) == false){
                    break;
                }
                sum++;
            }
        }
        if(sum >= 4){
            return true;
        }
        return false;
    }

    public boolean verticalCheck(String let, int ro, int cl){
        int sum = 1;
        if(ro > 2){
            return false;
        }
        for(int i = ro + 1; i < ro + 4; i++){
            if(board[i][cl].equals(let) == false){
                break;
            }
            sum++;
        }
        if(sum >= 4){
            return true;
        }
        return false;
    }

    public boolean diagonalCheck(String let, int ro, int cl){
        int sum = 0;
        int startRo = ro;
        while(startRo > -1){
            startRo--;
        }
        int startCol = cl;
        while(startCol > -1){
            startCol--;
        }
        while(startRo < 5 && startCol < 6){
            if(board[startRo][startCol].equals(let)){
                sum++;
            }
            else{
                break;
            }
            startRo++;
            startCol++;
        }
        if(sum >= 4){
            return true;
        }
        sum = 0;
        startRo = ro;
        while(startRo < 5){
            startRo++;
        }
        startCol = cl;
        while(startCol > -1){
            startCol--;
        }
        while(startRo > -1 && startCol < 6){
            if(board[startRo][startCol].equals(let)){
                sum++;
            }
            else{
                break;
            }
            startRo--;
            startCol++;
        }
        return sum >= 4;
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
