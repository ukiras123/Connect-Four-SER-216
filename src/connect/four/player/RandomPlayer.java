
package connect.four.player;

import connect.four.board.ReadWritableBoard;
import java.util.Random;


public class RandomPlayer implements Player {
    @Override
    public String getName() {
        return "Computer";
    }
    @Override
    public void performPlay(ReadWritableBoard board) {
    	int width = board.getWidth();
		int height = board.getHeight();
		Random rand = new Random();
        int randomInt = rand.nextInt(width);
        
        if (board.whoPlayed(randomInt, height-1) != null) {
        	int chosenX = (randomInt + 1) % width;
	    
        	while (board.whoPlayed(chosenX, height-1) != null && chosenX != randomInt) {
		    		chosenX = (randomInt + 1) % width;
        	}
        	randomInt = chosenX;
        }
        
        board.play(randomInt, this);
    }
}
