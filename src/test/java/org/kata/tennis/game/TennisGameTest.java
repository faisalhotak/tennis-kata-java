package org.kata.tennis.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kata.tennis.player.Player;
import org.kata.tennis.score.ScoreBoard;

import static org.junit.jupiter.api.Assertions.*;

class TennisGameTest {

    private TennisGame tennisGame;
    private Player playerOne;
    private Player playerTwo;
    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        tennisGame = new TennisGame();
        playerOne = new Player("Player Test One");
        playerTwo = new Player("Player Test Two");
        scoreBoard = new ScoreBoard();
        tennisGame.setScoreBoard(scoreBoard);
    }

    @Test
    void testPlay_GameNotFinished_ShouldPlayRounds() {
        // When
        tennisGame.play(playerOne, playerTwo);

        // Then
        // Verify that playRound is called at least once
        assertTrue(scoreBoard.getRoundScores().size() > 1);

        // Verify that the game is finished
        assertTrue(tennisGame.isGameFinished(playerOne, playerTwo));
    }

    @Test
    void testPlay_GameFinished_ShouldNotPlayRounds() {
        // Simulate a game already finished
        playerOne.setWinBalls(4);
        playerTwo.setWinBalls(2);

        while (!tennisGame.isGameFinished(playerOne, playerTwo)) {
            tennisGame.playRound(scoreBoard, playerOne, playerTwo);
        }

        // When
        tennisGame.play(playerOne, playerTwo);

        // Then
        // Verify that playRound is never called
        assertTrue(scoreBoard.getRoundScores().isEmpty());

        // Verify that the game is finished
        assertTrue(tennisGame.isGameFinished(playerOne, playerTwo));
    }

    @Test
    void testSetRandomRoundWinner() {
        // Given
        Player mockPlayerOne = new Player("MockPlayerOne");
        Player mockPlayerTwo = new Player("MockPlayerTwo");

        // When
        tennisGame.setRandomRoundWinner(mockPlayerOne, mockPlayerTwo);

        // Then
        // Verify that one of the players has an increased score
        assertEquals(1, mockPlayerOne.getWinBalls() + mockPlayerTwo.getWinBalls());
    }
}