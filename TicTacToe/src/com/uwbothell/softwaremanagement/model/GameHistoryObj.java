package com.uwbothell.softwaremanagement.model;

import java.io.*;
import java.util.HashMap;

public class GameHistoryObj {


    private HashMap<String, int[]> gameData = new HashMap<String, int[]>();

    public GameHistoryObj(String fileName) throws Exception {
        this.gameData = generateGameData(fileName);
    }

    public int[] getGameHistory(String playerOne, String playerTwo) {
        int[] history = gameData.get(playerOne + " & " + playerTwo);
        if(history==null)
            history=new int[3];
        return history;
    }


    private HashMap<String, int[]> generateGameData(String fileName) throws Exception {

        try {
            HashMap<String, int[]> history = new HashMap<String, int[]>();
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = br.readLine()) != null) {

                String[] arr = line.trim().split("=");

                String[] stringScores = arr[1].trim().split(",");
                int[] intArr = new int[stringScores.length];

                for (int j = 0; j < intArr.length; j++) {
                    try {
                        intArr[j] = Integer.parseInt(stringScores[j]);

                    } catch (NumberFormatException nfe) {
                        throw nfe;

                    }
                }

                history.put(arr[0].toString(), intArr);
            }

            return history;

        }catch (FileNotFoundException fnfe){
            FileManager.createFile();
            return new HashMap<String, int[]>();
        }
    }
}
