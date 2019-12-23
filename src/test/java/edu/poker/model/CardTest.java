package edu.poker.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTest {

    @Test
    void testEqualCards() {
        Card jackOfDiamonds = new Card("Diamonds", "Jack");
        Card jackOfClubs = new Card("Clubs", "Jack");
        assertTrue(jackOfDiamonds.equals(jackOfClubs), "Cards are not equal");
    }

    @Test
    void testCreateCard() throws Exception {
        Card aceOfSpades = new Card("Spades", "Ace");
        aceOfSpades.validate();
        assertTrue(aceOfSpades.getRank().getName().equals("Ace"));
    }
}
