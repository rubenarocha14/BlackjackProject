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
		Deck deck = new Deck();
		BlackjackHand dealer = new BlackjackHand();
		BlackjackHand player1 = new BlackjackHand();
		shuffleDeck(deck);
		dealCards(deck,dealer,player1);
		
	}
	
	//Deck methods prior to game
	
	private void shuffleDeck(Deck deck) {
		deck.shuffle();
	}
	public void dealCards(Deck deck, BlackjackHand dealer, BlackjackHand player) {
		//player card visisble to table
		Card removedCard = deck.removeTopCard();
		player.addCard(removedCard);
		player.getCardValue();
		player.getHandValue();
		//dealer card visible
		removedCard = deck.removeTopCard();
		dealer.addCard(removedCard);
		dealer.getCardValue();
		dealer.getHandValue();
		//player card 2 visible
		removedCard = deck.removeTopCard();
		player.addCard(removedCard);
		player.getHandValue();
		//dealer card 2 hidden
		dealer.addCard(removedCard);
	}
	
	

}
