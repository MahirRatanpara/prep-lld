package TicTacToe;

public class WonState extends BoardState{
    Player winner;

    public WonState(Board board, Player winner) {
        super(board);
        this.winner = winner;
    }
    @Override
    public void init() {
        board.init();
        board.changeState(new InitState(board));
    }
}
