package org.kata.tennis;

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

    public void addWinBall() {
        this.winBalls++;
    }
}
