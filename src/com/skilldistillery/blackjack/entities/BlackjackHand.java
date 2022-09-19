package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		cards = new ArrayList<Card>();
	}

	public int getHandValue() {
		int handValue = 0;
		for (int i = 0; i < cards.size(); i++) {
			handValue += cards.get(i).getValue();
		}
		return handValue;

	}

	public boolean isBlackjack() {
		boolean blackjack = false;
		int _21 = 21;
		if (getHandValue() == _21) {
			blackjack = true;
		}
		return blackjack;

	}

	public boolean isBust() {
		boolean bust = false;
		int blackjack = 21;
		if (getHandValue() > blackjack) {
			bust = true;
		}
		return bust;

	}

	public int getHandSize() {
		return cards.size();
	}

	public Card getCard(int idx) {
		System.out.println(cards.get(idx));
		return cards.get(idx);
	}

	public int getCardValue() {
		int cardValue = 0;
		if (cards.size() == 1) {
			cardValue = cards.get(0).getValue();
			System.out.println("Card 1: " + cardValue);
		} else if (cards.size() == 2) {
			cardValue = cards.get(1).getValue();
			System.out.println("Card 2 :" + cardValue + "\n");
		}
		return cardValue;
	}
}
