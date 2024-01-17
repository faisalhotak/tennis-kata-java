package org.kata.tennis;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for playing the tennis game.
 */
public class TennisGame {

    private static final Logger logger = LoggerFactory.getLogger(TennisGame.class);

    /**
     * This random object is used to randomly choose the winner of each round.
     */
    private static final Random random = new Random();

    /**
     * This method is responsible for playing the tennis game.
     * It will play rounds until the game is finished.
     * It will display the score and the winner of the game after the game is finished.
     * @param playerOne the first player
     * @param playerTwo the second player
     */
    public void play(Player playerOne, Player playerTwo) {
        ScoreBoard board = new ScoreBoard();

        logger.info("""
                
                =======================
                TENNIS KATA JAVA
                =======================
                """);

        while (!isGameFinished(playerOne, playerTwo)) {
            playRound(board, playerOne, playerTwo);
        }

        board.displayScore();
        board.displayWinner(playerOne, playerTwo);
    }

    /**
     * This method is responsible for playing a round.
     * It will randomly choose the winner of the round and save the score of the round in the scoreboard.
     * @param board the scoreboard
     * @param playerOne the first player
     * @param playerTwo the second player
     */
    private void playRound(ScoreBoard board, Player playerOne, Player playerTwo) {
        setRandomRoundWinner(playerOne, playerTwo);
        board.saveRoundScore(playerOne, playerTwo);
    }

    /**
     * This method is responsible for checking if the game is finished.
     * @param playerOne the first player
     * @param playerTwo the second player
     * @return true if the game is finished, false otherwise
     */
    private boolean isGameFinished(Player playerOne, Player playerTwo) {
        return GameEvaluator.evaluateGameStatus(playerOne, playerTwo) == GameStatus.GAME_FINISHED;
    }

    /**
     * This method is responsible for randomly choosing the winner of a round.
     * It is using the random object to generate a random integer between 0 and 1.
     * Based on the generated integer, it will add a win ball to the player one or player two.
     * @see Random nextInt(int bound)
     * @param playerOne the first player
     * @param playerTwo the second player
     */
    private void setRandomRoundWinner(Player playerOne, Player playerTwo) {
        int roundWinner = random.nextInt(2);

        if (roundWinner == 0) {
            playerOne.addWinBall();
        } else {
            playerTwo.addWinBall();
        }
    }
}
