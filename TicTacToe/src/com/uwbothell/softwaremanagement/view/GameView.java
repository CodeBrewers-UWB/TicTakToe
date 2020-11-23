package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.model.GameHistoryObj;
import com.uwbothell.softwaremanagement.model.GamePanelSetting;
import com.uwbothell.softwaremanagement.model.GridModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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

        northPanel = new NorthPanel(model);
        southPanel = new SouthPanel(controller, model,gameData);
        centralPanel = new CenterPanel(controller, model);

        mainFrame.add(northPanel, BorderLayout.NORTH);
        mainFrame.add(centralPanel, BorderLayout.CENTER);
        mainFrame.add(southPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                HashMap<String, int[]> data = gameData.getGameData();
//                if (data != null) {
//                    for (Map.Entry<String, int[]> ent : data.entrySet()) {
//                        System.out.println("inside the loop");
//                        System.out.println(ent.getKey() + " = " + ent.getValue());
//                    }

                    try {
                        System.out.println(data.size());
                        BufferedWriter output = new BufferedWriter(new FileWriter(gameDataFile, true));
                        int count = 0;
                        for (Map.Entry<String, int[]> entry : data.entrySet()) {
                            String s = entry.getKey();
                            int[] score = entry.getValue();
                            output.write(s + "=" + score[0] + "," + score[1] + "," + score[2]);
                            output.newLine();
                            count++;

                        }
                        output.close();
                        System.out.println("Successfully wrote to the file." + count);
                    } catch (IOException exe) {
                        System.out.println("An error occurred.");
                        exe.printStackTrace();
                    }
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
