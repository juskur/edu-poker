package edu.poker.validators;

/**
 * Cards validation exception.
 */
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
