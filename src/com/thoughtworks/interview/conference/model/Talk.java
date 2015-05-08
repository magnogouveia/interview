package com.thoughtworks.interview.conference.model;

/**
 * @author magnogouveia
 *         <p>
 *         Palestra
 *         </p>
 */
public class Talk {

	private String title;

	/**
	 * duration in minutes
	 */
	private int duration;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
