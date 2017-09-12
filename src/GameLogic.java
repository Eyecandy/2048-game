/**
 * Created by joakimnilfjord on 9/12/2017 AD.
 */
public class GameLogic {
    private Integer board[][];
    private final Integer ROW = 4;
    private final Integer COL = 4;

    public GameLogic() {
        initBoard();
    }

    private void initBoard() {
        board = new Integer[ROW][COL];
        for (int i = 0;i < ROW;i++) {
            for (int j = 0;j < COL;j++) {
                board[i][j] = i+j;
            }
        }
    }
    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer cmd) {
        for (int i = 0;i < ROW;i++) {
            for (int j = 0;j < COL;j++) {
                board[i][j] = board[i][j] + cmd;
            }
        }


    }


 }
