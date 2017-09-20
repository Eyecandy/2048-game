import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;


class GUI extends JFrame {
    private JPanel panel;
    private JMenuBar menuBar;
    private Integer row;
    private Integer column;
    private JLabel[][] grid;

    GUI(int row, int column) {
        this.row = row;
        this.column = column;

        panel = new JPanel();
        menuBar = new JMenuBar();
    }

    void start(KeyPress keyPress, GameBoard board){
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1000, 1000);
        panel.setLayout(new GridLayout(row, column));
        initGUI(board);

        menuBar.setPreferredSize(new Dimension(100, 15));

        JMenu jMenu = new JMenu();
        jMenu.setText("Game");
        jMenu.add(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                board.initBoard();
            }
        }).setText("New");
        jMenu.addSeparator();
        jMenu.add(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final JDialog frame = new JDialog();
                frame.setLayout(new BorderLayout());
                frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                frame.setBounds(200, 200, 200, 200);

                final String[] labels = {"Rows", "Columns"};
                final JTextField[] textFields = new JTextField[labels.length];

                JPanel modalPanel = new JPanel();
                modalPanel.setLayout(new GridLayout());
                for (int i = 0; i < labels.length; ++i) {
                    JLabel label = new JLabel(labels[i], JLabel.TRAILING);
                    modalPanel.add(label);
                    textFields[i] = new JTextField(10);
                    textFields[i].setSize(new Dimension(50, 50));
                    label.setLabelFor(textFields[i]);
                    modalPanel.add(textFields[i]);
                }
                frame.add(modalPanel, BorderLayout.NORTH);
                JButton button = new JButton("Apply");
                button.setSize(new Dimension(100, 100));
                button.setMaximumSize(new Dimension(50, 50));
                frame.add(new JLabel(), BorderLayout.SOUTH);
                frame.add(button, BorderLayout.SOUTH);

                button.addActionListener(actionEvent1 -> {
                    row = Integer.parseInt(textFields[0].getText());
                    column = Integer.parseInt(textFields[1].getText());
                    panel.setLayout(new GridLayout(row, column));
                    board.initBoard(row, column);
                    initGUI(board);
//                    repaint();
//                    revalidate();
//                    doLayout();
                });

                frame.pack();
                frame.setVisible(true);
            }
        }).setText("New Board Dimensions");
        jMenu.setSize(new Dimension(40, 45));
        menuBar.add(jMenu);
        this.setJMenuBar(menuBar);

        this.setVisible(true);
        addKeyListener(keyPress);
    }

    private void initGUI(GameBoard board) {
        for (Component component: panel.getComponents()) {
            if (component.getClass() == JLabel.class)
                panel.remove(component);
        }
        grid = new JLabel[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                Integer boardTile = board.getBoardTile(i,j);
                JLabel jLabel = new JLabel();
                jLabel.setHorizontalAlignment(0);
                if (boardTile != 0) jLabel.setText(boardTile.toString());
                else jLabel.setText("");
                jLabel.setFont(new Font("Arial", Font.BOLD, 24));
                jLabel.setBackground(pickColor(boardTile));
                grid[i][j] = jLabel;
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                grid[i][j].setOpaque(true);
                panel.add(grid[i][j]);
            }
        }
    }

    private Color pickColor(Integer boardTile){
        switch (boardTile){
            case 0:
                return new Color(205,193,180);
            case 2:
                return new Color(238,228,218);
            case 4:
                return new Color(237,224,200);
            case 8:
                return new Color(242,177,121);
            case 16:
                return new Color(245,149,99);
            case 32:
                return new Color(246,124,95);
            case 64:
                return new Color(246,94,59);
            case 128:
                return new Color(237,207,114);
            case 256:
                return new Color(237,204,99);
            case 512:
                return new Color(236,197,80);
            case 1024:
                return new Color(143, 205, 125);
            case 2048:
                return new Color(100, 205, 61);
            default:
                return new Color(205,193,180);
        }
    }

    void setGUI(GameBoard board) {
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
