package org.kata.tennis.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    @DisplayName("When a player is created with a name, then the getName method should return the name")
    void givenPlayer_ShouldReturnName() {
        // Given
        Player player = new Player("Player Test");

        // When
        String result = player.getName();

        // Then
        assertEquals("Player Test", result);
    }

    @Test
    @DisplayName("When a player is created with no win balls set, then the getWinBalls method should return zero")
    void givenPlayerWithNoWinBalls_ShouldReturnZeroWinBalls() {
        // Given
        Player player = new Player("Player Test");

        // When
        int result = player.getWinBalls();

        // Then
        assertEquals(0, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("When a player is created and win balls are added, then the getWinBalls method should return the number of win balls")
    void givenPlayerWithWinBalls_ShouldReturnWinBalls(int winBalls) {
        // Given
        Player player = new Player("Player Test");

        for (int i = 0; i < winBalls; i++) {
            player.addWinBall();
        }

        // When
        int result = player.getWinBalls();

        // Then
        assertEquals(winBalls, result);
    }
}