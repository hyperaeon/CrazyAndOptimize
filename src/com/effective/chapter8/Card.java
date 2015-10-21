package com.effective.chapter8;

import com.effective.chapter8.ForEache.Rank;
import com.effective.chapter8.ForEache.Suit;

public class Card {

	private Suit suit;
	private Rank rank;

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
}
