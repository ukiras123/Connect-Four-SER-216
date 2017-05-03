package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connect.four.board.Board;
import connect.four.board.ReadableBoard;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;

public class TestConsolePlayer {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void testDumpBoard() {

		ConsolePlayer player1 = new ConsolePlayer("Player1 (@)");
		ConsolePlayer player2 = new ConsolePlayer("Player2 (X)");
		Method dumpBoard = null;
		/**
		 * Setup board layout 1
		 */
		Object[][] board1Layout = { { null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null } };
		Board a = new Board(board1Layout.length, board1Layout[0].length);
		for (int i = 0; i < a.getWidth(); i++) {
			for (int j = 0; j < a.getHeight(); j++) {
				a.play(i, (Player) board1Layout[i][j]);
			}

		}
		/**
		 * Setup board layout 2
		 */
		Object[][] board2Layout = { { player1, null, null, null, null, null },
				{ player2, player2, player1, null, null, null }, { player1, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ player2, player1, null, null, null, null }, { null, null, null, null, null, null } };
		Board b = new Board(board2Layout.length, board2Layout[0].length);
		for (int i = 0; i < b.getWidth(); i++) {
			for (int j = 0; j < b.getHeight(); j++) {
				b.play(i, (Player) board2Layout[i][j]);
			}

		}
		/**
		 * Setup board layout 3
		 */
		Object[][] board3Layout = { { null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { player1, player2, player1, player2, player1, player2 },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null } };
		Board c = new Board(board3Layout.length, board3Layout[0].length);
		for (int i = 0; i < c.getWidth(); i++) {
			for (int j = 0; j < c.getHeight(); j++) {
				c.play(i, (Player) board3Layout[i][j]);
			}

		}

		/**
		 * Create the two board layouts
		 */
		Board board1 = new Board(a);
		Board board2 = new Board(b);

		/**
		 * Grab dumpBoard function from ConsolePlayer so it can be tested.
		 */
		try {
			dumpBoard = ConsolePlayer.class.getDeclaredMethod("dumpBoard", new Class[] { ReadableBoard.class });
		}

		catch (NoSuchMethodException e) {
			fail("No such method exception thrown.");
		}

		catch (Exception e) {
			fail("ERROR");
		}

		/**
		 * Make dumpBoard accessible
		 */
		dumpBoard.setAccessible(true);

		try {
			// Test 1
			dumpBoard.invoke(player1, new Object[] { board1 });
			outContent.reset();
			// Test 2
			dumpBoard.invoke(player1, new Object[] { board2 });
			outContent.reset();
		} catch (Exception e) {
			fail("ERROR");
		}
	}

}