package com.pacifich20.module2.v3;

import java.util.Objects;

public class Card {
    //variables
    private Suit suit;
    private String rank;
    private boolean faceCard;

    /**
     * creates card with given suit and rank
     * @param suit suit of card
     * @param rank rank of card 
     */
    public Card(Suit suit, String rank) {
        this.suit = suit;
        setRank(rank);
    }

    /**
     * gets suit of the card
     * @return suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * sets the suit of card
     * @param suit suit to set for card
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * gets rank of card
     * @return rank of card
     */
    public String getRank() {
        return rank;
    }

    /**
     * sets the rank of card and updates face card status
     * @param rank rank to set for card
     */
    public void setRank(String rank) {
        this.rank = rank;
        updateFaceCard();
    }

    /**
     * checks if card is face card (queen, king or jack)
     * @return true if card is face card, false otherwise
     */
    public boolean faceCard() {
        return faceCard;
    }

    /**
     * updates face card status based on rank of card
     */
    private void updateFaceCard() {
        faceCard = (rank.equals("Q") || rank.equals("K") || rank.equals("J"));
    }

    /**
     * checks if 2 cards are equal by comparing suit, rank, and face card status
     * @param o object to compare with current card
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Card)){
            return false;
        } else {
            Card card = (Card) o;
            return faceCard == card.faceCard && Objects.equals(suit, card.suit) && Objects.equals(rank, card.rank);
        }
    }

    /**
     * generates hash code based on suit, rank, and face card status of card
     * @return hash code for card
     */
    @Override
    public int hashCode() {
        return Objects.hash(suit, rank, faceCard);
    }

    /**
     * converts planet information to string format for printing
     * @return planet information in string format
     */
    @Override
    public String toString() {
        return "Card: suit = " + suit + ", rank = " + rank + ", face card = " + faceCard;
    }

}