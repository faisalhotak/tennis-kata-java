package org.kata.tennis.main;

import org.kata.tennis.player.Player;
import org.kata.tennis.game.TennisGame;

/**
 * This is the main class of the application. It is used to start the game.
 * <p>
 *     The game is played between two players.
 *     The player who wins a round gets a point.
 *     The game is finished when one of the players wins more than 3 points and has a 2 points ahead of the other player.
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        TennisGame tennisGame = new TennisGame();
        Player playerOne = new Player("Player One");
        Player playerTwo = new Player("Player Two");

        tennisGame.play(playerOne, playerTwo);
    }
}
