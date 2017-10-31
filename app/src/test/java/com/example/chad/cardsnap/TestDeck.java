package com.example.chad.cardsnap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 27/10/2017.
 */

public class TestDeck {

    Deck deck;
    Deck spydeck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        spydeck = Mockito.spy(deck);
    }

    @Test
    public void canGenerateDeck() {
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void canGetCard() {
        Mockito.when(spydeck.removeCard()).thenReturn(new Card(Suit.HEARTS, Rank.ACE));
        Card card = spydeck.removeCard();
        assertEquals(Suit.HEARTS, card.getSuit());
        assertEquals(Rank.ACE, card.getRank());
    }


}
