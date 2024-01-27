package com.pacifich20.module2.v3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Deck deck1 = new Deck();

        System.out.println("Hand 1:");
        List<Card> hand1 = deck1.drawSeven();
        for (Card card : hand1) {
            System.out.println(card);
        }

        System.out.println("Hand 2:");
        List<Card> hand2 = deck1.drawSeven();
        for (Card card : hand2) {
            System.out.println(card);
        }

        System.out.println("Is hand 1 the same as hand 2? " + hand1.equals(hand2));

        hand1.sort(new SuitComparator());
        System.out.println("Hand 1 sorted by suit: ");
        for (Card card : hand1) {
            System.out.println(card);
        }
        hand2.sort(new RankComparator());
        System.out.println("Hand 2 sorted by rank: ");
        for (Card card : hand2) {
            System.out.println(card);

        }
    }
}