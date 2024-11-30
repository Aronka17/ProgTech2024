package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JatekosTeszt {

    @Test
    public void testJatekosInitialization() {
        Jatekos jatekos = new Jatekos("Player1", 'Y');
        assertEquals("Player1", jatekos.getName());
        assertEquals('Y', jatekos.getPiece());
    }
}

