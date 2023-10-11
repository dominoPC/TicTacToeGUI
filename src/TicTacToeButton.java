import javax.swing.*;

public class TicTacToeButton extends JButton {
    private int row;
    private int col;
    private String state = " ";
    private ImageIcon blank = new ImageIcon(".\\src\\blank.png");
    private ImageIcon x = new ImageIcon(".\\src\\X.png");
    private ImageIcon o = new ImageIcon(".\\src\\O.png");
    public TicTacToeButton(int row, int col){
        this.row = row;
        this.col = col;
        setIcon(blank);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public void setState(String state){
        this.state = state;
        if(this.state.equals("X")){
            setIcon(x);
        }
        if(this.state.equals("O")){
            setIcon(o);
        }
        if(this.state.equals("blank")){
            setIcon(blank);
        }
    }
}