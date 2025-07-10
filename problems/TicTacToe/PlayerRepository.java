package TicTacToe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlayerRepository {
    private Queue<Player> players = new LinkedList<>();
    private static final Integer MAX_PLAYERS = 2;

    public void addPlayer(Player player) {
        if(players.stream().anyMatch(x -> x.getSymbol().equals(player.getSymbol()))) {
            System.out.println("Choose another symbol for a Player: "+ player);
        }
        players.add(player);
    }

    public void addPlayers(List<Player> players) {
        if(players.size() > MAX_PLAYERS - players.size()) {
            System.out.println("Cannot add more than 2 players");
            return;
        }
        players.forEach(this::addPlayer);
    }

    public Player nextPlayer() {
        Player next = players.poll();
        players.add(next);
        return next;
    }
}
