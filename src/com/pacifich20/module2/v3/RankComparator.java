package com.pacifich20.module2.v3;

import java.util.Comparator;

public class RankComparator implements Comparator<Card> {

    /**
     * compares two cards based on rank
     * @param card1 first card to compare
     * @param card2 second card to compare
     * @return negative integer if card1 is less than card2, 0 if equal, and positive integer if card1 greater than card2
     */
    @Override
    public int compare(Card card1, Card card2) {
        String rank1 = card1.getRank();
        String rank2 = card2.getRank();

        if (rank1.equals(rank2)) {
            return 0;
        }

        if (card1.faceCard() && !card2.faceCard()) {
            return compareFaceCardToNonFaceCard(card1, card2);
        } else if (!card1.faceCard() && card2.faceCard()) {
            return -compareFaceCardToNonFaceCard(card2, card1);
        } else {
            return Integer.compare(Integer.parseInt(rank1), Integer.parseInt(rank2));
        }
    }

    /**
     * compares face card to a non-face card, considering order of face cards
     * @param faceCard face card to compare.
     * @param nonFaceCard non-face card to compare.
     * @return negative integer if face card less than non-face card, 0 if equal, and a positive integer if face card greater
     */
    private int compareFaceCardToNonFaceCard(Card faceCard, Card nonFaceCard) {
        switch (faceCard.getRank()) {
            case "K":
                return -1;
            case "Q":
                return nonFaceCard.getRank().equals("K") ? 1 : -1;
            case "J":
                return nonFaceCard.getRank().equals("K") || nonFaceCard.getRank().equals("Q") ? 1 : -1;
            default:
                return 0;
        }
    }
}