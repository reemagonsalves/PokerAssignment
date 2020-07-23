package net.covasoft.poker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Poker {

    /**
     * @param hands Hands playing poker, we assume that the game is played with a single deck of cards and nobody is
     *              cheating.
     * @return A set of winner(s), can be more than one if hands draw
     * @throws IllegalArgumentException If duplicate cards are used to play the game, someone is cheating!
     */
    public static Set<Hand> play(Set<Hand> hands) {
        Objects.requireNonNull(hands);
        if (hands.size() <= 1) {
            return new HashSet<>(hands);
        }

        long distinctCards = hands.stream()
                .flatMap(hand -> hand.getCards().stream())
                .distinct()
                .count();
        if (distinctCards != hands.size() * 5) {
            throw new IllegalArgumentException("Duplicate cards found, no cheating!");
        }


        Hand winner = Collections.max(hands);
        return hands.stream()
                .filter(hand -> hand.compareTo(winner) == 0)
                .collect(Collectors.toSet());
    }
}
