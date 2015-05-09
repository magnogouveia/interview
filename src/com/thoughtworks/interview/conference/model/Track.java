package com.thoughtworks.interview.conference.model;

import java.util.ArrayList;

/**
 * Conference Track Management
 * 
 * <p>
 * Conjunto único de Session
 * </p>
 * 
 * @author magnogouveia
 */
public class Track {

	private ArrayList<Session> sessions;

	public Track() {

	}

	public Track(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

}
