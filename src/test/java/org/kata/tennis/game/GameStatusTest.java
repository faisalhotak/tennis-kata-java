package org.kata.tennis.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStatusTest {

    @Test
    @DisplayName("When getting the value of the enum values, then the correct value should be returned")
    void testValueOf() {
        assertEquals(GameStatus.GAME_ONGOING, GameStatus.valueOf("GAME_ONGOING"));
        assertEquals(GameStatus.GAME_FINISHED, GameStatus.valueOf("GAME_FINISHED"));
    }
}