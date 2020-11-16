package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.model.GamePanelSetting;
import com.uwbothell.softwaremanagement.model.GridModel;

import javax.swing.*;
import java.awt.*;

public class GameView {
    public JFrame mainFrame;
    public JPanel northPanel;
    public JPanel southPanel;
    public JPanel centralPanel;

//    TicTacToeObj model;
    GameController controller;
    public GameView(){
//        this.model = model;
    }

    public void init(GridModel model){
        mainFrame = new JFrame("Lets Play... TIC TAC TOE");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(GamePanelSetting.getMainWindowX(),
                GamePanelSetting.getMainWindowY(),
                GamePanelSetting.getMainWindowWidth(),
                GamePanelSetting.getMainWindowHeight());

        northPanel = new NorthPanel(model);
        southPanel = new SouthPanel(controller);
        centralPanel = new CenterPanel(controller, model);

        mainFrame.add(northPanel, BorderLayout.NORTH);
        mainFrame.add(centralPanel, BorderLayout.CENTER);
        mainFrame.add(southPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public JPanel getCentralPanel() {
        return centralPanel;
    }
}
