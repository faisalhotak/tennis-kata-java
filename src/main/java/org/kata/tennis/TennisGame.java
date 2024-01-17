package org.kata.tennis;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisGame {

    private static final Logger logger = LoggerFactory.getLogger(TennisGame.class);
    private static final Random random = new Random();

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

    private void playRound(ScoreBoard board, Player playerOne, Player playerTwo) {
        setRandomRoundWinner(playerOne, playerTwo);
        board.saveRoundScore(playerOne, playerTwo);
    }

    private boolean isGameFinished(Player playerOne, Player playerTwo) {
        return GameEvaluator.evaluateGameStatus(playerOne, playerTwo) == GameStatus.GAME_FINISHED;
    }

    private void setRandomRoundWinner(Player playerOne, Player playerTwo) {
        int roundWinner = random.nextInt(2);

        if (roundWinner == 0) {
            playerOne.addWinBall();
        } else {
            playerTwo.addWinBall();
        }
    }
}
