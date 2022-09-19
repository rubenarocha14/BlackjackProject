package com.skilldistillery.blackjack.entities;

import java.util.List;

public abstract class Hand {

	protected List<Card> cards;

	public Hand() {
	}

	public void addCards(Card cardRemovedFromDeck) {
		cards.add(cardRemovedFromDeck);
	}

	public int getHandSize() {
		return cards.size();
	}

	public void clearHand() {
		// this should remove all cards in the hand
		cards.removeAll(cards);

	}

	public int getHandValue() {
		int handTotal = 0;
		for (int i = 0; i < cards.size(); i++) {
			handTotal += cards.get(i).getValue();

		}
		return handTotal;

	}


	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}

}
