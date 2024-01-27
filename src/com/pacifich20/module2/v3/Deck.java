package com.pacifich20.module2.v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private final LinkedList<Card> cards;

    /**
     * creates a deck by creating and shuffling deck of playing cards
     */
    public Deck() {
        cards = createShuffledDeck();
    }

    /**
     * creates and shuffles deck of playing cards
     * @return shuffled LinkedList of cards in a deck
     */
    private LinkedList<Card> createShuffledDeck() {
        LinkedList<Card> shuffledDeck = new LinkedList<>();

        // loops through each suit and rank to create standard deck
        for (Suit suit : Suit.values()) {
            for (int rank = 1; rank <= 10; rank++) {
                shuffledDeck.add(new Card(suit, String.valueOf(rank)));
            }
            shuffledDeck.add(new Card(suit, "K"));
            shuffledDeck.add(new Card(suit, "Q"));
            shuffledDeck.add(new Card(suit, "J"));
        }

        Collections.shuffle(shuffledDeck);
        return shuffledDeck;
    }

    /**
     * draws seven cards from deck
     * @return list of 7 cards drawn
     */
    public List<Card> drawSeven() {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            drawnCards.add(cards.poll());
        }
        return drawnCards;
    }

    /**
     * checks if 2 decks are equal by comparing card contents
     * @param o object to compare with current deck
     * @return true if decks are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        } else if (!(o instanceof Deck)) {
            return false;
        } else {
            Deck deck = (Deck) o;
            return cards.equals(deck.cards);
        }
    }

    /**
     * generates hash code based on cards in deck
     * @return hash code for deck
     */
    @Override
    public int hashCode() {
        return cards.hashCode();
    }

    /**
     * converts deck information to string format for printing
     * @return deck information in string format
     */
    @Override
    public String toString() {
        return "Deck cards: " + cards;
    }
}