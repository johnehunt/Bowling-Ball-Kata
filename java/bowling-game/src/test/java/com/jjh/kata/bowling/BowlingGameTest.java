package com.jjh.kata.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    private Game g;

    @BeforeEach
    void setUp()  {
        g = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++)
            g.roll(pins);
    }

    @Test
    public void testGutterGame() {
        int n = 20;
        int pins = 0;
        rollMany(n, pins);
        assertEquals(0, g.score());
    }

    @Test
    public void testAllOnes() {
        int n = 20;
        int pins = 1;
        rollMany(n, pins);
        assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare() {
        rollSpare(5, 5);
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12,10);
        assertEquals(300, g.score());
    }

    private void rollStrike() {
        g.roll(10);
    }

    private void rollSpare(int first, int second) {
        g.roll(first);
        g.roll(second);
    }

}

