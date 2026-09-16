import javax.swing.*;

/**
 * The main class for a Tic-Tac-Toe game using Swing JOptionPane for user interaction.
 */
public class Main {
    /**
     * The main method to run the Tic-Tac-Toe game.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args){
        int rows;
        int cols;
        int play;
        while (true) {
            //option for the user to quit
            play = JOptionPane.showOptionDialog(null, "Do you want to play?", "Play?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Yes", "No"}, "Yes");
            if (play == JOptionPane.NO_OPTION){
                break;
            }

            //choose the dimensions of the game
            try {
                rows = Integer.parseInt(JOptionPane.showInputDialog("How many rows? (from 3 to 10)"));
                cols = Integer.parseInt(JOptionPane.showInputDialog("How many cols? (from 3 to 10)"));
                if (rows < 3 || rows > 10 || cols < 3 || cols > 10){
                    JOptionPane.showMessageDialog(null, "Rows ot cols out of range!");
                    continue;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Wrong input type in rows or cols!");
                continue;
            }

            //initialize the game
            Playground p = new Playground(rows, cols);
            p.run();
            if(p.getWinner() == '0'){
                JOptionPane.showMessageDialog(null, "The game is tied! ");
            }else{
                JOptionPane.showMessageDialog(null, "The winner is: " + p.getWinner());
            }
        }
    }
}