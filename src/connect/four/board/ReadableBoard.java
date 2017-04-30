
package connect.four.board;

import connect.four.player.Player;

public interface ReadableBoard {
    Player whoPlayed(int x, int y);
    int getWidth();
    int getHeight();
    int getColumnHeight(int x);
    int getMoveCount();
}
