import java.util.Observable;
import java.util.Observer;

/**
 * Created by DevSingh on 9/19/17.
 */
public class MyObserver implements Observer{
    private GUI gui;
    private GameBoard board;

    public MyObserver(GUI gui, GameBoard board){
        this.gui = gui;
        this.board = board;
    }
    @Override
    public void update(Observable o, Object arg) {
        gui.setGUI(board);
    }
}
