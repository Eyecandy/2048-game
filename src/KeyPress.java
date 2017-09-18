import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_R;

/**
 * Created by joakimnilfjord on 9/12/2017 AD.
 */
public class KeyPress extends KeyAdapter {

    private GUI gui;
    private GameLogic gameLogic;
    private GameBoard board;

    public KeyPress(GameLogic gameLogic, GameBoard board){
        this.gameLogic = gameLogic;
        this.board = board;
    }

    public void keyPressed(KeyEvent k) {
        super.keyPressed(k);
        if (k.getKeyCode() == 82){
            board.initBoard();
            gui.setGUI(board);
            return;
        }
        Integer[][] oldBoard = board.copyBoard();
        boolean moved = false;
        if (k.getKeyCode() == 37) {
            gameLogic.keyLeft(board); // left
            moved = true;
        }
        else if (k.getKeyCode() == 38) {
            gameLogic.keyUp(board); //up
            moved = true;
        }
        else if (k.getKeyCode() == 39) {
            gameLogic.keyRight(board); //right
            moved = true;
        }
        else if (k.getKeyCode() == 40) {
            gameLogic.keyDown(board); //down
            moved = true;
        }

        if (moved){
            if (!Arrays.deepEquals(oldBoard,board.getBoard())){
                board.setFreeSpace();
            }
            gui.setGUI(board);
        }
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }
}
