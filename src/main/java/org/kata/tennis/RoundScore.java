package org.kata.tennis;

public class RoundScore {

    private int playerOneScore;
    private int playerTwoScore;

    public RoundScore() {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
    }

    public RoundScore(int playerOneScore, int playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void playerOneWinsTheRound() {
        this.playerOneScore++;
    }

    public void playerTwoWinsTheRound() {
        this.playerTwoScore++;
    }
}
