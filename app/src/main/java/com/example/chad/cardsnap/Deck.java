package com.example.chad.cardsnap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by chad on 27/10/2017.
 */

public class Deck {

    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        generateDeck();
    }

    public void generateDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card removeCard() {
        return cards.remove(0);
    }


}
