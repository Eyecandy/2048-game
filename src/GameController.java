/**
 * Created by DevSingh on 9/14/17.
 */
public class GameController{

    public void start(){
        GameLogic gameLogic = new GameLogic();
        GameBoard board = new GameBoard(10,10);
        board.initBoard();
        KeyPress keyPress = new KeyPress(gameLogic,board);
        GUI gui = new GUI(10,10);
        keyPress.setGui(gui);
        gui.start(keyPress,board);

    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.start();
    }

}
