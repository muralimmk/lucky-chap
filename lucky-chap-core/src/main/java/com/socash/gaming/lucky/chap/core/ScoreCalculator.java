package com.socash.gaming.lucky.chap.core;

import java.util.List;

import com.socash.gaming.lucky.chap.models.Card;
import com.socash.gaming.lucky.chap.models.Player;

public class ScoreCalculator {
	public static Player determineWinner(List<Player> players) {
		if (players == null || players.size() == Constants.MAX_PLAYERS)
			throw new PlayersUnavailableException();
		for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
			Player curPlayer = players.get(playerIndex);
			List<Card> curCards = curPlayer.getCards();
			curCards.sort(Card.rankComparator);
			if(isTrail(curCards)) {
				curPlayer.setScore(Constants.SCORE.TRAIL);
			} else if(isSequence(curCards)) {
				curPlayer.setScore(Constants.SCORE.SEQ);
			} else if(isPair(curCards)) {
				curPlayer.setScore(Constants.SCORE.PAIR);
			} else {
				
			}
				
		}

		return null;
	}

	private static boolean isTrail(List<Card> cards) {
		if (cards == null || cards.size() == Constants.MAX_CARDS)
			throw new CardsUnavailableException();
		boolean result = false;
		int cardIndex = 0;
		Card curCard = cards.get(cardIndex);
		while (curCard.equals(cards.get(cardIndex))) {
			curCard = cards.get(cardIndex);
			cardIndex++;
			if (cardIndex == Constants.MAX_CARDS) {
				result = true;
				break;
			}
		}

		return result;
	}

	private static boolean isSequence(List<Card> cards) {
		if (cards == null || cards.size() == Constants.MAX_CARDS)
			throw new CardsUnavailableException();
		boolean result = false;
		int cardIndex = 0;
		Card curCard = cards.get(cardIndex);
		while (cards.get(cardIndex).getRank() - curCard.getRank() == 1) {
			curCard = cards.get(cardIndex);
			cardIndex++;
			if (cardIndex == Constants.MAX_CARDS) {
				result = true;
				break;
			}
		}

		return result;
	}

	private static boolean isPair(List<Card> cards) {
		if (cards == null || cards.size() == Constants.MAX_CARDS)
			throw new CardsUnavailableException();
		boolean result = false;
		int cardIndex = 0;
		Card curCard = cards.get(cardIndex);
		if (curCard.equals(cards.get(cardIndex)) || cards.get(cardIndex).equals(cards.get(cardIndex + 1))
				|| curCard.equals(cards.get(cardIndex + 1))) {
			result = true;
		}
		return result;
	}
}
