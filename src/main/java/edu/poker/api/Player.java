package edu.poker.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Player with cards
 */
@Validated
public class Player {

    @JsonProperty("name")
    String name;

    @JsonProperty("cards")
    List<Card> cardsList;

    /**
     * Name or number of the player
     *
     * @return name
     **/
    @ApiModelProperty(value = "Name or number of the player")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * List of five cards
     *
     * @return userId
     **/
    @ApiModelProperty(value = "List of five cards")
    public List<Card> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Card> cardsList) {
        this.cardsList = cardsList;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cardsList=" + cardsList +
                '}';
    }
}
