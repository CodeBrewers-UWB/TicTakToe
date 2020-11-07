package com.uwbothell.softwaremanagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonListener implements ActionListener {

    private static int TURN_COUNT = 0;

    private TicTacToeObj ticTacToeObj;

    public ButtonListener(TicTacToeObj ticTacToeObj) {
        this.ticTacToeObj = ticTacToeObj;
    }

    public void actionPerformed(ActionEvent event) {

        JButton button = (JButton)event.getSource();
        int buttonIndex = ticTacToeObj.getButtonPosition().get(button);

        try {
            if (TURN_COUNT %2 == 0) {
                ticTacToeObj.setValue(buttonIndex, TicTacToeObj.CROSS);
            }
            else {
                ticTacToeObj.setValue(buttonIndex, TicTacToeObj.CIRCLE);
            }
        }
        catch (IOException ex) {

        }

        String winner = checkWinner();

        if (ticTacToeObj.isGameOver(winner)) {
            // Winner is decided so game ends
            String winningMessage = "Congratulations Player " + ticTacToeObj.getWinner(winner) + " Won!";
            JOptionPane.showConfirmDialog(null, winningMessage);
            ticTacToeObj.resetGame();
        }

        // TODO
        // After every click check if some player actually won the game (checkWinningCriteria() )
        // If some player won, then say game is over and reset board (endGame(), resetBoard())

        // Else, increment the count of turns and wait for next click
        TURN_COUNT ++;
    }


/* return 1 if player 1 wins
          2  if player 2 wins
          0 if no outcome */
    private String checkWinner() {
        String winner = "";
        TicTacToeObj obj=new  TicTacToeObj();
        obj.getTicTacToeObj();



        JButton[] container = obj.getFullGrid();

        if(threeEqual(container[0].getText(),container[1].getText(),container[2].getText()))
             winner=container[0].getText();

        if(threeEqual(container[3].getText(),container[4].getText(),container[5].getText()))
            winner=container[3].getText();

        if(threeEqual(container[6].getText(),container[7].getText(),container[8].getText()))
            winner=container[6].getText();

        if(threeEqual(container[0].getText(),container[3].getText(),container[6].getText()))
            winner=container[0].getText();

        if(threeEqual(container[1].getText(),container[4].getText(),container[7].getText()))
            winner=container[1].getText();

        if(threeEqual(container[2].getText(),container[5].getText(),container[8].getText()))
            winner=container[2].getText();

        if(threeEqual(container[0].getText(),container[4].getText(),container[8].getText()))
            winner=container[0].getText();

        if(threeEqual(container[2].getText(),container[4].getText(),container[6].getText()))
            winner=container[2].getText();


        return winner;
    }


    private boolean threeEqual(String a, String b, String c){

        boolean isEqual=false;

        if(a.equals(b) && a.equals(c)) {
            isEqual=true;
        }

        return  isEqual;

    }
}
