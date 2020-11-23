package com.uwbothell.softwaremanagement;

import com.uwbothell.softwaremanagement.controller.GameController;
import com.uwbothell.softwaremanagement.model.GameHistoryObj;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;
import com.uwbothell.softwaremanagement.view.GameView;
import com.uwbothell.softwaremanagement.view.StartFrame;
import com.uwbothell.softwaremanagement.view.TicTacToePanel;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main extends JFrame {
    
    static  JFrame  windowObject = new JFrame("Lets Play... TIC TAC TOE");
	static JPanel NorthPanel = new JPanel();
	static  JPanel southPanel = new JPanel();
	static JPanel centerPanel = new JPanel();
	public  static  JButton x ;
	public static  JLabel statusBar;
	public static String PlayerTurn = "X";
    final static String gameDataFile = "GameData.txt";
    
    public static void main(String[] args) {
        // write your code here
        try {
            TicTacToeObj model = new TicTacToeObj();
            GameHistoryObj gameData= new GameHistoryObj(gameDataFile);
            GameView view = new GameView(gameData);
            StartFrame startView = new StartFrame(view);

            GameController controller = new GameController(view, model, startView, gameData);
        }catch (FileNotFoundException fnfe) {
            System.err.println(gameDataFile + " file not found !!");
        }catch (Exception e){

        }
    }
}
