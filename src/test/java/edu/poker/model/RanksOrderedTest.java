package edu.poker.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RanksOrderedTest {

    @Test
    void testIsRoyalFlush() throws Exception {
        List<Card> cardList = Arrays.asList(new Card("Spades", "Ace"), new Card("Spades", "Jack"),
                new Card("Spades", "10"), new Card("Spades", "King"), new Card("Spades", "Queen"));
        RanksOrdered ordered = new RanksOrdered();
        ordered.addAll(cardList);
        assertTrue(ordered.isRoyalFlush(), "isRoyalFlush returns false for Royal Flush");
    }

    @Test
    void testIsNotRoyalFlushOfSuite() throws Exception {
        List<Card> cardList = Arrays.asList(new Card("Spades", "Ace"), new Card("Spades", "Jack"),
                new Card("Spades", "10"), new Card("Hearts", "King"), new Card("Spades", "Queen"));
        RanksOrdered ordered = new RanksOrdered();
        ordered.addAll(cardList);
        assertFalse(ordered.isRoyalFlush(), "isRoyalFlush returns true for not Royal Flush");
    }

    @Test
    void testIsNotRoyalFlushOfRank() throws Exception {
        List<Card> cardList = Arrays.asList(new Card("Spades", "Ace"), new Card("Spades", "Jack"),
                new Card("Spades", "9"), new Card("Spades", "King"), new Card("Spades", "Queen"));
        RanksOrdered ordered = new RanksOrdered();
        ordered.addAll(cardList);
        assertFalse(ordered.isRoyalFlush(), "isRoyalFlush returns true for not Royal Flush");
    }

    @Test
    void testIsStraightFlush() throws Exception {
        List<Card> cardList = Arrays.asList(new Card("Spades", "Ace"), new Card("Spades", "3"),
                new Card("Spades", "2"), new Card("Spades", "King"), new Card("Spades", "4"));
        RanksOrdered ordered = new RanksOrdered();
        ordered.addAll(cardList);
        assertTrue(ordered.isStraightFlush(), "isStraightFlush returns false for Straight Flush");
    }

    @Test
    void testIsStraight() throws Exception {
        List<Card> cardList = Arrays.asList(new Card("Spades", "Ace"), new Card("Diamonds", "3"),
                new Card("Hearts", "2"), new Card("Clubs", "King"), new Card("Spades", "Queen"));
        RanksOrdered ordered = new RanksOrdered();
        ordered.addAll(cardList);
        assertTrue(ordered.isStraight(), "isStraight returns false for Straight");
    }
}