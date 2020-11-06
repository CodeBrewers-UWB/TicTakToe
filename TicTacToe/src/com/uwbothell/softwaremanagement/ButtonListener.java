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

        // TODO
        // After every click check if some player actually won the game (checkWinningCriteria() )
        // If some player won, then say game is over and reset board (endGame(), resetBoard())

        // Else, increment the count of turns and wait for next click
        TURN_COUNT ++;
    }
}
