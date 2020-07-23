# SDET Poker Hand Evaluator Assignment

## Implementation

The application provides JUnit test cases for poker hand evaluator. The test cases check for the winner among 2 players for 5 cards poker hands.
The test cases are written in PokerTest and HandTest classes.
The poker hands implemented are (only a subset of regular poker):
1) Flush
2) Three of A kind
3) One Pair
4) High Card

### The PokerTest consists of below methods:

(A) Functional Test Cases:

1) when_flush_against_threeOfAKind
This is the test case where Flush against 3-of-A-Kind condition is tested then player with Flush is the winner

2) when_flush_against_onePair
This is the test case where Flush against One Pair condition is tested then player with Flush is the winner

3) when_flush_against_highCard
This is the test case where Flush against High card condition is tested then player with Flush is the winner

4) when_threeOfAKind_against_onePair
This is the test case where 3-Of-A-Kind against One pair condition is tested then player with 3-Of-A-Kind is the winner

5) when_threeOfAKind_against_highCard
This is the test case where 3-Of-A-Kind against High card condition is tested then player with 3-Of-A-Kind is the winner

6) when_onePair_against_highCard
This is the test case where One pair against High card condition is tested then player with One pair is the winner

7) when_flush_then_onePlayerWins
This is the test case where player1 has all 5 cards of the same suit (Flush) and is the winner

8) when_flush_both_then_firstHighestCardWins
This is the test case where both players have all 5 cards of the same suit (Flush) then the player with first highest card value is the winner

9) when_flush_both_then_secondHighestCardWins
This is the test case where both players have all 5 cards of the same suit (Flush) and one card with same strength then the player with 
second highest card value is the winner

10) when_flush_both_then_thirdHighestCardWins
This is the test case where both players have all 5 cards of the same suit (Flush) and two cards with same strength then the player with 
third highest card value is the winner

11) when_flush_both_then_fourthHighestCardWins
This is the test case where both players have all 5 cards of the same suit (Flush) and three cards with same strength then the player with 
fourth highest card value is the winner

12) when_flush_both_then_fifthHighestCardWins
This is the test case where both players have all 5 cards of the same suit (Flush) and four cards with same strength then the player with 
fifth highest card value is the winner

13) when_flush_sameStrength_then_bothPlayersWin
This is the test case where player1 and palyer2 both have all 5 cards same suit (Flush) and all cards are the same strength then both 
players are the winners

14) when_threeOfAKind_then_onePlayerWins
This is the test case where player1 has 3-Of-A-Kind and the other player has normal cards in the hand then player1 is the winner

15) when_threeOfAKind_both_then_highestValueWins
This is the test case where both the players have 3-Of-A-Kind and the player having higher value of 3-Of-A-Kind is the winner

16) when_onePair_then_onePlayerWins
This is the test case where player1 has one pair and the other player2 has random cards then player1 is the winner

17) when_onePair_sameStrength_then_bothPlayersWin
This is the test case where both players have same strength of one pair value and rest of the cards are also of same strength then both 
players are the winners

18) when_onePair_then_highestValueCardWins
This is the test case where both players have different one pair value then the player with higher value one pair card is the winner

19) when_onePair_then_firstKickerCardWins
This is the test case where both players have same strength one pair cards then the player with first higher value kicker card is the winner

20) when_onePair_then_secondKickerCardWins
This is the test case where both players have same strength one pair cards and the first kicker card is same strength then player with 
second higher value kicker card is the winner

21) when_onePair_then_thirdKickerCardWins

This is the test case where both players have same strength one pair cards and same strength first and second kicker cards then player with 
third higher value kicker card is the winner

22) when_highCard_then_onePlayerWins
This is the test case where player1 has a higher value card in the hand than the other player then player1 is the winner

23) when_highCard_then_secondKickerCardWins
This is the test case where both the players have same first higher value card in the hand then the player with 
second high kicker value card is the winner

24) when_highCard_then_thirdKickerCardWins
This is the test case where both the players have same first and second higher value cards in the hand then the player with 
third high kicker value card is the winner

25) when_highCard_then_fourthKickerCardWins
This is the test case where both the players have same first, second and third higher value cards in the hand then the player with 
fourth high kicker value card is the winner

26) when_highCard_then_fifthKickerCardWins
This is the test case where both the players have same first, second, third and fourth higher value cards in the hand then the 
player with fifth high kicker value card is the winner

27) when_highCard_sameValue_then_bothPlayersWin
This is the test case where both the players have same set of high value cards but different ranks then both players are the winners

(B) NON-FUNCTIONAL TEST CASES:

28) duplicateCards_samePlayer
This is the test case where Player1 has duplicate cards in the hand which causes exception

29) duplicateCards_acrossMultiplePlayers
This is the test case where player1 and player2 have duplicate cards in each of their hands which causes exception

30) lessCards_onePlayer
This is the test case where Player1 has less than five cards in the hand which causes exception

31) lessCards_bothPlayers
This is the test case where both players have less than five cards in each of their hands which causes exception

##### The HandTest consists of below methods:

(A) Functional Test Cases:

1) when_flush_sameStrength_bothHands
This is the test case where both hands are Flush

2) when_flush_firstHand
This is the test case where first hand is a flush

3) when_flush_secondHand
This is the test case where we second hand is a flush

4) when_threeOfAKind_firstHand
This is the test case where first hand is 3-of-A-Kind

5) when_threeOfAKind_secondHand
This is the test case where second hand is 3-of-A-Kind

6) when_onePair_sameStrength_bothHands
This is the test case where both hands are one pair cards of same strength

7) when_onePair_firstHand
This is the test case where first hand is one pair

8) when_onePair_secondHand
This is the test case where second hand is one pair

9) when_higherCard_sameStrength_bothHands
This is the test case where both hands are same strength Higher value card

10) when_higherCard_firtsHand
This is the test case where first hand is the Higher value card

11) when_higherCard_secondHand
This is the test case where second hand is the Higher value card

(B) NON-FUNCTIONAL TEST CASES:

12) create_hand
This is the test case where hand object is created and its instance is verified

13) create_duplicate_cardInHand
This is the test case where we check for duplicate cards in same hand

14) create_nullCard_inHand
This is the test case where we check for null card values passed in a Hand

15) get_playerName
This is the test case where we try to retrieve the player name

16) get_cards_passedInHand
This is the test case where we try to retrieve the cards passed in the hand

17) test_same_hand_isEqual
This is the test case where we check hand with the same hand

18) test_hand_with_otherHand
This is the test case where we check first hand with second hand

