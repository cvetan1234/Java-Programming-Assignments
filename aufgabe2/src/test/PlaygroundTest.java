import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaygroundTest {

    @Test
    void changeTurn() {
        assertEquals('O', Playground.changeTurn('X'));
        assertEquals('X', Playground.changeTurn('O'));
    }

    @Test
    void isGameOverWithWinner() {
        Playground playground = new Playground(3, 3);
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };
        playground.setBoardForTesting(board);
        assertTrue(playground.isGameOver());
    }

    @Test
    void isFullEmptyBoard() {
        Playground playground = new Playground(3, 3);
        assertFalse(playground.isFull());
    }

    @Test
    void isFullFullBoard() {
        Playground playground = new Playground(3, 3);
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };
        playground.setBoardForTesting(board);
        assertTrue(playground.isFull());
    }

    @Test
    void testIsGameOverWithWinnerHorizontal() {
        Playground playground = new Playground(3, 3);
        char[][] board = {
                {'X', 'X', 'X'},
                {'O', 'O', ' '},
                {' ', ' ', ' '}
        };
        playground.setBoardForTesting(board);
        assertTrue(playground.isGameOver());
    }

    @Test
    void testIsGameOverWithWinnerVertical() {
        Playground playground = new Playground(3, 3);
        char[][] board = {
                {'X', 'O', ' '},
                {'X', 'O', ' '},
                {'X', ' ', ' '}
        };
        playground.setBoardForTesting(board);
        assertTrue(playground.isGameOver());
    }

    @Test
    void testIsGameOverWithWinnerDiagonal() {
        Playground playground = new Playground(3, 3);
        char[][] board = {
                {'X', 'O', ' '},
                {'O', 'X', ' '},
                {' ', ' ', 'X'}
        };
        playground.setBoardForTesting(board);
        assertTrue(playground.isGameOver());
    }

    @Test
    void testIsGameOverWithWinnerDiagona2() {
        Playground playground = new Playground(3, 3);
        char[][] board = {
                {'X', ' ', 'O'},
                {'O', 'O', 'X'},
                {'O', 'X', 'X'}
        };
        playground.setBoardForTesting(board);
        assertTrue(playground.isGameOver());
    }
}
