package com.uwbothell.softwaremanagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonListener implements ActionListener {
    private static int TURN_COUNT = 0;
    private Main main ;
    static JButton button;
    private TicTacToeObj ticTacToeObj;

    public ButtonListener(TicTacToeObj ticTacToeObj) {
        this.ticTacToeObj = ticTacToeObj;
    }
    
    public ButtonListener(Main main) {
    	this.main= main;	
	}

    public void actionPerformed(ActionEvent event) {
        
   
         button = (JButton)event.getSource();
         
         if (button == Main.x) {
        	 
        		Main.centerPanel.removeAll();
            	
        		Main.centerPanel.revalidate();
        		Main.centerPanel.repaint();
        		Main.CenterPanel();
         }
         
         else {
        int buttonIndex = ticTacToeObj.getButtonPosition().get(button);
      

        try {
            if (TURN_COUNT %2 == 0) {
                ticTacToeObj.setValue(buttonIndex, TicTacToeObj.CROSS);
                Main.statusBar.setText("Player " + "O" + " Turn");
            }
            else {
                ticTacToeObj.setValue(buttonIndex, TicTacToeObj.CIRCLE);
                Main.statusBar.setText("Player " + "X" + " Turn");
            }
        }
        catch (IOException ex) {

        }

        // After every click check if some player actually won the game
        int winner = checkWinner();

        // If some player won, then say game is over and reset board
        if (ticTacToeObj.isGameOver(winner)) {
            // Winner is decided so game ends
            String winningMessage = "Congratulations Player " + ticTacToeObj.getWinner(winner) + " Won!";
            JOptionPane.showConfirmDialog(null, winningMessage);
            ticTacToeObj.resetGame();
        }

        // Else, increment the count of turns and wait for next click
        TURN_COUNT ++;
    }}



/* return 1 if player 1 wins
          2  if player 2 wins
          0 if no outcome */
    private int checkWinner() {
        int winner=0;

        int[] container=ticTacToeObj.getFullGrid();

        if(threeEqual(container[0],container[1],container[2]))
             winner=container[0];

        if(threeEqual(container[3],container[4],container[5]))
            winner=container[3];

        if(threeEqual(container[6],container[7],container[8]))
            winner=container[6];

        if(threeEqual(container[0],container[3],container[6]))
            winner=container[0];

        if(threeEqual(container[1],container[4],container[7]))
            winner=container[1];

        if(threeEqual(container[2],container[5],container[8]))
            winner=container[2];

        if(threeEqual(container[0],container[4],container[8]))
            winner=container[0];

        if(threeEqual(container[2],container[4],container[6]))
            winner=container[2];


        return winner;
    }


    private boolean threeEqual(int a, int b, int c){

        boolean isEqual=false;

        if(a==b && a==c)

            isEqual=true;

        return  isEqual;

    }
}
