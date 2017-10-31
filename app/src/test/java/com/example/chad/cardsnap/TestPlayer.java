package com.example.chad.cardsnap;

import org.junit.Before;
import org.junit.Test;

import static com.example.chad.cardsnap.Rank.ACE;
import static com.example.chad.cardsnap.Rank.JACK;
import static com.example.chad.cardsnap.Rank.TEN;
import static com.example.chad.cardsnap.Suit.DIAMONDS;
import static com.example.chad.cardsnap.Suit.SPADES;
import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 27/10/2017.
 */

public class TestPlayer {

    Player player;
    Card card;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void setUp() throws Exception {
        player = new Player("Chad");
        card = new Card(Suit.HEARTS, Rank.TEN);
        card2 = new Card(Suit.SPADES, Rank.ACE);
        card3 = new Card(Suit.DIAMONDS, Rank.TEN);
        card4 = new Card(Suit.DIAMONDS, Rank.NINE);


    }

    @Test
    public void canTakeCard() {
        player.takeCard(card);
        assertEquals(1, player.getCards().size());
    }

    @Test
    public void canCalculateScore() {
        player.takeCard(card);
        player.takeCard(card2);
        assertEquals(21, player.getFinalScore());
    }

    @Test
    public void canChangeAce() {
        player.takeCard(card4);
        player.takeCard(card2);
        player.takeCard(card2);
        assertEquals(21, player.getFinalScore());
    }

    @Test
    public void canCheckBlackjack() {
        player.takeCard(card);
        assertEquals(false, player.checkBlackjack());
        player.takeCard(card2);
        assertEquals(true, player.checkBlackjack());
    }
}
