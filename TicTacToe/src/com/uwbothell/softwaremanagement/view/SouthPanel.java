package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.controller.ResetButtonListener;
import com.uwbothell.softwaremanagement.model.FrameConstants;
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

    public SouthPanel(GameController controller, GridModel gridModel,GameHistoryObj gameData ){

            this.controller=controller;
            this.gridModel=gridModel;

            int[] scores=gameData.getGameHistory(gridModel.getPlayerOneName(),gridModel.getPlayerTwoName());

            gridModel.setHistory(scores);
            initSouthPanel();

    }

    public void initSouthPanel(){
        String playerOneIcon = gridModel.getPlayerOneIcon().length()>2? "custom" : gridModel.getPlayerOneIcon();
        String playerTwoIcon = gridModel.getPlayerTwoIcon().length()>2? "custom" : gridModel.getPlayerTwoIcon();

        label=new JLabel("Game Scores :",SwingConstants.CENTER);
        label.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        label.setForeground(Color.blue);
        label1 = new JLabel(gridModel.getPlayerOneName()
                + "  [" + playerOneIcon
                +"] " + ": "
                +gridModel.getPlayerOneWins()
                + "     Vs    "
                + gridModel.getPlayerTwoName()
                + "  ["
                + playerTwoIcon
                + "] " + ": "
                +gridModel.getPlayerTwoWins()
                +"   Draw  : "+gridModel.getDraw() );

        label1.setFont(new java.awt.Font("Arial", Font.BOLD, 12));

        button = new JButton("Restart");
        button.setPreferredSize(new Dimension(GamePanelSetting.getRestartButtonWidth(), GamePanelSetting.getRestartButtonHeight()));
        button.addActionListener(new ResetButtonListener(controller));

        this.setPreferredSize(new Dimension(GamePanelSetting.getSouthPanelWidth(), GamePanelSetting.getSouthPanelHeight()));
        this.add(label);
        this.add(label1);
        this.add(button);
        this.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));
        this.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));

    }
}
