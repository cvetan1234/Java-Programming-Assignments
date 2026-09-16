import java.util.ArrayList;
import java.util.Random;

public class TicTacToeAI extends Player{
    TicTacToeAI(char symbol) { super(symbol); }

    /**
     * Generates a random available move for the player.
     *
     * @return The coordinates (row and column) of a randomly selected available move on the game board.
     */
    public CoordinatePair playMove(){
        ArrayList<CoordinatePair> availableMoves = new ArrayList<>();
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                if (board[row][col] == ' '){
                    availableMoves.add(new CoordinatePair(row, col));
                }
            }
        }
        CoordinatePair randAvailableMove = availableMoves.get(new Random().nextInt(availableMoves.size()));
        return new CoordinatePair(randAvailableMove.first, randAvailableMove.second);
    }
}
