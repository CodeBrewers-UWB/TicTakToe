package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.view.CenterPanel;
import com.uwbothell.softwaremanagement.view.TicTacToePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipsButtonListener implements ActionListener {
    GameController controller;


    public TipsButtonListener(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String generalTips =  "* 1. If you're playing first, claim a corner spot instead of the center spot.\n" +
                "* 2. If you're playing second, claim the center segment if the first player did not,\n " +
                "claim a corner spot if the first player claimed the center segment.\n ";

        Object[] options = {"Yes, please", "No, thanks"};
        int n = JOptionPane.showOptionDialog(null, "\n" + generalTips + "\n" +
                "Do you want a further hint?", "Tips", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (n == JOptionPane.YES_OPTION) {
            int nextMove = controller.getTips();
            System.out.println(nextMove);
            controller.highlightButton(nextMove);
        }
    }


}
