package com.example;

import java.util.Scanner;

public class Connect4 {

    private final char[][] board;
    private final int ROWS = 6;
    private final int COLS = 7;
    private char currentPlayer;

    public Connect4() {
        board = new char[ROWS][COLS];
        initializeBoard();
        currentPlayer = 'Y';
    }


    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '.';
            }
        }
    }


    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean dropPiece(int col) {
        if (col < 0 || col >= COLS) {
            System.out.println("Érvénytelen oszlop.");
            return false;
        }
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == '.') {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        System.out.println("Az oszlop tele van.");
        return false;
    }


    public boolean checkWin() {

        return false;
    }


    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'Y') ? 'R' : 'Y';
    }


    public static void main(String[] args) {
        Connect4 game = new Connect4();
        Scanner scanner = new Scanner(System.in);

        boolean gameWon = false;
        while (!gameWon) {
            game.printBoard();
            System.out.println("Játékos " + game.currentPlayer + ", válassz egy oszlopot (0-6): ");
            int col = scanner.nextInt();

            if (game.dropPiece(col)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Játékos " + game.currentPlayer + " nyert!");
                    gameWon = true;
                } else {
                    game.switchPlayer();
                }
            }
        }

        scanner.close();
    }
}
