package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>();
	int initialDeckSize = 52;
	// for each suit create 13 cards (1 of each rank)

	public Deck() {
		for (Suit suits : Suit.values()) {// values gives us the enum list
			for (Rank rank : Rank.values()) {
				Card card = new Card(suits, rank);
				deck.add(card);
				
			}

		}
		System.out.println("Done creating" + deck.size());
	}
	
	public int checkDeckSize() {
		return deck.size();
}
	
	public Card dealCard() {
		Card dealtCard = deck.remove(0);
		return dealtCard;
		
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
}