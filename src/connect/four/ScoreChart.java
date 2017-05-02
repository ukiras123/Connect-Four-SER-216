
package connect.four;

import connect.four.board.ReadableBoard;
import connect.four.player.Player;
import java.util.List;

public interface ScoreChart {

    public interface Listener {
    	void gameOver(Player winner, ScoreChart scores, ReadableBoard end);
    }

    List<Player> getPlayers();
    int getScore(Player player);
    void registerListener(Listener toRegister);
    void unregisterListener(Listener toUnregister);
	
}
