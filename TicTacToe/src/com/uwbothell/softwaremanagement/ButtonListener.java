package com.uwbothell.softwaremanagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private static int TURN_COUNT = 0;
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton)event.getSource();
        if (TURN_COUNT %2 == 0) {
            button.setText("X");
        }
        else {
            button.setText("O");
        }

        int winner =checkWinner();
        // TODO
        // After every click check if some player actually won the game (checkWinningCriteria() )
        // If some player won, then say game is over and reset board (endGame(), resetBoard())

        // Else, increment the count of turns and wait for next click
        TURN_COUNT ++;
    }


/* return 1 if player 1 wins
          2  if player 2 wins
          0 if no outcome */
    private int checkWinner() {
       int winner=0;
        TicTacToeObj obj=new  TicTacToeObj();
        obj.getTicTacToeObj();



        int[] container=obj.getFullGrid();

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
