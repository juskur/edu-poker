package edu.poker.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Result of card comparison
 */
@Validated
public class Result {
    @JsonProperty("message of comparison")
    private String message;

    public Result() {}

    public Result(String message) {
        this.message = message;
    }

    /**
     * Get comparison message
     * @return message
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
