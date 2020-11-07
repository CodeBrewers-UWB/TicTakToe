package com.uwbothell.softwaremanagement;

import java.awt.GridLayout;
import javax.swing.*;

public class TicTacToePanel extends JPanel {
    private TicTacToeObj ticTakToeObj;

    public TicTacToePanel() {
        ticTakToeObj = new TicTacToeObj();

        // Set the grid layout to 3 X 3
        setLayout(new GridLayout(3, 3));

        // Pull the container from ticTakToeObj to render in the grid
        JButton[] container = ticTakToeObj.getFullGrid();

        for (int index = 0; index < 9 ; index ++) {

            // call add method in JPanel to add every button in container to grid
            this.add(container[index]);
        }
    }
}
