import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by joakimnilfjord on 9/12/2017 AD.
 */
public class GameLogic extends JFrame  {
    private Integer board[][];
    private final Integer ROW = 4;
    private final Integer COL = 4;
    private Random randomizer = new Random();

    public GameLogic() {
        initBoard();
    }

    public void initBoard() {
        board = new Integer[ROW][COL];
        int startOne,startTwo;
        startOne = randomizer.nextInt(16);
        startTwo = randomizer.nextInt(16);
        while (startOne == startTwo){
            startTwo = randomizer.nextInt(16);
        }
        for (int i = 0;i < ROW;i++) {
            for (int j = 0;j < COL;j++) {
                board[i][j] = 0;
            }
        }
        board[startOne/4][startOne%4] = randomTile();
        board[startTwo/4][startTwo%4] = randomTile();

    }

    public Integer[][] getBoard() {
        return board;
    }

    public Integer[] combineDownRight(Integer[] row){
        int i;
        int loc;
        Integer[] newRow = new Integer[]{ 0, 0 ,0, 0 };
        loc = 3;
        int current = 0;
        for (i=newRow.length - 1;i >= 0; i--){
            if (row[i] == 0){
//                System.out.println("continue");
                continue;
            }
            else if (current == 0){
                current = row[i];
//                System.out.println("current " + current);
            }
            else if (row[i] == current){
//                System.out.println("combine");
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
//        System.out.println("After");
//        for (int k : newRow){
//            System.out.print(k + " | ");
//        }
        return newRow;
    }

    public Integer[] combineUpLeft(Integer[] row){
        int i;
        int loc;
        Integer[] newRow = new Integer[]{ 0, 0 ,0, 0 };
        loc = 0;
        int current = 0;
        for (i=0;i < 4; i++){
            if (row[i] == 0){
//                System.out.println("continue");
                continue;
            }
            else if (current == 0){
                current = row[i];
//                System.out.println("current " + current);
            }
            else if (row[i] == current){
//                System.out.println("combine");
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
//        System.out.println("After");
//        for (int k : newRow){
//            System.out.print(k + " | ");
//        }
        return newRow;
    }

    public void transpose(){
        for(int i = 0; i < 4; i++) {
            for(int j = i+1; j < 4; j++) {
                int temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }
    }

    public void keyLeft(){
        for (int i = 0; i < 4; i ++){
            board[i] = combineUpLeft(board[i]);
        }
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public void keyRight(){
        for (int i = 0; i < 4; i ++){
            board[i] = combineDownRight(board[i]);
        }
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public void keyUp(){
        transpose();
        for (int i = 0; i < 4; i ++){
            board[i] = combineUpLeft(board[i]);
        }
        transpose();
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public void keyDown(){
        transpose();
        for (int i = 0; i < 4; i ++){
            board[i] = combineDownRight(board[i]);
        }
        transpose();
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public void setFreeSpace(){
        ArrayList<FreeSpace> freeSpaces = new ArrayList<FreeSpace>();
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++)
                if (board[i][j] == 0) freeSpaces.add(new FreeSpace(i,j));
        }
        FreeSpace randomFreeSpace = freeSpaces.get(randomizer.nextInt(freeSpaces.size()));
        board[randomFreeSpace.getRow()][randomFreeSpace.getColumn()] = randomTile();
        System.out.println("Row : " +  randomFreeSpace.getRow());
        System.out.println("Col : " +  randomFreeSpace.getColumn());

    }

    private int randomTile(){
        if (randomizer.nextFloat() < 0.75){
            return 2;
        }else{
            return 4;
        }
    }

    public static void main(String[] args) {
        GameLogic test = new GameLogic();
//        Integer[] row = new Integer[4];
//        row[0] = 0; row[1] = 0; row[2] = 0; row[3] = 0;
//        // 4 2 2 2
//        System.out.println("Before");
//        for (int k : row){
//            System.out.print(k + " | ");
//        }
//        System.out.println();
//        test.combineUpLeft(row);
//        System.out.println();
//        test.combineDownRight(row);
//        System.out.println("up");
//        test.keyUp();
//        System.out.println("down");
//        test.keyDown();
//        System.out.println("left");
//        test.keyLeft();
//        System.out.println("right");
//        test.keyRight();
//
//        test.initBoard();
//        System.out.println("up");
//        test.keyUp();
//
//        test.initBoard();
//        System.out.println("down");
//        test.keyDown();
//
//        test.initBoard();
//        System.out.println("left");
//        test.keyLeft();
//
//        test.initBoard();
//        System.out.println("right");
//        test.keyRight();
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,2,0};
        System.out.println(Arrays.equals(a,b));
    }


}
