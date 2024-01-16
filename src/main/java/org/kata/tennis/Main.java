package org.kata.tennis;

public class Main {
    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();
        Player playerOne = new Player("Player One");
        Player playerTwo = new Player("Player Two");

        tennisGame.play(playerOne, playerTwo);
    }
}
