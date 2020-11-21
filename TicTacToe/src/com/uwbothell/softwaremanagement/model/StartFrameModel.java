package com.uwbothell.softwaremanagement.model;

import com.uwbothell.softwaremanagement.controller.ComboBox1Listener;
import com.uwbothell.softwaremanagement.controller.ComboBox2Listener;
import com.uwbothell.softwaremanagement.controller.PlaywithcomListener;
import com.uwbothell.softwaremanagement.controller.StartButtonListener;

import javax.swing.*;

public class StartFrameModel {
    private JLabel label1;
    private JLabel label2;
    private JLabel comboBox1Label;
    private JLabel comboBox2Label;
    private JTextField label1TextField;
    private JTextField label2TextField;
    private JButton startButton;
    private JButton Playwithcom;

    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public JLabel getLabel1() {
        return label1;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public JLabel getComboBox1Label() {
        return comboBox1Label;
    }

    public JTextField getLabel1TextField() {
        return label1TextField;
    }

    public JTextField getLabel2TextField() {
        return label2TextField;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public JLabel getComboBox2Label() {
        return comboBox2Label;
    }

    public StartFrameModel() {
        label1=new JLabel(StartGameFrameSetting.getLabelOneText());
        label2=new JLabel(StartGameFrameSetting.getLabelTwoText());
        label1TextField=new JTextField();
        label1TextField.setText("Aden");
        label2TextField=new JTextField();
        label2TextField.setText("Bob");
        comboBox1Label = new JLabel(StartGameFrameSetting.getComboBox1LabelText());
        comboBox2Label = new JLabel(StartGameFrameSetting.getComboBox2LabelText());
        comboBox1 = new JComboBox(StartGameFrameSetting.getIcons());
        comboBox2 = new JComboBox(StartGameFrameSetting.getIcons());
        comboBox2.setSelectedIndex(1);
        comboBox1.addActionListener(new ComboBox1Listener(this));
        comboBox2.addActionListener(new ComboBox2Listener(this));
        initStartButton();
    }

    private void initStartButton() {
        startButton=new JButton(StartGameFrameSetting.getStartButtonText());
    }

    public void designModelItems() {
        int labelX = StartGameFrameSetting.getLabelXBounds();
        int yBounds = StartGameFrameSetting.getyBounds();
        int labelWidth = StartGameFrameSetting.getLabelWidth();
        int labelHeight = StartGameFrameSetting.getLabelHeight();
        int yOffset = StartGameFrameSetting.getyOffset();

        int textFieldX = StartGameFrameSetting.getTextFieldXBounds();

        label1.setBounds(labelX, yBounds, labelWidth, labelHeight);
        comboBox1Label.setBounds(labelX, yBounds + 40, labelWidth, labelHeight);
        label2.setBounds(labelX, yBounds + yOffset, labelWidth, labelHeight);
        comboBox2Label.setBounds(labelX, yBounds + yOffset + 30, labelWidth, labelHeight);
        label1TextField.setBounds(textFieldX, yBounds, StartGameFrameSetting.getTextFieldWidth(), labelHeight);
        label2TextField.setBounds(textFieldX, yBounds + yOffset, StartGameFrameSetting.getTextFieldWidth(), labelHeight);
        comboBox1.setBounds(150, 200,90,20);
        comboBox2.setBounds(150, yBounds + yOffset + 40, 90, 20);
        startButton.setBounds(130, 320, 120, 30);
        Playwithcom.setBounds(110 , 350,160,  39);
    }

    public void setButtonListener(StartButtonListener listener) {
        startButton.addActionListener(listener);
    }
    public void setButtonListener(PlaywithcomListener listener) {
    	Playwithcom.addActionListener(listener);
    }
    
}
