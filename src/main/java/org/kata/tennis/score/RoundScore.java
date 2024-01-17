package org.kata.tennis.score;

/**
 * This class represents the score of a round.
 * <p>
 *     It contains the score of the two players.
 *     The score of a player is an integer value.
 * </p>
 * @param playerOneScore The score of the first player represented by an integer value.
 * @param playerTwoScore The score of the second player represented by an integer value.
 */
public record RoundScore(int playerOneScore, int playerTwoScore) {

}
