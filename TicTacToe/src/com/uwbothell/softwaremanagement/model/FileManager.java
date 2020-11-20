package com.uwbothell.softwaremanagement.model;

import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class FileManager {
    public static void createFile() {
        try {
            File myObj = new File("GameData.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void saveData(String playerOne, String playerTwo, int winner) {
        try {
            FileWriter myWriter = new FileWriter("GameData.txt");
            int[] score=gameScore(winner);
            myWriter.write(playerOne+ " & "+ playerTwo +"="+score[0]+","+ score[1]+","+ score[2]);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static int[] gameScore(int winner){

        int[] score= new int[3];
        if(winner==1)
            score[0]=1;
        else if(winner==2)
            score[1]=1;
        else
            score[2]=1;
        return score;
    }
}