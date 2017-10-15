package com.skilldistillery.card.blackjack;

public class Card {
    private Rank rank;
    private Suit suit;
    private int value;

   public Card(Rank r, Suit s) { //Constructor
        rank = r;
        suit = s;
    }

    public Card(Rank r, Suit s, int value) { //int i is the value of the card
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
    //@Override
	public int compareTo(Card otherCard) { //ref StringComparator.java
		int compareValues = this.rank.compareTo(otherCard.rank);
		if (compareValues == 0) {
			return this.suit.compareTo(otherCard.suit);
		}
		else {
			return compareValues;
		}
    }
    public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

    public int getValue() {
		return rank.getValue(); //The missing piece!!!!! this link assigned values from Rank to eah card
	}
}
