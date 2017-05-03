
package connect.four.board;

import connect.four.gui.GUIPiece;
import connect.four.player.Player;


public interface WritableBoard {
    void clear();
	void play(int column, Player player);
}
