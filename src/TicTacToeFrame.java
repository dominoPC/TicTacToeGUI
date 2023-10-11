import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
    JPanel mainPnl;
    TicTacToe game;
    GridLayout gridLayout;
    TicTacToeButton[] board;
    String turn = "X";
    int turnCount = 1;
    ActionListener al;
    public TicTacToeFrame(){
        gridLayout = new GridLayout(3,3);
        mainPnl = new JPanel(gridLayout);
        game = new TicTacToe();
        board = new TicTacToeButton[]{new TicTacToeButton(0, 0), new TicTacToeButton(0, 1),
                new TicTacToeButton(0, 2), new TicTacToeButton(1, 0),
                new TicTacToeButton(1, 1), new TicTacToeButton(1, 2),
                new TicTacToeButton(2, 0), new TicTacToeButton(2, 1),
                new TicTacToeButton(2, 2)
        };
        mainPnl.add(board[0]);
        mainPnl.add(board[1]);
        mainPnl.add(board[2]);
        mainPnl.add(board[3]);
        mainPnl.add(board[4]);
        mainPnl.add(board[5]);
        mainPnl.add(board[6]);
        mainPnl.add(board[7]);
        mainPnl.add(board[8]);
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToeButton source = (TicTacToeButton) e.getSource();
                if(game.isValidMove(source.getRow(), source.getCol())){
                    turnCount++;
                    boolean gameOver = false;
                    source.setState(turn);
                    game.play(turn, source.getRow(), source.getCol());
                    if(turnCount >= 5 && game.isWin(turn)){
                        int answer = JOptionPane.showConfirmDialog(new JFrame(),turn + " wins! Play again?",
                                "Game Over", JOptionPane.YES_NO_OPTION);
                        if(answer == JOptionPane.YES_OPTION){
                            gameOver = true;
                        }
                        else{
                            System.exit(0);
                        }
                    }
                    if(turnCount >= 7 && game.isTie()){
                        int answer = JOptionPane.showConfirmDialog(new JFrame(),"Tie game. Play again?",
                                "Game Over", JOptionPane.YES_NO_OPTION);
                        if(answer == JOptionPane.YES_OPTION){
                            gameOver = true;
                        }
                        else{
                            System.exit(0);
                        }
                    }
                    if(turn.equals("X")){
                        turn = "O";
                    }
                    else{
                        turn = "X";
                    }
                    if(gameOver){
                        newGame();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),"That square is occupied","Invalid Move",JOptionPane.PLAIN_MESSAGE);
                }

            }
        };
        board[0].addActionListener(al);
        board[1].addActionListener(al);
        board[2].addActionListener(al);
        board[3].addActionListener(al);
        board[4].addActionListener(al);
        board[5].addActionListener(al);
        board[6].addActionListener(al);
        board[7].addActionListener(al);
        board[8].addActionListener(al);


        add(mainPnl);

        setTitle("Tic-Tac-Toe");


        setSize(350,350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void newGame(){
        turnCount = 1;
        game.clearBoard();
        turn = "X";
        for (TicTacToeButton b: board) {
            b.setState("blank");
        }
    }
}
