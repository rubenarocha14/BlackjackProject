package com.skilldistillery.blackjack.entities;

public abstract class CardPlayer {
	protected String name;
	protected Hand hand;
	
	CardPlayer(){
		
	}
	CardPlayer(String name, Hand hand){
		this.name = name;
		this.hand = hand;
	}
	public String getName() {
		return name;
	}
	public Hand getHand() {
		return hand;
	}
	@Override
	public String toString() {
		return "CardPlayer [name=" + name + ", hand=" + hand + "]";
	}
	
}
