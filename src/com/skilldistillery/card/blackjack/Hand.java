package com.skilldistillery.card.blackjack;

import java.util.*;

public class Hand {
	List<Card> hand = new ArrayList<>();

	public void addCard(Card dealtCard) { // being used in Deck class
		this.hand.add(dealtCard);
	}

	public List<Card> getHand() {
		return hand;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [hand=");
		builder.append(hand);
		builder.append("]");
		return builder.toString();
	}
//	public int AssignCardValues() {
//		int value = 0;
//		for (int i = 0; 0 < hand.size(); i++);
//		value += hand.get(i).getRank();
//		return value;
//	}
	
}
