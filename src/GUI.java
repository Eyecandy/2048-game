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
    Integer row = 4;
    Integer col = 4;
    Integer board[][];
    JLabel[][] grid;



    public GUI() {
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        panel.setLayout(new GridLayout(4, 4));
        GameLogic gameLogic = new GameLogic();
        board = gameLogic.getBoard();
        initGUI();
        setVisible(true);
        KeyPress keyPress = new KeyPress(gameLogic,this);
        addKeyListener(keyPress);

    }

    public JLabel[][] initGUI() {
        grid = new JLabel[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                JLabel jLabel = new JLabel();
                jLabel.setText(board[i][j].toString());
                grid[i][j] = jLabel;
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                //grid[i][j].setBackground(Color.black);
                grid[i][j].setOpaque(true);
                panel.add(grid[i][j]);
            }
        }
        return grid;
    }

    public void setGUI() {
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                JLabel jLabel = grid[i][j];
                jLabel.setText(board[i][j].toString());
            }
        }
        repaint();
        revalidate();
        doLayout();

    }
    public static void main(String[] args) {
        GUI gui = new GUI();

    }


}
