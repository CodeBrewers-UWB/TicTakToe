package com.uwbothell.softwaremanagement;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;
import com.uwbothell.softwaremanagement.view.GameView;
import com.uwbothell.softwaremanagement.view.TicTacToePanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    
    static  JFrame  windowObject = new JFrame("Lets Play... TIC TAC TOE");
	static JPanel NorthPanel = new JPanel();
	static  JPanel southPanel = new JPanel();
	static JPanel centerPanel = new JPanel();
	public  static  JButton x ;
	public static  JLabel statusBar;
	public static String PlayerTurn = "X";
    
    public static void main(String[] args) {
        // write your code here

        TicTacToeObj model = new TicTacToeObj();
        GameView view = new GameView();
        GameController controller = new GameController(view, model);
    }
}
