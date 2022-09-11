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
		//app.playBlackjack();
		Deck deckTest = new Deck();
		deckTest.shuffle();
		deckTest.checkDeckSize();
		deckTest.printCards();
		Card removedTopCard = deckTest.removeTopCard();
		Hand player1 = new BlackjackHand();
		player1.addCard(removedTopCard);
		deckTest.checkDeckSize();
		deckTest.printCards();
		
		
		}
		
		
	
	
	public void playBlackjack() {
		deal();
	}
	
	public void deal() {
		Deck deck = new Deck();// create deck
		deck.shuffle();
		System.out.println("how many?");	
		int numCardsToDeal = scan.nextInt();
		int total =0;
		
		int numCardsDealt = 0;
		
		while(numCardsDealt<numCardsToDeal) {
			Card card = deck.dealCard();
			System.out.println("Dealt " + card + " =>");
			System.out.println(deck.checkDeckSize() + " cards dealt");
			total += card.getValue();
			numCardsDealt++;
		}
		System.out.println("Your total hand " + total);;
	}

}
