package com.uwbothell.softwaremanagement.model;

public class StartGameFrameSetting {
    private static int labelXBounds = 50;
    private static int yBounds = 280;
    private static int labelWidth = 100;
    private static int labelHeight = 30;
    private static int yOffset = 70;

    private static int textFieldWidth = 150;
    private static int textFieldXBounds = 150;

    private static String labelOneText = "PLAYER 1";
    private static String labelTwoText = "PLAYER 2";
    private static String comboBox1LabelText = "PLAYER 1 ICON";
    private static String comboBox2LabelText = "PLAYER 2 ICON";

    private static String startGameTitle = "START GAME";
    private static String startButtonText = "START";
    private static String icons[]={"X","O","*","\uF0C6", "custom"};
    private static String PlaywithcomButtonText = "Play with Computer";

    public static int getLabelXBounds() {
        return labelXBounds;
    }

    public static String getComboBox1LabelText() {
        return comboBox1LabelText;
    }

    public static String getComboBox2LabelText() {
        return comboBox2LabelText;
    }

    public static int getyBounds() {
        return yBounds;
    }

    public static int getLabelWidth() {
        return labelWidth;
    }

    public static int getLabelHeight() {
        return labelHeight;
    }

    public static int getyOffset() {
        return yOffset;
    }

    public static int getTextFieldWidth() {
        return textFieldWidth;
    }

    public static int getTextFieldXBounds() {
        return textFieldXBounds;
    }

    public static String getLabelOneText() {
        return labelOneText;
    }

    public static String getLabelTwoText() {
        return labelTwoText;
    }

    public static String getStartGameTitle() {
        return startGameTitle;
    }
    
    public static String getPlaywithcomButtonText() 
    {	
    	return PlaywithcomButtonText;
    }

    public static String getStartButtonText() {
        return startButtonText;
    }

    public static String[] getIcons() {
        return icons;
    }
}
