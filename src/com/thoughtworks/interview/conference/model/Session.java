package com.thoughtworks.interview.conference.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * <p>
 * Representa o turno (Manhã, Tarde e Noite)
 * </p>
 * 
 * @author magnogouveia
 */
public class Session {

	private String name;

	private Date startAt;

	private Date endAt;

	private ArrayList<Talk> talks;

	public Session() {
	}

	public Session(String name, Date startAt, Date endAt, ArrayList<Talk> talks) {
		this.name = name;
		this.startAt = startAt;
		this.endAt = endAt;
		this.talks = talks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

	public Date getEndAt() {
		return endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}

	public ArrayList<Talk> getTalks() {
		return talks;
	}

	public void setTalks(ArrayList<Talk> talks) {
		this.talks = talks;
	}
}
