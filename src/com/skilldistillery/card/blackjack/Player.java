package com.skilldistillery.card.blackjack;

public class Player {
	Hand hand = new Hand(); //The player HAS A hand
	
	
	
	public Player(){ //creates a no-arg constructor
		 this.hand = new Hand(); 
	}
	
	public Hand getHand() {
		return hand;
	}
}