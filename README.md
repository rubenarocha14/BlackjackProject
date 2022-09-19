# BlackjackProject

##Description
My BlackjackProject was developed across 7 different class files. The overall functionality of the project is ran through the BlackjackGame class, which utilizes the other classes: Deck, Hand, BlackjackHand, Card, Rank, and Suit.

Rank and Suit enums:
  Rank and Suit used enums to produce the attributes rank and suit of a card

Card:
  Used the Rank and Suit as fields and assigned them to a card. This associated a rank and suit for each card created. We created a method getCardValue() in Card which allowed us to get the individual card value when counting up total scores in our BlackjackGame. This method vital to the program

Deck:
  Created an arrayList of cards, one for each card in a common playing card deck less the jokers. The Deck class used a nested for loop to create each card in a deck with suit and rank attributes. The deck class had 3 methods we utilized in our BlackjackGame. The first was dealCard(Hand), this method took a Hand as an argument and removed the top card from the deck and added it to the Hand which was passed. Shuffle() randomized the order of the deck. Lastly, checkDeckSize() printed out the size of the deck, we used this after each run of the BlackjackGame to ensure our deck size was reverted back to the original count of 52.

Hand:
  The hand class was an abstract class which would be extended by BlackjackHand. It would define a list of cards, and this list would be able to be manipulated by the methods in the class. These methods were addCards() which would take a card as a parameter and add it to the list. getHandSize() would return the current size of the hand. This method allowed us to determine when to call certain methods in the BlackjackGame that was dependent on the number of cards in the player or dealer's hand. clearHand() reset the list values so each run of the game would be started with a new hand. getHandValue() returned the total count of the hand, this was used for determining game logic for both the player and dealer.

  BlackjackHand:
    BlackjackHand created an arrayList of cards inside its no arg constructor so that each time a hand was created, it would have an arrayList to store cards in. The methods utilized in this class were getHandValue, which was similar to that of the Hand class. isBlackjack() to determine whether the BlackjackHand calling the method had a value of 21. isBust() to determine if the BlackjackHand calling the method had a value greater than 21. getHandSize() to determine the size of the hand. getCard() which gets the specific card in the hand. Finally, getCardValue() which is also similar to that of the Hand class

  BlackjackGame:

  The meat of the project is in this class. It begins by defining a final int dealerMustHit that gives the value that the dealer must hit, we use this later to determine whether the dealer will hit or stay in the dealerLogic(). We then instantiate a scanner to be used throughout the program. We then instantiate a deck, a BlackjackHand playerHand and BlackjackHand dealerHand which is the starting point of our program. All of these priorly mentioned  are defined outside of a class to be used throughout without needing an object of the class.

  In the main method we instantiate our object of the class and use it to call playGame() which is the method that calls all of the methods to run our program.

  Inside playGame() we have:
  -deck.shuffle()
    This method shuffles the deck prior to each game so we get a new game each time
  -welcomeScreen()
    This method displays a welcome message to start the game
  -dealCards()
    deals our the first round of cards, 2 to the player and 2 to the dealer
  -seePlayerShowingCards();
    displays the cards currently in the playerHand
	-seeDealerInitialShowingCard();
    displays only the face up card of the dealer since the second card should be hidden
	-playerHitOrStand();
    this is the player's logic. It displays an option to hit or stand. If the player chooses to hit, a card will be removed from the top of the deck and added to their hand. Their hit card will be displayed each time since they're all face up. If the player chooses to stand, the method will check for immediate ends to the game, if there is no immediate ends, the method will end.
	-playerBust();
    Will check if the player busts after each hit, this is used within playerHitOrStand to determine immediate ends to the game
	-seeAllDealerCards();
    Displays the hidden card in the dealers hand in the first round, and will display all cards if the dealer must hit
	-checkFor21();
    Will check if dealer has 21 in the first round, and will compare to playerHand to determine if there is an immediate end, or to continue the program
	-dealerLogic();
    Will force the dealer to hit anytime the dealer's hand is less than 16 or equal, and less than the player's hand, if they haven't busted. It will also force them to stand if their hand is greater than 16. At each logic step, the dealer will check if the player has already busted, or if the dealer has a higher hand than the player, if the player has already busted or the dealer's hand is better, there is no need to continue on.
	-determineTheWinner();
    Will compare the playerHand to the dealerHand to determine whether the game ends in a push, dealer winning or player winning.

    Anytime the game comes to an end, the player will be promted to play again by playAgain() if the player chooses to play again, the game will be reset, and played from the beginning. If the player chooses not to play again, they will be displayed a goodbye message by goodBye()

##Lessons Learned
  Design, design, design. Hopefully it sinks in someday. I developed the program 3 different times before getting my logic sound. Had I have sat down and methodically designed by program before doing any code, I feel like it would have gone much smoother. Unfortunately, I get impatient and get a small portion of it ready to code and I start coding more than I have designed. It is a flaw I am trying to overcome. Aside from that, I think the most beneficial lesson was finally having the calling of methods by a run()/launch()/play() method to do the bulk of the program work. It allowed me to call methods without having to use an object of the class, which in turn allowed me to better use my methods and have fewer return statement and use unnecessary variables to store the return values.
##Technology Used
Git, gitHub, Eclipse, Atom, YouTube, StackOverFlow, SkillDistillery lessons
