/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connect.four.gui;

import connect.four.*;
import connect.four.board.*;
import connect.four.player.*;


public class GUI extends javax.swing.JFrame {

	MainMenuPanel mainMenu;
	GamePanel gamePanel;
	GameOverPanel gameOverPanel;
	String p1Name;
	String p2Name;
	String winner;
	int score1;
	int score2;
	
	public GUI() {
		initComponents();
		score1 = 0;
		score2 = 0;
		//gamePanel = new GamePanel(this);
		mainMenu = new MainMenuPanel(this);
		add(mainMenu);
		
	}

	
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).
                        addGap(0, 1280, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).
                        addGap(0, 800, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

	
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */

        
		/* If Nimbus (introduced in Java SE 6) is not available, 
		 * stay with the default look and  feel. For details see 
         *  http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info 
					: javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).
			log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).
			log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).
			log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).
			log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
		
		
	}
	
	//Methods
	
	void updateDisplay(){
	
		revalidate();
		repaint();
	}
	
	void setPlayer1Name(String name){
		p1Name = name;
		System.out.println("Player 1's name set to " + name);
	}
	
	void setPlayer2Name(String name){
		p2Name = name;
		System.out.println("Player 2's name set to " + name);
	}
	
	String getPlayer1Name(){
		return p1Name;
	}
	
	String getPlayer2Name(){
		return p2Name;
	}
	
	void addGamePanel(){
		gamePanel = new GamePanel(this, mainMenu.getIsEnabled());
		add(gamePanel);
	}
	
	void removeGamePanel(){
		remove(gamePanel);
	}
	
	void addMainMenu(){
		score1 = 0;
		score2 = 0;
		mainMenu = new MainMenuPanel(this);
		add(mainMenu);
	}
	
	void addGameOver(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		remove(gamePanel);
		System.out.println("New Game Over Panel added");
		gameOverPanel = new GameOverPanel(this, winner);
		add(gameOverPanel);
		updateDisplay();
	}
	
	void setWinner(String winner){
		this.winner = winner;
	}
	
	int getScore1(){
		return score1;
	}
	
	int getScore2(){
		return score2;
	}
	
	void setScore1(int newScore){
		score1 = newScore;
	}
	
	void setScore2(int newScore){
		score2 = newScore;
	}
}
