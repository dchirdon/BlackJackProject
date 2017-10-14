package com.skilldistillery.card.blackjack;

//Create a class structure that mimics a deck of cards. 
//Remember decks as well as a hand of cards are made up of cards. 
//Feel free to create the structure in any way you see fit. hint 
//We did a lab in Chapter 6 of this week that dealt with a deck 
//of cards. Your card and deck implementations should NOT be
//coupled to Blackjack; you should be able to reuse them to 
//implement a poker or bridge game application.

public class GameDriver {
	
	public static void main(String[] args) {
		
		System.out.println("================BEGIN GAME===============");
		System.out.println("Cards dealt to the you: " + playerHand());
		System.out.println("Cards dealt to the dealer: " +dealerHand());
		
		if (playerHand() = 21) {
			System.out.println("You win!");
		}
		if (dealerHand = 21) {
			System.out.println("You lose!");
		} 
		if dealerHand() <=16 && dealerHand() 
	}

	private static String playerHand() {
		// TODO Auto-generated method stub
		return null;
	}

	private static String dealerHand() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
