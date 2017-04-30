/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect.four.gui;

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
	
	
	
	public String getName() {
		return player.getName();
	}

	public void performPlay(final ReadWritableBoard board) {
		
		this.board = board;
		final ReadWritableBoard wrapperBoard = new ReadWritableBoard() {
			
			
			public Player whoPlayed( int x, int y){
				
				return board.whoPlayed(x, y);
			}
			
			public void play(final int x, Player p) {
				
				
				java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
					gpGUI.calcWidth(x);
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

			public int getColumnHeight(int x) {
				return board.getColumnHeight(x);
			}

			public int getMoveCount() {
				return board.getMoveCount();
			}

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
