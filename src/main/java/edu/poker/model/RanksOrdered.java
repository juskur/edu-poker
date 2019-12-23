package edu.poker.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class identifying hands based on order of cards
 */
@Data
public class RanksOrdered {
    List<Card> cardsOrdered = null;

    /**
     * Add cards and order by rank in descending order
     * @param allCards
     */
    public void addAll(List<Card> allCards) {
        cardsOrdered = new ArrayList<>(allCards);
        cardsOrdered.sort((card1, card2) -> (card1.getRank().compareTo(card2.getRank()) * -1));
    }

    public boolean isRoyalFlush() {
        return isStraightFlush() && getLastCard().getRank().isTen();
    }

    public boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    public boolean isStraight() {
        int idxNotInOrderDescending = getIndexOfFirstNotInOrderDescending();
        if (idxNotInOrderDescending == cardsOrdered.size()) {
            return true;
        } else {
            //Ace must be the first and Two should be the last to connect
            if (isFirstAceAndLastTwo()) {
                int idxNotInOrderAscending = getIndexOfFirstNotInOrderAscending(idxNotInOrderDescending);
                if (idxNotInOrderDescending > idxNotInOrderAscending) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getIndexOfFirstNotInOrderDescending() {
        Card previousCard = getFirstCard();
        for (int i = 1; i < cardsOrdered.size(); i++) {
            if (!previousCard.getRank().isRankLowerByOne(cardsOrdered.get(i).getRank())) {
                return i;
            } else {
                previousCard = cardsOrdered.get(i);
            }
        }
        return cardsOrdered.size();
    }

    private int getIndexOfFirstNotInOrderAscending(int firstNotInOderDescendingIndex) {
        Card previousCard = getLastCard();
        for (int i = cardsOrdered.size() - 1; i <= firstNotInOderDescendingIndex; i--) {
            if (!previousCard.getRank().isRankHigherByOne(cardsOrdered.get(i).getRank())) {
                return i;
            } else {
                previousCard = cardsOrdered.get(i);
            }
        }
        return firstNotInOderDescendingIndex - 1;
    }

    public boolean isFlush() {
        Suite suiteOfFirstCard = getFirstCard().getSuite();
        for (int i = 1; i < cardsOrdered.size(); i++) {
            if (!suiteOfFirstCard.equals(cardsOrdered.get(i).getSuite())) {
                return false;
            }
        }
        return true;
    }

    private boolean isFirstAceAndLastTwo() {
        return getFirstCard().getRank().isAce() && getLastCard().getRank().isTwo();
    }

    private Card getFirstCard() {
        return cardsOrdered.get(0);
    }

    private Card getLastCard() {
        return cardsOrdered.get(cardsOrdered.size() - 1);
    }
}
