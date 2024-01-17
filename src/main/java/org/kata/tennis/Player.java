package org.kata.tennis;

/**
 * This class represents a player.
 * <p>
 *     A player has a name and a number of win balls.
 *     The number of win balls is the number of rounds won by the player.
 *     The player who wins a round gets a point.
 * </p>
 */
public class Player {
    private final String name;
    private int winBalls;

    public Player(String name) {
        this.name = name;
        this.winBalls = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getWinBalls() {
        return winBalls;
    }

    /**
     * This method is used to add a win ball to the player.
     */
    public void addWinBall() {
        this.winBalls++;
    }
}
