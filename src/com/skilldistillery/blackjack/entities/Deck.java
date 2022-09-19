package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>(); // instantiate a deck of cards
	int initialDeckSize = 52; // determine deck size

	public Deck() {// no arg ctor

		// for each suit create 13 cards (1 of each rank)
		for (Suit suits : Suit.values()) {// .values returns a collection of values from a HashMap //returns the suit in
											// a collection
			for (Rank rank : Rank.values()) {// returns the rank in a collection
				Card card = new Card(suits, rank);// creates a new card for each iteration through suits and rank
				deck.add(card); // card is added to the deck

			}

		}

	}

	public int cardsLeftInDeck() {
		int cardsLeft = deck.size();
		return cardsLeft;
	}

	public Card dealCard() {
		Card dealtCard = deck.remove(0);
		return dealtCard;
	}

	public void dealCard(Hand hand) {
		Card dealtCard = deck.remove(0);
		hand.addCards(dealtCard);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card removeTopCard() { // this is the same as dealCard change all instances to dealCard()
		Card dealtCard = deck.remove(0);
		return dealtCard;
	}

	public int checkDeckSize() {
		System.out.println(deck.size());
		return deck.size();
	}
}