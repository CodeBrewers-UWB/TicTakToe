package com.uwbothell.softwaremanagement;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        JFrame windowObject = new JFrame("Lets Play... TIC TAC TOE");
        windowObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowObject.getContentPane().add(new TicTacToe() , "Center");
        windowObject.getContentPane().add(new JButton("Restart") , "South");
        
        windowObject.setBounds(300, 200, 300, 300);
        windowObject.setVisible(true);
    }
}
