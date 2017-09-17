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

    private Initiater initiater;
    public KeyPress(Initiater initiater){
        this.initiater = initiater;
    }

    public void keyPressed(KeyEvent k) {
        super.keyPressed(k);
//        Integer[][] oldBoard = copyArray(gameLogic.getBoard());
//        Integer[][] newBoard = gameLogic.getBoard();
//        if (!Arrays.deepEquals(oldBoard,newBoard)){
//            gameLogic.setFreeSpace();
//        }
        if (k.getKeyCode() == 37) initiater.sendCommand("left"); // left
        else if (k.getKeyCode() == 38) initiater.sendCommand("up"); //up
        else if (k.getKeyCode() == 39) initiater.sendCommand("right"); //right
        else if (k.getKeyCode() == 40) initiater.sendCommand("down"); //down
    }

}
