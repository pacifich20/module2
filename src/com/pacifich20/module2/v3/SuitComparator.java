package com.pacifich20.module2.v3;

import java.util.Comparator;
public class SuitComparator implements Comparator<Card> {

    /**
     * compares two cards based on suits
     * @param card1 first card to compare
     * @param card2 second card object to compare
     * @return negative integer if card1 less than card2, 0 if equal, and positive integer if card1 greater than card2
     */
    @Override
    public int compare(Card card1, Card card2) {
        Suit suit1 = card1.getSuit();
        Suit suit2 = card2.getSuit();

        if (suit1 == suit2) {
            return 0;
        }

        switch (suit1) {
            case DIAMOND:
                return 1;
            case CLUB:
                return compareClubToOtherSuits(suit2);
            case HEART:
                return compareHeartToOtherSuits(suit2);
            case SPADE:
                return -1;
            default:
                return 0; // Should not reach here
        }
    }

    /**
     * compares club suit to other suits
     * @param otherSuit suit to compare with club
     * @return negative integer if club less than other suit, 0 if equal, and positive integer if club is greater
     */
    private int compareClubToOtherSuits(Suit otherSuit) {
        return switch (otherSuit) {
            case DIAMOND -> -1;
            case HEART, SPADE -> 1;
            default -> 0;
        };
    }

    /**
     * compares heart suit to other suits
     * @param otherSuit suit to compare with heart
     * @return negative integer if heart less than other suit, 0 if equal, and positive integer if heart is greater
     */
    private int compareHeartToOtherSuits(Suit otherSuit) {
        return switch (otherSuit) {
            case DIAMOND, CLUB -> -1;
            case SPADE -> 1;
            default -> 0;
        };
    }
}