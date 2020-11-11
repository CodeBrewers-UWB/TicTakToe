package com.uwbothell.softwaremanagement.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonListener implements ActionListener {

    GameController controller;

    public ResetButtonListener(GameController controller){
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.resetGame();
    }
}
