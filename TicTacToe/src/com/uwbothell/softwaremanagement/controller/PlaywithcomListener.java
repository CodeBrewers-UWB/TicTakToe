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
    public PlaywithcomListener(StartFrameModel model, StartFrame currentFrame, GameView nextFrame){
        this.model = model;
        this.currentFrame = currentFrame;
        this.nextFrame = nextFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
             currentFrame.setVisible(false);

    }
}
