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

    public GridButtonListener(JButton button, int buttonID, GameController controller, GridModel gridModel){
        this.controller = controller;
        this.button = button;
        this.buttonID = buttonID;
        this.gridModel = gridModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model = controller.getModel();

        if(button.getText().length()>0){
            // pop up error or do nothing
            System.out.println("grid occupied");
        }
        else if(model.currentTurn == TicTacToeObj.PLAYER_ONE) {
            String buttonText = gridModel.getPlayerOneIcon();
            this.button.setText(buttonText);

            if(buttonText.length()>1){
                conpressPic(buttonText);
            }else this.button.setText(buttonText);

            model.currentTurn = TicTacToeObj.PLAYER_TWO;
            model.setValue(buttonID, TicTacToeObj.CROSS);
        }
        else {
            String buttonText = gridModel.getPlayerTwoIcon();
            this.button.setText(buttonText);
            if(buttonText.length()>1){
                conpressPic(buttonText);
            }else this.button.setText(buttonText);

            model.currentTurn = TicTacToeObj.PLAYER_ONE;
            model.setValue(buttonID, TicTacToeObj.CIRCLE);
        }
        controller.updatePlayerIndicator(gridModel);
        controller.checkWinner(gridModel);
        controller.resetClock();
    }

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
