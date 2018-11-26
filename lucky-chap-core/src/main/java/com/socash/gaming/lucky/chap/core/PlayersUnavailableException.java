package com.socash.gaming.lucky.chap.core;

public class PlayersUnavailableException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 400L;
	private static final String message = "Not enough Players!!";

	public PlayersUnavailableException() {
		super(message);
	}
}
