package com.uwbothell.softwaremanagement.model;


import com.uwbothell.softwaremanagement.Main;
import com.uwbothell.softwaremanagement.controller.GridButtonListener;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// UI control grab this object
// Use the container for init / update of the UI
public class TicTacToeObj {
    public static final  int EMPTY = 0;
    public static int CROSS = 1;
    public static int  CIRCLE= 2;

    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int GAME_IN_PROGRESS = 0;

    public int[] container;

    public int currentTurn;

    public TicTacToeObj(){
        container = new int[9];
        currentTurn = PLAYER_ONE;
        initContainer();
    }

    public void initContainer(){
        // Initialize container (wrapper for buttons)
        Arrays.fill(container, EMPTY);
    }

    public int[] getContainer(){
        return container;
    }

    //set value in the container
    // input has to be either EMPTY, CIRCLE, CROSS
    // Need to use the player variable
    public void setValue(int index, int input){
        container[index] = input;
    }
}
