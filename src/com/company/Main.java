package com.company;

import java.util.Scanner;

public class Main {
    private static Board board = new Board();
    private static Player[] players = new Player[2];
    static Scanner scanner = new Scanner(System.in);
    private static boolean onGame = true;

    public static void main(String[] args) {
        System.out.println("ИГРА = 1");
        System.out.println("ИСТОРИЯ = 2");
        System.out.println("ВЫХОД = 3");
        int select = scanner.nextInt();
        if (select == 3) {
            System.exit(0);
        }
        if (select == 2) {
            Dao.printScores();
        }
        if (select == 1) {
            System.out.println("SELECT NAME: ");
            System.out.println("PLAYER 1 : ");
            String name1 = scanner.nextLine();
            players[0] = new Player(name1, "X");
            Board.players[0] = players[0];

            System.out.println("PLAYER 2");
            String name2 = scanner.nextLine();
            players[1] = new Player(name2, "O");
            Board.players[1] = players[1];
            board.printBoard();

            while (onGame) {
                for (Player player : players) {
                    for (Player player1 : players) {
                        if (board.checkWins(player1)) {
                            onGame = false;
                            return;
                        }
                    }
                    System.out.println("Сделайте свой ход : " + player.getName() + " " + player.getElement());
                    int i = scanner.nextInt();
                    int j = scanner.nextInt();
                    board.board[i][j + 1] = player.getElement();
                    board.printBoard();

                }
            }
            Dao.writeToFile(Dao.scores);
        }

    }

}
