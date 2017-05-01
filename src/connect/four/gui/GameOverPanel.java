

package connect.four.gui;


public class GameOverPanel extends javax.swing.JPanel {

	GUI gui;
	
	public GameOverPanel(GUI gui, String winner) {
		initComponents();
		this.gui = gui;
		setSize(1280, 800);
		System.out.println("Here!");
		winnerDisplay.setText(winner);
		setVisible(true);
	}
	
	

	
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                winnerDisplay = new javax.swing.JLabel();
                winner = new javax.swing.JLabel();
                labelGameOVer = new javax.swing.JLabel();
                butPlayAgain = new javax.swing.JButton();
                butMainMenu = new javax.swing.JButton();

                setBackground(new java.awt.Color(0, 0, 0));

                winnerDisplay.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                winnerDisplay.setForeground(new java.awt.Color(255, 255, 255));
                winnerDisplay.setText("Winner");

                winner.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                winner.setForeground(new java.awt.Color(255, 255, 255));
                winner.setText("Winner:");

                labelGameOVer.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
                labelGameOVer.setForeground(new java.awt.Color(255, 255, 255));
                labelGameOVer.setText("GAME OVER");

                butPlayAgain.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
                butPlayAgain.setText("Play Again");
                butPlayAgain.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                butPlayAgainActionPerformed(evt);
                        }
                });

                butMainMenu.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
                butMainMenu.setText("Main Menu");
                butMainMenu.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                butMainMenuActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(499, 499, 499)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(winner)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(winnerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(butPlayAgain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(labelGameOVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(551, 551, 551)
                                                .addComponent(butMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(429, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(labelGameOVer)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(winnerDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addComponent(butPlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(butMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(304, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void butPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPlayAgainActionPerformed
                
		gui.remove(this);
		gui.addGamePanel();
		gui.revalidate();
		gui.repaint();
        }//GEN-LAST:event_butPlayAgainActionPerformed

        private void butMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMainMenuActionPerformed
		gui.remove(this);
		gui.addMainMenu();
		gui.revalidate();
		gui.repaint();
        }//GEN-LAST:event_butMainMenuActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton butMainMenu;
        private javax.swing.JButton butPlayAgain;
        private javax.swing.JLabel labelGameOVer;
        private javax.swing.JLabel winner;
        private javax.swing.JLabel winnerDisplay;
        // End of variables declaration//GEN-END:variables
}
