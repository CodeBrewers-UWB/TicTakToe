package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.view.CenterPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipsButtonListener implements ActionListener {

    public TipsButtonListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "\n" +
                "* 1. If you're playing first, claim a corner spot instead of the center spot.\n" +
                "* 2. If you're playing second, claim the center segment if the first player did not,\n " +
                "claim a corner spot if the first player claimed the center segment.", "Tips", JOptionPane.INFORMATION_MESSAGE);
    }
}
