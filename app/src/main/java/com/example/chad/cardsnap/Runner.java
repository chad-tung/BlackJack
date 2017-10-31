package com.example.chad.cardsnap;

import java.util.Scanner;

/**
 * Created by chad on 27/10/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Chad");
        Dealer dealer = new Dealer("Dealer", deck);
        Game game = new Game(player, dealer, deck);


        game.run();
    }
}