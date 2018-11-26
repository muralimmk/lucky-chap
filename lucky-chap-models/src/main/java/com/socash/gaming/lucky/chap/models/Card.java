package com.socash.gaming.lucky.chap.models;

import java.util.Comparator;

public enum Card {
	KING(13, 13), QUEEN(12, 12), JACK(11, 11), TEN(10, 10), NINE(9, 9), EIGHT(8, 8), SEVEN(7, 7), SIX(6, 6), FIVE(5,
			5), FOUR(4, 4), THREE(3, 3), TWO(2, 2), ACE(1, 14);
	
	public static Comparator<Card> rankComparator = new Comparator<Card>() {

		public int compare(Card cardOne, Card cardTwo) {
			if(cardOne.getRank() > cardTwo.getRank())
				return 1;
			else if(cardOne.getRank() < cardTwo.getRank())
				return -1;
			else
				return 0;
		}
		
	};

	private int rank;
	private int value;

	private Card(int rank, int value) {
		this.rank = rank;
		this.value = value;
	}

	public int getRank() {
		return rank;
	}

	public int getValue() {
		return value;
	}
}
