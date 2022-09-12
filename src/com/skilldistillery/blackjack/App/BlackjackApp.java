package com.skilldistillery.blackjack.App;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Hand;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp game = new BlackjackApp();
		game.play();
	}

	private void play() {
		Deck deck = new Deck();//instantiate the deck
		BlackjackHand dealer = new BlackjackHand(); //instantiate dealers hand
		BlackjackHand player1 = new BlackjackHand(); //instantiate players hand
		shuffleDeck(deck);//shuffle deck
		dealInitialCards(deck, dealer, player1); // deal the initial cards
		//players cards face up, dealers first card up and second down
		//index through hand size and show value of all players cards
		//show all but idx 1 of dealers
		
		
		//player1.checkFor21();
		dealer.checkFor21();
		
//		player1.getHandValue();
//		dealer.getHandValue();

	}

	// Deck methods prior to game

	private void shuffleDeck(Deck deck) {
		deck.shuffle();
	}

	public void dealInitialCards(Deck deck, BlackjackHand dealer, BlackjackHand player) {
		// player card visible to table
		System.out.println("Dealing to player");
		Card removedCard = deck.removeTopCard();
		player.addCards(removedCard);
		player.getCardValue();
		player.getHandValue();
		//dealer card visible
		System.out.println("Dealing to dealer");
		removedCard = deck.removeTopCard();
		dealer.addCards(removedCard);
		dealer.getCardValue();
		dealer.getHandValue();
//		//player card 2 visible
		System.out.println("Dealing to player");
		removedCard = deck.removeTopCard();
		player.addCards(removedCard);
		player.getCardValue();
		player.getHandValue();
//		dealer card 2 hidden
		System.out.println("Dealing to dealer");
		removedCard = deck.removeTopCard();
		dealer.addCards(removedCard);
		//dealer.getCardValue();
		//dealer.checkFor21();
		}

//		for (int i = 0; i < 2; i++) {
//			System.out.println("Dealing to player");
//			Card removedCard = deck.removeTopCard();
//			player.addCards(removedCard);
//			player.getCardValue();
//			player.getHandValue();
//
//			while (dealer.getHandSize() < 1) {
//				System.out.println("Dealing to dealer");
//				removedCard = deck.removeTopCard();
//				dealer.addCards(removedCard);
//				dealer.getCardValue();
//				dealer.getHandValue();
//
//				break;
//			}
//			while (dealer.getHandSize() == 1 && player.getHandSize() ==2) {
//				System.out.println("Dealing to dealer");
//				removedCard = deck.removeTopCard();
//				dealer.addCards(removedCard);
//			}
//		}
	
	
	public void checkShowingTotals(BlackjackHand dealer, BlackjackHand player) {
		player.getHandValue();
	}
	public int dealerShowingTotal(BlackjackHand dealer) {
		int totalHandValue = dealer.getHandValue();
		int hiddenValue = dealer.getHandValue();
		int showingHandValue = totalHandValue - hiddenValue;
		
		return showingHandValue;
	}
	
	public void checkDealerFor21(BlackjackHand dealer) {
		System.out.println("Checking dealer's hand: ");
		dealer.checkFor21();
	}
	
	public void checkingPlayerFor21(BlackjackHand player) {
		System.out.println("Checking player's hand ");
		player.checkFor21();
		
	}
	

	


	public void dealerLogic() {

	}

}

//System.out.println("Dealing to player");
//Card removedCard = deck.removeTopCard();
//player.addCards(removedCard);
//player.getCardValue();
//player.getHandValue();
////dealer card visible
//System.out.println("Dealing to dealer");
//removedCard = deck.removeTopCard();
//dealer.addCards(removedCard);
//dealer.getCardValue();
//dealer.getHandValue();
////player card 2 visible
//System.out.println("Dealing to player");
//removedCard = deck.removeTopCard();
//player.addCards(removedCard);
//player.getHandValue();
////dealer card 2 hidden
//System.out.println("Dealing to dealer");
//removedCard = deck.removeTopCard();
//dealer.addCards(removedCard);
//dealer.getCardValue();
//dealer.getHandValue();
//}