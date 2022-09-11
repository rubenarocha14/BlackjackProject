package com.skilldistillery.blackjack.entities;

public abstract class CardPlayer {
	protected String name;
	protected Hand hand;
	
	CardPlayer(){
		
	}
	CardPlayer(String name, Hand hand){
		this.name = name;
		hand = new Hand();
	}
	
}
