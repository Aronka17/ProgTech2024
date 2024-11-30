package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game {
    private final Tabla tabla;
    private final Jatekos player1;
    private final Jatekos player2;
    private Jatekos currentPlayer;

    public Game(String player1Name, String player2Name) {
        tabla = new Tabla();
        player1 = new Jatekos(player1Name, 'Y');
        player2 = new Jatekos(player2Name, 'X');
        currentPlayer = player1;
    }

    public Jatekos getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void saveGame(String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(currentPlayer.getName());
            writer.println(currentPlayer.getPiece());
            writer.println(tabla.serialize());
        } catch (IOException e) {
            System.out.println("Hiba a játék mentése során: " + e.getMessage());
        }
    }

    public void loadGame(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String playerName = reader.readLine();
            char playerPiece = reader.readLine().charAt(0);
            currentPlayer = (player1.getName().equals(playerName)) ? player1 : player2;
            StringBuilder tablaData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                tablaData.append(line).append("\n");
            }
            tabla.deserialize(tablaData.toString().trim());
        } catch (IOException e) {
            System.out.println("Hiba a játék betöltése során: " + e.getMessage());
        }
    }
}




