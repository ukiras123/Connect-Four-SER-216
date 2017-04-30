
package connect.four;

import connect.four.board.ReadableBoard;
import connect.four.player.Player;
import java.util.List;

public interface ScoreChart {

    public static interface Listener {
	void gameOver(Player winner, ScoreChart scores, ReadableBoard end);
    }

    List<Player> getPlayers();
    int getScore(Player p);
    void registerListener(Listener l);
    void unregisterListener(Listener l);
	
}
