package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTeszt {

    @Test
    public void testPlayerSwitching() {
        Game game = new Game("Player1", "Player2");
        assertEquals("Player1", game.getCurrentPlayer().getName());
        game.switchPlayer();
        assertEquals("Player2", game.getCurrentPlayer().getName());
    }

    @Test
    public void testSaveAndLoadGame() {
        Game game = new Game("Player1", "Player2");
        game.getTabla().dropPiece(0, 'Y');
        game.saveGame("test_game.txt");

        Game loadedGame = new Game("Player1", "Player2");
        loadedGame.loadGame("test_game.txt");

        assertArrayEquals(game.getTabla().getTabla(), loadedGame.getTabla().getTabla());
        assertEquals(game.getCurrentPlayer().getName(), loadedGame.getCurrentPlayer().getName());
    }
}

