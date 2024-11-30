package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TablaTeszt {

    @Test
    public void testInitializeBoard() {
        Tabla tabla = new Tabla();
        char[][] board = tabla.getTabla();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                assertEquals('.', board[i][j]);
            }
        }
    }

    @Test
    public void testDropPiece() {
        Tabla tabla = new Tabla();
        assertTrue(tabla.dropPiece(0, 'Y'));
        assertEquals('Y', tabla.getTabla()[5][0]);
    }
}
