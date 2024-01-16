package org.kata.tennis;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TennisGame {

    private static final Logger logger = LoggerFactory.getLogger(TennisGame.class);
    private static final Random random = new Random();

    public void play(Player playerOne, Player playerTwo) {
        ScoreBoard board = new ScoreBoard();
        GameEvaluator evaluator = new GameEvaluator();

        logger.info("""
                
                =======================
                TENNIS KATA JAVA
                =======================
                """);

        while (!isGameFinished(evaluator, playerOne, playerTwo)) {
            playRound(board, playerOne, playerTwo);
        }

        board.displayScore();
        board.displayWinner(playerOne, playerTwo);
    }

    private void playRound(ScoreBoard board, Player playerOne, Player playerTwo) {
        int ballWin = random.nextInt(2);

        if (ballWin == 0) {
            playerOne.addWinBall();
        } else {
            playerTwo.addWinBall();
        }

        board.saveRoundScore(playerOne, playerTwo);
    }

    private boolean isGameFinished(GameEvaluator evaluator, Player playerOne, Player playerTwo) {
        return evaluator.evaluateGameStatus(playerOne, playerTwo) == GameStatus.GAME_FINISHED;
    }
}
