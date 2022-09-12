package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cards;

	public Hand() {
	}

//	public void addCard1(Card cardRemovedFromDeck, ArrayList<Card> hand) {
//
//		cards.add(cardRemovedFromDeck);
//		System.out.println("Card added to hand is " + cards.get(0));
//
//	}

	public void addCards(Card cardRemovedFromDeck) {
		cards.add(cardRemovedFromDeck);
	}

	public int getHandSize() {
		return cards.size();

	}

	public void clearHand() {
		// this should remove all cards in the hand
		cards.remove(0);
		cards.remove(0);

	}

	public int getHandValue() {
		int handTotal = 0;
		for (int i = 0; i < cards.size(); i++) {
			handTotal += cards.get(i).getValue();
			
		}
		//System.out.println(handTotal);
		return handTotal;

	}
	


	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}

}
