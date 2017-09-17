/**
 * Created by DevSingh on 9/14/17.
 */
public class GameController{

    public void start(){
        GameLogic gameLogic = new GameLogic();
        GameBoard board = new GameBoard(4,4);
        board.initBoard();
        board.printBoard();
        Initiater initiater = new Initiater();
        KeyPress keyPress = new KeyPress(initiater);
        GUI gui = new GUI(4,4,keyPress, board);
        Responder responder = new Responder(gameLogic,board,gui);
        initiater.addListener(responder);
    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.start();
    }

}
