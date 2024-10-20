package com.example;

import java.util.Scanner;

public class Game {
    private final Tabla tabla;
    private final Jatekos player1;
    private final Jatekos player2;
    private Jatekos currentPlayer;

    public Game(String player1Name, String player2Name) {
        tabla = new Tabla();
        player1 = new Jatekos(player1Name, 'Y'); // Sárga játékos
        player2 = new Jatekos(player2Name, 'R'); // Piros játékos
        currentPlayer = player1; // Sárga játékos kezd
    }

    // Játék elindítása
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon) {
            tabla.printBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getPiece() + "), válassz egy oszlopot (0-6): ");
            int col = scanner.nextInt();

            if (tabla.dropPiece(col, currentPlayer.getPiece())) {
                if (tabla.checkWin(currentPlayer.getPiece())) {
                    tabla.printBoard();
                    System.out.println(currentPlayer.getName() + " nyert!");
                    gameWon = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Érvénytelen lépés, próbáld újra.");
            }
        }

        scanner.close();
    }

    // Játékos váltás
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Add meg az első játékos nevét: ");
        String player1Name = scanner.nextLine();
        System.out.print("Add meg a második játékos nevét: ");
        String player2Name = scanner.nextLine();

        Game game = new Game(player1Name, player2Name);
        game.start();
    }
}
