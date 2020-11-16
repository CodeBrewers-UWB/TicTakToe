package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.model.GridModel;

import javax.swing.*;

public class NorthPanel extends JPanel {
    JPanel panel;
    JLabel label;



    public NorthPanel(GridModel gridModel){
        String playerTurn = gridModel.getPlayerOneName();
        String initLabel = "Player " + playerTurn + " Turn";

        panel = new JPanel();
        label = new JLabel();
        label.setText(initLabel);
        panel.add(label);
        this.add(panel);
    }

    public void setLabelText(String input){
        label.setText(input);
    }
}
