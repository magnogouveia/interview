package com.thoughtworks.interview.conference.exception;

public class TalkException extends Exception {

	private static final long serialVersionUID = 1L;

	public TalkException(String message) {
		super(message);
	}

	public TalkException(String message, String row) {
		super(message + ": " + row);
	}
}
