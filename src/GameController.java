/**
 * Created by DevSingh on 9/14/17.
 */
public class GameController{

    private void start(){

        final int INITIAL_COL = 6;
        final int INITIAL_ROW = 6;
        GameBoard board = new GameBoard(INITIAL_ROW, INITIAL_COL);
        board.initBoard();
        KeyPress keyPress = new KeyPress(board);
        GUI gui = new GUI(INITIAL_ROW, INITIAL_COL);
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
