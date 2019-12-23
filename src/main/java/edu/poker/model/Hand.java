package edu.poker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hand representation data object
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Hand extends NameWithStrength {
    public static final Map<String, Integer> HANDS_WITH_STRENGTH = Collections.unmodifiableMap(getHandsWithStrength());

    public static final String HAND_ROYAL_FLUSH = "Royal Flush";
    public static final String HAND_STRAIGHT_FLUSH = "Straight Flush";
    public static final String HAND_FOUR_OF_A_KIND = "Four of a Kind";
    public static final String HAND_FULL_HOUSE = "Full House";
    public static final String HAND_FLUSH = "Flush";
    public static final String HAND_STRAIGHT = "Straight";
    public static final String HAND_THREE_OF_A_KIND = "Three of a Kind";
    public static final String HAND_TWO_PAIR = "Two Pair";
    public static final String HAND_PAIR = "Pair";
    public static final String HAND_HIGH_CARD = "High Card";

    private static Map<String, Integer> getHandsWithStrength() {
        Map<String, Integer> handsMap = new HashMap<>();
        handsMap.put(HAND_ROYAL_FLUSH, new Integer(10));
        handsMap.put(HAND_STRAIGHT_FLUSH, new Integer(9));
        handsMap.put(HAND_FOUR_OF_A_KIND, new Integer(8));
        handsMap.put(HAND_FULL_HOUSE, new Integer(7));
        handsMap.put(HAND_FLUSH, new Integer(6));
        handsMap.put(HAND_STRAIGHT, new Integer(5));
        handsMap.put(HAND_THREE_OF_A_KIND, new Integer(4));
        handsMap.put(HAND_TWO_PAIR, new Integer(3));
        handsMap.put(HAND_PAIR, new Integer(2));
        handsMap.put(HAND_HIGH_CARD, new Integer(1));
        return handsMap;
    }

    private CardSet cardSet;

    public Hand(String name, CardSet cardSet) {
        super(name);
        this.cardSet = cardSet;
    }

    @Override
    protected Map<String, Integer> getNamesWithStrengthsMap() {
        return HANDS_WITH_STRENGTH;
    }

    @Override
    public int compareTo(NameWithStrength o) {
        int compareResult = super.compareTo(o);
        if ((o instanceof Hand) && (compareResult == 0)) {
            //when hands are equal we must compare ranks of cards
            List<Rank> ranks = cardSet.getDescendingRanksForComparison(this);
            List<Rank> oRanks = ((Hand) o).cardSet.getDescendingRanksForComparison((Hand) o);
            for (int i = 0; i < ranks.size(); i++) {
                int result = ranks.get(i).compareTo(oRanks.get(i));
                if (result != 0) {
                    return result;
                }
            }
        }
        return compareResult;
    }
}