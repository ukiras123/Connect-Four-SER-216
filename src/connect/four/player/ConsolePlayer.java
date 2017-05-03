
package connect.four.player;

import connect.four.board.ReadableBoard;
import connect.four.board.ReadWritableBoard;
import connect.four.Game;
import connect.four.ScoreChart;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ConsolePlayer implements Player, ScoreChart.Listener {
	String playerName;

	public ConsolePlayer(String name) {
		if(name != null && !name.isEmpty()) {
			playerName = name;
		} else{
			throw new NullPointerException("Name cannot be empty or null."); 
		}
	}

	@Override
	public String getName() {
		return playerName;
	}

	public void setName(String newName) {
		if(newName != null && !newName.isEmpty()) {
			this.playerName = newName;
		} else{
			throw new NullPointerException("Name cannot be empty or null."); 
		}
	}

	@Override
	public void gameOver(Player winner, ScoreChart scores, ReadableBoard board) {
		dumpBoard(board);
		
		System.out.println("|------------------------|");
		System.out.println("  "+ playerName + (winner == this ? " won." : " lost."));
		
		System.out.println("  "+ playerName + ": " + scores.getScore(this));
		System.out.println("|------------------------|");
	}

	@Override
	public void performPlay(ReadWritableBoard board) {
		int width = board.getWidth();
		int height = board.getHeight();

		System.out.println("\n" + playerName + "'s turn!");
		dumpBoard(board);

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int userInput = 0;
		boolean invalid = true;
		while (invalid) {
			while (userInput < 1 || userInput > width) {
				try {
					System.out.print("Enter the column you want to play"
							+ " in (0 to exit) : ");
					userInput = Integer.parseInt(stdin.readLine());
					if (userInput == 0) {
						System.exit(0);
					}
				} catch (IOException e) {
					System.out.print("Something went wrong when reading"
							+ " your column. Please enter it again");
					continue;
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid integer "
							+ "between 0 and " + width + ".");
					continue;
				}
			}
			if (board.getColumnHeight(userInput - 1) == height) {
				invalid = true;
				System.out.println("Column is full, try again.");
				userInput = 0;
			} else {
				invalid = false;
			}

		}
		board.play(userInput - 1, this);
	}

	private void dumpBoard(ReadableBoard board) {
		int width = board.getWidth();
		int height = board.getHeight();

		System.out.println("@ is you, X is the other player, and * is empty.");
		for (int i = height - 1; i != -1; --i) {
			for (int j = 0; j != width; ++j) {
				Player played = board.whoPlayed(j, i);
				System.out.print(played == this ? " @ " 
						: played == null ? " * " : " X ");
			}
			System.out.println();
		}
		System.out.println("=====================");
		for (int i = 0; i != width; ++i) {
			int column = i+1;
			System.out.print(" "+column+" ");
		}
		System.out.println();
	}
}
