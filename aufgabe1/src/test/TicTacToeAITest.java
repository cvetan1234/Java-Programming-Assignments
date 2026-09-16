import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeAITest {

    @Test
    void playMoveReturnsValidCoordinate() {
        char[][] initialBoard = {
                {'X', 'O', 'X'},
                {'O', ' ', ' '},
                {'X', ' ', 'O'}
        };

        TicTacToeAI aiPlayer = new TicTacToeAI('O');
        aiPlayer.setBoard(initialBoard);

        CoordinatePair move = aiPlayer.playMove();

        assertTrue(move.first >= 0 && move.first < 3);
        assertTrue(move.second >= 0 && move.second < 3);
        assertEquals(' ', initialBoard[move.first][move.second]);
    }
}
