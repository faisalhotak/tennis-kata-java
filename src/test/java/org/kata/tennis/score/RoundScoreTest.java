package org.kata.tennis.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundScoreTest {

    @Test
    @DisplayName("When creating a new RoundScore object, then the object should be returned with the correct values")
    void testRoundScoreConstructor() {
        // Given
        int playerOneScore = 2;
        int playerTwoScore = 3;

        // When
        RoundScore roundScore = new RoundScore(playerOneScore, playerTwoScore);

        // Then
        assertEquals(playerOneScore, roundScore.playerOneScore());
        assertEquals(playerTwoScore, roundScore.playerTwoScore());
    }

    @Test
    @DisplayName("When creating a new RoundScore object, then the toString method should return the correct stringified object")
    void testRoundScoreToString() {
        // Given
        int playerOneScore = 2;
        int playerTwoScore = 3;
        RoundScore roundScore = new RoundScore(playerOneScore, playerTwoScore);

        // When
        String toStringResult = roundScore.toString();

        // Then
        assertEquals("RoundScore[playerOneScore=2, playerTwoScore=3]", toStringResult);
    }

    @Test
    @DisplayName("When comparing two RoundScore objects, then the equals method should return the correct result")
    void testRoundScoreEquals() {
        // Given
        RoundScore roundScore1 = new RoundScore(2, 3);
        RoundScore roundScore2 = new RoundScore(2, 3);
        RoundScore roundScore3 = new RoundScore(4, 1);

        // Then
        assertEquals(roundScore1, roundScore2);
        assertNotEquals(roundScore1, roundScore3);
    }

    @Test
    @DisplayName("When comparing two RoundScore objects, then the hashCode method should return the correct result")
    void testRoundScoreHashCode() {
        // Given
        RoundScore roundScore1 = new RoundScore(2, 3);
        RoundScore roundScore2 = new RoundScore(2, 3);
        RoundScore roundScore3 = new RoundScore(4, 1);

        // Then
        assertEquals(roundScore1.hashCode(), roundScore2.hashCode());
        assertNotEquals(roundScore1.hashCode(), roundScore3.hashCode());
    }
}