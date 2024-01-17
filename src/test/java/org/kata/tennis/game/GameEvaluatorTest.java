package org.kata.tennis.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.tennis.player.Player;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

class GameEvaluatorTest {

    @Test
    @DisplayName("When two players have been created and none of them has more than 3 points, then the game status should be ongoing")
    void givenTwoPlayersWithScoreLessThanThreePoints_ShouldReturnGameOngoing() {
        // Given
        Player playerOne = new Player("Player Test One");
        Player playerTwo = new Player("Player Test Two");

        // When
        GameStatus result = GameEvaluator.evaluateGameStatus(playerOne, playerTwo);

        // Then
        assertEquals(GameStatus.GAME_ONGOING, result);
    }

    @Test
    @DisplayName("When two players have been created and both of them has 3 points, then the game status should be ongoing (deuce)")
    void givenTwoPlayersWithScoreEqualThreePoints_ShouldReturnGameOngoing() {
        // Given
        Player playerOne = new Player("Player Test One");
        Player playerTwo = new Player("Player Test Two");

        playerOne.addWinBall();
        playerOne.addWinBall();
        playerOne.addWinBall();

        playerTwo.addWinBall();
        playerTwo.addWinBall();
        playerTwo.addWinBall();

        // When
        GameStatus result = GameEvaluator.evaluateGameStatus(playerOne, playerTwo);

        // Then
        assertEquals(GameStatus.GAME_ONGOING, result);
    }

    @Test
    @DisplayName("When two players have been created and both of them have more than 3 points and 1 point difference, " +
            "then the game status should be ongoing (advantage for the player leading)")
    void givenTwoPlayersWithScoreOfBothMoreThanThreePointsAndOnePointDifferenceBetweenThem_ShouldReturnGameOngoing() {
        // Given
        Player playerOne = new Player("Player Test One");
        Player playerTwo = new Player("Player Test Two");

        playerOne.addWinBall();
        playerOne.addWinBall();
        playerOne.addWinBall();
        playerOne.addWinBall();

        playerTwo.addWinBall();
        playerTwo.addWinBall();
        playerTwo.addWinBall();

        // When
        GameStatus result = GameEvaluator.evaluateGameStatus(playerOne, playerTwo);

        // Then
        assertEquals(GameStatus.GAME_ONGOING, result);
    }

    @Test
    @DisplayName("When two players have been created and one of them has 4 points and the other has less than 3 points, then the game status should be finished")
    void givenTwoPlayersWithScoreOfOnePlayerWithMoreThanThreePointsAndTheSecondWithLessThanThreePoints_ShouldReturnGameFinished() {
        // Given
        Player playerOne = new Player("Player Test One");
        Player playerTwo = new Player("Player Test Two");

        playerOne.addWinBall();
        playerOne.addWinBall();

        playerTwo.addWinBall();
        playerTwo.addWinBall();
        playerTwo.addWinBall();
        playerTwo.addWinBall();


        // When
        GameStatus result = GameEvaluator.evaluateGameStatus(playerOne, playerTwo);

        // Then
        assertEquals(GameStatus.GAME_FINISHED, result);
    }
}