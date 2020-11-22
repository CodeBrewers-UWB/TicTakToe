package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.TipsButtonListener;
import com.uwbothell.softwaremanagement.model.FrameConstants;
import com.uwbothell.softwaremanagement.model.GamePanelSetting;
import com.uwbothell.softwaremanagement.model.GridModel;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    JPanel panel;
    JLabel label;
    JButton button;



    public NorthPanel(GridModel gridModel){
        String playerTurn = gridModel.getPlayerOneName();
        String initLabel = "Player " + playerTurn + " Turn";

        panel = new JPanel();
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(10);
        panel.setLayout(layout);

        label = new JLabel();
        label.setText(initLabel);

        button = new JButton("Get Tips");
        button.setPreferredSize(new Dimension(GamePanelSetting.getTipsButtonWidth(), GamePanelSetting.getTipsButtonHeight()));
        button.addActionListener(new TipsButtonListener());

        panel.add(label);
        panel.add(button);
        panel.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));
        this.add(panel);
        this.setBackground(new Color(FrameConstants.r, FrameConstants.g, FrameConstants.b));
    }

    public void setLabelText(String input){
        label.setText(input);
    }
}
