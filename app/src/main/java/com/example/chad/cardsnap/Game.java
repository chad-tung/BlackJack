package com.example.chad.cardsnap;

import java.util.ArrayList;
import java.util.Scanner;

import static android.R.color.black;

/**
 * Created by chad on 27/10/2017.
 */

public class Game {

    Player player;
    Dealer dealer;
    Deck deck;
    ArrayList<Player> players;
    boolean isWon;

    public Game(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.players = new ArrayList<>();

    }

    public void start() {

        player.takeCard(dealer.deal());
        dealer.takeCard(dealer.deal());
        player.takeCard(dealer.deal());
        dealer.takeCard(dealer.deal());

//        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        players.add(dealer);

//        for (int i=0; i < 3; i++) {
//            for (Player guy : players) {
//                guy.takeCard(dealer.deal())
//            players.indexOf(0).takeCard(dealer.deal());
//
//            }
//        }



    }

    public String getInput() {

        String text;

        System.out.println("Stick or Twist");
        Scanner in = new Scanner(System.in);
        text = in.nextLine();
        return text;
    }





    public String checkWin() {
        if ((player.getScore() > dealer.getScore()) && (!player.isBust() && !dealer.isBust())) {
            return "Player wins!";
        } if ((player.getScore() <= dealer.getScore()) && (!player.isBust() && !dealer.isBust())) {
            return "Dealer wins!";
        } if (player.isBust() && dealer.isBust()) {
            return "Draw!";
        } if (player.isBust() && !dealer.isBust()) {
            return "Dealer wins!";
        } if (!player.isBust() && dealer.isBust()) {
            return "Player wins!";
        }

        return "Draw";
    }

    public String blackjack() {
        if (player.checkBlackjack() && dealer.checkBlackjack()) {
            return "Both players got Blackjack! It's a draw";
        }
        if (player.checkBlackjack()) {
            return "Player got Blackjack! Player wins.";
        }
        if (dealer.checkBlackjack()) {
            return "Dealer got Blackjack! Dealer wins.";
        }
        return  "No Blackjack, game on!";
    }

    public void run() {
        start();
        blackjack();
        for (Player player: players) {
            String option = getInput();
            player.stickOrTwist(option);
            while (!player.isFinished()) {
                player.takeTurn(dealer.deal());
            }
        }
        checkWin();
    }



//    public String takeTurns(ArrayList<Player> players) {
//        for player in players
//        finished == false
//        while finished == false
//        get the input
//        finished == stickOrTwist(input)
//        if finished == false
//        draw card
// }



//    public boolean checkWin() {

//    }


}

