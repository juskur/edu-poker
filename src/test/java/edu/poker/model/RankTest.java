package edu.poker.model;

import edu.poker.validators.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RankTest {

    @Test
    void testNotExistingRank() {
        Rank rank = new Rank("W");
        Assertions.assertThrows(ValidationException.class, () -> {
            rank.validate();
        });
    }

    @Test
    void testExistingRank() {
        Rank rank = new Rank("Ace");
        Assertions.assertDoesNotThrow(() -> {
            rank.validate();
        }, "Validation throws unexpected exception");
    }

    @Test
    void testIsAce() {
        Rank rank = new Rank("Ace");
        assertTrue(rank.isAce(), "isAce returns false for rank Ace");
    }
}
