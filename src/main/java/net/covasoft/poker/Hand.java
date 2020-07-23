package net.covasoft.poker;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public final class Hand implements Comparable<Hand> {

    private final String player;
    private final Collection<Card> cards;

    /**
     * Cards in the hand cannot be equal or null
     *
     * @param player the name of the player
     * @param card1  card 1
     * @param card2  card 2
     * @param card3  card 3
     * @param card4  card 4
     * @param card5  card 5
     * @throws IllegalArgumentException If duplicate cards are used to make the hand, someone is cheating!
     */
    public Hand(String player, Card card1, Card card2, Card card3, Card card4, Card card5) {
        this.player = Objects.requireNonNull(player);
        cards = Set.of(
                Objects.requireNonNull(card1),
                Objects.requireNonNull(card2),
                Objects.requireNonNull(card3),
                Objects.requireNonNull(card4),
                Objects.requireNonNull(card5));

        if (cards.size() != 5) {
            throw new IllegalArgumentException("Duplicate cards found, no cheating!");
        }
    }

    @Override
    public int compareTo(Hand o) {
        Optional<Integer> compareFlush = compareFlush(o);
        if (compareFlush.isPresent()) {
            return compareFlush.get();
        }

        Optional<Integer> compareThreeOfAKind = compareOfAKind(o, 3);
        if (compareThreeOfAKind.isPresent()) {
            return compareThreeOfAKind.get();
        }

        Optional<Integer> compareHighPair = compareOfAKind(o, 2);
        if (compareHighPair.isPresent()) {
            return compareHighPair.get();
        }

        return Long.compare(getHandValue(), o.getHandValue());
    }

    /**
     * Compares this hand with the specified other hand in terms of flush hand value. If neither hand is a flush then
     * returns an empty Optional. Otherwise, if either or both hands are a flush, then returns an Optional containing
     * the comparison result. The comparison result is a negative integer, zero, or a positive integer as this hand is
     * less than, equal to, or greater than the other hand.
     *
     * @param o the other hand to be compared against
     * @return an optional comparison result
     */
    private Optional<Integer> compareFlush(Hand o) {
        boolean isFlush = isFlush();
        boolean otherIsFlush = o.isFlush();

        if (isFlush && otherIsFlush) {
            return Optional.of(Long.compare(getHandValue(), o.getHandValue()));
        } else if (isFlush) {
            return Optional.of(1);
        } else if (otherIsFlush) {
            return Optional.of(-1);
        } else {
            return Optional.empty();
        }
    }

    private boolean isFlush() {
        Suit aSuit = cards.iterator().next().getSuit();
        return cards.stream()
                .allMatch(card -> aSuit.equals(card.getSuit()));
    }

    /**
     * Compares this hand with the specified other hand in terms of of-a-kind hand value. An of-a-kind hand is a hand
     * that contains multiple cards of the same Rank. If neither hand is of-a-kind then returns an empty Optional.
     * Otherwise, if either or both hands are an of-a-kind, then returns an Optional containing the comparison result.
     * The comparison result is a negative integer, zero, or a positive integer as this hand is less than, equal to, or
     * greater than the other hand.
     *
     * @param o the other hand to be compared against
     * @param ofAKind the number of cards with the same rank required for a hand to be of-a-kind
     * @return an optional comparison result
     */
    private Optional<Integer> compareOfAKind(Hand o, int ofAKind) {
        Optional<Rank> maxOfAKindOption = getMaxOfAKindRank(ofAKind);
        Optional<Rank> otherMaxOfAKindOption = o.getMaxOfAKindRank(ofAKind);

        if (maxOfAKindOption.isPresent() && otherMaxOfAKindOption.isPresent()) {
            Rank maxOfAKindRank = maxOfAKindOption.get();
            Rank otherMaxOfAKindRank = otherMaxOfAKindOption.get();

            // if the ranks of the of-a-kinds are equal then compare the other cards in the hand
            if (maxOfAKindRank.equals(otherMaxOfAKindRank)) {
                Collection<Card> nonOfAKindCards = getNonOfAKindCards(maxOfAKindRank);
                Collection<Card> otherNonOfAKindCards = o.getNonOfAKindCards(otherMaxOfAKindRank);
                return Optional.of(Long.compare(getCardsValue(nonOfAKindCards), getCardsValue(otherNonOfAKindCards)));
            }

            return Optional.of(maxOfAKindRank.compareTo(otherMaxOfAKindRank));

        } else if (maxOfAKindOption.isPresent()) {
            return Optional.of(1);
        } else if (otherMaxOfAKindOption.isPresent()) {
            return Optional.of(-1);
        } else {
            return Optional.empty();
        }
    }

    private Optional<Rank> getMaxOfAKindRank(int ofAKind) {
        Collection<Rank> ranks = cards.stream()
                .map(Card::getRank)
                .collect(Collectors.toList());
        return ranks.stream()
                .filter(rank -> Collections.frequency(ranks, rank) == ofAKind)
                .max(Comparator.naturalOrder());
    }

    private Collection<Card> getNonOfAKindCards(Rank rank) {
        return cards.stream()
                .filter(card -> !card.getRank().equals(rank))
                .collect(Collectors.toList());
    }

    private long getHandValue() {
        return getCardsValue(cards);
    }

    /**
     * To be able to compare the value or strength of a collection of cards to another of equal size without looping and
     * comparing Ranks we can give each collection of cards a long value. To ensure that a card of a higher rank in one
     * collection will beat any combination of lower rank cards in the other collection we use the number of cards in
     * the collection to the power of an index value for each rank.
     *
     * @return Returns the cumulative value of a collection of cards
     */
    private long getCardsValue(Collection<Card> cards) {
        long handValue = cards.stream()
                .mapToLong(card -> getRankValue(card.getRank(), cards.size()))
                .sum();
        if (handValue >= Long.MAX_VALUE) {
            throw new IllegalStateException("Cannot calculate hand value due to long overflow");
        }
        return handValue;
    }

    private long getRankValue(Rank rank, int numberOfCards) {
        long rankValue = (long) Math.pow(numberOfCards, rank.getValue());
        if (rankValue >= Long.MAX_VALUE) {
            throw new IllegalStateException("Cannot calculate rank value due to long overflow");
        }
        return rankValue;
    }

    public String getPlayer() {
        return player;
    }

    public Set<Card> getCards() {
        return new HashSet<>(cards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return player.equals(hand.player) &&
                cards.equals(hand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, cards);
    }

    @Override
    public String toString() {
        return "Hand{" +
                "player='" + player + '\'' +
                ", cards=" + cards +
                '}';
    }
}
