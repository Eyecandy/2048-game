import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by joakimnilfjord on 9/12/2017 AD.
 */
public class GameLogic {
    private Integer[] combineDownRight(Integer[] row){
        int i;
        int loc;
        Integer[] newRow = new Integer[row.length];
        for (int j= 0; j < newRow.length; j++){
            newRow[j] = 0;
        }
        loc = row.length - 1;
        int current = 0;
        for (i=newRow.length - 1;i >= 0; i--){
            if (row[i] == 0){
                continue;
            }
            else if (current == 0){
                current = row[i];
            }
            else if (row[i] == current){
                newRow[loc] = current*2;
                current = 0;
                loc--;
            }else{
                newRow[loc] = current;
                current = row[i];
                loc--;
            }
        }
        newRow[loc] = current;
        return newRow;
    }

    private Integer[] combineUpLeft(Integer[] row){
        int i;
        int loc;
        Integer[] newRow = new Integer[row.length];
        for (int j= 0; j < newRow.length; j++){
            newRow[j] = 0;
        }
        loc = 0;
        int current = 0;
        for (i=0;i < row.length; i++){
            if (row[i] == 0){
                continue;
            }
            else if (current == 0){
                current = row[i];
            }
            else if (row[i] == current){
                newRow[loc] = current*2;
                current = 0;
                loc++;
            }else{
                newRow[loc] = current;
                current = row[i];
                loc++;
            }
        }
        newRow[loc] = current;
        return newRow;
    }

    public void keyLeft(GameBoard board){
        for (int i = 0; i < board.getColumnWidth(); i ++){
            Integer[] boardRow = board.getBoardRow(i);
            board.setBoardRow(i,combineUpLeft(boardRow));
        }
    }

    public void keyRight(GameBoard board){
        for (int i = 0; i < board.getColumnWidth(); i ++){
            Integer[] boardRow = board.getBoardRow(i);
            board.setBoardRow(i,combineDownRight(boardRow));
        }
    }

    public void keyUp(GameBoard board){
        board.transpose();
        for (int i = 0; i < board.getRowWidth(); i ++){
            Integer[] boardRow = board.getBoardRow(i);
            board.setBoardRow(i,combineUpLeft(boardRow));
        }
        board.transpose();
    }

    public void keyDown(GameBoard board){
        board.transpose();
        for (int i = 0; i < board.getRowWidth(); i ++){
            Integer[] boardRow = board.getBoardRow(i);
            board.setBoardRow(i,combineDownRight(boardRow));
        }
        board.transpose();
    }

 }
