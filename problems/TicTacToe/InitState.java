package TicTacToe;

public class InitState extends BoardState{
    public InitState(Board board) {
        super(board);
    }

    @Override
    public void startGame() {
        board.changeState(new PlayingState(board));
    }
}
