package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import connect.four.board.Board;
import connect.four.board.ColumnFullException;
import connect.four.board.ReadableBoard;
import connect.four.gui.GUIPiece;
import connect.four.player.ComputerPlayer;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;

public class BoardTest {

	private static Board board;
	private static ConsolePlayer console;
	private static ComputerPlayer computer;

	/**
	 * Creates a new board
	 */
	@Before
	public void initializeTest() {
		board = new Board(new ReadableBoard() {
			@Override
			public Player whoPlayed(int x, int y) {
				return null;
			}

			@Override
			public int getWidth() {
				return 7;
			}

			@Override
			public int getHeight() {
				return 6;
			}

			@Override
			public int getColumnHeight(int x) {
				return 0;
			}

			@Override
			public int getMoveCount() {
				return 0;
			}

			public int turnAt(int positionX, int positionY) {
				// TODO Auto-generated method stub
				return 0;
			}

			public GUIPiece pieceAt(int positionX, int positionY) {
				// TODO Auto-generated method stub
				return null;
			}
		});

		/**
		 * Creates two players to fill the board
		 */
		console = createConsolePlayer();
		computer = createComputerPlayer();
	}

	@Test
	public void testPlay() {
		/**
		 * Case 1, x=0
		 */
		board.play(0, console);
		Assert.assertEquals("The first slot in column 1 must be filled.", console, board.whoPlayed(0, 0));
		Assert.assertEquals("The board should only register 1 move.", 1, board.getMoveCount());

		/**
		 * Case 2, x=1
		 */
		board.clear();
		board.play(0, console);
		board.play(1, computer);
		board.play(1, computer);
		board.play(2, console);
		board.play(5, computer);
		board.play(5, console);
		board.play(1, console);
		Assert.assertEquals("Changing play must be filled", console, board.whoPlayed(1, 2));
		Assert.assertEquals("Only 7 moves should be registered to the board", 7, board.getMoveCount());
	}

	/**
	 * Case 3, testFailedPlay
	 */
	@Test(expected = ColumnFullException.class)
	public void testFailedPlay() {
		/**
		 * Case 3, x=3
		 */
		board.play(3, console);
		board.play(3, computer);
		board.play(3, console);
		board.play(3, computer);
		board.play(3, console);
		board.play(3, computer);
		board.play(3, console);
	}

	@Test
	public void testGetColumnHeight() {
		/**
		 * Case 0, x=0
		 */
		board.play(0, computer);
		board.play(1, console);
		board.play(1, console);
		board.play(1, console);
		board.play(2, computer);
		board.play(2, console);
		Assert.assertEquals("Height of column 0 should be 1", 1, board.getColumnHeight(0));

		/**
		 * Case 1, x=1
		 */
		board.clear();
		board.play(0, computer);
		board.play(1, console);
		board.play(1, console);
		board.play(1, console);
		board.play(2, computer);
		board.play(2, console);
		Assert.assertEquals("Height of column 1 should be 3", 3, board.getColumnHeight(1));

		/**
		 * Case 2, x=2
		 */
		board.clear();
		board.play(0, computer);
		board.play(1, console);
		board.play(1, console);
		board.play(1, console);
		board.play(2, computer);
		board.play(2, console);
		Assert.assertEquals("Height of column 2 should be 2", 2, board.getColumnHeight(2));

		/**
		 * Case 3, x=3
		 */
		board.clear();
		board.play(0, computer);
		board.play(1, console);
		board.play(1, console);
		board.play(1, console);
		board.play(2, computer);
		board.play(2, console);
		Assert.assertEquals("Height of column 3 should be 0", 0, board.getColumnHeight(3));

		/**
		 * Case 4, x=4
		 */
		board.clear();
		board.play(0, computer);
		board.play(1, console);
		board.play(1, console);
		board.play(1, console);
		board.play(4, computer);
		board.play(4, console);
		Assert.assertEquals("Height of column 4 should be 2", 2, board.getColumnHeight(4));

		/**
		 * Case 5, x=5
		 */
		board.clear();
		Assert.assertEquals("Height of column 5 should be 0", 0, board.getColumnHeight(5));

		/**
		 * Case 6, x=6
		 */
		board.clear();
		board.play(0, computer);
		board.play(1, console);
		board.play(1, computer);
		board.play(3, computer);
		board.play(3, computer);
		board.play(3, computer);
		board.play(3, console);
		board.play(3, computer);
		board.play(3, console);
		board.play(5, console);
		board.play(6, console);
		board.play(6, computer);
		Assert.assertEquals("Height of column 6 should be 2", 2, board.getColumnHeight(6));
	}

	@Test
	public void testClear() {
		/**
		 * Case 1
		 */
		board.play(0, console);
		board.clear();
		Assert.assertEquals("Must be an empty board.", 0, board.getMoveCount());

		/**
		 * Case 2
		 */
		console = createConsolePlayer();
		board.play(0, computer);
		board.play(1, console);
		board.play(1, computer);
		board.play(4, console);
		board.play(4, computer);
		board.play(6, console);
		board.play(5, computer);
		board.play(6, console);
		board.play(4, console);
		board.play(2, computer);
		board.play(1, console);
		board.clear();
		Assert.assertEquals("Must be an empty board.", 0, board.getMoveCount());

		/**
		 * Case 3
		 */
		console = createConsolePlayer();
		computer = createComputerPlayer();
		board.clear();
		Assert.assertEquals("Must be an empty board.", 0, board.getMoveCount());
	}

	private ConsolePlayer createConsolePlayer() {
		return new ConsolePlayer("HumanPlayer");
	}

	private ComputerPlayer createComputerPlayer() {
		return new ComputerPlayer();
	}

}
