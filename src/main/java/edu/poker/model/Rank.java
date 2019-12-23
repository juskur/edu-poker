package edu.poker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Rank data representation class
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Rank extends NameWithStrength {

    public static final String RANK_ACE = "Ace";
    public static final String RANK_TEN = "10";
    public static final String RANK_TWO = "2";
    public static final Integer RANK_ACE_STRENGTH = new Integer(13);
    public static final Integer RANK_TEN_STRENGTH = new Integer(9);
    public static final Integer RANK_TWO_STRENGTH = new Integer(1);
    public static final Map<String, Integer> RANKS_WITH_STRENGTH = Collections.unmodifiableMap(getRanksWithStrength());

    private static Map<String, Integer> getRanksWithStrength() {
        Map<String, Integer> suitesMap = new HashMap<>();
        suitesMap.put(RANK_ACE, RANK_ACE_STRENGTH);
        suitesMap.put("King", new Integer(12));
        suitesMap.put("Queen", new Integer(11));
        suitesMap.put("Jack", new Integer(10));
        suitesMap.put(RANK_TEN, RANK_TEN_STRENGTH);
        suitesMap.put("9", new Integer(8));
        suitesMap.put("8", new Integer(7));
        suitesMap.put("7", new Integer(6));
        suitesMap.put("6", new Integer(5));
        suitesMap.put("5", new Integer(4));
        suitesMap.put("4", new Integer(3));
        suitesMap.put("3", new Integer(2));
        suitesMap.put(RANK_TWO, RANK_TWO_STRENGTH);
        return suitesMap;
    }

    public Rank(String rank) {
        super(rank);
    }

    @Override
    protected Map<String, Integer> getNamesWithStrengthsMap() {
        return RANKS_WITH_STRENGTH;
    }

    public boolean isAce() {
        return RANK_ACE_STRENGTH.equals(getStrength());
    }

    public boolean isTwo() {
        return RANK_TWO_STRENGTH.equals(getStrength());
    }

    public boolean isTen() {
        return RANK_TEN_STRENGTH.equals(getStrength());
    }

    public boolean isRankLowerByOne(Rank rank) {
        return (getStrength() - rank.getStrength() == 1);
    }

    public boolean isRankHigherByOne(Rank rank) {
        return (rank.getStrength() - getStrength() == 1);
    }
}
