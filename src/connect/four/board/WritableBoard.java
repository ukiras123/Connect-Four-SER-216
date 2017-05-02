
package connect.four.board;

import connect.four.player.Player;


public interface WritableBoard {
    void play(int column, Player player);
    void clear();
}
