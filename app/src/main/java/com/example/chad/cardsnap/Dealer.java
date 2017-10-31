package com.example.chad.cardsnap;

/**
 * Created by chad on 27/10/2017.
 */

public class Dealer extends Player {
    private Deck deck;

    public Dealer(String name, Deck deck) {
        super(name);
        this.deck = deck;
        shuffle();
    }

    public Card deal() {
        return deck.removeCard();
    }

    public void shuffle() {
        deck.shuffle();
    }



}
