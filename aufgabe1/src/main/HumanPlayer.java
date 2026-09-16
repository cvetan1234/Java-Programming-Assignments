import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner sc = new Scanner(System.in);

    HumanPlayer(char symbol) { super(symbol); }

    private static int translateCoordinatesTo2D(int coord, char[][] board){
        int col = (coord-1)%board[0].length;
        coord -= (col + 1);
        int row = coord/board[0].length;
        return row*10 + col;
    }

    /**
     * Allows the player to choose a move by providing input through the console.
     *
     * @return The coordinates (row and column) of the selected move on the game board.
     */
    public CoordinatePair playMove(){
        int move;
        while(true) {
            try {
                System.out.print("Player " + this.symbol + " choose a move: ");
                move = sc.nextInt();
                int row = translateCoordinatesTo2D(move, board) / 10;
                int col = translateCoordinatesTo2D(move, board) % 10;
                if (move >= 1 && move <= 9) {
                    if (board[row][col] == ' ') {
                        return new CoordinatePair(row, col);
                    }else{
                        System.out.println("There already is a piece on that index!");
                    }
                }else{
                    System.out.println("Index out of range!");
                }
            }catch (InputMismatchException e){
                System.out.println("Wrong input type!");
                sc.nextLine();
            }
        }
    }
}
