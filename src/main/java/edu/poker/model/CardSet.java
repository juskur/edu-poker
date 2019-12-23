package edu.poker.model;

import edu.poker.validators.ValidationException;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Card set object deciding the hand based on ordered or grouped ranks.
 */
@Data
public class CardSet {

    private static final Integer ACE_RANK_STRENGTH = Rank.RANKS_WITH_STRENGTH.get(Rank.RANK_ACE);
    List<Card> cards;
    private RanksOrdered orderedRanks = new RanksOrdered();
    private RanksGrouped groupedRanks = new RanksGrouped();

    /**
     * Constructor
     * @param cards in original order
     */
    public CardSet(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Get highest hand after validation
     * @return Highest hand so later two of them can be compared
     * @throws ValidationException on data validation error
     */
    public Hand getHand() throws ValidationException {
        validate();
        calculateRanks();
        return new Hand(getHandNameByRankingResult(), this);
    }

    private String getHandNameByRankingResult() {
        String handName = Hand.HAND_HIGH_CARD;
        if (orderedRanks.isRoyalFlush()) {
            handName = Hand.HAND_ROYAL_FLUSH;
        } else if (orderedRanks.isStraightFlush()) {
            handName = Hand.HAND_STRAIGHT_FLUSH;
        } else if (groupedRanks.isFourOfTheKind()) {
            handName = Hand.HAND_FOUR_OF_A_KIND;
        } else if (groupedRanks.isFullHouse()) {
            handName = Hand.HAND_FULL_HOUSE;
        } else if (orderedRanks.isFlush()) {
            handName = Hand.HAND_FLUSH;
        } else if (orderedRanks.isStraight()) {
            handName = Hand.HAND_STRAIGHT;
        } else if (groupedRanks.isThreeOfTheKind()) {
            handName = Hand.HAND_THREE_OF_A_KIND;
        } else if (groupedRanks.isTwoPair()) {
            handName = Hand.HAND_TWO_PAIR;
        } else if (groupedRanks.isPair()) {
            handName = Hand.HAND_PAIR;
        }
        return handName;
    }

    private void calculateRanks() {
        orderedRanks.addAll(this.cards);
        groupedRanks.addAll(this.cards);
    }

    public void validate() throws ValidationException {
        validateSize();
        validateCards();
    }

    private void validateSize() throws ValidationException {
        if (cards == null || !(cards.size() == 5)) {
            throw new ValidationException("There should be 5 cards in hand");
        }
    }

    private void validateCards() throws ValidationException {
        for (Card card : cards) {
            card.validate();
        }
    }

    public List<Rank> getDescendingRanksForComparison(Hand hand) {
        switch (hand.getName()) {
            case Hand.HAND_HIGH_CARD:
            case Hand.HAND_ROYAL_FLUSH:
            case Hand.HAND_STRAIGHT_FLUSH:
            case Hand.HAND_FLUSH:
            case Hand.HAND_STRAIGHT:
                return orderedRanks.cardsOrdered.stream().map(Card::getRank).collect(Collectors.toList());
            default:
                return groupedRanks.getDescendingRanks();
        }
    }
}
