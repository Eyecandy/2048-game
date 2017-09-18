import com.sun.source.doctree.AttributeTree;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by joakimnilfjord on 9/12/2017 AD.
 */
public class GUI extends JFrame {
    JPanel panel = new JPanel();
    Integer row;
    Integer column;
    JLabel[][] grid;

    public GUI(int row, int column) {
        this.row = row;
        this.column = column;

    }

    public void start(KeyPress keyPress, GameBoard board){
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 500, 500);
        panel.setLayout(new GridLayout(row, column));
        initGUI(board);
        this.setVisible(true);
        addKeyListener(keyPress);
    }

    public JLabel[][] initGUI(GameBoard board) {

        grid = new JLabel[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                Integer boardTile = board.getBoardTile(i,j);
                JLabel jLabel = new JLabel();
                jLabel.setHorizontalAlignment(0);
                if (boardTile != 0) jLabel.setText(boardTile.toString());
                else jLabel.setText("");
                jLabel.setBackground(pickColor(boardTile));
                grid[i][j] = jLabel;
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                grid[i][j].setOpaque(true);
                panel.add(grid[i][j]);
            }
        }
        return grid;
    }

    public Color pickColor(Integer boardTile){
        if (boardTile==0){
            return new Color(205,193,180);
        }else if (boardTile == 2){
            return new Color(238,228,218);
        }else if (boardTile == 4){
            return new Color(237,224,200);
        }else if (boardTile == 8){
            return new Color(242,177,121);
        }else if (boardTile == 16){
            return new Color(245,149,99);
        }else if (boardTile == 32){
            return new Color(246,124,95);
        }else if (boardTile == 64){
            return new Color(246,94,59);
        }else if (boardTile == 128){
            return new Color(237,207,114);
        }else if (boardTile == 256){
            return new Color(237,204,99);
        }else if (boardTile == 512){
            return new Color(236,197,80);
        }else if (boardTile == 1024){
            return new Color(143, 205, 125);
        }else if (boardTile == 2048){
            return new Color(100, 205, 61);
        }
        return new Color(205,193,180);
    }

    public void setGUI(GameBoard board) {
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                JLabel jLabel = grid[i][j];
                Integer boardTile = board.getBoardTile(i,j);
                jLabel.setBackground(pickColor(boardTile));
                if (board.getBoardTile(i,j) != 0) {
                    jLabel.setText(boardTile.toString());
                }else{
                    jLabel.setText("");
                }
            }
        }
        repaint();
        revalidate();
        doLayout();
    }


}
