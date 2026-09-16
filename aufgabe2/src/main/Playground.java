import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a Tic Tac Toe game played in a graphical user interface.
 */
public class Playground {

    private JFrame f;
    private static char[][] board = new char[10][10];
    private static int rows;
    private static int cols;
    private static char turn = 'X';
    private static char winner = '1';
    private static int buttonSize;
    private static int textSize;
    private static int winningNumber;

    /**
     * Constructs a Playground with the specified number of rows and columns.
     *
     * @param rows Number of rows in the game board.
     * @param cols Number of columns in the game board.
     */
    Playground(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        buttonSize = Math.min(600/cols, 600/rows);
        textSize = buttonSize/3;
        winningNumber = Math.min(rows, cols);
    }

    /**
     * Changes the player's turn.
     *
     * @param turn Current player's turn ('X' or 'O').
     * @return The next player's turn.
     */
    public static char changeTurn(char turn){
        if (turn == 'X'){
            return 'O';
        }else{
            return 'X';
        }
    }

    /**
     * Initializes the game and GUI, and waits until the game is over.
     */
    public void run(){
        initializeFrame();
        setBoard();
        setup(f, rows, cols);
        waitTillTheGameIsOver();
    }

    /**
     * Exposed for testing purposes only. Sets the game board directly.
     *
     * @param testBoard The board to set for testing.
     */
    public void setBoardForTesting(char[][] testBoard) {
        if (testBoard.length == rows && testBoard[0].length == cols) {
            board = testBoard;
        } else {
            throw new IllegalArgumentException("Invalid board dimensions for testing.");
        }
    }

    public static char getWinner(){ return winner; }

    boolean isGameOver(){
        return checkForWinner().first != -1 || isFull();
    }

    private static CoordinatePair checkRows() {
        for (int row = 0; row < rows; row++) {
            Loop: for (int col = 0; col < cols - winningNumber + 1; col++) {
                if (board[row][col] != ' ') {
                    for (int n = 1; n < winningNumber; n++) {
                        if (board[row][col] != board[row][col + n]) {
                            continue Loop;
                        }
                    }
                    return new CoordinatePair(row, col);
                }
            }
        }
        return new CoordinatePair(-1, 0);
    }

    private static CoordinatePair checkCols(){
        for (int col = 0; col < cols; col++){
            Loop: for (int row = 0; row < rows - winningNumber + 1; row++){
                if (board[row][col] != ' '){
                    for (int n = 1; n < winningNumber; n++) {
                        if (board[row][col] != board[row + n][col]) {
                            continue Loop;
                        }
                    }
                    return new CoordinatePair(row, col);
                }
            }
        }
        return new CoordinatePair(-1, 0);
    }

    private static CoordinatePair checkDiagonal1(){
        for (int row = 0; row < rows - winningNumber + 1; row++){
            Loop: for (int col = 0; col < cols - winningNumber + 1; col++){
                if (board[row][col] != ' '){
                    for (int n = 1; n < winningNumber; n++) {
                        if (board[row][col] != board[row + n][col + n]) {
                            continue Loop;
                        }
                    }
                    return new CoordinatePair(row, col);
                }
            }
        }
        return new CoordinatePair(-1, 0);
    }

    private static CoordinatePair checkDiagonal2() {
        for (int row = rows - 1; row >= winningNumber - 1; row--) {
            Loop: for (int col = 0; col <= cols - winningNumber; col++) {
                if (board[row][col] != ' ') {
                    for (int n = 1; n < winningNumber; n++) {
                        if (board[row][col] != board[row - n][col + n]) {
                            continue Loop;
                        }
                    }
                    return new CoordinatePair(row, col);
                }
            }
        }
        return new CoordinatePair(-1, 0);
    }

    static CoordinatePair checkForWinner(){
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

    static boolean isFull(){
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (board[row][col] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static void setup(JFrame f, int num_rows, int num_cols) {
        for (int row = 0; row < num_rows; row++) {
            for (int col = 0; col < num_cols; col++) {
                createButton(col*buttonSize, row*buttonSize, buttonSize, buttonSize, f);
            }
        }
        f.revalidate();
        f.repaint();
    }

    private static void setBoard(){
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                board[row][col] = ' ';
            }
        }
    }

    private void waitTillTheGameIsOver(){
        while(true){
            if (isGameOver()){
                break;
            }
        }
    }

    private static void createButton(int x, int y, int width, int height, JFrame f) {
        JButton b = new JButton();
        b.setBounds(x, y, width, height);
        b.setBackground(Color.WHITE);
        b.setFont(new Font("Calibri", Font.PLAIN, textSize));
        int x_coordinate = y/height;
        int y_coordinate = x/width;

        //when clicked
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b.getText().isEmpty()) {
                    //change symbol and color
                    b.setText(String.valueOf(turn));
                    if (turn == 'X') {
                        b.setBackground(Color.RED);
                    }else{
                        b.setBackground(Color.GREEN);
                    }

                    board[x_coordinate][y_coordinate] = turn;
                    CoordinatePair checkForWinner = checkForWinner();
                    boolean isFull = isFull();

                    //check if the game is over
                    if (checkForWinner.first != -1 || isFull){
                        if (checkForWinner.first != -1) {
                            winner = turn;
                        }else{
                            winner = '0';
                        }
                        f.dispose();
                    }
                    turn = changeTurn(turn);
                }
            }
        });
        f.add(b);
    }

    private void initializeFrame(){
        f = new JFrame("Tic Tac Toe");
        f.setSize(cols*buttonSize, rows*buttonSize);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setUndecorated(true);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
