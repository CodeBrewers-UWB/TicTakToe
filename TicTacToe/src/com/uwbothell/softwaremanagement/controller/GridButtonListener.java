package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.model.GirdSymbols;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridButtonListener implements ActionListener {
    TicTacToeObj model;
    JButton button;
    int buttonID;
    GameController controller;

    public GridButtonListener(JButton button, int buttonID, GameController controller){
        this.controller = controller;
        this.button = button;
        this.buttonID = buttonID;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = controller.getModel();

        if(button.getText().length()>0){
            // pop up error or do nothing
            System.out.println("gird occupied");
        }
        else if(model.currentTurn == TicTacToeObj.PLAYER_ONE) {
            this.button.setText(GirdSymbols.CROSS_TEXT);
            model.currentTurn = TicTacToeObj.PLAYER_TWO;
            model.setValue(buttonID, TicTacToeObj.CROSS);
        }
        else {
            this.button.setText(GirdSymbols.CIRCLE_TEXT);
            model.currentTurn = TicTacToeObj.PLAYER_ONE;
            model.setValue(buttonID, TicTacToeObj.CIRCLE);
        }
        controller.updatePlayerIndicator();
        controller.checkWinner();

    }
}
