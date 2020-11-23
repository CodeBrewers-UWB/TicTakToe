package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.model.FrameConstants;
import com.uwbothell.softwaremanagement.model.GameHistoryObj;
import com.uwbothell.softwaremanagement.model.GamePanelSetting;
import com.uwbothell.softwaremanagement.model.GridModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;


public class GameView {
    public JFrame mainFrame;
    public JPanel northPanel;
    public JPanel southPanel;
    public JPanel centralPanel;
    public GameHistoryObj gameData;
    final static String gameDataFile = "GameData.txt";

    //    TicTacToeObj model;
    GameController controller;
    public GameView(){
//        this.model = model;
    }

    public void init(GridModel model){
        try {
        mainFrame = new JFrame("Lets Play... TIC TAC TOE");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(GamePanelSetting.getMainWindowX(),
                GamePanelSetting.getMainWindowY(),
                GamePanelSetting.getMainWindowWidth(),
                GamePanelSetting.getMainWindowHeight());

        gameData = new GameHistoryObj(gameDataFile);

        northPanel = new NorthPanel(controller, model);
        southPanel = new SouthPanel(controller, model,gameData);
        centralPanel = new CenterPanel(controller, model);

        mainFrame.getContentPane().setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));
        mainFrame.add(northPanel, BorderLayout.NORTH);
        mainFrame.add(centralPanel, BorderLayout.CENTER);
        mainFrame.add(southPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        }catch (FileNotFoundException fnfe) {
            System.err.println(gameDataFile + " file not found !!");
        }catch (Exception e){

        }
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
