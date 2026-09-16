public abstract class Player {
    protected char[][] board;
    protected char symbol;

    Player(char symbol){ this.symbol = symbol; }

    protected void setBoard(char[][] board){
        this.board = board;
    }

    protected char getSymbol() { return symbol; }

    protected abstract CoordinatePair playMove();
}
