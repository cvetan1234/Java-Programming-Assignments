import java.util.*;

/**
 * The Playground class represents the Tic Tac Toe game board and logic.
 */
public class Playground {

    static char[][] board = new char[3][3];
    static ArrayList<Player> players = new ArrayList<>();

    /**
     * Adds a player to the list of players if there is space for one.
     *
     * @param p The player to be added.
     */
    public void addPlayer(Player p){
        if (players.size() <= 2) {
            players.add(p);
        }else{
            System.out.println("No more players can be added!");
        }
    }

    /**
     * Runs the Tic Tac Toe game. Displays the initial board, sets up the game, and
     * iteratively allows each player to make a move until there is a winner or the
     * board is full. Prints the winner or a tie message.
     *
     * @throws IncorrectNumberOfPlayersException If the number of players is not exactly 2.
     */
    public void run() throws IncorrectNumberOfPlayersException {
        if(players.size() == 2) {
            showBoardIndexes();
            setBoard();
            while (checkForWinner().first == -1 && !isFull()) {
                for (Player player : players) {
                    if (checkForWinner().first == -1 && !isFull()) {
                        player.setBoard(board);
                        CoordinatePair move = player.playMove();
                        board[move.first][move.second] = player.getSymbol();
                        printBoard();
                    }
                }
            }
            CoordinatePair winner = checkForWinner();
            if (isFull()) {
                System.out.println("The game is tied");
            } else {
                System.out.println("The winner is: " + board[winner.first][winner.second]);
            }
        }else{
            throw new IncorrectNumberOfPlayersException();
        }
    }

    private void setBoard(){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                board[row][col] = ' ';
            }
        }
    }

    private void printBoard(){
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " \n-----------\n "
                + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " \n-----------\n "
                + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
    }

    private void showBoardIndexes(){
        System.out.println(" 1 | 2 | 3 " + " \n-----------\n "
                + "4 | 5 | 6 " + " \n-----------\n "
                + "7 | 8 | 9 ");
    }

    private static CoordinatePair checkRows(){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length - 2; col++){
                if (board[row][col] != ' ' && board[row][col] == board[row][col+1] && board[row][col] == board[row][col+2]){
                    return new CoordinatePair(row, col);
                }
            }
        }
        return new CoordinatePair(-1, 0);
    }

    private static CoordinatePair checkCols(){
        for (int col = 0; col < board[0].length; col++){
            for (int row = 0; row < board.length - 2; row++){
                if (board[row][col] != ' ' && board[row][col] == board[row+1][col] && board[row][col] == board[row+2][col]){
                    return new CoordinatePair(row, col);
                }
            }
        }
        return new CoordinatePair(-1, 0);
    }

    private static CoordinatePair checkDiagonal1(){
        for (int row = 0; row < board.length - 2; row++){
            for (int col = 0; col < board[0].length - 2; col++){
                if (board[row][col] != ' ' && board[row][col] == board[row+1][col+1] && board[row][col] == board[row+2][col+2]){
                    return new CoordinatePair(row, col);
                }
            }
        }
        return new CoordinatePair(-1, 0);
    }

    private CoordinatePair checkDiagonal2(){
        for (int row = board.length - 1; row >= 2; row--){
            for (int col = 0; col < board[0].length - 2; col++){
                if (board[row][col] != ' ' && board[row][col] == board[row-1][col+1] && board[row][col] == board[row-2][col+2]){
                    return new CoordinatePair(row, col);
                }
            }
        }
        return new CoordinatePair(-1, 0);
    }

    CoordinatePair checkForWinner(){
        CoordinatePair rowWinner = checkRows();
        CoordinatePair colWinner = checkCols();
        CoordinatePair diag1Winner = checkDiagonal1();
        CoordinatePair diag2Winner = checkDiagonal2();
        if (rowWinner.first != -1){
            return rowWinner;
        }
        if (colWinner.first != -1){
            return colWinner;
        }
        if (diag1Winner.first != -1){
            return diag1Winner;
        }
        if (diag2Winner.first != -1){
            return diag2Winner;
        }
        return new CoordinatePair(-1, 0);
    }

    boolean isFull(){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                if (board[row][col] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}
