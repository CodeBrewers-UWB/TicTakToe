package com.uwbothell.softwaremanagement.view;

import javax.swing.*;

public class NorthPanel extends JPanel {
    JPanel panel;
    JLabel label;

    String playerTurn = "X";
    String initLabel = "Player " + playerTurn + " Turn";

    public NorthPanel(){
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
