package com.skilldistillery.card.blackjack;

import java.util.*;

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
		Deck d = new Deck();
		Game game = new Game();
		Player player = new Player();
		Player dealer = new Player();

		dealer.dealCard(player); // dealer deals a card to the player
		dealer.dealCard(dealer); // dealer deals a card to the dealer
		dealer.dealCard(player); //deals second card to eh player (or third card from the deck)
		dealer.dealCard(dealer);

		System.out.println("==============================BEGIN GAME=============================");
		System.out.println("You have been dealt a : " + player.getHand());
		System.out.println("=====================================================================");
		System.out.println("Cards dealt to the dealer: " + dealer.getHand());
		System.out.println("=====================================================================");

		if (game.total(player) == 21) {
			System.out.println("you win!");
		}
		System.out.println();
		if (game.total(dealer) == 21) {
			System.out.println("Dealer wins");
		} else if (game.total(dealer) > 21) {
			System.out.println("Dealer goes over 21, you win this round.");
		}
		game.playGame(game, player, dealer, d);
	}

	public void playGame(Game game, Player player, Player dealer, Deck deck) {
		Scanner kb = new Scanner(System.in);
		String input = "";
		boolean keepPlaying = true; //Game continues while true
		boolean playerKeepPlaying = true; //Game 
		boolean dealerKeepPlaying = true;

		while (keepPlaying == true && game.total(player) != 21 && game.total(dealer) != 21) {

			while (playerKeepPlaying) {
				if (game.total(player) < 21 && game.total(dealer) < 21) {
					System.out.println("Hit/stay?");
					input = kb.next();
					if (input.equals("hit")) {
						Card dealtCard = dealer.dealCard(player); // Despite eclipse's claims, dealtCard IS being used
																	// to record the players new card
						// System.out.println("Player's new card: " + dealtCard);
						for (Card newPlayerCard : player.getHand()) {
							System.out.println(newPlayerCard);
						}
						System.out.println("Total: " + game.total(player));
						System.out.println("=====================================================================");
					}
					if (input.equals("stay")) {
						playerKeepPlaying = false;
					}
				} else if (game.total(player) == 21) {
					System.out.println("BlackJack!");
					playerKeepPlaying = false;
					dealerKeepPlaying = false;
					keepPlaying = false;
				} else if (game.total(player) > 21) {
					System.out.println("Over 21 - you lose");
					playerKeepPlaying = false;
					dealerKeepPlaying = false;
					keepPlaying = false;
				}
			}
			while (dealerKeepPlaying) {
				if (game.total(dealer) <= 16) {
					Card dealtCard = dealer.dealCard(dealer);
					System.out.println("Dealer gets new card: " + dealtCard);
					System.out.println("Dealer's hand is now: " + game.total(dealer));
					System.out.println("======================================================================");
				} else if (game.total(dealer) > 21) {
					System.out.println("Dealer busts (over 21)");
					dealerKeepPlaying = false;
					keepPlaying = false;
				} else {
					dealerKeepPlaying = false;
				}
			}
			if (total(player) < 21 && total(dealer) < 21) {
				Winner(player, dealer);
			}
			// else if (handTotal(player) == 21 && handTotal(dealer) != 21) {
			// System.out.println("You win!");
			// }
			else if (total(player) != 21 && total(dealer) == 21) {
				System.out.println("Dealer has blackjack");
			} else if (total(player) == 21 && total(dealer) == 21) {
				System.out.println("Tie game");
			}
			keepPlaying = false;
		}
	}

	public double total(Player player) { 
		double total = 0;
		for (Card dealtCard : player.getHand()) {
			total = total + dealtCard.getValue();
			//System.out.println(handTotal); //Test sysout -- can be deleted
			//System.out.println(dealtCard); //Test sysout -- can be deleted
		}
		return total;
	}

	public void Winner(Player player, Player dealer) {
		if (total(player) < total(dealer) && total(dealer) != 21) {
			System.out.println("Dealer wins this round");
		} else if (total(dealer) < total(player)) {
			System.out.println("You win!!!");
		} else {
			System.out.println("Tie game");
		}
	}

	// if (dealer.getHand().getCard() = 21) {
	// System.out.println("You lose!");
	// }
	// else if (game.dealer.getHand() > 21);
	// System.out.println("Dealer's hand exceeded 21 points, you win this round")

	// public void handTotal() {

}
