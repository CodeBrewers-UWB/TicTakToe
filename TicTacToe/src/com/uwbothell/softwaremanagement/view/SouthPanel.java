package com.uwbothell.softwaremanagement.view;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.controller.ResetButtonListener;
import com.uwbothell.softwaremanagement.model.GamePanelSetting;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel{
    JPanel panel;
    JLabel label;
    JButton button;

    public SouthPanel(GameController controller){
        panel = new JPanel();
        label = new JLabel();
        button = new JButton("Restart");
        button.setPreferredSize(new Dimension(GamePanelSetting.getRestartButtonWidth(), GamePanelSetting.getRestartButtonHeight()));
        button.addActionListener(new ResetButtonListener(controller));

        panel.setPreferredSize(new Dimension(GamePanelSetting.getSouthPanelWidth(), GamePanelSetting.getSouthPanelHeight()));
        panel.add(button);

        this.add(panel);
    }
}
