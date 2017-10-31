package com.example.chad.cardsnap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 27/10/2017.
 */

public class TestCard {

    Card card;

    @Before
    public void before() {
        card = new Card(Suit.CLUBS, Rank.FOUR);
    }

    @Test
    public void hasValue() {
        assertEquals(4, card.getValue());

    }
}
