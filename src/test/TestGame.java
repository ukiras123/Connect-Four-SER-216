package test;

import static org.junit.Assert.*;
import org.junit.Test;
import connect.four.Game;
import connect.four.board.*;
import connect.four.player.*;
import org.junit.Before;
import org.junit.Test;

public class TestGame {

	@Test
	public void testDetectWinner() {
		
		/**
		*Initialize variable for how many coins must be in a row to win a game.
		*/
		int inRow = 4;
		
		/**
		*Initialize the console players
		*/
		ConsolePlayer plyX = new ConsolePlayer("X");
		ConsolePlayer plyO = new ConsolePlayer("@");
		
		/**
		*Setup board layout 1 of the six board layouts.
		* Diagonal Wins plyO
		*/
		Object[][] board1Layout = {{ plyO, null, null, null, null, null }, 
						  { plyO, plyO, plyO, null, null, null }, 
						  { plyX, plyX, plyO, null, null, null }, 
						  { plyO, plyX, plyO, plyO, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		Board a = new Board(board1Layout.length, board1Layout[0].length);
		for(int i = 0; i < a.getWidth(); i++){
			for(int j = 0; j < a.getHeight();j++){
				a.play(i,(Player) board1Layout[i][j]);
			}
		
		}
		/**
		*Setup board layout 2.
		* Horizontal Wins plyO
		*/		
		Object[][] board2Layout = {{ plyO, null, null, null, null, null }, 
						  { plyO, plyX, plyO, null, null, null }, 
						  { plyO, plyX, plyX, null, null, null }, 
						  { plyO, plyX, plyO, plyX, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		Board b = new Board(board2Layout.length, board2Layout[0].length);
		for(int i = 0; i < b.getWidth(); i++){
			for(int j = 0; j < b.getHeight();j++){
				b.play(i,(Player) board2Layout[i][j]);
			}
		
		}
		/**
		*Setup board layout 3.
		* Diagonal Wins plyO
		*/
		Object[][] board3Layout = {{ plyX, plyX, plyX, plyO, null, null }, 
						  { plyX, plyX, plyO, null, null, null }, 
						  { plyX, plyO, plyO, null, null, null }, 
						  { plyO, plyX, plyO, plyO, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		Board c = new Board(board3Layout.length, board3Layout[0].length);
		for(int i = 0; i < c.getWidth(); i++){
			for(int j = 0; j < c.getHeight();j++){
				c.play(i,(Player) board3Layout[i][j]);
			}
		
		}
		/**
		*Setup board layout 4.
		* Vertical Wins plyX
		*/		
		Object[][] board4Layout = {{ plyX, plyX, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { plyX, plyO, plyO, plyO, null, null }, 
						  { plyX, plyX, plyX, plyX, null, null }, 
						  { plyO, plyO, null, null, null, null }, 
						  { plyO, null, null, null, null, null }};
		Board d = new Board(board4Layout.length, board4Layout[0].length);
		for(int i = 0; i < d.getWidth(); i++){
			for(int j = 0; j < d.getHeight();j++){
				d.play(i,(Player) board4Layout[i][j]);
			}
		
		}
		/**
		*Setup board layout 5.
		* No winner
		*/		
		Object[][] board5Layout = {{ plyX, plyX, null, null, null, null }, 
						  { plyX, plyX, plyX, null, null, null }, 
						  { plyO, plyX, plyO, plyX, null, null }, 
						  { plyX, plyO, null, null, null, null }, 
						  { plyX, plyO, plyX, plyO, plyO, plyX }, 
						  { plyO, plyO, plyX, null, null, null }, 
						  { plyO, plyX, plyO, plyO, plyO, plyX }};
		Board e = new Board(board5Layout.length, board5Layout[0].length);
		for(int i = 0; i < e.getWidth(); i++){
			for(int j = 0; j < e.getHeight();j++){
				e.play(i,(Player) board5Layout[i][j]);
			}
		
		}
		/**
		*Setup board layout 6.
		* No winner
		*/		
		Object[][] board6Layout = {{ null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }, 
						  { null, null, null, null, null, null }};
		Board f = new Board(board6Layout.length, board6Layout[0].length);
		for(int i = 0; i < f.getWidth(); i++){
			for(int j = 0; j < f.getHeight();j++){
				f.play(i,(Player) board6Layout[i][j]);
			}
		
		}

		Board board1 = new Board(a);
		Board board2 = new Board(b);
		Board board3 = new Board(c);
		Board board4 = new Board(d);
		Board board5 = new Board(e);
		Board board6 = new Board(f);
		
		/**
		*Test layouts with the winners
		*/
		assertEquals(plyO, Game.detectWinner(board1, inRow));
		assertEquals(plyO, Game.detectWinner(board2, inRow));
		assertEquals(plyO, Game.detectWinner(board3, inRow));
		assertEquals(plyX, Game.detectWinner(board4, inRow));
		
		/**
		*Test layouts with no winners
		*/		
		assertNull(Game.detectWinner(board5, inRow));
		assertNull(Game.detectWinner(board6, inRow));
	}//end testDetectWinners

}