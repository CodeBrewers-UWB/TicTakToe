package com.uwbothell.softwaremanagement.model;

public class GridModel {
    private static final String EMPTY_TEXT = "";

    private String playerOneName;
    private String playerTwoName;
    private String playerOneIcon;
    private String playerTwoIcon;
    private int playerOneWins;
    private int playerTwoWins;
    private int draw;



    public GridModel(String playerOneName, String playerTwoName, String playerOneIcon, String playerTwoIcon) {
        this.playerOneIcon = playerOneIcon;
        this.playerTwoIcon = playerTwoIcon;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getEmptyText() {
        return EMPTY_TEXT;
    }

    public String getPlayerOneIcon() {
        return playerOneIcon;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoIcon() {
        return playerTwoIcon;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setHistory(int[] score){
        this.playerOneWins=score[0];
        this.playerTwoWins=score[1];
        this.draw=score[2];

    }

    public int[] getHistory(){
        return new int[]{playerOneWins,playerTwoWins,draw};
    }

    public void updateHistory(int winner){

        if(winner==1)
            playerOneWins++;
        else if(winner==2)
            playerTwoWins++;
        else
            draw++;

    }


    public int getPlayerOneWins() {
        return playerOneWins;
    }

    public int getPlayerTwoWins() {
        return playerTwoWins;
    }

    public int getDraw() {
        return draw;
    }
}
