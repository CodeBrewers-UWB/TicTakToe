package com.uwbothell.softwaremanagement.controller;

import com.uwbothell.softwaremanagement.model.GridModel;
import com.uwbothell.softwaremanagement.model.TicTacToeObj;
import com.uwbothell.softwaremanagement.view.CenterPanel;
import com.uwbothell.softwaremanagement.view.GameView;
import com.uwbothell.softwaremanagement.view.StartFrame;
import com.uwbothell.softwaremanagement.view.NorthPanel;

import javax.swing.*;

public class GameController {
    GameView gameView;
    StartFrame startFrame;
    TicTacToeObj model;

    public GameController(GameView gameView, TicTacToeObj model, StartFrame startFrame) {
        this.gameView = gameView;
        this.model = model;
        this.startFrame = startFrame;
        startFrame.setGameController(this);
        gameView.setController(this);
        initGame();
    }

    public void initGame() {
        startFrame.start(this.startFrame);
        //gameView.init();
    }

    public void resetGame() {
        CenterPanel centralPanel = (CenterPanel) gameView.getCentralPanel();
        centralPanel.removeAll();
        centralPanel.revalidate();
        centralPanel.repaint();
        centralPanel.resetPanel();
        model.initContainer();
    }

    public StartFrame getStartFrame() {
        return this.startFrame;
    }

    public TicTacToeObj getModel() {
        return model;
    }

    public void updatePlayerIndicator(GridModel gridModel) {
        NorthPanel panel = (NorthPanel) gameView.getNorthPanel();
        String symbol = model.currentTurn == TicTacToeObj.PLAYER_ONE ? gridModel.getPlayerOneName() : gridModel.getPlayerTwoName();
        String label = "Player " + symbol + " Turn";
        panel.setLabelText(label);
    }

    public void checkWinner(GridModel gridModel) {
        int winner = 0;

        int[] container = model.container;

        if (threeEqual(container[0], container[1], container[2]))
            winner = container[0];

        if (threeEqual(container[3], container[4], container[5]))
            winner = container[3];

        if (threeEqual(container[6], container[7], container[8]))
            winner = container[6];

        if (threeEqual(container[0], container[3], container[6]))
            winner = container[0];

        if (threeEqual(container[1], container[4], container[7]))
            winner = container[1];

        if (threeEqual(container[2], container[5], container[8]))
            winner = container[2];

        if (threeEqual(container[0], container[4], container[8]))
            winner = container[0];

        if (threeEqual(container[2], container[4], container[6]))
            winner = container[2];


        if (isGameOverWithWinner(winner)) {
            // Winner is decided so game ends
            String winningMessage = "Congratulations Player " + getWinner(winner, gridModel) + " Won!";
            JOptionPane.showConfirmDialog(null, winningMessage);
            resetGame();
        } else if (isGameOverWithTie()) {
            //game is Tie so game ends
            String tieMessage = "Game Over. No Winner.";
            JOptionPane.showConfirmDialog(null, tieMessage);
            resetGame();
        }
    }

    private boolean threeEqual(int a, int b, int c) {
        boolean isEqual = false;

        if (a != 0 && a == b && a == c)
            isEqual = true;

        return isEqual;
    }

    public boolean isGameOverWithWinner(int winner) {
        return winner == TicTacToeObj.CROSS || winner == TicTacToeObj.CIRCLE;
    }

    public String getWinner(int winner, GridModel gridModel) {
        if (winner == TicTacToeObj.CROSS) {
            return gridModel.getPlayerOneName();
        } else if (winner == TicTacToeObj.CIRCLE) {
            return gridModel.getPlayerTwoName();
        } else {
            return gridModel.getEmptyText();
        }
    }

    //check if it is tie(no outcome possible), if it's tie should end the game.
    //it has two situations: get tie before the grid is full and get tie when the grid is full.
    //need to call isGameOver first, if no winner then check if it is a tie.
    boolean isGameOverWithTie() {
        int[] container = model.getContainer();

        int countEmpty = 0;
        for (int n : container) {
            if (n == TicTacToeObj.EMPTY) countEmpty++;
        }

        if (countEmpty == 0) return true; // grid is full,  it's tie.
        if (countEmpty > 1) return false; //when there is more than 1 empty, must not be a tie.

        //one empty, check if it's tie on its row, col and diagonals.
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if (container[i] == TicTacToeObj.EMPTY) {
                index = i;
                break;
            }
        }

        int row = index / 3;
        int col = index % 3;
        int rowSum = 0;
        int colSum = 0;

        for (int i = 3 * row; i < 3 * row + 3; i++) {
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

        if (rowSum == 3 && colSum == 3 && (diagonalSum1 == 0 || diagonalSum1 == 3) && (diagonalSum2 == 3 || diagonalSum2 == 0))
            return true;

        return false;
    }
}
