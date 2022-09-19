package com.skilldistillery.blackjack.App;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Deck;

public class BlackjackGame {
	private final int dealerMustHit = 16;

	Scanner scan = new Scanner(System.in);

	private Deck deck = new Deck();
	private BlackjackHand dealerHand = new BlackjackHand();
	private BlackjackHand playerHand = new BlackjackHand();

	public static void main(String[] args) {
		BlackjackGame app = new BlackjackGame();
		app.playGame();

	}

	private void playGame() {
		deck.shuffle();
		welcomeScreen();
		dealCards();
		seePlayerShowingCards();
		seeDealerInitialShowingCard();
		playerHitOrStand();
		playerBust();
		seeAllDealerCards();
		checkFor21(); // immediately end game under certain conditions
		dealerLogic();
		determineTheWinner();

	}

	private void welcomeScreen() {
		System.out.println("==========================================");
		System.out.println("   === WELCOME TO THE BLACKJACK APP ===");
		System.out.println("==========================================");
	}

	private void dealCards() {
		System.out.println("Dealing cards...\n");
		deck.dealCard(playerHand);

		deck.dealCard(dealerHand);

		deck.dealCard(playerHand);

		deck.dealCard(dealerHand);

	}

	private void seePlayerShowingCards() {
		System.out.println("Player Hand: ");
		for (int playerCards = 0; playerCards < playerHand.getHandSize(); playerCards++) {
			playerHand.getCard(playerCards).getValue();

		}
		// System.out.println(playerHand.getHandValue());
		System.out.println();
	}

	private void seeDealerInitialShowingCard() {
		System.out.println("Dealer Showing: ");
		dealerHand.getCard(0).getValue();
		System.out.println();
	}

	private void playerHitOrStand() {

		int selection = 0;
		boolean hit = false;

		if (playerHand.isBlackjack()) {
			System.out.println("Player: Blackjack\n");
		} else if (playerHand.isBust()) {
			System.out.println("Player busts");
			playAgain();
		} else {

			System.out.println("Your current hand total is " + playerHand.getHandValue());
			System.out.println("Select your next move");
			System.out.println("1) Hit");
			System.out.println("2) Stand");

			selection = scan.nextInt();

			switch (selection) {

			case 1:
				deck.dealCard(playerHand);
				seePlayerShowingCards();
				hit = true;
				break;
			case 2:
				System.out.println("Player stands.");
				break;
			default:
				System.out.println("Please select a valid option");
				playerHitOrStand();
			}
			if (playerHand.isBust()) {
				System.out.println("Player busts with " + playerHand.getHandValue() + ", dealer wins.");
				playAgain();
			} else if (!playerHand.isBust() && hit == true) {
				playerHitOrStand();
			} else if (hit == false) {
				System.out.println("Dealer's turn\n");
			}

		}
	}

	private void playerBust() {
		if (playerHand.isBust()) {
			System.out.println("Player busts with " + dealerHand.getHandValue() + ", dealer wins.");
			playAgain();
		}
	}

	private void seeAllDealerCards() {
		System.out.println("Dealer's hand: ");
		for (int indexOfHand = 0; indexOfHand < dealerHand.getHandSize(); indexOfHand++) {
			dealerHand.getCard(indexOfHand).getValue();
		}
		System.out.println();
	}

	private void checkFor21() {
		if (dealerHand.isBlackjack() && playerHand.isBlackjack()) {
			System.out.println("Dealer: Blackjack");
			System.out.println("Player: Blackjack");
			System.out.println("Push");
			playAgain();
		} else if (dealerHand.isBlackjack() && !playerHand.isBlackjack()) {
			System.out.println("Dealer wins with Blackjack!");
			playAgain();
		} else if (!dealerHand.isBlackjack() && playerHand.isBlackjack()) {
			System.out.println("Player has Blackjack, the dealer will attempt to push...");
		}
	}

	private void dealerLogic() {

		while (dealerHand.getHandValue() <= dealerMustHit && dealerHand.getHandValue() < playerHand.getHandValue()) {
			System.out.println("Dealer hits");
			deck.dealCard(dealerHand);
			seeAllDealerCards();
		}
		if (dealerHand.isBust()) {
			System.out.println("Dealer busts Player wins with " + playerHand.getHandValue() + "!");
			playAgain();
		} else if (dealerHand.getHandValue() > dealerMustHit) {
			System.out.println("Dealer stands with " + dealerHand.getHandValue() + "!");
		} else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("Dealer stands with " + dealerHand.getHandValue() + "!");
		}
	}

	private void playAgain() {
		int selection = 0;
		System.out.println("Would you like to play again?");
		System.out.println("1) Yes");
		System.out.println("2) No");

		selection = scan.nextInt();

		switch (selection) {
		case 1:
			playerHand.clearHand();
			dealerHand.clearHand();
			deck = new Deck();
			System.out.println("New deck ready to go! All " + deck.checkDeckSize() + " cards available.");
			playGame();
			break;

		case 2:
			goodBye();
			break;
		default:
			System.out.println("Please enter a valid selection");
			playAgain();
		}
	}

	private void goodBye() {
		System.out.println("Thank you for playing Blackjack!");
		System.exit(0);
	}

	private void determineTheWinner() {
		if (dealerHand.getHandValue() == playerHand.getHandValue()) {
			System.out.println("Push");
			playAgain();
		} else if (dealerHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("Dealer wins with " + dealerHand.getHandValue() + "!");
			playAgain();
		} else if (playerHand.getHandValue() > dealerHand.getHandValue()) {
			System.out.println("Player wins with " + playerHand.getHandValue() + "!");
			playAgain();
		}
	}

}
