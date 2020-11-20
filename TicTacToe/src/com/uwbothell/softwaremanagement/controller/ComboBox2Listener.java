package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.model.StartFrameModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ComboBox2Listener implements ActionListener {
    StartFrameModel model;
    Random rand;
    int maxNum;

    public ComboBox2Listener(StartFrameModel model){
        this.model = model;
        rand = new Random();
        maxNum = model.getComboBox1().getItemCount();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int indexOne = model.getComboBox1().getSelectedIndex();
        int indexTwo = model.getComboBox2().getSelectedIndex();

        // avoid two comboBox to get same symbol
        if(indexOne == indexTwo) {
            int random = rand.nextInt(maxNum);
            while(random == indexTwo){
                random = rand.nextInt(maxNum);
            }
            model.getComboBox2().setSelectedIndex(random);
        }
    }
}
