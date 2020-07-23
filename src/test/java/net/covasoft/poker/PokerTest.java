package net.covasoft.poker;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class PokerTest {

	/*********************************************************************************/
	/*********************
	 * FUNCTIONAL TEST CASES
	 *************************************/
	/**********************************************************************************/

	/*
	 * This is the test case where Flush against 3-of-A-Kind condition is tested
	 * then player with Flush is the winner
	 */
	@Test
	public void when_flush_against_threeOfAKind() {

		// Prepare
		String player1 = "Jane";
		String player2 = "Simon";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.ACE); // Flush cards
		Card card4 = new Card(Suit.HEARTS, Rank.NINE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.FIVE); // 3 of A kind cards
		Card card9 = new Card(Suit.SPADES, Rank.FIVE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where Flush against One Pair condition is tested then
	 * player with Flush is the winner
	 */
	@Test
	public void when_flush_against_onePair() {

		// Prepare
		String player1 = "Jane";
		String player2 = "Simon";

		Card card1 = new Card(Suit.CLUBS, Rank.ACE); // one pair card
		Card card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card3 = new Card(Suit.HEARTS, Rank.FIVE);
		Card card4 = new Card(Suit.SPADES, Rank.ACE); // one pair card
		Card card5 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.HEARTS, Rank.THREE);
		Card card7 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card8 = new Card(Suit.HEARTS, Rank.ACE); // Flush cards
		Card card9 = new Card(Suit.HEARTS, Rank.NINE);
		Card card10 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where Flush against High card condition is tested then
	 * player with Flush is the winner
	 */
	@Test
	public void when_flush_against_highCard() {

		// Prepare
		String player1 = "Jane";
		String player2 = "Simon";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.ACE); // Flush cards
		Card card4 = new Card(Suit.HEARTS, Rank.NINE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card card7 = new Card(Suit.SPADES, Rank.THREE);
		Card card8 = new Card(Suit.SPADES, Rank.ACE); // High value card
		Card card9 = new Card(Suit.SPADES, Rank.FOUR);
		Card card10 = new Card(Suit.DIAMONDS, Rank.FIVE);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where 3-Of-A-Kind against One pair condition is tested
	 * then player with 3-Of-A-Kind is the winner
	 */
	@Test
	public void when_threeOfAKind_against_onePair() {

		// Prepare
		String player1 = "Kelly";
		String player2 = "Ryan";

		Card card1 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card3 = new Card(Suit.HEARTS, Rank.FIVE); // 3 of A kind cards
		Card card4 = new Card(Suit.SPADES, Rank.FIVE);
		Card card5 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.HEARTS, Rank.THREE);
		Card card7 = new Card(Suit.SPADES, Rank.FOUR);
		Card card8 = new Card(Suit.CLUBS, Rank.QUEEN); // One pair
		Card card9 = new Card(Suit.DIAMONDS, Rank.NINE);
		Card card10 = new Card(Suit.DIAMONDS, Rank.QUEEN); // One pair

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where 3-Of-A-Kind against High card condition is tested
	 * then player with 3-Of-A-Kind is the winner
	 */
	@Test
	public void when_threeOfAKind_against_highCard() {

		// Prepare
		String player1 = "Kelly";
		String player2 = "Ryan";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.SPADES, Rank.FOUR);
		Card card3 = new Card(Suit.CLUBS, Rank.KING); // High Card
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE);
		Card card5 = new Card(Suit.DIAMONDS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.FIVE); // 3 of A kind cards
		Card card9 = new Card(Suit.SPADES, Rank.FIVE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where One pair against High card condition is tested
	 * then player with One pair is the winner
	 */
	@Test
	public void when_onePair_against_highCard() {

		// Prepare
		String player1 = "Kelly";
		String player2 = "Ryan";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.SPADES, Rank.FOUR);
		Card card3 = new Card(Suit.CLUBS, Rank.QUEEN); // One pair
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE);
		Card card5 = new Card(Suit.DIAMONDS, Rank.QUEEN); // One pair

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.ACE); // High card
		Card card9 = new Card(Suit.SPADES, Rank.FIVE);
		Card card10 = new Card(Suit.SPADES, Rank.JACK);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where player1 has all 5 cards of the same suit(Flush)
	 * and is the winner
	 */
	@Test
	public void when_flush_then_onePlayerWins() {

		// Prepare
		String player1 = "Joe";
		String player2 = "Jen";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.ACE); // Flush cards
		Card card4 = new Card(Suit.HEARTS, Rank.NINE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.FIVE); // All random cards
		Card card9 = new Card(Suit.SPADES, Rank.NINE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have all 5 cards of the same suit
	 * (Flush) then the player with first highest card value is the winner
	 */
	@Test
	public void when_flush_both_then_firstHighestCardWins() {

		// Prepare
		String player1 = "Joe";
		String player2 = "Jen";

		Card card1 = new Card(Suit.HEARTS, Rank.QUEEN);
		Card card2 = new Card(Suit.HEARTS, Rank.SIX);
		Card card3 = new Card(Suit.HEARTS, Rank.JACK);
		Card card4 = new Card(Suit.HEARTS, Rank.NINE);
		Card card5 = new Card(Suit.HEARTS, Rank.TWO);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FOUR);
		Card card7 = new Card(Suit.CLUBS, Rank.KING);
		Card card8 = new Card(Suit.CLUBS, Rank.ACE); // Highest card
		Card card9 = new Card(Suit.CLUBS, Rank.THREE);
		Card card10 = new Card(Suit.CLUBS, Rank.TEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have all 5 cards of the same suit
	 * (Flush) and one card with same strength then the player with second highest
	 * card value is the winner
	 */
	@Test
	public void when_flush_both_then_secondHighestCardWins() {

		// Prepare
		String player1 = "Jim";
		String player2 = "Pam";

		Card card1 = new Card(Suit.HEARTS, Rank.JACK); // Highest card
		Card card2 = new Card(Suit.HEARTS, Rank.TWO);
		Card card3 = new Card(Suit.HEARTS, Rank.SIX);
		Card card4 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN); // Same strength

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.THREE);
		Card card7 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card8 = new Card(Suit.CLUBS, Rank.EIGHT);
		Card card9 = new Card(Suit.CLUBS, Rank.TEN);
		Card card10 = new Card(Suit.CLUBS, Rank.QUEEN); // Same strength

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have all 5 cards of the same suit
	 * (Flush) and two cards with same strength then the player with third highest
	 * card value is the winner
	 */
	@Test
	public void when_flush_both_then_thirdHighestCardWins() {

		// Prepare
		String player1 = "Jim";
		String player2 = "Pam";

		Card card1 = new Card(Suit.HEARTS, Rank.JACK); // Same strength
		Card card2 = new Card(Suit.HEARTS, Rank.TWO);
		Card card3 = new Card(Suit.HEARTS, Rank.SIX);
		Card card4 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN); // Same strength

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.JACK); // Same strength
		Card card7 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card8 = new Card(Suit.CLUBS, Rank.EIGHT);
		Card card9 = new Card(Suit.CLUBS, Rank.TEN); // Highest card
		Card card10 = new Card(Suit.CLUBS, Rank.QUEEN); // Same strength

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have all 5 cards of the same suit
	 * (Flush) and three cards with same strength then the player with fourth
	 * highest card value is the winner
	 */
	@Test
	public void when_flush_both_then_fourthHighestCardWins() {

		// Prepare
		String player1 = "Roy";
		String player2 = "Richie";

		Card card1 = new Card(Suit.HEARTS, Rank.JACK); // Same strength
		Card card2 = new Card(Suit.HEARTS, Rank.TWO);
		Card card3 = new Card(Suit.HEARTS, Rank.EIGHT); // Highest card
		Card card4 = new Card(Suit.HEARTS, Rank.TEN); // Same strength
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN); // Same strength

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.JACK); // Same strength
		Card card7 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card8 = new Card(Suit.CLUBS, Rank.SIX);
		Card card9 = new Card(Suit.CLUBS, Rank.TEN); // Same strength
		Card card10 = new Card(Suit.CLUBS, Rank.QUEEN); // Same strength

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have all 5 cards of the same suit
	 * (Flush) and four cards with same strength then the player with fifth highest
	 * card value is the winner
	 */
	@Test
	public void when_flush_both_then_fifthHighestCardWins() {

		// Prepare
		String player1 = "Roy";
		String player2 = "Richie";

		Card card1 = new Card(Suit.HEARTS, Rank.JACK); // Same strength
		Card card2 = new Card(Suit.HEARTS, Rank.TWO);
		Card card3 = new Card(Suit.HEARTS, Rank.EIGHT); // Same strength
		Card card4 = new Card(Suit.HEARTS, Rank.TEN); // Same strength
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN); // Same strength

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.JACK); // Same strength
		Card card7 = new Card(Suit.CLUBS, Rank.FIVE); // Highest card
		Card card8 = new Card(Suit.CLUBS, Rank.EIGHT); // Same strength
		Card card9 = new Card(Suit.CLUBS, Rank.TEN); // Same strength
		Card card10 = new Card(Suit.CLUBS, Rank.QUEEN); // Same strength

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where player1 and palyer2 both have all 5 cards same
	 * suit (Flush) and all cards are the same strength then both players are the
	 * winners
	 */
	@Test
	public void when_flush_sameStrength_then_bothPlayersWin() {

		// Prepare
		String player1 = "Jack";
		String player2 = "Sam";
		int winners = 2;

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.NINE); // All same strength
		Card card4 = new Card(Suit.HEARTS, Rank.SIX);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.THREE);
		Card card7 = new Card(Suit.CLUBS, Rank.FOUR);
		Card card8 = new Card(Suit.CLUBS, Rank.NINE); // All same strength
		Card card9 = new Card(Suit.CLUBS, Rank.SIX);
		Card card10 = new Card(Suit.CLUBS, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(winners, winnerHand.size());
	}

	/*
	 * This is the test case where player1 has 3-Of-A-Kind and the other player has
	 * normal cards in the hand then player1 is the winner
	 */
	@Test
	public void when_threeOfAKind_then_onePlayerWins() {

		// Prepare
		String player1 = "Mona";
		String player2 = "Fiona";

		Card card1 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card3 = new Card(Suit.HEARTS, Rank.FIVE); // 3 of A kind cards
		Card card4 = new Card(Suit.SPADES, Rank.FIVE);
		Card card5 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.HEARTS, Rank.ACE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.THREE);
		Card card8 = new Card(Suit.HEARTS, Rank.KING);
		Card card9 = new Card(Suit.CLUBS, Rank.QUEEN); // Random cards
		Card card10 = new Card(Suit.SPADES, Rank.SIX);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both the players have 3-Of-A-Kind and the player
	 * having higher value of 3-Of-A-Kind is the winner
	 */
	@Test
	public void when_threeOfAKind_both_then_highestValueWins() {

		// Prepare
		String player1 = "Mona";
		String player2 = "Fiona";

		Card card1 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card3 = new Card(Suit.HEARTS, Rank.FIVE); // 3 of A kind cards
		Card card4 = new Card(Suit.SPADES, Rank.FIVE);
		Card card5 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.HEARTS, Rank.ACE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.QUEEN); // Higher 3 of a kind cards
		Card card8 = new Card(Suit.HEARTS, Rank.KING);
		Card card9 = new Card(Suit.CLUBS, Rank.QUEEN); // Higher 3 of a kind cards
		Card card10 = new Card(Suit.HEARTS, Rank.QUEEN); // Higher 3 of a kind cards

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where player1 has one pair and the other player2 has
	 * random cards then player1 is the winner
	 */
	@Test
	public void when_onePair_then_onePlayerWins() {

		// Prepare
		String player1 = "Tim";
		String player2 = "Tom";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.DIAMONDS, Rank.FOUR);
		Card card3 = new Card(Suit.CLUBS, Rank.NINE); // One pair
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE); // One pair
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.TWO); // Random cards
		Card card9 = new Card(Suit.SPADES, Rank.SIX);
		Card card10 = new Card(Suit.SPADES, Rank.KING);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have same strength of one pair value
	 * and rest of the cards are also of same strength then both players are the
	 * winners
	 */
	@Test
	public void when_onePair_sameStrength_then_bothPlayersWin() {

		// Prepare
		String player1 = "James";
		String player2 = "Joy";
		int winners = 2;

		Card card1 = new Card(Suit.HEARTS, Rank.FIVE);
		Card card2 = new Card(Suit.CLUBS, Rank.SEVEN);
		Card card3 = new Card(Suit.CLUBS, Rank.NINE); // Same one pair
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE); // Same one pair
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.NINE); // Same one pair
		Card card9 = new Card(Suit.SPADES, Rank.NINE); // Same one pair
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(winners, winnerHand.size());
	}

	/*
	 * This is the test case where both players have different one pair value then
	 * the player with higher value one pair card is the winner
	 */
	@Test
	public void when_onePair_then_highestValueCardWins() {

		// Prepare
		String player1 = "Mary";
		String player2 = "Mark";

		Card card1 = new Card(Suit.HEARTS, Rank.TWO);
		Card card2 = new Card(Suit.CLUBS, Rank.JACK);
		Card card3 = new Card(Suit.CLUBS, Rank.NINE); // Lower one pair
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE); // Lower one pair
		Card card5 = new Card(Suit.HEARTS, Rank.FOUR);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.ACE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.THREE);
		Card card8 = new Card(Suit.HEARTS, Rank.KING); // Higher one pair
		Card card9 = new Card(Suit.SPADES, Rank.KING); // Higher one pair
		Card card10 = new Card(Suit.SPADES, Rank.SIX);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have same strength one pair cards
	 * then the player with first higher value kicker card is the winner
	 */
	@Test
	public void when_onePair_then_firstKickerCardWins() {

		// Prepare
		String player1 = "Marc";
		String player2 = "Mary";

		Card card1 = new Card(Suit.HEARTS, Rank.TWO);
		Card card2 = new Card(Suit.CLUBS, Rank.JACK);
		Card card3 = new Card(Suit.CLUBS, Rank.NINE); // Same one pair
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE); // Same one pair
		Card card5 = new Card(Suit.HEARTS, Rank.FOUR);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.ACE); // High kicker card
		Card card7 = new Card(Suit.DIAMONDS, Rank.THREE);
		Card card8 = new Card(Suit.HEARTS, Rank.NINE); // Same one pair
		Card card9 = new Card(Suit.SPADES, Rank.NINE); // Same one pair
		Card card10 = new Card(Suit.SPADES, Rank.SIX);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have same strength one pair cards
	 * and the first kicker card is same strength then player with second higher
	 * value kicker card is the winner
	 */
	@Test
	public void when_onePair_then_secondKickerCardWins() {

		// Prepare
		String player1 = "Jason";
		String player2 = "Jerry";

		Card card1 = new Card(Suit.HEARTS, Rank.ACE); // Same strength
		Card card2 = new Card(Suit.CLUBS, Rank.JACK); // High kicker card
		Card card3 = new Card(Suit.CLUBS, Rank.NINE); // Same one pair
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE); // Same one pair
		Card card5 = new Card(Suit.HEARTS, Rank.FOUR);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.ACE); // Same strength
		Card card7 = new Card(Suit.DIAMONDS, Rank.THREE);
		Card card8 = new Card(Suit.HEARTS, Rank.NINE); // Same one pair
		Card card9 = new Card(Suit.SPADES, Rank.NINE); // Same one pair
		Card card10 = new Card(Suit.SPADES, Rank.SIX);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both players have same strength one pair cards
	 * and same strength first and second kicker cards then player with third higher
	 * value kicker card is the winner
	 */
	@Test
	public void when_onePair_then_thirdKickerCardWins() {

		// Prepare
		String player1 = "Jason";
		String player2 = "Jerry";

		Card card1 = new Card(Suit.HEARTS, Rank.ACE); // Same strength
		Card card2 = new Card(Suit.CLUBS, Rank.JACK); // High kicker card
		Card card3 = new Card(Suit.CLUBS, Rank.NINE); // Same one pair
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE); // Same one pair
		Card card5 = new Card(Suit.HEARTS, Rank.FOUR);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.ACE); // Same strength
		Card card7 = new Card(Suit.DIAMONDS, Rank.JACK); // Same strength
		Card card8 = new Card(Suit.HEARTS, Rank.NINE); // Same one pair
		Card card9 = new Card(Suit.SPADES, Rank.NINE); // Same one pair
		Card card10 = new Card(Suit.SPADES, Rank.SIX); // High kicker value

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where player1 has a higher value card in the hand than
	 * the other player then player1 is the winner
	 */
	@Test
	public void when_highCard_then_onePlayerWins() {

		// Prepare
		String player1 = "Tony";
		String player2 = "Kaleb";

		Card card1 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card card2 = new Card(Suit.SPADES, Rank.THREE);
		Card card3 = new Card(Suit.SPADES, Rank.ACE); // High value card
		Card card4 = new Card(Suit.SPADES, Rank.FOUR);
		Card card5 = new Card(Suit.DIAMONDS, Rank.FIVE);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.TWO);
		Card card9 = new Card(Suit.SPADES, Rank.NINE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN); // Lower value card

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both the players have same first higher value
	 * card in the hand then the player with second high kicker value card is the
	 * winner
	 */
	@Test
	public void when_highCard_then_secondKickerCardWins() {

		// Prepare
		String player1 = "Tony";
		String player2 = "Kaleb";

		Card card1 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card card2 = new Card(Suit.SPADES, Rank.THREE);
		Card card3 = new Card(Suit.SPADES, Rank.ACE); // Same High value card
		Card card4 = new Card(Suit.SPADES, Rank.FOUR);
		Card card5 = new Card(Suit.DIAMONDS, Rank.FIVE);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.ACE); // Same High value card
		Card card9 = new Card(Suit.SPADES, Rank.NINE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN); // Second kicker value card

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both the players have same first and second
	 * higher value cards in the hand then the player with third high kicker value
	 * card is the winner
	 */
	@Test
	public void when_highCard_then_thirdKickerCardWins() {

		// Prepare
		String player1 = "Dean";
		String player2 = "Pat";

		Card card1 = new Card(Suit.HEARTS, Rank.TWO);
		Card card2 = new Card(Suit.SPADES, Rank.THREE);
		Card card3 = new Card(Suit.SPADES, Rank.ACE); // Same High value card
		Card card4 = new Card(Suit.SPADES, Rank.NINE); // Third kicker value card
		Card card5 = new Card(Suit.DIAMONDS, Rank.QUEEN); // Same High value card

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.ACE); // Same High value card
		Card card9 = new Card(Suit.SPADES, Rank.SIX);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN); // Same High value card

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both the players have same first, second and
	 * third higher value cards in the hand then the player with fourth high kicker
	 * value card is the winner
	 */
	@Test
	public void when_highCard_then_fourthKickerCardWins() {

		// Prepare
		String player1 = "Dean";
		String player2 = "Pat";

		Card card1 = new Card(Suit.HEARTS, Rank.TWO);
		Card card2 = new Card(Suit.SPADES, Rank.THREE);
		Card card3 = new Card(Suit.SPADES, Rank.ACE); // Same High value card
		Card card4 = new Card(Suit.SPADES, Rank.NINE); // Same High value card
		Card card5 = new Card(Suit.DIAMONDS, Rank.QUEEN); // Same High value card

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN); // Fourth kicker value card
		Card card8 = new Card(Suit.HEARTS, Rank.ACE); // Same High value card
		Card card9 = new Card(Suit.HEARTS, Rank.NINE); // Same High value card
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN); // Same High value card

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player2, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both the players have same first, second, third
	 * and fourth higher value cards in the hand then the player with fifth high
	 * kicker value card is the winner
	 */
	@Test
	public void when_highCard_then_fifthKickerCardWins() {

		// Prepare
		String player1 = "Peter";
		String player2 = "Simon";

		Card card1 = new Card(Suit.HEARTS, Rank.FIVE); // Fifth kicker value card
		Card card2 = new Card(Suit.SPADES, Rank.SEVEN); // Same High value card
		Card card3 = new Card(Suit.SPADES, Rank.ACE); // Same High value card
		Card card4 = new Card(Suit.SPADES, Rank.NINE); // Same High value card
		Card card5 = new Card(Suit.DIAMONDS, Rank.QUEEN); // Same High value card

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.TWO);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN); // Same High value card
		Card card8 = new Card(Suit.HEARTS, Rank.ACE); // Same High value card
		Card card9 = new Card(Suit.HEARTS, Rank.NINE); // Same High value card
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN); // Same High value card

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(player1, winnerHand.iterator().next().getPlayer());
	}

	/*
	 * This is the test case where both the players have same set of high value
	 * cards but different ranks then both players are the winners
	 */
	@Test
	public void when_highCard_sameValue_then_bothPlayersWin() {

		// Prepare
		String player1 = "Peter";
		String player2 = "Simon";
		int winners = 2;

		Card card1 = new Card(Suit.HEARTS, Rank.FIVE); // Same High value card
		Card card2 = new Card(Suit.SPADES, Rank.SEVEN); // Same High value card
		Card card3 = new Card(Suit.SPADES, Rank.ACE); // Same High value card
		Card card4 = new Card(Suit.SPADES, Rank.NINE); // Same High value card
		Card card5 = new Card(Suit.DIAMONDS, Rank.QUEEN); // Same High value card

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE); // Same High value card
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN); // Same High value card
		Card card8 = new Card(Suit.HEARTS, Rank.ACE); // Same High value card
		Card card9 = new Card(Suit.HEARTS, Rank.NINE); // Same High value card
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN); // Same High value card

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);

		// Assert
		assertEquals(winners, winnerHand.size());
	}

	/*********************************************************************************/
	/*********************
	 * NON-FUNCTIONAL TEST CASES
	 ***********************************/
	/**********************************************************************************/

	/*
	 * This is the test case where Player1 has duplicate cards in the hand which
	 * causes exception
	 */
	@Test
	public void duplicateCards_samePlayer() {
		try {

			// Prepare
			String player1 = "Jack";
			String player2 = "Sam";

			Card card1 = new Card(Suit.HEARTS, Rank.QUEEN); // Duplicate card
			Card card2 = new Card(Suit.DIAMONDS, Rank.FOUR);
			Card card3 = new Card(Suit.CLUBS, Rank.NINE);
			Card card4 = new Card(Suit.DIAMONDS, Rank.SIX);
			Card card5 = new Card(Suit.HEARTS, Rank.QUEEN); // Duplicate card

			Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

			Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
			Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
			Card card8 = new Card(Suit.HEARTS, Rank.NINE);
			Card card9 = new Card(Suit.SPADES, Rank.NINE);
			Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

			Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

			Set<Hand> hands = new HashSet<Hand>();
			hands.add(hand1);
			hands.add(hand2);

			// Act
			Set<Hand> winnerHand = Poker.play(hands);

			// Assert
			Assert.fail("Duplicates were not found.");

		} catch (Exception ex) {
			Assert.assertEquals("Duplicate cards were found", ex.getMessage(), "Duplicate cards found, no cheating!");
		}
	}

	/*
	 * This is the test case where player1 and player2 have duplicate cards in each
	 * of their hands which causes exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void duplicateCards_acrossMultiplePlayers() {

		// Prepare
		String player1 = "Jack";
		String player2 = "Sam";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.DIAMONDS, Rank.FOUR);
		Card card3 = new Card(Suit.CLUBS, Rank.NINE);
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE);// Duplicate
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.NINE);
		Card card9 = new Card(Suit.DIAMONDS, Rank.NINE); // Duplicate
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);
	}

	/*
	 * This is the test case where Player1 has less than five cards in the hand
	 * which causes exception
	 */
	@Test(expected = NullPointerException.class)
	public void lessCards_onePlayer() {

		// Prepare
		String player1 = "Jack";
		String player2 = "Sam";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.DIAMONDS, Rank.FOUR);
		Card card3 = new Card(Suit.CLUBS, Rank.NINE);
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, null);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.NINE);
		Card card9 = new Card(Suit.SPADES, Rank.NINE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);
	}

	/*
	 * This is the test case where both players have less than five cards in each of
	 * their hands which causes exception
	 */
	@Test(expected = NullPointerException.class)
	public void lessCards_bothPlayers() {

		// Prepare
		String player1 = "Jack";
		String player2 = "Sam";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.DIAMONDS, Rank.FOUR);
		Card card3 = new Card(Suit.CLUBS, Rank.NINE);
		Card card4 = new Card(Suit.DIAMONDS, Rank.NINE);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, null);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.NINE);
		Card card9 = new Card(Suit.SPADES, Rank.NINE);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, null);

		Set<Hand> hands = new HashSet<Hand>();
		hands.add(hand1);
		hands.add(hand2);

		// Act
		Set<Hand> winnerHand = Poker.play(hands);
	}
}