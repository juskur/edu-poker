package edu.poker.model;

import edu.poker.validators.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SuiteTest {

    @Test
    void testNotExistingSuite() {
        Suite suite = new Suite("Leafs");
        Assertions.assertThrows(ValidationException.class, () -> {
            suite.validate();
        });
    }

    @Test
    void testExistingSuite() {
        Suite suite = new Suite("Hearts");
        Assertions.assertDoesNotThrow(() -> {
            suite.validate();
        }, "Validation throws unexpected exception");
    }
}
