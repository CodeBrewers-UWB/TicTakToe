package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.model.PanelSetting;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

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

    public void init(){
        mainFrame = new JFrame("Lets Play... TIC TAC TOE");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(PanelSetting.getMainWindowX(),
                PanelSetting.getMainWindowY(),
                PanelSetting.getMainWindowWidth(),
                PanelSetting.getMainWindowHeight());

        northPanel = new NorthPanel();
        southPanel = new SouthPanel(controller);
        centralPanel = new CenterPanel(controller);

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
