package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Dao {
    static ArrayList<Results> scores = new ArrayList<>();

    static void printScores() {
        for (Results results : scores) {
            System.out.println(results);
            for (int i = 0; i < results.board.length; i++) {
                for (int j = 0; j < results.board.length + 1; j++) {
                    System.out.print(" ");
                    System.out.print(results.board[i][j]);
                }
                System.out.println();
            }
        }
    }

    static {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/antn/IdeaProjects/KrestikiNoliki/src/com/company/score.dat"))) {
            scores = (ArrayList<Results>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(ArrayList<Results> scores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/antn/IdeaProjects/KrestikiNoliki/src/com/company/score.dat"))) {
            oos.writeObject(scores);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
