
package connect.four.player;

import connect.four.board.ReadWritableBoard;

public interface Player {
    String getName();
    void performPlay(ReadWritableBoard board);
}
