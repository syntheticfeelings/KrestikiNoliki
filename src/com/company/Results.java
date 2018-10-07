package com.company;

import java.io.Serializable;
import java.util.Arrays;

public class Results implements Serializable {
    String[][] board;
    Player[] players;
    String winner;

    public Results(String[][] board, Player[] players, String winner) {
        this.board = board;
        this.players = players;
        this.winner = winner;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(players) +
                ", winner='" + '\'' + winner + '\'' +
                '}';
    }
}
