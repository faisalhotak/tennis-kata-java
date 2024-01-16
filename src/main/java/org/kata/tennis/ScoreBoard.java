package org.kata.tennis;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private static final Logger logger = LoggerFactory.getLogger(ScoreBoard.class);

    private final List<RoundScore> roundScores = new ArrayList<>();

    public void displayScore() {
        for (RoundScore roundScore : roundScores) {
            logger.info("Round {} : {} - {}", roundScores.indexOf(roundScore) + 1, roundScore.getPlayerOneScore(), roundScore.getPlayerTwoScore());
        }
    }

    public void displayWinner(Player playerOne, Player playerTwo) {
        String winner = getWinnerName(playerOne, playerTwo);

        logger.info("'{}' has won the game!", winner);
    }

    protected String getWinnerName(Player playerOne, Player playerTwo) {
        if (playerOne.getWinBalls() > playerTwo.getWinBalls()) {
            return playerOne.getName();
        }

        return playerTwo.getName();
    }

    public void addRoundScore(RoundScore roundScore) {
        int playerOneScore = roundScore.getPlayerOneScore();
        int playerTwoScore = roundScore.getPlayerTwoScore();

        if (!roundScores.isEmpty()) {
            RoundScore latestRoundScore = roundScores.get(roundScores.size() - 1);

            playerOneScore += latestRoundScore.getPlayerOneScore();
            playerTwoScore += latestRoundScore.getPlayerTwoScore();
        }

        RoundScore newRoundScore = new RoundScore(playerOneScore, playerTwoScore);

        roundScores.add(newRoundScore);
    }
}
