package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

import javax.swing.*;

public class CenterPanel extends JPanel{
    JPanel panel;
    GameController controller;

    public CenterPanel(GameController controller){
        this.controller = controller;
        panel = new JPanel();
        panel.add(new TicTacToePanel(controller));
        this.add(panel);
    }

    public void resetPanel(){
        panel = new JPanel();
        panel.add(new TicTacToePanel(controller));
        this.add(panel);
    }
}
