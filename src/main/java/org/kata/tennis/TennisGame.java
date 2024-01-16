package org.kata.tennis;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisGame {

    private static final Logger logger = LoggerFactory.getLogger(TennisGame.class);
    private static final Random random = new Random();

    public void play(Player playerOne, Player playerTwo) {
        ScoreBoard board = new ScoreBoard();
        ScoreEvaluator evaluator = new ScoreEvaluator();

        logger.info("""
                
                ====================================
                TENNIS KATA JAVA
                ====================================
                """);

        while (!isGameFinished(evaluator, playerOne, playerTwo)) {
            playRound(board, playerOne, playerTwo);
        }

        board.displayScore();
        board.displayWinner(playerOne, playerTwo);
    }

    private void playRound(ScoreBoard board, Player playerOne, Player playerTwo) {
        RoundScore roundScore = new RoundScore();
        int ballWin = random.nextInt(2);

        if (ballWin == 0) {
            playerOne.addWinBall();
            roundScore.playerOneWinsTheRound();
        } else {
            playerTwo.addWinBall();
            roundScore.playerTwoWinsTheRound();
        }

        board.addRoundScore(roundScore);
    }

    private boolean isGameFinished(ScoreEvaluator evaluator, Player playerOne, Player playerTwo) {
        return evaluator.evaluateScore(playerOne, playerTwo) == GameStatus.GAME_FINISHED;
    }
}
