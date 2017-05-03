
package connect.four.board;

import connect.four.gui.GUIPiece;
import connect.four.player.Player;

public interface ReadableBoard {
    Player whoPlayed(int positionX, int positionY);
    int getWidth();
    int getHeight();
    int getColumnHeight(int column);
    int getMoveCount();
	int turnAt(int positionX, int positionY);
	GUIPiece pieceAt(int positionX, int positionY);

}
