

/**
 * Created by joakimnilfjord on 9/13/2017 AD.
 */
public class GameController {
    private GameLogic gameLogic;
    private GUI gui;

    public static void main(String[] args) {
        GameController gameController = new GameController();
    }

    GameController() {
        gameLogic = new GameLogic();
        gui = new GUI();
        gui.initGUI(gameLogic.getBoard());
        gameLogic.setFocusable(true);
        KeyPress keyPress = new KeyPress(gameLogic,gui);
        gui.addKeyListener(keyPress);
    }
}
