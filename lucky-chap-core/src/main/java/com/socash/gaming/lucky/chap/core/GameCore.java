package com.socash.gaming.lucky.chap.core;

import java.util.List;

import com.socash.gaming.lucky.chap.models.Player;

public interface GameCore {
	public void distributeCards(List<Player> players);

	public void determineWinner();
}
