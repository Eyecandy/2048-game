import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

import static java.awt.event.KeyEvent.*;


/**
 * Created by joakimnilfjord on 9/12/2017 AD.
 */
public class KeyPress extends KeyAdapter {
    private GameLogic gameLogic;
    private GUI gui;
    public KeyPress(GameLogic gameLogic,GUI gui) {
        this.gameLogic = gameLogic;
        this.gui = gui;
    }

    public void keyPressed(KeyEvent k) {
        super.keyPressed(k);
        Integer[][] oldBoard = gameLogic.getBoard().clone();
        if (k.getKeyCode() == VK_LEFT) gameLogic.keyLeft();
        else if (k.getKeyCode() == VK_UP) gameLogic.keyUp(); //up
        else if (k.getKeyCode() == VK_RIGHT) gameLogic.keyRight(); //right
        else if (k.getKeyCode() == VK_DOWN) gameLogic.keyDown(); //down
        Integer[][] newBoard = gameLogic.getBoard();
        gameLogic.setFreeSpace();
        gui.setGUI(newBoard);
    }


}
