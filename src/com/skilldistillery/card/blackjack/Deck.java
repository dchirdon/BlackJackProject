package com.skilldistillery.card.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import cards.Rank;
//import cards.Suit;

public class Deck {
	List<Card> deck = new ArrayList<>(52);

	//int numberOfCardsDealt;

	public void originalDeck() {
		int counter = 1;
		for (Rank rank : Rank.values()) { //copy pasted from Card/Deck examples, then figured out how to assign values to face cards and the ace
			for (Suit suit : Suit.values()) {
				if (counter == 1) { 
					deck.add(new Card(rank, suit, 11)); //Assigns the Ace a value because there is no card with a value of 1
				} else if (counter < 10) {
					deck.add(new Card(rank, suit, counter)); //iterates through 2-10 assigning them values as it goes, acccording to the counter
				} else {
					deck.add(new Card(rank, suit, 10)); //assigns the remaining face cards a value of 10
				}
			}
			counter++;
		}
		Collections.shuffle(deck); //Shuffles the deck

	}

	

}
