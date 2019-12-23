package edu.poker.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RanksGroupedTest {

    @Test
    void testIsFourOfTheKind() {
        List<Card> cardList = Arrays.asList(new Card("Spades", "3"), new Card("Diamonds", "3"),
                new Card("Hearts", "3"), new Card("Clubs", "King"), new Card("Clubs", "3"));
        RanksGrouped grouped = new RanksGrouped();
        grouped.addAll(cardList);
        assertTrue(grouped.isFourOfTheKind(), "isFourOfTheKind returns false for Four Of The Kind");
        assertFalse(grouped.isFullHouse(), "isFullHouse returns true for Four Of The Kind");
        assertFalse(grouped.isThreeOfTheKind(), "isThreeOfTheKind returns true for Four Of The Kind");
        assertFalse(grouped.isTwoPair(), "isTwoPair returns true for Four Of The Kind");
        assertFalse(grouped.isPair(), "isPair returns true for Four Of The Kind");
    }

    @Test
    void testIsFullHouse() {
        List<Card> cardList = Arrays.asList(new Card("Spades", "3"), new Card("Diamonds", "3"),
                new Card("Hearts", "King"), new Card("Clubs", "King"), new Card("Clubs", "3"));
        RanksGrouped grouped = new RanksGrouped();
        grouped.addAll(cardList);
        assertFalse(grouped.isFourOfTheKind(), "isFourOfTheKind returns true for Full House");
        assertTrue(grouped.isFullHouse(), "isFullHouse returns false for Full House");
        assertFalse(grouped.isThreeOfTheKind(), "isThreeOfTheKind returns true for Full House");
        assertFalse(grouped.isTwoPair(), "isTwoPair returns true for Full House");
        assertFalse(grouped.isPair(), "isPair returns true for Full House");
    }

    @Test
    void testIsThreeOfTheKind() {
        List<Card> cardList = Arrays.asList(new Card("Spades", "3"), new Card("Diamonds", "3"),
                new Card("Hearts", "King"), new Card("Clubs", "Queen"), new Card("Clubs", "3"));
        RanksGrouped grouped = new RanksGrouped();
        grouped.addAll(cardList);
        assertFalse(grouped.isFourOfTheKind(), "isFourOfTheKind returns true for Three Of The Kind");
        assertFalse(grouped.isFullHouse(), "isFullHouse returns true for Three Of The Kind");
        assertTrue(grouped.isThreeOfTheKind(), "isThreeOfTheKind returns false for Three Of The Kind");
        assertFalse(grouped.isTwoPair(), "isTwoPair returns true for Three Of The Kind");
        assertFalse(grouped.isPair(), "isPair returns true for Three Of The Kind");
    }

    @Test
    void testIsTwoPair() {
        List<Card> cardList = Arrays.asList(new Card("Spades", "3"), new Card("Diamonds", "2"),
                new Card("Hearts", "King"), new Card("Clubs", "King"), new Card("Clubs", "3"));
        RanksGrouped grouped = new RanksGrouped();
        grouped.addAll(cardList);
        assertFalse(grouped.isFourOfTheKind(), "isFourOfTheKind returns false for Two Pair");
        assertFalse(grouped.isFullHouse(), "isFullHouse returns true for Two Pair");
        assertFalse(grouped.isThreeOfTheKind(), "isThreeOfTheKind returns true for Two Pair");
        assertTrue(grouped.isTwoPair(), "isTwoPair returns false for Two Pair");
        assertFalse(grouped.isPair(), "isPair returns true for Two Pair");
    }

    @Test
    void testIsPair() {
        List<Card> cardList = Arrays.asList(new Card("Spades", "Ace"), new Card("Diamonds", "3"),
                new Card("Hearts", "King"), new Card("Clubs", "Jack"), new Card("Clubs", "3"));
        RanksGrouped grouped = new RanksGrouped();
        grouped.addAll(cardList);
        assertFalse(grouped.isFourOfTheKind(), "isFourOfTheKind returns false for Pair");
        assertFalse(grouped.isFullHouse(), "isFullHouse returns true for Pair");
        assertFalse(grouped.isThreeOfTheKind(), "isThreeOfTheKind returns true for Pair");
        assertFalse(grouped.isTwoPair(), "isTwoPair returns true for Pair");
        assertTrue(grouped.isPair(), "isPair returns false for Pair");
    }

    @Test
    void testAreRanksDescending() {
        List<Card> cardList = Arrays.asList(new Card("Spades", "3"), new Card("Diamonds", "3"),
                new Card("Hearts", "King"), new Card("Clubs", "Queen"), new Card("Clubs", "3"));
        RanksGrouped grouped = new RanksGrouped();
        grouped.addAll(cardList);
        List<Rank> ranksForComparison = grouped.getDescendingRanks();
        assertTrue(ranksForComparison.size() == 3, "side of descending ranks is not 3");
        assertTrue(ranksForComparison.get(0).getName().equals("King"), "first rank is not King");
        assertTrue(ranksForComparison.get(1).getName().equals("Queen"), "second rank is not Queen");
        assertTrue(ranksForComparison.get(2).getName().equals("3"), "third rank is not 3");
    }
}