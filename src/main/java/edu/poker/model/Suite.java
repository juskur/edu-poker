package edu.poker.model;

import edu.poker.validators.ValidationException;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Suite representation. Suites are considered equal
 */
@Data
public class Suite {

    public static final List<String> SUITES = Collections.unmodifiableList(Arrays.asList("Hearts", "Spades", "Diamonds", "Clubs"));

    private String name;

    public Suite(String name) {
        this.name = name;
    }

    public void validate() throws ValidationException {
        if (!SUITES.contains(name)) {
            throw new ValidationException(String.format("No such suite: %s", name));
        }
    }
}

