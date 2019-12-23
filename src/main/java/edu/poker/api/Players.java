package edu.poker.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Two players class
 */
@Validated
public class Players {
    @JsonProperty("player1")
    private Player player1;

    @JsonProperty("player2")
    private Player player2;

    /**
     * Get player one
     *
     * @return player1
     */
    @ApiModelProperty(value = "Player one")
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Get player two
     *
     * @return player2
     */
    @ApiModelProperty(value = "Player two")
    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return "Players{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }
}
