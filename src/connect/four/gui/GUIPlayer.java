/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect.four.gui;

import connect.four.board.ReadWritableBoard;
import connect.four.player.Player;


public class GUIPlayer implements Player {
	private String m_name;
	GamePanel gpGUI;
	ReadWritableBoard board;
	
	public GUIPlayer(String name, GamePanel gp){
		m_name = name;
		gpGUI = gp;
	}
	
	@Override public String getName(){
		return m_name;
	}
	
	@Override public void performPlay(ReadWritableBoard board) {
		this.board = board;
		
		
	}
	
	public ReadWritableBoard getBoard(){
		return board;
	}
}
