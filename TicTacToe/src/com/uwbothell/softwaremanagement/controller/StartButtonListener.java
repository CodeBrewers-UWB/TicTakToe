package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.model.CustomPicHolder;
import com.uwbothell.softwaremanagement.model.GridModel;
import com.uwbothell.softwaremanagement.model.StartFrameModel;
import com.uwbothell.softwaremanagement.model.StartGameFrameSetting;
import com.uwbothell.softwaremanagement.view.GameView;
import com.uwbothell.softwaremanagement.view.StartFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener {
    StartFrameModel model;
    StartFrame currentFrame;
    GameView nextFrame;
    public StartButtonListener(StartFrameModel model, StartFrame currentFrame, GameView nextFrame){
        this.model = model;
        this.currentFrame = currentFrame;
        this.nextFrame = nextFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String player1 = model.getLabel1TextField().getText();
        String player2 = model.getLabel2TextField().getText();
        //JOptionPane.showMessageDialog(currentFrame, "No two players must choose same icon!",
              //  "   Error Message", JOptionPane.ERROR_MESSAGE);//
        int comboBoxLength = model.getComboBox1().getItemCount();
        int iconIndexOne = model.getComboBox1().getSelectedIndex();
        int iconIndexTwo = model.getComboBox2().getSelectedIndex();

        String player1Icon;
        String player2Icon;

        if(iconIndexOne == comboBoxLength-1) player1Icon = CustomPicHolder.playerOnePath;
        else player1Icon = StartGameFrameSetting.getIcons()[iconIndexOne];

        if(iconIndexTwo == comboBoxLength-1) player2Icon = CustomPicHolder.playerTwoPath;
        else player2Icon = StartGameFrameSetting.getIcons()[iconIndexTwo];

        if ( player1Icon == player2Icon){
            JOptionPane.showMessageDialog(currentFrame, "No two players must choose same icon!",
                    "   Error Message", JOptionPane.ERROR_MESSAGE);

        }
        else{
            currentFrame.setVisible(false);
            nextFrame.init(new GridModel(player1, player2, player1Icon, player2Icon));
        }
    }
}
