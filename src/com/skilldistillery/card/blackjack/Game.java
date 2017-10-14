package com.skilldistillery.card.blackjack;

//import java.util.Scanner;

//Create a class structure that mimics a deck of cards. 
//Remember decks as well as a hand of cards are made up of cards. 
//Feel free to create the structure in any way you see fit. hint 
//We did a lab in Chapter 6 of this week that dealt with a deck 
//of cards. Your card and deck implementations should NOT be
//coupled to Blackjack; you should be able to reuse them to 
//implement a poker or bridge game application.

public class Game {
		
		public void beginGame() {
			//Deck d = new Deck();
			Player player = new Player();
			Player dealer = new Player();
			dealer.dealCard(player);
			dealer.dealCard(dealer);
			dealer.dealCard(player);
			dealer.dealCard(dealer);
			
			
		System.out.println("=========================BEGIN GAME========================");
		System.out.println("You have been dealt a : " + player.getHand());
		System.out.println("===========================================================");
		System.out.println("Cards dealt to the dealer: " + dealer.getHand());
		System.out.println("===========================================================");
		
		
//		if ( = 21) { //????????????????????
//			System.out.println("You win!");
//		}
//		if (dealer.getHand().getCard() = 21) {
//			System.out.println("You lose!");
//		} 
//		else if (game.dealer.getHand() > 21);
//			System.out.println("Dealer's hand exceeded 21 points, you win this round")
	}
}
