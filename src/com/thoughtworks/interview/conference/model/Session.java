package com.thoughtworks.interview.conference.model;

import java.util.ArrayList;

/**
 * <p>
 * Representa o turno (Manhã, Tarde e Noite)
 * </p>
 * 
 * @author magnogouveia
 */
public class Session {

	private String type;
	
	private int duration;

	private ArrayList<Talk> talks;

	public Session() {
	}

	public Session(String type, int duration, ArrayList<Talk> talks) {
		this.type = type;
		this.duration = duration;
		this.talks = talks;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public ArrayList<Talk> getTalks() {
		return talks;
	}

	public void setTalks(ArrayList<Talk> talks) {
		this.talks = talks;
	}
}
