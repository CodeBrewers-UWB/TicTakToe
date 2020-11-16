package com.uwbothell.softwaremanagement.model;

public class GridModel {
    private static final String EMPTY_TEXT = "";

    private String playerOneName;
    private String playerTwoName;
    private String playerOneIcon;
    private String playerTwoIcon;

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
}
