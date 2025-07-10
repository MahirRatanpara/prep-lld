package TicTacToe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardState {
    public Board board;

    public void init() {
        System.out.println("Not in a stage where we can init a game");
    }

    public void startGame() {
        System.out.println("Not in a stage where we can state game");
    }

    public void declareWinner(Player player) {
        System.out.println("Not in a stage where we can declare winner");
    }

    public void declareDraw() {
        System.out.println("Not in a stage where we can declare winner");
    }
}
