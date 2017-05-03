/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect.four.gui;

import connect.four.board.Board;
import connect.four.board.ReadWritableBoard;
import connect.four.player.Player;


public class GUIWrapperPlayer implements Player {

	Player player;
	GamePanel gpGUI;
	ReadWritableBoard board;
	
	
	GUIWrapperPlayer(Player player, GamePanel gpGUI){
		this.player = player;
		this.gpGUI = gpGUI;
		
	}
	
	
	
	@Override
	public String getName() {
		return player.getName();
	}

	@Override
	public void performPlay(final ReadWritableBoard board) {
		
		this.board = board;
		final ReadWritableBoard wrapperBoard = new ReadWritableBoard() {
			
			
			public Player whoPlayed( int positionX, int positionY){
				
				return board.whoPlayed(positionX, positionY);
			}

			public int turnAt( int positionX, int positionY){
				
				return board.turnAt(positionX, positionY);
			}
			
			public GUIPiece pieceAt( int positionX, int positionY){
				
				return board.pieceAt(positionX, positionY);
			}
			
			@Override
			public void play(final int column, Player player) {
				
				
				java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
					gpGUI.calcWidth(column);
					gpGUI.turn();
				}
			});
				
				
			}
			
			public int getWidth(){
				return board.getWidth();
			}
			
			public int getHeight(){
				return board.getHeight();
			}

			@Override
			public int getColumnHeight(int height) {
				return board.getColumnHeight(height);
			}

			@Override
			public int getMoveCount() {
				return board.getMoveCount();
			}

			@Override
			public void clear() {
				board.clear(); 
			}
			
		};
		(new Thread() {
			public void run() {
				player.performPlay(wrapperBoard);
			}
		}).start();
		
	}
	
	public ReadWritableBoard getBoard(){
		return this.board;
	}
	
}
