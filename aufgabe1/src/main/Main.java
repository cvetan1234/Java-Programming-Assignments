import java.util.Objects;
import java.util.Scanner;

/**
 * The Main class represents the entry point for running the Tic Tac Toe game.
 */
public class Main {
    /**
     * The main method initializes and runs the Tic Tac Toe game.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Playground pl = new Playground();

        //add two players to the game
        pl.addPlayer(new HumanPlayer('X'));
        pl.addPlayer(new TicTacToeAI('O'));

        //main game loop
        while (true) {
            try {
                pl.run();
            }catch (IncorrectNumberOfPlayersException e){
                System.out.println(e.getMessage());
            }

            //chance for the user to quit the game
            System.out.println("Continue playing (y/n)?");
            char answer = sc.next().charAt(0);
            if (Objects.equals(answer, 'n')){
                break;
            }
        }
    }
}