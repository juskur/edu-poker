package edu.poker.model;

import edu.poker.validators.ValidationException;
import lombok.Data;

/**
 * Card model data object
 */
@Data
public class Card {

    private Suite suite;
    private Rank rank;

    public Card(Suite suite, Rank rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public Card(String suite, String rank) {
        this.suite = new Suite(suite);
        this.rank = new Rank(rank);
    }

    public void validate() throws ValidationException {
        suite.validate();
        rank.validate();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Card)) {
            return false;
        } else {
            return ((Card) o).rank.equals(this.rank);
        }
    }
}
