package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;

public class BlackjackHand extends Hand {
	
public BlackjackHand() {
	cards = new ArrayList<Card>();
	
}

public int handSize() {
	return cards.size();
}

public Card getCard(int idx) {
	System.out.println(cards.get(idx));
	return cards.get(idx);
}


public void checkFor21() {

	boolean twentyOne = false;
	int goalNumber = 21;

	if (getHandValue() == goalNumber) {
		twentyOne = true;
		System.out.println("21!");

	}
	else if (getHandValue() >= goalNumber) {
		System.out.println("Bust!");
	}
	else {
		System.out.println("Not 21!");
	}
}

public int getCardValue() {
	int cardValue = 0;
	if(cards.size() == 1 ) {
		cardValue = cards.get(0).getValue();
		System.out.println("Card 1: " + cardValue);
	}
	else if (cards.size() == 2) {
		cardValue = cards.get(1).getValue();
		System.out.println("Card 2 :" + cardValue + "\n");
	}
	return cardValue;
	}
	
//	
}

	

