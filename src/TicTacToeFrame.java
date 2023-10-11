import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    JPanel mainPnl;
    ImageIcon blank;
    ImageIcon x;
    ImageIcon o;
    TicTacToe game;
    GridLayout gridLayout;
    public TicTacToeFrame(){
        gridLayout = new GridLayout(3,3);
        mainPnl = new JPanel(gridLayout);
        game = new TicTacToe();




        add(mainPnl);

        setTitle("Tic-Tac-Toe");


        setSize(350,350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
