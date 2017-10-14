package com.skilldistillery.card.blackjack;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank r, Suit s) { //Constructor
        rank = r;
        suit = s;
    }

    public Card(Rank r, Suit s, int i) { //int i is the value of the card
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return (rank + " of " + suit);
    }

    @Override
    public int hashCode() { //Taken from Card/Deck class example
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result
                + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) { //Taken from Card/Deck example
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (rank != other.rank)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }

    int value = 0;
    public int getValue() {
		return value;
	}
}
