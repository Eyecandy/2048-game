

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by joakimnilfjord on 9/12/2017 AD.
 */
public class GUI extends JFrame {

    private JPanel panel = new JPanel();
    private Integer row = 4;
    private Integer col = 4;
    private JLabel[][] grid;

    public GUI() {
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        panel.setLayout(new GridLayout(4, 4));
        setVisible(true);
    }

    public void initGUI(Integer[][] board) {
        grid = new JLabel[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                JLabel jLabel = new JLabel();
                jLabel.setHorizontalAlignment(0);
                if (board[i][j] != 0) jLabel.setText(board[i][j].toString());
                else jLabel.setText("");
                jLabel.setFont(new Font("Arial", Font.BOLD, 30));
                grid[i][j] = jLabel;
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                grid[i][j].setOpaque(true);
                panel.add(grid[i][j]);
            }
        }
        doLayout();
        revalidate();
        repaint();
    }

    public void setGUI(Integer[][] board) {
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                JLabel jLabel = grid[i][j];
                if (board[i][j] != 0) {
                    jLabel.setText(board[i][j].toString());
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
