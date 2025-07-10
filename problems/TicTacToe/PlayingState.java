package TicTacToe;

public class PlayingState extends BoardState{
    public PlayingState(Board board) {
        super(board);
    }

    @Override
    public void declareWinner(Player player) {
        board.changeState(new WonState(board, player));
    }

    @Override
    public void declareDraw() {
        board.changeState(new DrawState(board));
    }
}
