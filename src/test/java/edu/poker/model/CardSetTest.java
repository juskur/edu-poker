package edu.poker.model;

import edu.poker.validators.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardSetTest {

    @Test
    public void testHandHas5Cards() {
        CardSet cardSet = new CardSet(null);
        Assertions.assertThrows(ValidationException.class, () -> {
            cardSet.validate();
        });
    }

    @Test
    public void testCompareEqualHands() throws ValidationException {
        CardSet cardSet1 = new CardSet(Arrays.asList(new Card("Spades", "3"), new Card("Diamonds", "3"),
                new Card("Hearts", "King"), new Card("Clubs", "Queen"), new Card("Clubs", "3")));
        CardSet cardSet2 = new CardSet(Arrays.asList(new Card("Spades", "2"), new Card("Diamonds", "2"),
                new Card("Hearts", "King"), new Card("Clubs", "Queen"), new Card("Clubs", "2")));
        Hand hand1 = cardSet1.getHand();
        Hand hand2 = cardSet2.getHand();
        assertTrue(hand1.compareTo(hand2) > 0, "Three thees are less than three twos");
    }

    @Test
    public void testCompareEvenMoreEqualHands() throws ValidationException {
        CardSet cardSet1 = new CardSet(Arrays.asList(new Card("Spades", "3"), new Card("Diamonds", "3"),
                new Card("Hearts", "Jack"), new Card("Clubs", "Queen"), new Card("Clubs", "3")));
        CardSet cardSet2 = new CardSet(Arrays.asList(new Card("Spades", "3"), new Card("Diamonds", "3"),
                new Card("Hearts", "King"), new Card("Clubs", "Queen"), new Card("Clubs", "3")));
        Hand hand1 = cardSet1.getHand();
        Hand hand2 = cardSet2.getHand();
        assertTrue(hand1.compareTo(hand2) < 0, "Queen is greater than King");
    }

    @Test
    public void testCompareDifferentHands() throws ValidationException {
        CardSet cardSet1 = new CardSet(Arrays.asList(new Card("Spades", "2"), new Card("Diamonds", "2"),
                new Card("Hearts", "Jack"), new Card("Clubs", "Queen"), new Card("Clubs", "2")));
        CardSet cardSet2 = new CardSet(Arrays.asList(new Card("Spades", "2"), new Card("Diamonds", "3"),
                new Card("Hearts", "King"), new Card("Clubs", "Queen"), new Card("Clubs", "3")));
        Hand hand1 = cardSet1.getHand();
        Hand hand2 = cardSet2.getHand();
        assertTrue(hand1.compareTo(hand2) > 0, "Three twos is less than pair of 3");
    }
}