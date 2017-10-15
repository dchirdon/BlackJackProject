package com.skilldistillery.card.blackjack;

import java.util.Scanner;

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
		dealer.dealCard(player);
		dealer.dealCard(dealer);

		System.out.println("==============================BEGIN GAME=============================");
		System.out.println("You have been dealt a : " + player.getHand());
		System.out.println("=====================================================================");
		System.out.println("Cards dealt to the dealer: " + dealer.getHand());
		System.out.println("=====================================================================");

		if (game.handTotal(player) == 21) {
			System.out.println("you win!");
		}
		System.out.println();
		if (game.handTotal(dealer) == 21) {
			System.out.println("Dealer wins");
		} else if (game.handTotal(dealer) > 21) {
			System.out.println("Dealer goes over 21, you win this round.");
		}
		game.userPlay(game, player, dealer, d);
	}

	public void userPlay(Game game, Player player, Player dealer, Deck deck) {
		Scanner kb = new Scanner(System.in);
		String input = "";
		boolean keepPlaying = true;
		boolean playerKeepPlaying = true;
		boolean dealerKeepPlaying = true;

		while (keepPlaying == true && game.handTotal(player) != 21 && game.handTotal(dealer) != 21) {

			while (playerKeepPlaying) {
				if (game.handTotal(player) < 21 && game.handTotal(dealer) < 21) {
					System.out.println("Hit/stay?");
					input = kb.next();
					if (input.equals("hit")) {
						Card dealtCard = dealer.dealCard(player); // Despite eclipse's claims, dealtCard IS being used
																	// to record the players new card
						// System.out.println("Player's new card: " + dealtCard);
						for (Card newPlayerCard : player.getHand()) {
							System.out.println(newPlayerCard);
						}
						System.out.println("Total: " + game.handTotal(player));
						System.out.println("=====================================================================");
					}
					if (input.equalsIgnoreCase("Stay")) {
						playerKeepPlaying = false;
					}
				} else if (game.handTotal(player) == 21) {
					System.out.println("BlackJack!");
					playerKeepPlaying = false;
					dealerKeepPlaying = false;
					keepPlaying = false;
				} else if (game.handTotal(player) > 21) {
					System.out.println("Busted!");
					playerKeepPlaying = false;
					dealerKeepPlaying = false;
					keepPlaying = false;
				}
			}
			while (dealerKeepPlaying) {
				if (game.handTotal(dealer) <= 16) {
					Card dealtCard = dealer.dealCard(dealer);
					System.out.println("Dealer gets new card: " + dealtCard);
					System.out.println("Dealer's hand is now: " + game.handTotal(dealer));
					System.out.println("======================================================================");
				} else if (game.handTotal(dealer) > 21) {
					System.out.println("\n---Dealer busts, you win.---");
					dealerKeepPlaying = false;
					keepPlaying = false;
				} else {
					dealerKeepPlaying = false;
				}
			}
			if (handTotal(player) < 21 && handTotal(dealer) < 21) {
				Winner(player, dealer);
			}
			// else if (handTotal(player) == 21 && handTotal(dealer) != 21) {
			// System.out.println("You win!");
			// }
			else if (handTotal(player) != 21 && handTotal(dealer) == 21) {
				System.out.println("---BlackJack - Dealer wins.---");
			} else if (handTotal(player) == 21 && handTotal(dealer) == 21) {
				System.out.println("---Push---");
			}
			keepPlaying = false;
		}
	}

	public double handTotal(Player player) {
		double handTotal = 0;
		for (Card dealtCard : player.getHand()) {
			handTotal = handTotal + dealtCard.getValue();
		}
		return handTotal;
	}

	public void Winner(Player player, Player dealer) {
		if (handTotal(player) > handTotal(dealer) && handTotal(player) != 21) {
			System.out.println("You win!");
		} else if (handTotal(dealer) > handTotal(player)) {
			System.out.println("Dealer wins");
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
