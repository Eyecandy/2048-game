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

    public GUI(int row, int column, KeyPress keyPress, GameBoard board) {
        this.row = row;
        this.column = column;
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
                grid[i][j] = jLabel;
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                grid[i][j].setOpaque(true);
                panel.add(grid[i][j]);
            }
        }
        return grid;
    }

    public void setGUI(GameBoard board) {
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                JLabel jLabel = grid[i][j];
                Integer boardTile = board.getBoardTile(i,j);
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
