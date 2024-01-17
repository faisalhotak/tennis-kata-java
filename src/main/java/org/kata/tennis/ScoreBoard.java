package org.kata.tennis;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for displaying the score and the winner of the game.
 */
public class ScoreBoard {

    private static final Logger logger = LoggerFactory.getLogger(ScoreBoard.class);

    /**
     * This list contains the score of each round played by the two players.
     */
    private final List<RoundScore> roundScores = new ArrayList<>();

    /**
     * This list contains the description of each score displayed on the scoreboard.
     */
    private static final List<String> SCORES_DESCRIPTION = List.of("LOVE", "FIFTEEN", "THIRTY", "FORTY");

    /**
     * This method is responsible for displaying the score of each round.
     * It will display the score of each round in the following format:
     * "Round (round number) : (player one score) - (player two score)"
     */
    public void displayScore() {
        for (RoundScore roundScore : roundScores) {
            int roundNumber = roundScores.indexOf(roundScore) + 1;
            int playerOneScore = roundScore.playerOneScore();
            int playerTwoScore = roundScore.playerTwoScore();

            // If one of the players has a score greater than 40, then we need to check the score difference between the two players.
            // Else, we can directly display the score of the two players.
            if (playerOneScore > GameEvaluator.SCORE_FORTY || playerTwoScore > GameEvaluator.SCORE_FORTY) {
                int scoreDifference = Math.abs(playerOneScore - playerTwoScore);

                // If there is no score difference between the two players, then the score is DEUCE.
                // If there is a score difference of 1, then the score is ADVANTAGE for the player with the highest score.
                // Else, it means that the score difference is greater than 1, then the player with the highest score wins the game.
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

    /**
     * This method is responsible for displaying the winner of the game.
     * @param playerOne the first player
     * @param playerTwo the second player
     */
    public void displayWinner(Player playerOne, Player playerTwo) {
        String winner = getWinnerName(playerOne, playerTwo);

        logger.info("'{}' has won the game!", winner);
    }

    /**
     * This method is responsible for getting the name of the winner of the game.
     * It will compare the number of won balls of the two players
     * and return the name of the player with the highest number of won balls.
     * @param playerOne the first player
     * @param playerTwo the second player
     * @return the name of the winner
     */
    private String getWinnerName(Player playerOne, Player playerTwo) {
        if (playerOne.getWinBalls() > playerTwo.getWinBalls()) {
            return playerOne.getName();
        }

        return playerTwo.getName();
    }

    /**
     * This method is responsible for saving the score of a round into the list of round scores.
     * @param playerOne the first player
     * @param playerTwo the second player
     */
    public void saveRoundScore(Player playerOne, Player playerTwo) {
        RoundScore roundScore = new RoundScore(playerOne.getWinBalls(), playerTwo.getWinBalls());

        roundScores.add(roundScore);
    }
}
