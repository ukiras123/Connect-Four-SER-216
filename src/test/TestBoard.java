package test;

import static org.junit.Assert.*;

import org.junit.Test;
import connect.four.board.Board;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;
public class TestBoard {

	@Test
	public void testBoardCopyConstructor() {
		
		/**
		*Initialize console players and determine @ or X coins.
		*/
		ConsolePlayer aT = new ConsolePlayer("@");
		ConsolePlayer X = new ConsolePlayer("X");
		
		/**
		*Set up the two board layouts
		*/
		Object[][] board1Layout = {{ null, null, null, null, null, null, null  },
						  { null, null, null, null, null, null, null  },
						  { null, null, null, null, null, null, null  }, 
						  { X, null, null, null, null, null, null  },
						  { aT, X, null, null, null, null, null  },
						  { aT, X, null, null, null, null, null  },
						  { aT, X, aT, aT, X, aT, null }};
		Board a = new Board(board1Layout.length, board1Layout[0].length);
		for(int i = 0; i < a.getWidth(); i++){
			for(int j = 0; j < a.getHeight();j++){
				a.play(i,(Player) board1Layout[i][j]);
			}
		
		}
				
		Object[][] board2Layout = {{ null, null, null, null, null, null, null  }, 
						  { null, null, null, null, null, null, null  }, 
						  { null, null, null, null, null, null, null  }, 
						  { null, null, null, null, null, null, null  }, 
						  { null, null, null, null, null, null, null  }, 
						  { null, null, null, null, null, null, null  }, 
						  { null, null, null, null, null, null, null  }};
		Board b = new Board(board2Layout.length, board2Layout[0].length);
		for(int i = 0; i < b.getWidth(); i++){
			for(int j = 0; j < b.getHeight();j++){
				b.play(i,(Player) board2Layout[i][j]);
			}
		
		}
		
		/**
		 * Create two boards to be copied with two board layouts:
		 */
		Board board1 = new Board(a);
		Board board2 = new Board(b);
		
		/**
		* try to create two copies of the boards
		*/
		Board board1copy = new Board(board1);
		Board board2copy = new Board(board2);
		
		/**
		 * See if board 1 copy has the same dimensions
		 */ 
		if(board1.getWidth() != board1copy.getWidth())
			fail("The copied baord is a different width!");
		if(board1.getHeight() != board1copy.getHeight())
			fail("The copied board is a different height!");
		//If copy of board 1 has the same dimensions, see if it has the same contents.
		for(int i = 0; i < board1.getWidth(); i++) {
			for(int j = 0; j < board1.getHeight(); j++) {
				assertEquals(board1.whoPlayed(i, j), board1copy.whoPlayed(i, j));
			}//end inner for loop	
		}//end outer for loop
		
		/**
		 * See if board 2 copy has the same dimensions
		 */ 
		if(board2.getWidth() != board2copy.getWidth())
			fail("The copied board has a differnt width.");
		if(board2.getHeight() != board2copy.getHeight())
			fail("The copied board has a differnt height.");
		//If copy of board 2 has the same dimensions, see if it has the same contents.
		for(int i = 0; i < board2.getWidth(); i++) {
			for(int j = 0; j < board2.getHeight(); j++) {
				assertEquals(board2.whoPlayed(i, j), board2copy.whoPlayed(i, j));
			}//end inner for loop	
		}//end outer for loop		
		
	}// end testBoardCopyConstructor

}