package com.skilldistillery.blackjack.App;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Hand;

public class DealingApp {
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		DealingApp app = new DealingApp();
		app.play();

	}

	private void play() {
		Deck deckTest = new Deck();
		deckTest.shuffle();
		BlackjackHand player1 = new BlackjackHand();
		BlackjackHand dealer = new BlackjackHand();
		Card removedTopCard = deckTest.removeTopCard();

		dealInitialCards(deckTest, dealer, player1);

		checkPlayersHand(player1);
		// player1.checkFor21();
		checkDealersHand(dealer);
		// compareHands(deckTest, dealer, player1);
		checkDealersHand(dealer);
		hitsAndStands(deckTest, dealer, player1);

		determineWinner(dealer, player1);

//		player1.addCards(removedTopCard);
//		player1.getCardValue();
//		player1.getCard(0);
//		player1.getHandValue();

	}

	public void dealInitialCards(Deck deck, BlackjackHand dealer, BlackjackHand player) {
		int initialHandMax = 2;
		for (int handSize = 0; handSize < initialHandMax; handSize++) {
			Card dealtCard = deck.removeTopCard();
			player.addCards(dealtCard);
			for (int handSize2 = 0; handSize2 < initialHandMax; handSize2++) {
				dealtCard = deck.removeTopCard();
				dealer.addCards(dealtCard);
				break;

			}
		}
	}

	public void checkPlayersHand(BlackjackHand player) {
		System.out.println("Player's hand: ");
		for (int cards = 0; cards < player.getHandSize(); cards++) {
			player.getCard(cards).getValue();

			// System.out.println(player.getHandValue());
		}
	}

	public void checkDealersHand(BlackjackHand dealer) {
		System.out.println("Dealer showing: ");
		for (int cards = 0; cards < dealer.getHandSize(); cards++) {
//			if (cards ==1) {
//				continue;
//			}
			dealer.getCard(cards).getValue();

			// System.out.println(player.getHandValue());
		}
	}

	public void hitsAndStands(Deck deck, BlackjackHand dealer, BlackjackHand player) {
		promptPlayerDecision();
		playerTurn(deck, player);
		dealerLogic(deck, dealer, player);
	}

	public void promptPlayerDecision() {
		System.out.println("1) Hit");
		System.out.println("2) Stand");
	}

	public void playerTurn(Deck deck, BlackjackHand player) {
		int selection = 0;
		selection = scan.nextInt();
		while (selection == 1) {
			if (selection == 1) {
				playerHit(deck, player);
				checkPlayersHand(player);
			} else if (selection == 2) {
				player.getHandValue();
			} else {
				System.out.println("Please enter a valid entry");
				while (selection != 1 || selection != 2) {
					promptPlayerDecision();
					playerTurn(deck, player);
				}
			}
		}

	}

	public void blackjackMenu() {
		System.out.println("1) Play Blackjack");
		System.out.println("2) Exit");
	}

	public void dealerLogic(Deck deck, BlackjackHand dealer, BlackjackHand player) { // dealer should not perform
																						// operation if player has
																						// already busted
		while ((dealer.getHandValue() < 21 && player.getHandValue() > dealer.getHandValue())
				&& player.getHandValue() <= 21) {// dealer logic only if player has greater score and hasnt busted
			if (dealer.getHandValue() <= 16) {
				playerHit(deck, dealer); // create the method
				checkDealersHand(dealer);

			} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < 21) {
				System.out.println("Dealer stands");
				checkDealersHand(dealer);
				break;
			} else if (dealer.getHandValue() > 21) {
				checkDealersHand(dealer);
				System.out.println("Dealer busts! Player wins!");

			}
		}

	}

	public void determineWinner(BlackjackHand dealer, BlackjackHand player) {
		if (dealer.getHandValue() > 21 && player.getHandValue() <= 21) {
			System.out.println("Dealer busts! Player wins!");
		} else if (player.getHandValue() > 21 && dealer.getHandValue() <= 21) {
			System.out.println("Player busts! Dealer wins!");
		} else if ((player.getHandValue() > dealer.getHandValue()) && player.getHandValue() < 21) {
			System.out.println("Player wins");
		} else if ((player.getHandValue() > dealer.getHandValue()) && player.getHandValue() == 21) {
			System.out.println("Player 21!");
		} else if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("Push!");
		} else if ((dealer.getHandValue() > player.getHandValue()) && dealer.getHandValue() < 21) {
			System.out.println("Dealer wins");
		} else if ((dealer.getHandValue() > player.getHandValue()) && dealer.getHandValue() == 21) {
			System.out.println("Dealer 21... House wins...");
		}
	}

	public void playerHit(Deck deck, BlackjackHand player) {// can be player or dealer who use this to hit
		Card dealtCard = deck.removeTopCard();
		player.addCards(dealtCard);
	}

	public void deal() {
		Deck deck = new Deck();// create deck
		deck.shuffle();
		System.out.println("how many?");
		int numCardsToDeal = scan.nextInt();
		int total = 0;

		int numCardsDealt = 0;

		while (numCardsDealt < numCardsToDeal) {
			Card card = deck.dealCard();
			System.out.println("Dealt " + card + " =>");
			System.out.println(deck.checkDeckSize() + " cards dealt");
			total += card.getValue();
			numCardsDealt++;
		}
		System.out.println("Your total hand " + total);
		;
	}

}
