
package connect.four.board;

import connect.four.player.Player;


public interface WritableBoard {
    void play(int x, Player p);
    void clear();
}
