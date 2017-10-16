package com.skilldistillery.card.blackjack;

import java.util.*;

public class Deck {
	List<Card> deck = new ArrayList<>(52);

	public Deck() {
		for (Rank rank : Rank.values()) { // copy pasted from Card/Deck examples, then figured out how to assign values
											// // to face cards and the ace
			for (Suit suit : Suit.values()) {
				deck.add(new Card(rank, suit)); // Assigns the Ace a value because there is no card with a value of 1
												// assigns the remaining face cards a value of 10

			}
			Collections.shuffle(deck); // Shuffles the deck
		}
	}

	public Card getCard() {
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

	public void dealCard(Player dealer) { // auto generated because d.dealCard(); in Game was broken
		// TODO Auto-generated method stub
	}

}
