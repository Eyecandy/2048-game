/**
 * Created by DevSingh on 9/14/17.
 */
public class GameController{

    public void start(){
        GameLogic gameLogic = new GameLogic();
        GameBoard board = new GameBoard(4,4);
        board.initBoard();
        board.printBoard();
        KeyPress keyPress = new KeyPress(gameLogic,board);
        GUI gui = new GUI(4,4);
        keyPress.setGui(gui);
        gui.start(keyPress,board);

    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.start();
    }

}
