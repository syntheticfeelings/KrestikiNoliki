package com.company;

import java.io.Serializable;

public class Board implements Serializable {

    private static Results results;
    public static Player[] players = new Player[2];
    public static String[][] board = {
            {"*", "|", "1", "2", "3"},
            {"1", "|", "-", "-", "-"},
            {"2", "|", "-", "-", "-"},
            {"3", "|", "-", "-", "-"}
    };


    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length + 1; j++) {
                System.out.print(" ");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean checkWins(Player player) {
        int res = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 2; j < board.length + 1; j++) {
                if (board[i][j].contains(player.getElement())) {
                    res++;
                    if (res == 3) {
                        System.out.println("Player :" + player.getName() + " WIN");
                        String winner = "Winner is : " + player.getName();
                        Dao.scores.add(new Results(board, players, winner));
                        Dao.writeToFile(Dao.scores);
                        return true;
                    }
                }
            }
            res = 0;
        }
        for (int k = 2; k < board.length + 1; k++) {
            for (int l = 1; l < board.length; l++) {
                if (board[l][k].contains(player.getElement())) {
                    res++;
                    if (res == 3) {
                        System.out.println("Player :" + player.getName() + " WIN");
                        String winner = "Winner is : " + player.getName();
                        Dao.scores.add(new Results(board, players, winner));
                        Dao.writeToFile(Dao.scores);
                        return true;
                    }
                }
            }
            res = 0;
        }
        return false;
    }
}
