package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connect.four.player.ConsolePlayer;

public class ConsolePlayerTest {

	private ConsolePlayer player;
	private String playerName;
	private String playerNameChange;

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

	@Test(expected = NullPointerException.class)
	public void testConstructorNegative() {
		System.out.println("Initiating ConsolePlayer constructor negative Test");
		player = new ConsolePlayer(null);
		player = new ConsolePlayer("");
	}

	@Test
	public void testConstructorPositive() {
		player = new ConsolePlayer(playerName);
		assertEquals(playerName, player.getName());
	}

	@Test(expected = NullPointerException.class)
	public void testSetGetNameNegative() {
		player.setName(null);
	}

	@Test
	public void testSetGetName() {
		player = new ConsolePlayer(playerName);
		player.setName("OK");
		assertEquals("OK", player.getName());
		player.setName(playerName);
		assertEquals(playerName, player.getName());
	}

}
