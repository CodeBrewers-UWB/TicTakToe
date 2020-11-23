package com.uwbothell.softwaremanagement.model;

import com.uwbothell.softwaremanagement.controller.ComboBox1Listener;
import com.uwbothell.softwaremanagement.controller.ComboBox2Listener;
import com.uwbothell.softwaremanagement.controller.PlaywithcomListener;
import com.uwbothell.softwaremanagement.controller.StartButtonListener;
import com.uwbothell.softwaremanagement.util.ImageUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class StartFrameModel {
    private JLabel label1;
    private JLabel label2;
    private JLabel comboBox1Label;
    private JLabel comboBox2Label;
    private JTextField label1TextField;
    private JTextField label2TextField;
    private JButton startButton;
    private JButton Playwithcom;
    private JLabel imageLabel;

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
    
    public JButton getPlaywithcom() {
        return Playwithcom;
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

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public StartFrameModel(JFrame parent) {
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
        comboBox1.addActionListener(new ComboBox1Listener(this, parent));
        comboBox2.addActionListener(new ComboBox2Listener(this, parent));
        initStartButton();
        initImageLabel();
        initPlayeithcomButton();
    }

    private void initImageLabel() {
        try {
            imageLabel = new JLabel(compressPicFromURL("https://i.ibb.co/GtTW6Sy/bg3.png", 200, 200));
        }
        catch (Exception ex) {

        }
    }

    private void initStartButton() {
        try {
            startButton = new JButton(compressPicFromURL("https://i.ibb.co/VYSgDBf/play-icon.png", 150, 50));
        }
        catch (Exception ex) {
            System.out.println("pooh");
        }
    }
    
      private void initPlayeithcomButton() {
    	Playwithcom=new JButton(StartGameFrameSetting.getPlaywithcomButtonText());
    }

    private ImageIcon compressPicFromURL(String urlString, int width, int height){
        BufferedImage pic = null;
        try {
            URL url = new URL(urlString);
            pic = ImageIO.read(url);

        } catch (IOException err) {
            err.printStackTrace();
        }

        return ImageUtil.createCompressedImage(pic, width, height);
    }

    public void designModelItems() {
        int labelX = StartGameFrameSetting.getLabelXBounds();
        int yBounds = StartGameFrameSetting.getyBounds();
        int labelWidth = StartGameFrameSetting.getLabelWidth();
        int labelHeight = StartGameFrameSetting.getLabelHeight();
        int yOffset = StartGameFrameSetting.getyOffset();

        int textFieldX = StartGameFrameSetting.getTextFieldXBounds();

        imageLabel.setBounds(70, 20, 200, 200);
        label1.setBounds(labelX, yBounds, labelWidth, labelHeight);
        comboBox1Label.setBounds(labelX, yBounds + 40, labelWidth, labelHeight);
        label2.setBounds(labelX, yBounds + yOffset, labelWidth, labelHeight);
        comboBox2Label.setBounds(labelX, yBounds + yOffset + 30, labelWidth, labelHeight);
        label1TextField.setBounds(textFieldX, yBounds, StartGameFrameSetting.getTextFieldWidth(), labelHeight);
        label2TextField.setBounds(textFieldX, yBounds + yOffset, StartGameFrameSetting.getTextFieldWidth(), labelHeight);
        comboBox1.setBounds(150, yBounds + 40,90,20);
        comboBox2.setBounds(150, yBounds + yOffset + 40, 90, 20);
        startButton.setBounds(80, yBounds + yOffset + 100, 150, 50);
    }

    public void setButtonListener(StartButtonListener listener) {
        startButton.addActionListener(listener);
    }

    public void setButtonListener(PlaywithcomListener listener) {
    	Playwithcom.addActionListener(listener);
    }
}
