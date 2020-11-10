package com.uwbothell.softwaremanagement;

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
        
        windowObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowObject.setBounds(300, 200, 300, 300);
        NorthPanel();
        CenterPanel();
        
        Main C = new Main();
        C.SouthPanel();
        
 
        
        windowObject.add(NorthPanel, BorderLayout.NORTH);
        windowObject.add(centerPanel, BorderLayout.CENTER);
        windowObject.add(southPanel, BorderLayout.SOUTH);
        windowObject.setVisible(true);
    }
    

    public static void NorthPanel() {
     	
   	 statusBar = new JLabel();    
        statusBar.setText("Player " + PlayerTurn + " Turn");
        NorthPanel.add(statusBar);
        
	}
    
    public static void CenterPanel() {
		
   centerPanel.add(new TicTacToePanel());
   }
	
   
   private void SouthPanel() {
   	

       southPanel.add( x = new JButton("Restart"));
       x.setPreferredSize(new Dimension(100, 20));
       southPanel.setPreferredSize(new Dimension(100, 40));
       x.addActionListener(new ButtonListener(this));
    }
    
    
}
