/**
 * Created by DevSingh on 9/14/17.
 */
public class GameController{

    public void start(){
        GameBoard board = new GameBoard(2,2);
        board.initBoard();
        KeyPress keyPress = new KeyPress(board);
        GUI gui = new GUI(2,2);
        MyObserver myObserver = new MyObserver(gui,board);
        board.addObserver(myObserver);
//        keyPress.setGui(gui);
        gui.start(keyPress,board);

    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.start();
    }

}
