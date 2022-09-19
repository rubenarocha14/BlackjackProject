package com.skilldistillery.blackjack.entities;

public class BlackjackPlayer extends CardPlayer 
{
	public BlackjackPlayer(String name, BlackjackHand hand){
		this.name = name;
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "BlackjackPlayer: " + name + "\nCards: " + hand;
	}
	

}
