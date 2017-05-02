
package connect.four.player;

import connect.four.board.Board;
import connect.four.board.ReadableBoard;
import connect.four.board.ReadWritableBoard;
import connect.four.Game;
import java.util.Arrays;
import java.util.Random;


public class ComputerPlayer implements Player {
    int cpDepth;
    public ComputerPlayer() {
        cpDepth = 6;
    }
    public ComputerPlayer(int depth) {
        cpDepth = depth;
    }
    @Override public String getName() {
        return "Computer";
    }

    @Override public void performPlay(ReadWritableBoard board) {
        int width = board.getWidth();
        int height = board.getHeight();
        if (board.getMoveCount() == 0) {
            board.play((new Random()).nextInt(width), this);
        } else {
            Player opponent = getOpponent(board);
            int maxMove = (new Random()).nextInt(width);
            long maxScore = scoreMove(maxMove, cpDepth, board, opponent);
            long[] scores = new long[width];
            for (int i = 0; i != width; ++i) {
                if (board.whoPlayed(i, height-1) != null) {
                	continue;
                }
                long score = scoreMove(i, cpDepth, board, opponent);
                if (score > maxScore) {
                    maxMove = i;
                    maxScore = score;
                }
                scores[i] = score;
            }
	    while (board.whoPlayed(maxMove, height-1) != null) {
                maxMove = (maxMove+1)%width;
	    }
            System.out.println(Arrays.toString(scores));
            board.play(maxMove, this);
        }
    }

    private long scoreMove(int positionX, int depth, ReadableBoard board, Player opponent) {
        int height = board.getHeight();
        if (board.whoPlayed(positionX, height-1) != null) {
        	return 0;
        }
        Board myMove = new Board(board);
        myMove.play(positionX, this);
        int width = myMove.getWidth();
        long score = 0;
        if (Game.detectWinner(myMove, 4) == this) {
            score += Math.pow(width, depth);
        } else if (depth != 0) {
            for (int i = 0; i != width; ++i) {
                if (myMove.whoPlayed(i, height-1) != null) {
                	continue;
                }
                Board nextMove = new Board(myMove);
                nextMove.play(i, opponent);
                if (Game.detectWinner(nextMove, 4) == opponent) {
		    score -= Math.pow(width, depth-1);
		} else {
                    for (int j = 0; j != width; ++j) {
                        score += scoreMove(j, depth - 2, nextMove, opponent);
                    }
                }
            }
        }
        return score;
    }

    private Player getOpponent(ReadableBoard board) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i != width; ++i) {
            for (int j = 0; j != height; ++j) {
                Player here = board.whoPlayed(i, j);
                if (here != null && here != this) {
                    return here;
                }
            }
        }
        throw new Error("Can't call getOpponent on first turn.");
    }

}
