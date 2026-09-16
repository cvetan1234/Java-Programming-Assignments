import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {

    @Test
    void checkForWinnerReturnsCorrectCoordinatesForRows() {
        char[][] board = {
                {'X', 'X', 'X'},
                {'O', 'O', ' '},
                {' ', ' ', ' '}
        };

        Playground playground = new Playground();
        Playground.board = board;

        CoordinatePair winnerCoordinates = playground.checkForWinner();

        assertEquals(0, winnerCoordinates.first);
        assertEquals(0, winnerCoordinates.second);
    }

    @Test
    void checkForWinnerReturnsCorrectCoordinatesForCols() {
        char[][] board = {
                {'X', 'O', ' '},
                {'X', 'O', ' '},
                {'X', ' ', ' '}
        };

        Playground playground = new Playground();
        Playground.board = board;

        CoordinatePair winnerCoordinates = playground.checkForWinner();

        assertEquals(0, winnerCoordinates.first);
        assertEquals(0, winnerCoordinates.second);
    }

    @Test
    void checkForWinnerReturnsCorrectCoordinatesForDiagonal1() {
        char[][] board = {
                {'X', 'O', ' '},
                {'O', 'X', ' '},
                {' ', ' ', 'X'}
        };

        Playground playground = new Playground();
        Playground.board = board;

        CoordinatePair winnerCoordinates = playground.checkForWinner();

        assertEquals(0, winnerCoordinates.first);
        assertEquals(0, winnerCoordinates.second);
    }

    @Test
    void checkForWinnerReturnsCorrectCoordinatesForDiagonal2() {
        char[][] board = {
                {'O', 'O', 'X'},
                {'O', 'X', ' '},
                {'X', ' ', 'O'}
        };

        Playground playground = new Playground();
        Playground.board = board;

        CoordinatePair winnerCoordinates = playground.checkForWinner();

        assertEquals(2, winnerCoordinates.first);
        assertEquals(0, winnerCoordinates.second);
    }

    @Test
    void isFullReturnsTrueForFullBoard() {
        char[][] fullBoard = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };

        Playground playground = new Playground();
        Playground.board = fullBoard;

        assertTrue(playground.isFull());
    }

    @Test
    void isFullReturnsFalseForIncompleteBoard() {
        char[][] incompleteBoard = {
                {'X', 'O', 'X'},
                {'O', ' ', 'O'},
                {'X', 'O', 'X'}
        };

        Playground playground = new Playground();
        Playground.board = incompleteBoard;

        assertFalse(playground.isFull());
    }
}
