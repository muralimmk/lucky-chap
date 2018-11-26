package com.socash.gaming.lucky.chap.core;

public class CardsUnavailableException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 401L;
	private static final String message = "Not enough Cards!!";

	public CardsUnavailableException() {
		super(message);
	}
}
