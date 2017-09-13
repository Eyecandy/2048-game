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
    HashMap<Integer,Integer> hmap = new HashMap<>();
    GameLogic gameLogic;
    GUI gui;
    private static Integer[] KEYS = { VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT, VK_R };
//    private boolean[] directions = new boolean[] {true, true, true, true};

    public KeyPress(GameLogic gameLogic,GUI gui) {
        hmap.put(VK_UP, 1);
        hmap.put(VK_DOWN,-1);
        hmap.put(VK_LEFT,2);
        hmap.put(VK_RIGHT,-2);
        this.gameLogic = gameLogic;
        this.gui = gui;

    }

    public void keyPressed(KeyEvent k) {
        super.keyPressed(k);
        Integer[][] oldBoard = gameLogic.getBoard().clone();
        if (k.getKeyCode() == 37) gameLogic.keyLeft(); // left
        else if (k.getKeyCode() == 38) gameLogic.keyUp(); //up
        else if (k.getKeyCode() == 39) gameLogic.keyRight(); //right
        else if (k.getKeyCode() == 40) gameLogic.keyDown(); //down
        Integer[][] newBoard = gameLogic.getBoard();
        gameLogic.setFreeSpace();
//        gameLogic.setFreeSpace();
        gui.setGUI();
    }

}
