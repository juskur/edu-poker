package edu.poker.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Grouping cards by rank class. Used to identify group based ranks.
 */
@Data
public class RanksGrouped {
    Map<Rank, List<Card>> rankCarMap = new TreeMap<>();
    List<Card> fourOfAKind = null;
    List<Card> threeOfAKind = null;
    List<Card> pair1 = null;
    List<Card> pair2 = null;

    /**
     * Add cards to groups and identify hands
     * @param allCards
     */
    public void addAll(List<Card> allCards) {
        allCards.forEach(this::add);
        fillHands();
    }

    private void add(Card card) {
        getListOfRank(card.getRank()).add(card);
    }

    private List<Card> getListOfRank(Rank rank) {
        List<Card> listByRank = rankCarMap.get(rank);
        if (listByRank == null) {
            listByRank = new ArrayList<>();
            rankCarMap.put(rank, listByRank);
        }
        return listByRank;
    }

    private void fillHands() {
        rankCarMap.values().forEach(group -> {
            if (group.size() == 4) {
                fourOfAKind = group;
            } else if (group.size() == 3) {
                threeOfAKind = group;
            } else if (group.size() == 2 && pair1 == null) {
                pair1 = group;
            } else if (group.size() == 2) {
                pair2 = group;
            }
        });
    }

    public boolean isFourOfTheKind() {
        return fourOfAKind != null;
    }

    public boolean isFullHouse() {
        return (fourOfAKind == null) && (threeOfAKind != null) && (pair1 != null);
    }

    public boolean isThreeOfTheKind() {
        return (fourOfAKind == null) && (threeOfAKind != null) && (pair1 == null);
    }

    public boolean isTwoPair() {
        return (fourOfAKind == null) && (threeOfAKind == null) && (pair1 != null) && (pair2 != null);
    }

    public boolean isPair() {
        return (fourOfAKind == null) && (threeOfAKind == null) && (pair1 != null) && (pair2 == null);
    }

    public List<Rank> getDescendingRanks() {
        return rankCarMap.keySet().stream()
                .sorted((rank1, rank2) -> (rank1.getStrength().compareTo(rank2.getStrength()) * -1))
                .collect(Collectors.toList());
    }
}
