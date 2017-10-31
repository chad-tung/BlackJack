package com.example.chad.cardsnap;

import java.util.ArrayList;

import static com.example.chad.cardsnap.Rank.ACE;

/**
 * Created by chad on 27/10/2017.
 */

public class Player {
    private String name;
    private ArrayList<Card> cards;
    private int score;
    private boolean finished;
    private boolean bust;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.score = 0;
        this.finished = false;
        this.bust = false;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getScore() {
        return score;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isBust() {
        return bust;
    }

    public void takeCard(Card card) {
        cards.add(card);
    }

    public void calculateScore() {

        sumCards();

        int score = this.score;

        if (score > 21) {
            for (Card card : getCards()) {
                if (card.getRank() == Rank.ACE) {
                    score -= 10;
                    this.score = score;
                    if (score <= 21) {
                        break;
                    }
                }
            }
        }
    }

    public void sumCards() {
        int score = 0;
        for (Card card : this.cards) {
            score += card.getValue();
        }
        this.score = score;
    }

    public int getFinalScore() {
        calculateScore();
        return this.score;
    }

    public void stickOrTwist(String input) {
        boolean condition = false;
        if (input.toLowerCase() == "s") {
            condition = true;
        }
        this.finished = condition;
    }

    public boolean checkBlackjack() {
        calculateScore();
        if (this.score == 21) {
            return true;
        }
        return false;
    }

    public void checkBust() {
        calculateScore();
        if (this.score > 21) {
            this.bust = true;
        }
    }

    public void takeTurn(Card card) {
        takeCard(card);
        calculateScore();
        checkBust();
    }

}
