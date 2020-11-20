package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.model.GridModel;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridButtonListener implements ActionListener {
    TicTacToeObj model;
    JButton button;
    int buttonID;
    GameController controller;
    GridModel gridModel;

    public GridButtonListener(JButton button, int buttonID, GameController controller, GridModel gridModel){
        this.controller = controller;
        this.button = button;
        this.buttonID = buttonID;
        this.gridModel = gridModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = controller.getModel();

        if(button.getText().length()>0){
            // pop up error or do nothing
            System.out.println("grid occupied");
        }
        else if(model.currentTurn == TicTacToeObj.PLAYER_ONE) {
            this.button.setText(gridModel.getPlayerOneIcon());
            model.currentTurn = TicTacToeObj.PLAYER_TWO;
            model.setValue(buttonID, TicTacToeObj.CROSS);
        }
        else {
            this.button.setText(gridModel.getPlayerTwoIcon());
            model.currentTurn = TicTacToeObj.PLAYER_ONE;
            model.setValue(buttonID, TicTacToeObj.CIRCLE);
        }
        controller.updatePlayerIndicator(gridModel);
        controller.checkWinner(gridModel);
    }
}
