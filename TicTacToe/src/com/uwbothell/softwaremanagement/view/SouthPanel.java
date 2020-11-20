package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.controller.ResetButtonListener;
import com.uwbothell.softwaremanagement.model.GameHistoryObj;
import com.uwbothell.softwaremanagement.model.GamePanelSetting;
import com.uwbothell.softwaremanagement.model.GridModel;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class SouthPanel extends JPanel{
    JPanel panel;
    JLabel label1;
    JLabel label2;
    JLabel label;
    JButton button;
    GameController controller;
    GridModel gridModel;
    public GameHistoryObj gameData;
    final static String gameDataFile = "GameData.txt";

    public SouthPanel(GameController controller, GridModel gridModel){
        try {

            this.controller=controller;
            this.gridModel=gridModel;
            gameData = new GameHistoryObj(gameDataFile);

            int[] scores=gameData.getGameHistory(gridModel.getPlayerOneName(),gridModel.getPlayerTwoName());

            gridModel.setHistory(scores);
            initSouthPanel();
        }catch (FileNotFoundException fnfe) {
            System.err.println(gameDataFile + " file not found !!");
        }catch (Exception e){

        }
    }

    public void initSouthPanel(){
        panel = new JPanel();
        label1 = new JLabel(gridModel.getPlayerOneName() + "  [" +gridModel.getPlayerOneIcon() +"] " + ": " +gridModel.getPlayerOneWins() + "     Vs    " + gridModel.getPlayerTwoName() + "  [" + gridModel.getPlayerTwoIcon() + "] " + ": " +gridModel.getPlayerTwoWins() );
        // label1.setIconTextGap(10);
        label2 = new JLabel("Draw    : "+gridModel.getDraw());
        //label2.setIconTextGap(10);

        button = new JButton("Restart");
        button.setPreferredSize(new Dimension(GamePanelSetting.getRestartButtonWidth(), GamePanelSetting.getRestartButtonHeight()));
        button.addActionListener(new ResetButtonListener(controller));

        panel.setPreferredSize(new Dimension(GamePanelSetting.getSouthPanelWidth(), GamePanelSetting.getSouthPanelHeight()));

        panel.add(label1);
        panel.add(label2);
        panel.add(button);

        this.add(panel);

    }
}
