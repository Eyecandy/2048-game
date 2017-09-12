import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        if (hmap.containsKey(k.getKeyCode())) {
            gameLogic.setBoard(hmap.get(k.getKeyCode()));
            gui.setGUI();

        }
    }

}
