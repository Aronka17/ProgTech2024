package com.example;

public class Tabla {
    private final char[][] tabla;
    private final int ROWS = 6;
    private final int COLS = 7;

    public Tabla() {
        tabla = new char[ROWS][COLS];
        initializeBoard();
    }


    public void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                tabla[i][j] = '.';
            }
        }
    }


    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean dropPiece(int col, char playerPiece) {
        if (col < 0 || col >= COLS) {
            return false;
        }
        for (int row = ROWS - 1; row >= 0; row--) {
            if (tabla[row][col] == '.') {
                tabla[row][col] = playerPiece;
                return true;
            }
        }
        return false;
    }


    public boolean checkWin(char playerPiece) {

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (tabla[row][col] == playerPiece && tabla[row][col + 1] == playerPiece &&
                        tabla[row][col + 2] == playerPiece && tabla[row][col + 3] == playerPiece) {
                    return true;
                }
            }
        }

        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS; col++) {
                if (tabla[row][col] == playerPiece && tabla[row + 1][col] == playerPiece &&
                        tabla[row + 2][col] == playerPiece && tabla[row + 3][col] == playerPiece) {
                    return true;
                }
            }
        }

        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (tabla[row][col] == playerPiece && tabla[row - 1][col + 1] == playerPiece &&
                        tabla[row - 2][col + 2] == playerPiece && tabla[row - 3][col + 3] == playerPiece) {
                    return true;
                }
            }
        }

        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (tabla[row][col] == playerPiece && tabla[row + 1][col + 1] == playerPiece &&
                        tabla[row + 2][col + 2] == playerPiece && tabla[row + 3][col + 3] == playerPiece) {
                    return true;
                }
            }
        }
        return false;
    }
}
