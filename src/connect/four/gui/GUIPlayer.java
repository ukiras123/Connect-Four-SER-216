/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect.four.gui;

import connect.four.board.ReadWritableBoard;
import connect.four.gui.*;
import connect.four.player.Player;


public class GUIPlayer implements Player {
	private String playerName;
	private GamePanel gpGUI;
	private ReadWritableBoard board;
	
	public GUIPlayer(String name, GamePanel gp){
		playerName = name;
		gpGUI = gp;
	}
	
	@Override public String getName(){
		return playerName;
	}
	
	@Override public void performPlay(ReadWritableBoard board) {
		this.board = board;		
		
	}
	
	public ReadWritableBoard getBoard(){
		return board;
	}
}
