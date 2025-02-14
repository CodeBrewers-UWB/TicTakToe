package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.model.GridModel;
import com.uwbothell.softwaremanagement.model.StartFrameModel;
import com.uwbothell.softwaremanagement.model.StartGameFrameSetting;
import com.uwbothell.softwaremanagement.view.GameView;
import com.uwbothell.softwaremanagement.view.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaywithcomListener implements ActionListener {
    StartFrameModel model;
    StartFrame currentFrame;
    GameView nextFrame;
    public static int ClickonPlaywithComputer= 0;
    public PlaywithcomListener(StartFrameModel model, StartFrame currentFrame, GameView nextFrame){
        this.model = model;
        this.currentFrame = currentFrame;
        this.nextFrame = nextFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClickonPlaywithComputer = 1;

        String player1 = model.getLabel1TextField().getText();
        String player2 = "Computer";

        String player1Icon = StartGameFrameSetting.getIcons()[model.getComboBox1().getSelectedIndex()];
        String player2Icon = StartGameFrameSetting.getIcons()[model.getComboBox2().getSelectedIndex()];

        currentFrame.setVisible(false);
        nextFrame.init(new GridModel(player1, player2, player1Icon, player2Icon));
    }
}
