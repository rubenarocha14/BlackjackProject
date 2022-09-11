package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;

public class BlackjackHand extends Hand {
	
public BlackjackHand() {
	cards = new ArrayList<Card>();
	
}

public int getCardValue() {
	int cardValue = 0;
	if(cards.size() == 1 ) {
		cardValue = cards.get(0).getValue();
		System.out.println("Card 1: " + cardValue);
	}
	else if (cards.size() == 2) {
		cardValue = cards.get(1).getValue();
		System.out.println("Card 2 :" + cardValue);
	}
	return cardValue;
}
}
