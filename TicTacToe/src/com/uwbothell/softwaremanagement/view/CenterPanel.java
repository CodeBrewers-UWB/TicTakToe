package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.model.GridModel;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

import javax.swing.*;

public class CenterPanel extends JPanel{
    JPanel panel;
    GameController controller;
    GridModel model;

    public CenterPanel(GameController controller, GridModel model){
        this.model = model;
        this.controller = controller;
        panel = new JPanel();
        panel.add(new TicTacToePanel(controller, model));
        this.add(panel);
    }

    public void resetPanel(){
        panel = new JPanel();
        panel.add(new TicTacToePanel(controller, model));
        this.add(panel);
    }
    
    public void playwithcom(){
        panel = new JPanel();
        panel.add(new TicTacToePanel(controller, model));
        this.add(panel);
    }
}
