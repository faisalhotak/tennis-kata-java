package org.kata.tennis;

public final class GameEvaluator {
    public static final int HIGHEST_SCORE = 3;

    private GameEvaluator() {
        throw new UnsupportedOperationException("This class should not be instantiated");
    }

    public static GameStatus evaluateGameStatus(Player playerOne, Player playerTwo) {
        int playerOneScore = playerOne.getWinBalls();
        int playerTwoScore = playerTwo.getWinBalls();
        int scoreDifference = Math.abs(playerOneScore - playerTwoScore);

        if ((playerOneScore > HIGHEST_SCORE || playerTwoScore > HIGHEST_SCORE) && scoreDifference >= 2) {
            return GameStatus.GAME_FINISHED;
        }

        return GameStatus.GAME_ONGOING;
    }
}
