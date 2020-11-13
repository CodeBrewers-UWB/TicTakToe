package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.controller.GridButtonListener;
import com.uwbothell.softwaremanagement.model.GirdSymbols;
import com.uwbothell.softwaremanagement.model.PanelSetting;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class TicTacToePanel extends JPanel {
    TicTacToeObj model;
    JButton[] buttons;
    GameController controller;

    public TicTacToePanel(GameController controller) {
        this.controller = controller;
        buttons = new JButton[9];

        // Set the grid layout to 3 X 3
        setLayout(new GridLayout(3, 3));

        for (int index = 0; index < 9 ; index ++) {
            buttons[index] = new JButton();
            buttons[index].setText(GirdSymbols.EMPTY_TEXT);
            buttons[index].addActionListener( new GridButtonListener(buttons[index], index,controller));
            this.add(buttons[index]);
            setPreferredSize(new Dimension(PanelSetting.gridButtonWidth, PanelSetting.gridButtonHeight));
        }
    }
}
