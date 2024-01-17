package org.kata.tennis.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.tennis.player.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreBoardTest {

    private final ScoreBoard board = new ScoreBoard();

    @Test
    @DisplayName("When player one and player two have the same score and the score is equal to 40, then the score should be deuce")
    void testGetRoundScoreMessage_ThreePointsEach_NoScoreDifference_ShouldReturnDeuce() {
        // Given
        int roundNumber = 1;
        int playerOneScore = 3; // 40 points
        int playerTwoScore = 3; // 40 points

        // When
        String result = board.getRoundScoreMessage(roundNumber, playerOneScore, playerTwoScore);

        // Then
        assertEquals("Round 1 : DEUCE", result);
    }

    @Test
    @DisplayName("When player one and player two have the same score and the score is greater or equal to 40, then the score should be deuce")
    void testGetRoundScoreMessage_SevenPointsEach_NoScoreDifference_ShouldReturnDeuce() {
        // Given
        int roundNumber = 1;
        int playerOneScore = 7;
        int playerTwoScore = 7;

        // When
        String result = board.getRoundScoreMessage(roundNumber, playerOneScore, playerTwoScore);

        // Then
        assertEquals("Round 1 : DEUCE", result);
    }

    @Test
    @DisplayName("When player one has 4 points and player two has 3 points, then the score should be advantage player one")
    void testGetRoundScoreMessage_OnePointDifference_ShouldReturnAdvantage() {
        // Given
        int roundNumber = 2;
        int playerOneScore = 4; // 40 points + 1
        int playerTwoScore = 3; // 40 points

        // When
        String result = board.getRoundScoreMessage(roundNumber, playerOneScore, playerTwoScore);

        // Then
        assertEquals("Round 2 : ADVANTAGE - FORTY", result);
    }

    @Test
    @DisplayName("When player one has 3 points and player two has 4 points, then the score should be advantage player two")
    void testGetRoundScoreMessage_OnePointDifferenceReverse_ShouldReturnAdvantage() {
        // Given
        int roundNumber = 3;
        int playerOneScore = 3; // 40 points
        int playerTwoScore = 4; // 40 points + 1

        // When
        String result = board.getRoundScoreMessage(roundNumber, playerOneScore, playerTwoScore);

        // Then
        assertEquals("Round 3 : FORTY - ADVANTAGE", result);
    }

    @Test
    @DisplayName("When player one has 6 points and player two has 4 points, then the score should be game player one")
    void testGetRoundScoreMessage_GreaterThanOnePointDifference_ShouldReturnGame() {
        // Given
        int roundNumber = 4;
        int playerOneScore = 6; // 40 points + 3
        int playerTwoScore = 4; // 40 points + 1

        // When
        String result = board.getRoundScoreMessage(roundNumber, playerOneScore, playerTwoScore);

        // Then
        assertEquals("Round 4 : GAME", result);
    }

    @Test
    @DisplayName("When player one has 2 points and player two has 1 point, then the score should be THIRTY - FIFTEEN")
    void testGetRoundScoreMessage_LessThanFortyPoints_ShouldReturnRegularScore() {
        // Given
        int roundNumber = 5;
        int playerOneScore = 2; // THIRTY points
        int playerTwoScore = 1; // FIFTEEN points

        // When
        String result = board.getRoundScoreMessage(roundNumber, playerOneScore, playerTwoScore);

        // Then
        assertEquals("Round 5 : THIRTY - FIFTEEN", result);
    }

    @Test
    @DisplayName("When player one wins 2 points and player two wins 1 point, then player one should be the winner")
    void givenPlayerOneScoredTwoPointsAndPlayerTwoScoredOnePoint_ShouldReturnPlayerOneAsWinner() {
        Player playerOne = new Player("Player Test One");
        Player playerTwo = new Player("Player Test Two");

        playerOne.setWinBalls(2);
        playerTwo.addWinBall();

        String result = ScoreBoard.getWinnerName(playerOne, playerTwo);

        assertEquals("Player Test One", result);
    }

    @Test
    @DisplayName("When player two wins 2 points and player one wins 1 point, then player two should be the winner")
    void givenPlayerTwoScoredTwoPointsAndPlayerOneScoredOnePoint_ShouldReturnPlayerTwoAsWinner() {
        Player playerOne = new Player("Player Test One");
        Player playerTwo = new Player("Player Test Two");

        playerOne.addWinBall();
        playerTwo.setWinBalls(2);

        String result = ScoreBoard.getWinnerName(playerOne, playerTwo);

        assertEquals("Player Test Two", result);
    }
}