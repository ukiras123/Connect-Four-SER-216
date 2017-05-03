
package connect.four.board;

import connect.four.player.Player;
import java.util.Arrays;

public class Board implements ReadWritableBoard {
	Player[][] boardContents;
	int boardmoveCount;

	public Board(int width, int height) {
		boardContents = new Player[width][height];
		boardmoveCount = 0;
	}

	public Board(ReadableBoard copy) {
		if (copy instanceof Board) {
			Board copyB = (Board) copy;
			boardmoveCount = copyB.boardmoveCount;
			int width = copyB.boardContents.length;
			int height = copyB.boardContents[0].length;
			boardContents = new Player[width][height];
			for (int i = 0; i != width; ++i) {
				boardContents[i] = Arrays.copyOf(copyB.boardContents[i], height);
			}
		} else {
			int width = copy.getWidth();
			int height = copy.getHeight();
			boardContents = new Player[width][height];
			boardmoveCount = copy.getMoveCount();
			for (int i = 0; i != width; ++i) {
				for (int j = 0; j != height; ++j) {
					boardContents[i][j] = copy.whoPlayed(i, j);
				}
			}
		}
	}
	
	// Constructor for testing purpose
    public Board(Player[][] layout) {
    	boardContents = new Player[layout.length][layout[0].length];
        
        for(int i = 0; i < layout.length; i++){
        	for(int j = 0; j < layout[i].length; j++){
        		boardContents[i][j] = layout[i][j];
        	}
        }        
        boardmoveCount = 0;
    }

	public @Override Player whoPlayed(int positionX, int positionY) {
		return boardContents[positionX][positionY];
	}

	public @Override int getWidth() {
		return boardContents.length;
	}

	public @Override int getHeight() {
		return boardContents[0].length;
	}

	public @Override void play(int column, Player player) {
		int height = getColumnHeight(column);
		if (height == boardContents[column].length) {
			throw new ColumnFullException();
		}
		boardContents[column][height] = player;
		boardmoveCount += 1;
	}

	public @Override int getColumnHeight(int column) {
		int height = 0;
		int length = boardContents[0].length;
		while (height != length && boardContents[column][height] != null) {
			height += 1;
		}
		return height;
	}

	public @Override void clear() {
		int width = boardContents.length;
		int height = boardContents[0].length;
		for (int i = 0; i != width; ++i) {
			boardContents[i] = new Player[height];
		}
		boardmoveCount = 0;
	}

	public @Override int getMoveCount() {
		return boardmoveCount;
	}
}
