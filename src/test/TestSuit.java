package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoardTest.class, ConsolePlayerTest.class, ConsolePlayerTest2.class, TestBoard.class,
		TestConsolePlayer.class, TestGame.class })

public class TestSuit {
}