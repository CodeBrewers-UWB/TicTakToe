package com.uwbothell.softwaremanagement;


import java.io.IOException;


// UI control grab this object
// Use the container for init / update of the UI
public class TicTacToeObj {
    public static final  int EMPTY = 0;
    public static  int CROSS = 1;
    public static  int  CIRCLE= 2;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;

    private int[] container;
    private int currentTurn;

    public TicTacToeObj(){
        container = new int[9];
        currentTurn = PLAYER_ONE;
        initContainer();
    }

    //pull this object to UI for rendering the graphic
    public TicTacToeObj getTicTacToeObj(){
        return this;
    }

    private void initContainer(){
        for(int i: container){
            i = EMPTY;
        }
    }
    public int[] getFullGrid(){
        return  container;
    }

    private void resetGame(){
        initContainer();
    }

    //set value in the container
    // input has to be either EMPTY, CIRCLE, CROSS
    // Need to use the player variable
    private void setValue(int index, int input) throws IOException {
        if(input != EMPTY || input != CIRCLE || input != CROSS){
            throw new IOException("wrong input for set value method");
        }

    }

    // Please implement the logic of checking the winner
    boolean isGameOver(){
        return true;
    }

    // just check if all grid is full
    boolean isGridFull(){
        return true;
    }
}
