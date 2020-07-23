package net.covasoft.poker;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {

	/*********************************************************************************/
	/*********************
	 * FUNCTIONAL TEST CASES
	 *************************************/
	/**********************************************************************************/

	private int equalHand = 0;
	private int greaterHand = 1;
	private int lesserHand = -1;

	/*
	 * This is the test case where both hands are Flush
	 */
	@Test
	public void when_flush_sameStrength_bothHands() {

		// Prepare
		String player1 = "Joe";
		String player2 = "Jen";
		int result;

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.NINE); // Flush cards
		Card card4 = new Card(Suit.HEARTS, Rank.ACE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.THREE);
		Card card7 = new Card(Suit.CLUBS, Rank.FOUR);
		Card card8 = new Card(Suit.CLUBS, Rank.NINE); // Flush cards
		Card card9 = new Card(Suit.CLUBS, Rank.ACE);
		Card card10 = new Card(Suit.CLUBS, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(equalHand, result);
	}

	/*
	 * This is the test case where first hand is a flush
	 */
	@Test
	public void when_flush_firstHand() {

		// Prepare
		String player1 = "Joe";
		String player2 = "Jen";
		int result;

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.NINE); // Flush cards
		Card card4 = new Card(Suit.HEARTS, Rank.ACE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.CLUBS, Rank.NINE); // Random cards
		Card card9 = new Card(Suit.SPADES, Rank.NINE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(greaterHand, result);
	}

	/*
	 * This is the test case where we second hand is a flush
	 */
	@Test
	public void when_flush_secondHand() {

		// Prepare
		String player1 = "Joe";
		String player2 = "Jen";
		int result;

		Card card1 = new Card(Suit.HEARTS, Rank.TWO);
		Card card2 = new Card(Suit.DIAMONDS, Rank.THREE);
		Card card3 = new Card(Suit.CLUBS, Rank.FOUR); // Random cards
		Card card4 = new Card(Suit.SPADES, Rank.FIVE);
		Card card5 = new Card(Suit.HEARTS, Rank.SIX);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.THREE);
		Card card7 = new Card(Suit.CLUBS, Rank.FOUR);
		Card card8 = new Card(Suit.CLUBS, Rank.NINE); // Flush cards
		Card card9 = new Card(Suit.CLUBS, Rank.ACE);
		Card card10 = new Card(Suit.CLUBS, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(lesserHand, result);
	}

	/*
	 * This is the test case where first hand is 3-of-A-Kind
	 */
	@Test
	public void when_threeOfAKind_firstHand() {

		// Prepare
		String player1 = "Sam";
		String player2 = "Tom";
		int result;

		Card card1 = new Card(Suit.CLUBS, Rank.EIGHT); // Three of A kind
		Card card2 = new Card(Suit.HEARTS, Rank.ACE);
		Card card3 = new Card(Suit.SPADES, Rank.TWO);
		Card card4 = new Card(Suit.HEARTS, Rank.EIGHT);
		Card card5 = new Card(Suit.DIAMONDS, Rank.EIGHT);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.TWO);
		Card card7 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card8 = new Card(Suit.SPADES, Rank.NINE); // Random cards
		Card card9 = new Card(Suit.HEARTS, Rank.JACK);
		Card card10 = new Card(Suit.DIAMONDS, Rank.KING);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(greaterHand, result);
	}

	/*
	 * This is the test case where second hand is 3-of-A-Kind
	 */
	@Test
	public void when_threeOfAKind_secondHand() {

		// Prepare
		String player1 = "Sam";
		String player2 = "Tom";
		int result;

		Card card1 = new Card(Suit.CLUBS, Rank.TWO);
		Card card2 = new Card(Suit.HEARTS, Rank.ACE);
		Card card3 = new Card(Suit.SPADES, Rank.FOUR); // Random cards
		Card card4 = new Card(Suit.HEARTS, Rank.QUEEN);
		Card card5 = new Card(Suit.DIAMONDS, Rank.EIGHT);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.KING);
		Card card7 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card8 = new Card(Suit.SPADES, Rank.KING); // Three of A kind
		Card card9 = new Card(Suit.HEARTS, Rank.JACK);
		Card card10 = new Card(Suit.DIAMONDS, Rank.KING);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(lesserHand, result);
	}

	/*
	 * This is the test case where both hands are one pair cards of same strength
	 */
	@Test
	public void when_onePair_sameStrength_bothHands() {

		// Prepare
		String player1 = "Sam";
		String player2 = "Tom";
		int result;

		Card card1 = new Card(Suit.CLUBS, Rank.TWO);
		Card card2 = new Card(Suit.HEARTS, Rank.ACE); // Same one pair cards
		Card card3 = new Card(Suit.SPADES, Rank.TWO);
		Card card4 = new Card(Suit.HEARTS, Rank.QUEEN);
		Card card5 = new Card(Suit.DIAMONDS, Rank.EIGHT);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.ACE);
		Card card7 = new Card(Suit.HEARTS, Rank.TWO);
		Card card8 = new Card(Suit.SPADES, Rank.QUEEN); // Same one pair cards
		Card card9 = new Card(Suit.DIAMONDS, Rank.TWO);
		Card card10 = new Card(Suit.SPADES, Rank.EIGHT);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(equalHand, result);
	}

	/*
	 * This is the test case where first hand is one pair
	 */
	@Test
	public void when_onePair_firstHand() {

		// Prepare
		String player1 = "Sam";
		String player2 = "Tom";
		int result;

		Card card1 = new Card(Suit.CLUBS, Rank.TWO);
		Card card2 = new Card(Suit.HEARTS, Rank.ACE);
		Card card3 = new Card(Suit.SPADES, Rank.TWO); // One pair cards
		Card card4 = new Card(Suit.HEARTS, Rank.QUEEN);
		Card card5 = new Card(Suit.DIAMONDS, Rank.EIGHT);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.JACK);
		Card card7 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card8 = new Card(Suit.SPADES, Rank.KING); // Random cards
		Card card9 = new Card(Suit.HEARTS, Rank.TEN);
		Card card10 = new Card(Suit.DIAMONDS, Rank.THREE);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(greaterHand, result);
	}

	/*
	 * This is the test case where second hand is one pair
	 */
	@Test
	public void when_onePair_secondHand() {

		// Prepare
		String player1 = "Sam";
		String player2 = "Tom";
		int result;

		Card card1 = new Card(Suit.CLUBS, Rank.TWO);
		Card card2 = new Card(Suit.HEARTS, Rank.ACE);
		Card card3 = new Card(Suit.SPADES, Rank.SIX); // Random cards
		Card card4 = new Card(Suit.HEARTS, Rank.QUEEN);
		Card card5 = new Card(Suit.DIAMONDS, Rank.EIGHT);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.JACK);
		Card card7 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card8 = new Card(Suit.SPADES, Rank.KING); // One pair cards
		Card card9 = new Card(Suit.HEARTS, Rank.KING);
		Card card10 = new Card(Suit.DIAMONDS, Rank.THREE);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(lesserHand, result);
	}

	/*
	 * This is the test case where both hands are same strength Higher value card
	 */
	@Test
	public void when_higherCard_sameStrength_bothHands() {

		// Prepare
		String player1 = "Sam";
		String player2 = "Tom";
		int result;

		Card card1 = new Card(Suit.HEARTS, Rank.FIVE);
		Card card2 = new Card(Suit.SPADES, Rank.SEVEN);
		Card card3 = new Card(Suit.SPADES, Rank.TWO); // Same Higher card values
		Card card4 = new Card(Suit.CLUBS, Rank.NINE);
		Card card5 = new Card(Suit.DIAMONDS, Rank.QUEEN);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.TWO); // Same higher cards value
		Card card9 = new Card(Suit.SPADES, Rank.NINE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(equalHand, result);
	}

	/*
	 * This is the test case where first hand is the Higher value card
	 */
	@Test
	public void when_higherCard_firtsHand() {

		// Prepare
		String player1 = "Sam";
		String player2 = "Tom";
		int result;

		Card card1 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card card2 = new Card(Suit.SPADES, Rank.THREE);
		Card card3 = new Card(Suit.SPADES, Rank.ACE); // High value card
		Card card4 = new Card(Suit.SPADES, Rank.FOUR);
		Card card5 = new Card(Suit.DIAMONDS, Rank.FIVE);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.TWO); // Random cards lower value
		Card card9 = new Card(Suit.SPADES, Rank.NINE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(greaterHand, result);
	}

	/*
	 * This is the test case where second hand is the Higher value card
	 */
	@Test
	public void when_higherCard_secondHand() {

		// Prepare
		String player1 = "Sam";
		String player2 = "Tom";
		int result;

		Card card1 = new Card(Suit.HEARTS, Rank.SEVEN);
		Card card2 = new Card(Suit.SPADES, Rank.THREE);
		Card card3 = new Card(Suit.SPADES, Rank.JACK); // Random cards lower value
		Card card4 = new Card(Suit.SPADES, Rank.FOUR);
		Card card5 = new Card(Suit.DIAMONDS, Rank.FIVE);

		Hand hand1 = new Hand(player1, card1, card2, card3, card4, card5);

		Card card6 = new Card(Suit.CLUBS, Rank.FIVE);
		Card card7 = new Card(Suit.DIAMONDS, Rank.SEVEN);
		Card card8 = new Card(Suit.HEARTS, Rank.TWO);
		Card card9 = new Card(Suit.SPADES, Rank.NINE);
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN); // High value card

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		result = hand1.compareTo(hand2);

		// Assert
		assertEquals(lesserHand, result);
	}

	/*********************************************************************************/
	/*********************
	 * NON FUNCTIONAL TEST CASES
	 ***********************************/
	/**********************************************************************************/

	/*
	 * This is the test case where hand object is created and its instance is
	 * verified
	 */
	@Test
	public void create_hand() {

		// Prepare
		String player = "Joe";
		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.NINE);
		Card card4 = new Card(Suit.HEARTS, Rank.ACE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		// Act
		Hand hand1 = new Hand(player, card1, card2, card3, card4, card5);

		// Assert
		Assert.assertEquals(hand1 instanceof Hand, true);
	}

	/*
	 * This is the test case where we check for duplicate cards in same hand
	 */
	@Test
	public void create_duplicate_cardInHand() {
		try {

			// Prepare
			String player = "Joe";

			Card card1 = new Card(Suit.HEARTS, Rank.THREE); // Duplicate card
			Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
			Card card3 = new Card(Suit.HEARTS, Rank.NINE);
			Card card4 = new Card(Suit.HEARTS, Rank.ACE);
			Card card5 = new Card(Suit.HEARTS, Rank.THREE); // Duplicate card

			// Act
			Hand hand1 = new Hand(player, card1, card2, card3, card4, card5);
			Assert.fail("Duplicates were not found.");

		} catch (Exception ex) {
			Assert.assertEquals("Duplicate cards were found", ex.getMessage(), "Duplicate cards found, no cheating!");
		}
	}

	/*
	 * This is the test case where we check for null card values passed in a Hand
	 */
	@Test(expected = NullPointerException.class)
	public void create_nullCard_inHand() {

		// Prepare
		String player = "Joe";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.NINE);
		Card card4 = new Card(Suit.HEARTS, Rank.ACE);

		// Act
		Hand hand1 = new Hand(player, card1, card2, card3, card4, null);
	}

	/*
	 * This is the test case where we try to retrieve the player name
	 */
	@Test
	public void get_playerName() {

		// Prepare
		String player = "Sam";
		String checkPlayer = "";

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.NINE);
		Card card4 = new Card(Suit.HEARTS, Rank.ACE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player, card1, card2, card3, card4, card5);

		// Act
		checkPlayer = hand1.getPlayer();

		// Assert
		Assert.assertEquals(player, checkPlayer);
	}

	/*
	 * This is the test case where we try to retrieve the cards passed in the hand
	 */
	@Test
	public void get_cards_passedInHand() {

		// Prepare
		String player = "Sam";
		Set<Card> originalCards = new HashSet<Card>();
		Set<Card> cardsReturned = null;
		boolean compareCardSets = false;

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.NINE);
		Card card4 = new Card(Suit.HEARTS, Rank.ACE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player, card1, card2, card3, card4, card5);

		// Act
		originalCards.add(card1);
		originalCards.add(card2);
		originalCards.add(card3);
		originalCards.add(card4);
		originalCards.add(card5);

		cardsReturned = hand1.getCards();

		compareCardSets = cardsReturned.equals(originalCards);

		// Assert
		Assert.assertTrue(compareCardSets);
	}

	/*
	 * This is the test case where we check hand with the same hand
	 */
	@Test
	public void test_same_hand_isEqual() {

		// Prepare
		String player = "Joe";
		boolean compareSameHand = false;

		Card card1 = new Card(Suit.HEARTS, Rank.THREE);
		Card card2 = new Card(Suit.HEARTS, Rank.FOUR);
		Card card3 = new Card(Suit.HEARTS, Rank.NINE);
		Card card4 = new Card(Suit.HEARTS, Rank.ACE);
		Card card5 = new Card(Suit.HEARTS, Rank.QUEEN);

		Hand hand1 = new Hand(player, card1, card2, card3, card4, card5);

		// Act
		compareSameHand = hand1.equals(hand1);

		// Assert
		Assert.assertEquals(true, compareSameHand);
	}

	/*
	 * This is the test case where we check first hand with second hand
	 */
	@Test
	public void test_hand_with_otherHand() {

		// Prepare
		String player1 = "Joe";
		String player2 = "Jim";
		boolean compareHands = false;

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
		Card card10 = new Card(Suit.SPADES, Rank.QUEEN);

		Hand hand2 = new Hand(player2, card6, card7, card8, card9, card10);

		// Act
		compareHands = hand1.equals(hand2);

		// Assert
		Assert.assertEquals(false, compareHands);
	}
}