package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import connect.four.Game;
import connect.four.board.Board;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;

public class ConsolePlayerTest2 {

	Board testboard1;
	Board testboard2;
	Board testboard3;
	ConsolePlayer plyX;
	ConsolePlayer plyO;
	Game game;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}//end setUpAfterClass

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}//end tearDownAfterClass

	@Before
	public void setUp() throws Exception {
		
		plyX = new ConsolePlayer("X");						
		plyO = new ConsolePlayer("@");
		
		/**
        	* Case 1, 7x6 Null board.
        	*/
		Object[][] layout1 = {{ null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null },
					     { null, null, null, null, null, null }};
		Board a = new Board(layout1.length, layout1[0].length);
		for(int i = 0; i < a.getWidth(); i++){
			for(int j = 0; j < a.getHeight();j++){
				a.play(i,(Player) layout1[i][j]);
			}
		
		}
									
		/**
        	* Case 2
        	*/
		Object[][] layout2  ={{ null, null, null, null, null, null },
					     { null, null, null, null, null, null },
				 	     { null, null, null, null, null, null },
	            		 { null, null, null, null, null, null },
				 	     { null, plyO, null, null, null, null },
				 	     { null, plyX, null, null, null, plyO },
				 	     { plyO, plyX, null, null, null, plyX }};
		Board b = new Board(layout2.length, layout2[0].length);
		for(int i = 0; i < b.getWidth(); i++){
			for(int j = 0; j < b.getHeight();j++){
				b.play(i,(Player) layout2[i][j]);
			}
		
		}
		/**
        	* Case 3
        	*/
		Object[][] layout3 = {{ null, null, null, plyX, null, null },
					     { null, null, null, null, null, null },
				 	     { null, null, null, plyO, null, null },
				 	     { null, null, null, plyX, null, null },
				 	     { null, null, null, plyO, null, null },
				 	     { null, null, null, plyX, null, null },
				 	     { null, null, null, plyO, null, null }};
		Board c = new Board(layout3.length, layout3[0].length);
		for(int i = 0; i < c.getWidth(); i++){
			for(int j = 0; j < c.getHeight();j++){
				c.play(i,(Player) layout3[i][j]);
			}
		
		}
		
		testboard1 = new Board(a);
		game = new Game(new Player[] {plyX, plyO}, testboard1, 4);
		testboard2 = new Board(b);
		game = new Game(new Player[] {plyX, plyO}, testboard2, 4);
		testboard3 = new Board(c);
		game = new Game(new Player[] {plyX, plyO}, testboard3, 4);
		game.start();		
	}//end setUp

	@After
	public void tearDown() throws Exception {
	}//end tearDown


}
