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

	private String startAt;

	private String endAt;

	public Track() {

	}

	public Track(ArrayList<Session> sessions, String startAt, String endAt) {
		this.sessions = sessions;
		this.startAt = startAt;
		this.endAt = endAt;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public String getStartAt() {
		return startAt;
	}

	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}

	public String getEndAt() {
		return endAt;
	}

	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}

}
