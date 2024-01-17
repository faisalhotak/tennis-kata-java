package org.kata.tennis;

/**
 * This utility class is used to evaluate the game status.
 * <p>
 *     The game is finished when one of the players wins more than 3 points and has a 2 points ahead of the other player.
 *     The game is ongoing when the game is not finished.
 * </p>
 */
public final class GameEvaluator {
    /**
     * The score of a player when he wins 3 points.
     * It corresponds to 40 points.
     */
    public static final int SCORE_FORTY = 3;

    /**
     * A private constructor to prevent the instantiation of this utility class.
     */
    private GameEvaluator() {
        throw new UnsupportedOperationException("This class should not be instantiated");
    }

    /**
     * This method checks if the game is finished or not and returns the game status.
     * @param playerOne The first player
     * @param playerTwo The second player
     * @return {@link GameStatus} The game status
     */
    public static GameStatus evaluateGameStatus(Player playerOne, Player playerTwo) {
        int playerOneScore = playerOne.getWinBalls();
        int playerTwoScore = playerTwo.getWinBalls();
        int scoreDifference = Math.abs(playerOneScore - playerTwoScore);

        if ((playerOneScore > SCORE_FORTY || playerTwoScore > SCORE_FORTY) && scoreDifference >= 2) {
            return GameStatus.GAME_FINISHED;
        }

        return GameStatus.GAME_ONGOING;
    }
}
