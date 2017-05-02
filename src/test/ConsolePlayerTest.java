package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connect.four.board.ReadWritableBoard;
import connect.four.board.ReadableBoard;
import connect.four.player.ConsolePlayer;

public class ConsolePlayerTest {

	private ConsolePlayer player;
	private String playerName;
	private String playerNameChange;
	private ReadableBoard board;
	private ReadWritableBoard board2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		playerName = "Test Player";
		playerNameChange = "Some Change";
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		System.out.println("Initiating ConsolePlayer constructor Test");
		try{
			player = new ConsolePlayer(null);
		}catch(NullPointerException e){

			System.out.println("Console Player Constructor catched Null String");
			System.out.println(e.toString());
		}
		
		try{
			player = new ConsolePlayer("");
		}catch(NullPointerException e){

			System.out.println("Console Player Constructor catched Empty String");
			System.out.println(e.toString());
		}
		
		try{
			player = new ConsolePlayer(playerName);
		}catch(Exception e){

			fail("The constructor failed for unknown reason.");
		}
		
		System.out.println("Console Player Constructor Test Passed.");
		
		
		
	}
	
	@Test
	public void testSetGetName() {
		assertEquals(playerName, player.getName());
		
		try{
			player.setName(null);
		}catch(NullPointerException e){

			System.out.println("ConsolePlayer setName() catched Null String");
			System.out.println(e.toString());
		}
		
		try{
			player.setName("");
		}catch(NullPointerException e){

			System.out.println("ConsolePlayer setName() catched Null String");
			System.out.println(e.toString());
		}
		
		player.setName(playerNameChange);
		assertEquals(playerNameChange, player.getName());
		
		player.setName(playerName);
		assertEquals(playerName, player.getName());		
		
	}
	

}
