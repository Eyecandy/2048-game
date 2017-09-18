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
    private GameBoard board;
    private boolean isGameOver = false;
    private boolean[] moves = new boolean[]{true,true,true,true}; // L,U,R,D

    public KeyPress(GameBoard board){
        this.board = board;
    }

    public void keyPressed(KeyEvent k) {
        super.keyPressed(k);
        if (k.getKeyCode() == 82){ // Reset
            board.initBoard();
            gui.setGUI(board);
            isGameOver = false;
            return;
        }
        if (isGameOver){
            System.out.println("Game Over");
            return;
        }
        Integer[][] oldBoard = board.copyBoard();
        boolean moved = false;
        if (k.getKeyCode() == 37) {
            board.moveLeft(); // left
            moved = true;
        }
        else if (k.getKeyCode() == 38) {
            board.moveUp(); //up
            moved = true;
        }
        else if (k.getKeyCode() == 39) {
            board.moveRight(); //right
            moved = true;
        }
        else if (k.getKeyCode() == 40) {
            board.moveDown(); //down
            moved = true;
        }

        if (moved){
            if (!Arrays.deepEquals(oldBoard,board.getBoard())){
                board.setFreeSpace();
                resetMoves();
            }else{
                moves[k.getKeyCode()-37] = false;
                isGameOver = isOver();
            }
            printMoves();
            gui.setGUI(board);
        }
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public void resetMoves(){
        for(int i=0;i < 4;i++){
            moves[i] = true;
        }
    }

    public boolean isOver(){
        for(int i=0;i < 4;i++){
            if (moves[i]){
                return false;
            }
        }
        return true;
    }

    public void printMoves(){
        for(boolean i : moves){
            System.out.print(i + "|");
        }
        System.out.println("--------------");
    }
}
