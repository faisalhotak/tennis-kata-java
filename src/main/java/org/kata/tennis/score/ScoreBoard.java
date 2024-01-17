package org.kata.tennis.score;

import org.kata.tennis.player.Player;
import org.kata.tennis.game.GameEvaluator;
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

            String roundScoreMessage = getRoundScoreMessage(roundNumber, playerOneScore, playerTwoScore);

            logger.info(roundScoreMessage);
        }
    }

    /**
     * This method is responsible for getting the score message of a round.
     * @param playerOneScore the score of the first player represented by an integer
     * @param playerTwoScore the score of the second player represented by an integer
     * @param roundNumber the number of the round represented by an integer
     * @return the score message of the round
     */
    protected String getRoundScoreMessage(int roundNumber, int playerOneScore, int playerTwoScore) {
        int scoreDifference = Math.abs(playerOneScore - playerTwoScore);

        // If one of the players has a score greater than 40, then we need to check the score difference between the two players.
        // Else, we can directly display the score of the two players.
        if (playerOneScore > GameEvaluator.SCORE_FORTY || playerTwoScore > GameEvaluator.SCORE_FORTY) {
            // If there is no score difference between the two players, then the score is DEUCE.
            // If there is a score difference of 1, then the score is ADVANTAGE for the player with the highest score.
            // Else, it means that the score difference is greater than 1, then the player with the highest score wins the game.
            if (scoreDifference == 0) {
                return String.format("Round %d : DEUCE", roundNumber);
            } else if (scoreDifference == 1) {
                String forty = SCORES_DESCRIPTION.get(3);

                if (playerOneScore > playerTwoScore) {
                    return String.format("Round %d : ADVANTAGE - %s", roundNumber, forty);
                } else {
                    return String.format("Round %d : %s - ADVANTAGE", roundNumber, forty);
                }
            } else {
                return String.format("Round %d : GAME", roundNumber);
            }
        } else {
            String playerOneScoreDescription = SCORES_DESCRIPTION.get(playerOneScore);
            String playerTwoScoreDescription = SCORES_DESCRIPTION.get(playerTwoScore);

            if (playerOneScore == GameEvaluator.SCORE_FORTY && scoreDifference == 0) {
                return String.format("Round %d : DEUCE", roundNumber);
            }

            return String.format("Round %d : %s - %s", roundNumber, playerOneScoreDescription, playerTwoScoreDescription);
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
    protected static String getWinnerName(Player playerOne, Player playerTwo) {
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

    public List<RoundScore> getRoundScores() {
        return roundScores;
    }
}
