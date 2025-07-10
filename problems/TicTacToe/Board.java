package TicTacToe;

import java.util.Arrays;

public class Board {
    private Symbol[][] board;
    private int size;
    private PlayerRepository playerRepo;
    private BoardState boardState;

    public Board(int size, PlayerRepository playerRepo) {
        this.size = size;
        this.playerRepo = playerRepo;

        board = new Symbol[size][size];
        for(int i = 0; i < size; i++)
            Arrays.fill(board[i], Symbol.EMPTY);

        init();
    }

    public void init() {
        board = new Symbol[size][size];
        for(int i = 0; i < size; i++)
            Arrays.fill(board[i], Symbol.EMPTY);

        this.changeState(new InitState(this));
    }

    public void changeState(BoardState boardState) {
        this.boardState = boardState;
    }

    public void startGame() {
        System.out.println("Started Game");
        boardState.startGame();
    }

    public void playGame(int x, int y) {
        System.out.println("Play Game");
        if(x > size || y > size || y < 0 || x < 0 || board[x][y] != Symbol.EMPTY) {
            System.out.println("Please mention correct location");
            return;
        }
        Player player = playerRepo.nextPlayer();
        board[x][y] = player.getSymbol();
        int check = checkForWinner();
        if(check == 1) {
            boardState.declareWinner(player);
        } else if(check == 2) {
            boardState.declareDraw();
        }

    }

    public int checkForWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            // Check row
            if (board[i][0] != Symbol.EMPTY &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                return 1;
            }

            // Check column
            if (board[0][i] != Symbol.EMPTY &&
                    board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) {
                return 1;
            }
        }

        // Check diagonals
        if (board[0][0] != Symbol.EMPTY &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return 1;
        }

        if (board[0][2] != Symbol.EMPTY &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return 1;
        }

        // Check for draw (full board)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Symbol.EMPTY) {
                    return 0; // Game is not over
                }
            }
        }

        return 2; // Game is over (draw)
    }
}
