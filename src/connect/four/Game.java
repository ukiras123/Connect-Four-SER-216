
package connect.four;

import connect.four.player.Player;
import connect.four.board.ReadableBoard;
import connect.four.board.ReadWritableBoard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Game implements ScoreChart {
    Player[] gamePlayers;
    int[] playerScores;
    List<ScoreChart.Listener> listenersList;
    ReadWritableBoard gameBoard;
    int gameInRow;
    int gameCurrentPlayer;
    
    public Game(Player[] players, ReadWritableBoard board, int inRow) {
        gamePlayers = Arrays.copyOf(players, players.length);
        playerScores = new int[players.length];
        listenersList = new ArrayList<ScoreChart.Listener>();
        gameBoard = board;
        gameInRow = inRow;
    }
    public void start() {
        int first = (new Random()).nextInt(gamePlayers.length);
        performPlay(first);
    }
    @Override public void registerListener(ScoreChart.Listener toRegister) {
        listenersList.add(toRegister);
    }
    @Override public void unregisterListener(ScoreChart.Listener toUnregister) {
        listenersList.remove(toUnregister);
    }
    @Override public List<Player> getPlayers() {
        return Arrays.asList(gamePlayers);
    }
    @Override public int getScore(Player player) {
        int pos = -1;
        int lenght = gamePlayers.length;
        for (int i = 0; i != lenght; ++i) {
            if (gamePlayers[i] == player) {
            	pos = i;
            }
        }
        return playerScores[pos];
    }
    void performPlay(final int player) {
        gameCurrentPlayer = player;
        ReadWritableBoard controlledBoard = new ReadWritableBoard() {
            boolean played;
            
            @Override 
            public Player whoPlayed(int positionX, int positionY) {
                return gameBoard.whoPlayed(positionX, positionY);
            }
            
            @Override 
            public void play(int positionX, Player playerPlay) {
                if (played) {
                    throw new Error(playerPlay+" Played more than once in a turn.");
                }
                played = true;
                gameBoard.play(positionX, playerPlay);
                Player win = detectWinner(gameBoard, gameInRow);
                if (win != null) {
                    playerScores[player] += 1;
                    for (ScoreChart.Listener l : listenersList) {
                        l.gameOver(win, Game.this, gameBoard);
                    }
                    gameBoard.clear();
                    performPlay(player);
                } else if (gameBoard.getMoveCount() 
                		== gameBoard.getWidth()*gameBoard.getHeight() ) {
                    for (ScoreChart.Listener l : listenersList) {
                        l.gameOver(null, Game.this, gameBoard);
                    }
                    gameBoard.clear();
                    performPlay((player+1) % gamePlayers.length);
                } else {
                    performPlay((player+1) % gamePlayers.length);
                }
            }
            @Override public void clear() {
                gameBoard.clear();
            }
            @Override public int getWidth() {
                return gameBoard.getWidth();
            }
            @Override public int getHeight() {
                return gameBoard.getHeight();
            }
            @Override public int getColumnHeight(int column) {
            	return gameBoard.getColumnHeight(column);
            }
            @Override public int getMoveCount() {
            	return gameBoard.getMoveCount();
            }
        };
        gamePlayers[player].performPlay(controlledBoard);
    }
    
    public Player getCurrentPlayer(){
            return gamePlayers[gameCurrentPlayer];
    }

    public int getInRow() {
	return gameInRow;
    }

    public ReadableBoard getBoard() {
	return gameBoard;
    }

    public static Player detectWinner(ReadableBoard board, int inRow) {
        int width = board.getWidth();
        int height = board.getHeight();
        for (int i = 0; i != width; ++i) {
            Player possible = null;
            int found = 0;
            for (int j = 0; j != height; ++j) {
                if (board.whoPlayed(i, j) == possible && possible != null) {
                    found += 1;
                } else {
                    found = 1;
                    possible = board.whoPlayed(i, j);
                }
                if (found == inRow) {
                    return possible;
                }
            }
        }
        for (int i = 0; i != height; ++i) {
            Player possible = null;
            int found = 0;
            for (int j = 0; j != width; ++j) {
                if (board.whoPlayed(j, i) == possible && possible != null) {
                    found += 1;
                } else {
                    found = 1;
                    possible = board.whoPlayed(j, i);
                }
                if (found == inRow) {
                    return possible;
                }
            }
        }
	for (int i = -width; i != width; ++i) {
            Player possible = null;
            int found = 0;
	    for (int j = 0; j != height; ++j) {
		int sum = j+i;
		if (sum >= 0 && sum < width) {
                    if (board.whoPlayed(sum, j) == possible && possible != null) {
                        found += 1;
                    } else {
                        found = 1;
                        possible = board.whoPlayed(sum, j);
                    }
                    if (found == inRow) {
                        return possible;
                    }
		}
	    }
	}
	for (int i = -width; i != width; ++i) {
            Player possible = null;
            int found = 0;
	    for (int j = 0; j != height; ++j) {
		int sum = j+i;
		if (sum >= 0 && sum < width) {
                    if (board.whoPlayed(width-sum-1, j) == possible && possible != null) {
                        found += 1;
                    } else {
                        found = 1;
                        possible = board.whoPlayed(width-sum-1, j);
                    }
                    if (found == inRow) {
                        return possible;
                    }
		}
	    }
	}
        return null;
    }
}
