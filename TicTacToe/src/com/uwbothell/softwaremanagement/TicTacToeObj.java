package com.uwbothell.softwaremanagement;


import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


// UI control grab this object
// Use the container for init / update of the UI
public class TicTacToeObj {
    public static final  int EMPTY = 0;
    public static int CROSS = 1;
    public static int  CIRCLE= 2;

    public static final String EMPTY_TEXT = "";
    public static final String CROSS_TEXT = "X";
    public static final String  CIRCLE_TEXT = "O";

    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int GAME_IN_PROGRESS = 0;

    private int[] container;
    private JButton[] buttons;
    private Map<JButton, Integer> buttonPosition;

    private int currentTurn;

    public TicTacToeObj(){
        container = new int[9];
        buttons = new JButton[9];
        buttonPosition = new HashMap<>();
        currentTurn = PLAYER_ONE;
        initContainer();
    }

    //pull this object to UI for rendering the graphic
    public TicTacToeObj getTicTacToeObj(){
        return this;
    }

    private void initContainer(){

        // Initialize container (wrapper for buttons)
        for(int i: container){
            i = EMPTY;
        }

        // Initialize Buttons
        for (int index = 0; index < 9; index++) {
            buttons[index] = new JButton();
            buttons[index].setText(EMPTY_TEXT);
            buttons[index].addActionListener(new ButtonListener(this));
            buttonPosition.putIfAbsent(buttons[index], index);
        }
    }

    public int[] getFullGrid(){
        return  container;
    }

    public JButton[] getButtons(){
        return buttons;
    }

    public Map<JButton, Integer> getButtonPosition() {
        return this.buttonPosition;
    }

    public void resetGame() {
        // Set all values in container to EMPTY
        // All button text to EMPTY_TEXT
        
        Main.centerPanel.removeAll();
  		Main.centerPanel.revalidate();
  		Main.centerPanel.repaint();
  		Main.CenterPanel();

    }

    //set value in the container
    // input has to be either EMPTY, CIRCLE, CROSS
    // Need to use the player variable
    public void setValue(int index, int input) throws IOException {
        if(input != EMPTY && input != CIRCLE && input != CROSS){
            throw new IOException("wrong input for set value method");
        }
        container[index] = input;

        // Set the corresponding text for button as well
        setButtonText(index, input);
    }

    private void setButtonText(int index, int input) {
        if (input == EMPTY) {
            buttons[index].setText(EMPTY_TEXT);
            return;
        }
        if (input == CIRCLE) {
            buttons[index].setText(CIRCLE_TEXT);
            return;
        }
        if (input == CROSS) {
            buttons[index].setText(CROSS_TEXT);
            return;
        }
    }

    // Please implement the logic of checking the winner
    public boolean isGameOverWithWinner(int winner){
        return winner == TicTacToeObj.CROSS || winner == TicTacToeObj.CIRCLE;
    }

    public int getWinner(int winner) {
        if (winner == TicTacToeObj.CROSS) {
            return PLAYER_ONE;
        }
        else if (winner == TicTacToeObj.CIRCLE) {
            return PLAYER_TWO;
        }
        else {
            return GAME_IN_PROGRESS;
        }
    }

    //check if it is tie(no outcome possible), if it's tie should end the game.
    //it has two situations: get tie before the grid is full and get tie when the grid is full.
    //need to call isGameOver first, if no winner then check if it is a tie.
    boolean isGameOverWithTie() {
        int countEmpty = 0;
        for (int n : container) {
            if (n == EMPTY) countEmpty++;
        }

        if (countEmpty == 0) return true; // grid is full,  it's tie.
        if (countEmpty > 1) return false; //when there is more than 1 empty, must not be a tie.

        //one empty, check if it's tie on its row, col and diagonals.
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if (container[i] == EMPTY) {
                index = i;
                break;
            }
        }

        int row = index / 3;
        int col = index % 3;
        int rowSum = 0;
        int colSum = 0;

        for (int i = 3 *row; i < 3 * row + 3; i++) {
            rowSum += container[i];
        }

        for (int i = col; i <= col + 6; i += 3) {
            colSum += container[i];
        }

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        if (index == 0 || index == 4 || index == 8) {
            diagonalSum1 = container[0] + container[4] + container[8];
        }

        if (index == 2 || index == 4 || index == 6) {
            diagonalSum2 = container[2] + container[4] + container[6];
        }

        if (rowSum == 3 && colSum == 3 && (diagonalSum1 == 0 || diagonalSum1 == 3) && (diagonalSum2 == 3 || diagonalSum2 == 0)) return true;

        return false;
    }
}
