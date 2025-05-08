package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;//stores all cards in this hand

    public Hand() {
        cards = new ArrayList<>();
    }
    //Adds card to hand and flips it face up
    public void deal(Card card) {
        card.flip();//Added to make sure card is face up when added
        cards.add(card);
    }
    //Returns how many cards are currently in the hands
    public int getSize() {
        return cards.size();
    }
    // Calculates the total point value of the hand
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            int cardValue = card.getPointValue();
            value += cardValue;
            if (cardValue == 11) {
                aceCount++;
            }
        }

        // Handle the Ace: count it as 1 if 11 would bust the hand
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    // Returns a readable version of the hand for printing
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.getValue()).append(" of ").append(card.getSuit()).append(", ");
        }
        sb.append("Total: ").append(getValue());
        return sb.toString();
    }
}