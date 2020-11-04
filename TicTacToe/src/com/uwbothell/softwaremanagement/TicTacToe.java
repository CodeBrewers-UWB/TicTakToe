package com.uwbothell.softwaremanagement;

import java.awt.GridLayout;
import javax.swing.*;

public class TicTacToe extends JPanel {
    JButton[] buttons = new JButton[9];

    public TicTacToe() {
        setLayout(new GridLayout(3, 3));

        for (int index = 0; index < 9; index++) {
            buttons[index] = new JButton();
            buttons[index].setText("");
            add(buttons[index]);
        }
    }
}
