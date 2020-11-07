package com.uwbothell.softwaremanagement;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

// UI control grab this object
// Use the container for init / update of the UI
public class TicTacToeObj {
    public static final String EMPTY = "";
    public static final String CROSS = "X";
    public static final String CIRCLE = "O";

    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int GAME_IN_PROGRESS = 0;

    private JButton[] container;
    private Map<JButton, Integer> buttonPosition;
    private int currentTurn;

    public TicTacToeObj(){
        container = new JButton[9];
        buttonPosition = new HashMap<>();
        currentTurn = PLAYER_ONE;
        initContainer();
    }

    //pull this object to UI for rendering the graphic
    public TicTacToeObj getTicTacToeObj(){
        return this;
    }

    private void initContainer() {
        for (int index = 0; index < 9; index++) {
            container[index] = new JButton();
            container[index].setText(EMPTY);
            container[index].addActionListener(new ButtonListener(this));
            buttonPosition.putIfAbsent(container[index], index);
        }
    }

    public JButton[] getFullGrid(){
        return container;
    }

    public Map<JButton, Integer> getButtonPosition() {
        return this.buttonPosition;
    }

    public void resetGame(){
        initContainer();
    }

    // set value in the container
    // input has to be either EMPTY, CIRCLE, CROSS
    // Need to use the player variable
    public void setValue(int index, String input) throws IOException {
        if(input != EMPTY || input != CIRCLE || input != CROSS){
            throw new IOException("wrong input for set value method");
        }

        container[index].setText(input);
    }

    // Please implement the logic of checking the winner
    public boolean isGameOver(String winner){
        return winner.equals(TicTacToeObj.CROSS) || winner.equals(TicTacToeObj.CIRCLE);
    }

    public int getWinner(String winner) {
        if (winner.equals(TicTacToeObj.CROSS)) {
            return PLAYER_ONE;
        }
        else if (winner.equals(TicTacToeObj.CIRCLE)) {
            return PLAYER_TWO;
        }
        else {
            return GAME_IN_PROGRESS;
        }
    }

    //check if it is tie(no outcome possible), if it's tie should end the game.
    //it has two situations: get tie before the grid is full and get tie when the grid is full.
    //need to call isGameOver first, if no winner then check if it is a tie.
     boolean isTie() {
        int countEmpty = 0;
        for (JButton button : container) {
            if (button.getText().equals(EMPTY)) countEmpty++;
        }

        if (countEmpty == 0) return true; // grid is full,  it's tie.
        if (countEmpty > 1) return false; //when there is more than 1 empty, must not be a tie.

        //one empty, check if it's tie on its row, col and diagonals.
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if (container[i].getText().equals(EMPTY)) {
                index = i;
                break;
            }
        }

        int row = index / 3;
        int col = index % 3;
        int rowSum = 0;
        int colSum = 0;

        for (int i = row; i < row + 3; i++) {
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

        if (rowSum == 3 || colSum == 3 || diagonalSum1 == 3 || diagonalSum2 == 3) return true;

        return false;
    }
}
