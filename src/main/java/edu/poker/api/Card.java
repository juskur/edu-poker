package edu.poker.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Card api layer class
 */
@Validated
public class Card {
    @JsonProperty("suite")
    String suite;

    @JsonProperty("rank")
    String rank;

    /**
     * Get suite of the card
     *
     * @return suite
     **/
    @ApiModelProperty(value = "Suite of the card", example = "Hearts")
    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    /**
     * Get rank of the card
     *
     * @return rank
     **/
    @ApiModelProperty(value = "Get rank of the card", example = "Jack")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite='" + suite + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
