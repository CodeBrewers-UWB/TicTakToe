package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.controller.GridButtonListener;
import com.uwbothell.softwaremanagement.model.FrameConstants;
import com.uwbothell.softwaremanagement.model.GamePanelSetting;
import com.uwbothell.softwaremanagement.model.GridModel;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToePanel extends JPanel {
    TicTacToeObj model;
    public static JButton[] buttons;
    GameController controller;
    GridModel gridModel;

    public TicTacToePanel(GameController controller, GridModel gridModel) {
        this.gridModel = gridModel;
        this.controller = controller;
        buttons = new JButton[9];
        this.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));

        // Set the grid layout to 3 X 3
        setLayout(new GridLayout(3, 3));

        for (int index = 0; index < 9 ; index ++) {
            buttons[index] = new JButton();
            buttons[index].setText(gridModel.getEmptyText());
            buttons[index].addActionListener( new GridButtonListener(buttons[index], index,controller, gridModel));
            this.add(buttons[index]);
            setPreferredSize(new Dimension(GamePanelSetting.gridButtonWidth, GamePanelSetting.gridButtonHeight));
        }
    }

    public void highlightButton(int index) {

        //buttons[index].setBackground(Color.GREEN);
        buttons[index].setBackground(new Color(39, 216, 39));
        buttons[index].setOpaque(true);

        ActionListener timerListener = evt -> buttons[index].setBackground(null);

        Timer timer = new Timer(2500, timerListener);

        timer.start();

    }
}
