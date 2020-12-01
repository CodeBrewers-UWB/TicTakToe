package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.model.GridModel;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GridButtonListener implements ActionListener {
    TicTacToeObj model;
    JButton button;
    int buttonID;
    GameController controller;
    GridModel gridModel;
    int ClickonPlaywithComputer= PlaywithcomListener.ClickonPlaywithComputer;
    JButton button2;
    int randomNumber;
    Random random = new Random();

    public GridButtonListener(JButton button, int buttonID, GameController controller, GridModel gridModel){
        this.controller = controller;
        this.button = button;
        this.buttonID = buttonID;
        this.gridModel = gridModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (ClickonPlaywithComputer == 1) 
    	{
    	
    	 
            model = controller.getModel();

            if(button.getText().length()>0){
                // pop up error or do nothing
                System.out.println("grid occupied");
            }
          
            else {          
            	String buttonText = gridModel.getPlayerOneIcon();
            this.button.setText(buttonText);
            model.setValue(buttonID, TicTacToeObj.CROSS);


        int c = random.nextInt(8);
        
        for(int i =0 ; i <= TicTacToeObj.container.length ; i++) 
    	{
    		if (TicTacToeObj.container[c] == 1 || TicTacToeObj.container[c] == 2) 
    		{
    			c= random.nextInt(8);
    		}
    		else 
    		{
    	        
                button2 = TicTacToePanel.buttons[c];
                
                if(button2.getText().length()>0){
                    // pop up error or do nothing
                    System.out.println("grid occupied");
                }
                String buttonText2 = gridModel.getPlayerTwoIcon();
    		     
                this.button2.setText(buttonText2);
    	             model.setValue(c, TicTacToeObj.CIRCLE);
    	             
                    controller.checkWinner(gridModel);
                    controller.resetClock();	
    			break;
    		}
    	
    	}
        
        controller.checkWinner(gridModel);
        controller.resetClock();
        
        }
 
    	

    	}
        else {
        model = controller.getModel();

        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);
        if(button.getText().length()>0){
            // pop up error or do nothing
            System.out.println("grid occupied");
        }
        else if(model.currentTurn == TicTacToeObj.PLAYER_ONE) {
            String buttonText = gridModel.getPlayerOneIcon();
//            this.button.setText(buttonText);

            if(buttonText.length()>1){
                conpressPic(buttonText);
            }else if (buttonText.equals("X")){

                String tempFileName = filePath.concat("\\TicTacToe\\src\\com\\uwbothell\\softwaremanagement\\resources\\X.jpg");
//                System.out.println(tempFileName);
                conpressPic (tempFileName);
            }else if (buttonText.equals("O")){
                String tempFileName = filePath.concat("\\TicTacToe\\src\\com\\uwbothell\\softwaremanagement\\resources\\O.jpg");

                conpressPic (tempFileName);
            }else this.button.setText(buttonText);

            model.currentTurn = TicTacToeObj.PLAYER_TWO;
            model.setValue(buttonID, TicTacToeObj.CROSS);
        }
        else {
            String buttonText = gridModel.getPlayerTwoIcon();
//            this.button.setText(buttonText);
            if(buttonText.length()>1){
                conpressPic(buttonText);
            }else if (buttonText.equals("X")){

                String tempFileName = filePath.concat("\\TicTacToe\\src\\com\\uwbothell\\softwaremanagement\\resources\\X.jpg");
//                System.out.println(tempFileName);
                conpressPic (tempFileName);
            }else if (buttonText.equals("O")){
                String tempFileName = filePath.concat("\\TicTacToe\\src\\com\\uwbothell\\softwaremanagement\\resources\\O.jpg");

                conpressPic (tempFileName);
            }else this.button.setText(buttonText);

            model.currentTurn = TicTacToeObj.PLAYER_ONE;
            model.setValue(buttonID, TicTacToeObj.CIRCLE);
        }
        controller.updatePlayerIndicator(gridModel);
        controller.checkWinner(gridModel);
        controller.resetClock();
    }}

    private void conpressPic(String path){
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File(path));

        } catch (IOException err) {
            err.printStackTrace();
        }
        BufferedImage newImage = new BufferedImage(80,80, BufferedImage.TYPE_INT_RGB);

        Graphics g = newImage.createGraphics();
        g.drawImage(pic, 0, 0, 80, 80, null);
        g.dispose();

        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        this.button.add(picLabel);
    }
}
