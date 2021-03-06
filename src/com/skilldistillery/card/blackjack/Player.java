package com.skilldistillery.card.blackjack;

import java.util.*;

public class Player {
	Hand hand = new Hand(); // The player HAS A hand
	static Deck deck = new Deck();

	public Player() { // creates a no-arg constructor
		this.hand = new Hand();
	}

	public List<Card> getHand() { // Hand creates an individual hand
		return hand.getHand();
	}

	public Card dealCard(Player p) {
		Card c = deck.getCard();
		p.hand.addCard(c);
		return c;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [hand=");
		builder.append(hand);
		builder.append(", deck=");
		builder.append(deck);
		builder.append("]");
		return builder.toString();
	}

}