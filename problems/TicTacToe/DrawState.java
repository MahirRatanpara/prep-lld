package TicTacToe;

public class DrawState extends BoardState{
    public DrawState(Board board) {
        super(board);
    }

    @Override
    public void init() {
        board.init();
        board.changeState(new InitState(board));
    }
}
