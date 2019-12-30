package edu.poker.api;

import edu.poker.model.CardSet;
import edu.poker.model.Hand;
import edu.poker.model.Rank;
import edu.poker.model.Suite;
import edu.poker.validators.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Poker API
 */
@Controller
public class PokerApiController implements PokerApi {
    private static final Logger log = LoggerFactory.getLogger(PokerApiController.class);
    public static final String RESULT_WINNING_PLAYER_MESSAGE = "Player %s wins with %s because Player %s had only %s";
    public static final String RESULT_TIE_MESSAGE = "No one wins. Both players have the same hand %s";
    public static final String RESULT_VALIDATION_MESSAGE = "Cards can not be compared: %s";
    public static final String RESULT_SYSTEM_ERROR_MESSAGE = "System error: %s";

    /**
     * Compare cards rest method
     *
     * @param players players
     * @return response entity with result
     */
    @Override
    public ResponseEntity<Result> compareCards(@Valid Players players) {
        try {
            validatePlayers(players);
            CardSet cardSet0 = createCardSet(players.get(0).getCardsList());
            CardSet cardSet1 = createCardSet(players.get(1).getCardsList());
            return ResponseEntity.status(HttpStatus.CREATED).body(getComparisonResult(players.get(0).getName(),
                    cardSet1, players.get(1).getName(), cardSet1));
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Result(String.format(RESULT_VALIDATION_MESSAGE, e.getMessage())));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Result(String.format(RESULT_SYSTEM_ERROR_MESSAGE, e.getMessage())));
        }
    }

    /**
     * Crete model card from list of api layer cards
     *
     * @param cards api layer cards
     * @return model layer car set
     */
    private CardSet createCardSet(List<Card> cards) {
        List<edu.poker.model.Card> mCards = new ArrayList<>();
        for (Card card : cards) {
            edu.poker.model.Card mCard = new edu.poker.model.Card(new Suite(card.getSuite()), new Rank(card.getRank()));
            mCards.add(mCard);
        }
        return new CardSet(mCards);
    }

    /**
     * Get hands, compare them and return comparison message
     *
     * @param player1Name  player name
     * @param player1Cards player's cards
     * @param player2Name  player name
     * @param player2Cards player's cards
     * @return comparison result with message
     * @throws ValidationException if card suites or ranks are not valid
     */
    private Result getComparisonResult(String player1Name, CardSet player1Cards, String player2Name, CardSet player2Cards) throws ValidationException {
        Hand player1Hand = player1Cards.getHand();
        Hand player2Hand = player2Cards.getHand();
        Result result = new Result();
        int compared = player1Hand.compareTo(player2Hand);
        if (compared > 0) {
            result.setMessage(String.format(RESULT_WINNING_PLAYER_MESSAGE, player1Name, player1Hand.getName(), player2Name, player2Hand.getName()));
        } else if (compared < 0) {
            result.setMessage(String.format(RESULT_WINNING_PLAYER_MESSAGE, player2Name, player2Hand.getName(), player1Name, player1Hand.getName()));
        } else {
            result.setMessage(String.format(RESULT_TIE_MESSAGE, player1Hand.getName()));
        }
        return result;
    }

    private void validatePlayers(Players players) throws ValidationException {
        validatePlayersNotEmpty(players);
        validateExactlyTwoPlayers(players);
    }

    private void validatePlayersNotEmpty(Players players) throws ValidationException {
        if (players == null) {
            throw new ValidationException("Players are null.");
        }
    }

    private void validateExactlyTwoPlayers(Players players) throws ValidationException {
        if (players.size() != 2) {
            throw new ValidationException("There should be exactly two players in the request body");
        }
    }
}
