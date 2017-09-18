import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
    Integer[][] board;
    private Random randomizer = new Random();
    private GameLogic gameLogic = new GameLogic();


    public GameBoard(int row, int column){
        board = new Integer[row][column];
    }

    public Integer[][] getBoard() {
        return board;
    }

    public int getRowWidth(){
        return board.length;
    }

    public int getColumnWidth(){
        return board[0].length;
    }

    private int randomTile(){
        if (randomizer.nextFloat() < 0.75){
            return 2;
        }else{
            return 4;
        }
    }

    public void initBoard() {
        int startOne,startTwo;
        startOne = randomizer.nextInt(16);
        startTwo = randomizer.nextInt(16);
        while (startOne == startTwo){
            startTwo = randomizer.nextInt(16);
        }
        for (int i = 0;i < getRowWidth();i++) {
            for (int j = 0;j < getColumnWidth();j++) {
                board[i][j] = 0;
            }
        }
        board[startOne/getRowWidth()][startOne%getColumnWidth()] = randomTile();
        board[startTwo/getRowWidth()][startTwo%getColumnWidth()] = randomTile();
    }

    public void setFreeSpace(){
        ArrayList<FreeSpace> freeSpaces = new ArrayList<FreeSpace>();
        for (int i=0;i<getRowWidth();i++){
            for (int j=0;j<getColumnWidth();j++)
                if (board[i][j] == 0) freeSpaces.add(new FreeSpace(i,j));
        }
        FreeSpace randomFreeSpace = freeSpaces.get(randomizer.nextInt(freeSpaces.size()));
        board[randomFreeSpace.getRow()][randomFreeSpace.getColumn()] = randomTile();
    }

    public void setBoardRow(int row, Integer[] rowFill){
        board[row] = rowFill;
    }

    public Integer[] getBoardRow(int row){
        return board[row];
    }

    public Integer getBoardTile(int row, int column){
        return board[row][column];
    }

    public void transpose(){
        Integer[][] transposedBoard = new Integer[getColumnWidth()][getRowWidth()];
        for(int i = 0; i < getColumnWidth(); i++) {
            for(int j = 0; j < getRowWidth(); j++) {
                int temp = board[j][i];
                transposedBoard[i][j] = temp;
            }
        }
        board = transposedBoard;
    }

    public void printBoard(){
        for (int i=0;i < getRowWidth();i++){
            for (int j=0;j < getColumnWidth();j++){
                System.out.print(getBoardTile(i,j) + " | ");
            }
            System.out.println();
        }
    }

    public Integer[][] copyBoard(){
        int rowWidth = getRowWidth();
        int columnWidth = getColumnWidth();
        Integer[][] newArray = new Integer[rowWidth][columnWidth];
        for (int i = 0; i < rowWidth; i++){
            for (int j = 0; j < columnWidth; j++){
                newArray[i][j] = board[i][j];
            }
        }
        return newArray;
    }

    public void moveLeft(){
        gameLogic.keyLeft(this);
    }

    public void moveRight(){
        gameLogic.keyRight(this);
    }

    public void moveUp(){
        gameLogic.keyUp(this);
    }

    public void moveDown(){
        gameLogic.keyDown(this);
    }
}
