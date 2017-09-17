import java.util.Arrays;

/**
 * Created by DevSingh on 9/15/17.
 */
public class Responder implements Listener{
    private GameLogic gameLogic;
    private GameBoard board;
    private GUI gui;
    public Responder(GameLogic gameLogic,GameBoard board,GUI gui){
        this.gameLogic = gameLogic;
        this.board = board;
        this.gui = gui;
    }

    @Override
    public void moveKey(String command){
        Integer[][] oldBoard = board.copyBoard();
        if (command.equals("up")){
            System.out.println("respond : UP");
            gameLogic.keyUp(board);
        }else if (command.equals("down")){
            System.out.println("respond : DOWN");
            gameLogic.keyDown(board);
        }else if (command.equals("left")){
            System.out.println("respond : LEFT");
            gameLogic.keyLeft(board);
        }else if (command.equals("right")){
            System.out.println("respond : RIGHT");
            gameLogic.keyRight(board);
        }
        if (!Arrays.deepEquals(oldBoard,board.getBoard())){
            board.setFreeSpace();
        }
        gui.setGUI(board);
    }
}
