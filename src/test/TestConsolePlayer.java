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
		 * String representation 1 of expected output
		 */
		String expectedOutput1 = "@ is you, X is the other player, and O is empty." + System.lineSeparator() + "OOOOOOO"
				+ System.lineSeparator() + "OOOOOOO" + System.lineSeparator() + "OOOOOOO" + System.lineSeparator()
				+ "OOOOOOO" + System.lineSeparator() + "OOOOOOO" + System.lineSeparator() + "OOOOOOO"
				+ System.lineSeparator() + "1234567" + System.lineSeparator();
		/**
		 * String representation 2 of expected output
		 */
		String expectedOutput2 = "@ is you, X is the other player, and O is empty." + System.lineSeparator() + "OOOOOOO"
				+ System.lineSeparator() + "OOOOOOO" + System.lineSeparator() + "OOOOOOO" + System.lineSeparator()
				+ "O@OOOOO" + System.lineSeparator() + "OXOOO@O" + System.lineSeparator() + "@X@OOXO"
				+ System.lineSeparator() + "1234567" + System.lineSeparator();
		/**
		 * String representation 3 of expected output
		 */
		String expectedOutput3 = "@ is you, X is the other player, and O is empty." + System.lineSeparator() + "OOOXOOO"
				+ System.lineSeparator() + "OOO@OOO" + System.lineSeparator() + "OOOXOOO" + System.lineSeparator()
				+ "OOO@OOO" + System.lineSeparator() + "OOOXOOO" + System.lineSeparator() + "OOO@OOO"
				+ System.lineSeparator() + "1234567" + System.lineSeparator();
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
			assertEquals(expectedOutput1, outContent.toString());
			outContent.reset();

			// Test 2
			dumpBoard.invoke(player1, new Object[] { board2 });
			assertEquals(expectedOutput2, outContent.toString());
			outContent.reset();

			// Test 3
			dumpBoard.invoke(player1);
			assertEquals(expectedOutput3, outContent.toString());
			outContent.reset();
		}

		catch (Exception e) {
			fail("ERROR");
		}
	}

}