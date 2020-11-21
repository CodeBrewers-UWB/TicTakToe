package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.model.CustomPicHolder;
import com.uwbothell.softwaremanagement.model.StartFrameModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.util.Random;

public class ComboBox2Listener implements ActionListener {
    StartFrameModel model;
    Random rand;
    int maxNum;
    JFrame parent;

    public ComboBox2Listener(StartFrameModel model, JFrame parent){
        this.model = model;
        rand = new Random();
        maxNum = model.getComboBox1().getItemCount();
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int indexOne = model.getComboBox1().getSelectedIndex();
        int indexTwo = model.getComboBox2().getSelectedIndex();

        if(indexTwo == maxNum-1){
//            System.out.println("custom option picked");
            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setDialogTitle("Pick your custom picture");

            int userSelection = fileChooser.showSaveDialog(parent);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String path = fileToSave.getAbsolutePath();
                CustomPicHolder.playerTwoPath = path;
            }
        }else if(indexOne == indexTwo) {
            // avoid two comboBox to get same symbol
            int random = rand.nextInt(maxNum);
            while(random == indexTwo){
                random = rand.nextInt(maxNum);
            }
            model.getComboBox2().setSelectedIndex(random);
        }
    }
}
