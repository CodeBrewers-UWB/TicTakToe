package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.controller.StartButtonListener;
import com.uwbothell.softwaremanagement.model.StartFrameModel;
import com.uwbothell.softwaremanagement.model.StartGameFrameSetting;

import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;

public class StartFrame extends JFrame {
    private GameController gameController;
    private Container container;
    private StartFrameModel startFrameModel;
    private GameView nextFrame;

    public StartFrame(GameView nextFrame)
    {
        this.nextFrame = nextFrame;

        initFrameItems();
        setContainerLayout();
        designFrame();
        addComponentsToContainer();
    }

    public void start(StartFrame frame){
        frame.setTitle(StartGameFrameSetting.getStartGameTitle());
        frame.setVisible(true);
        frame.setBounds(10,10,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        JComboBox<String> jComboBox1 = new JComboBox<>();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public StartFrameModel getStartFrameModel() {
        return this.startFrameModel;
    }

    private void initFrameItems() {
        container = getContentPane();
        startFrameModel = new StartFrameModel();
        startFrameModel.setButtonListener(new StartButtonListener(startFrameModel, this, this.nextFrame));
    }

    private void setContainerLayout()
    {
        container.setLayout(null);
    }

    private void designFrame() {
        startFrameModel.designModelItems();
    }

    private void addComponentsToContainer()
    {
        container.add(startFrameModel.getLabel1());
        container.add(startFrameModel.getLabel2());
        container.add(startFrameModel.getLabel1TextField());
        container.add(startFrameModel.getLabel2TextField());
        container.add(startFrameModel.getComboBox1Label());
        container.add(startFrameModel.getComboBox1());
        container.add(startFrameModel.getComboBox2Label());
        container.add(startFrameModel.getComboBox2());
        container.add(startFrameModel.getStartButton());
    }
}
