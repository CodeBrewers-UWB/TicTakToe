package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;

import com.uwbothell.softwaremanagement.model.FrameConstants;

import com.uwbothell.softwaremanagement.controller.TipsButtonListener;
import com.uwbothell.softwaremanagement.model.GamePanelSetting;

import com.uwbothell.softwaremanagement.model.GridModel;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel{
    JPanel panel;
    GameController controller;
    GridModel model;
    TicTacToePanel ticTacToePanel;


    public CenterPanel(GameController controller, GridModel model){
        this.model = model;
        this.controller = controller;
        panel = new JPanel();

        ticTacToePanel = new TicTacToePanel(controller, model);
        panel.add(ticTacToePanel);
        panel.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));

        this.add(panel);
        this.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));
    }

    public void resetPanel(){
        panel = new JPanel();

        ticTacToePanel = new TicTacToePanel(controller, model);
        panel.add(ticTacToePanel);
        panel.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));
        this.add(panel);
        this.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));
    }
    
    public void playwithcom(){
        panel = new JPanel();
        ticTacToePanel = new TicTacToePanel(controller, model);
        panel.add(ticTacToePanel);
        this.add(panel);
    }

    public TicTacToePanel getTicTacToePanel() {
        return ticTacToePanel;
    }

}
