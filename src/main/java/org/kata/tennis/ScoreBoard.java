package org.kata.tennis;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    private static final Logger logger = LoggerFactory.getLogger(ScoreBoard.class);

    private final List<RoundScore> roundScores = new ArrayList<>();

    private static final List<String> SCORES_DESCRIPTION = List.of("LOVE", "FIFTEEN", "THIRTY", "FORTY");

    public void displayScore() {
        for (RoundScore roundScore : roundScores) {
            int roundNumber = roundScores.indexOf(roundScore) + 1;
            int playerOneScore = roundScore.playerOneScore();
            int playerTwoScore = roundScore.playerTwoScore();

            if (playerOneScore > GameEvaluator.HIGHEST_SCORE || playerTwoScore > GameEvaluator.HIGHEST_SCORE) {
                int scoreDifference = Math.abs(playerOneScore - playerTwoScore);

                if (scoreDifference == 0) {
                    logger.info("Round {} : DEUCE", roundNumber);
                } else if (scoreDifference == 1) {
                    String forty = SCORES_DESCRIPTION.get(3);

                    if (playerOneScore > playerTwoScore) {
                        logger.info("Round {} : ADVANTAGE - {}", roundNumber, forty);
                    } else {
                        logger.info("Round {} : {} - ADVANTAGE", roundNumber, forty);
                    }
                } else {
                    logger.info("Round {} : GAME", roundNumber);
                }
            } else {
                String playerOneScoreDescription = SCORES_DESCRIPTION.get(playerOneScore);
                String playerTwoScoreDescription = SCORES_DESCRIPTION.get(playerTwoScore);

                logger.info("Round {} : {} - {}" , roundNumber, playerOneScoreDescription, playerTwoScoreDescription);
            }
        }
    }

    public void displayWinner(Player playerOne, Player playerTwo) {
        String winner = getWinnerName(playerOne, playerTwo);

        logger.info("'{}' has won the game!", winner);
    }

    private String getWinnerName(Player playerOne, Player playerTwo) {
        if (playerOne.getWinBalls() > playerTwo.getWinBalls()) {
            return playerOne.getName();
        }

        return playerTwo.getName();
    }

    public void saveRoundScore(Player playerOne, Player playerTwo) {
        RoundScore roundScore = new RoundScore(playerOne.getWinBalls(), playerTwo.getWinBalls());

        roundScores.add(roundScore);
    }
}
