package org.kata.tennis;

public class ScoreEvaluator {
    public static final int HIGHEST_SCORE = 4;
    private boolean isDeuce;

    public GameStatus evaluateScore(Player playerOne, Player playerTwo) {
        int playerOneScore = playerOne.getWinBalls();
        int playerTwoScore = playerTwo.getWinBalls();

        if (playerOneScore == HIGHEST_SCORE && playerTwoScore == HIGHEST_SCORE) {
            this.isDeuce = true;

            return GameStatus.DEUCE;
        }

        if (playerOneScore == playerTwoScore && this.isDeuce) {
            return GameStatus.GAME_ONGOING;
        }

        if (playerOneScore >= HIGHEST_SCORE || playerTwoScore >= HIGHEST_SCORE) {
            return GameStatus.GAME_FINISHED;
        }

        return GameStatus.GAME_ONGOING;
    }
}
