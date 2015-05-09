package com.thoughtworks.interview.conference.model;

/**
 * @author magnogouveia
 *         <p>
 *         Palestra
 *         </p>
 */
public class Talk implements Comparable<Talk> {

	private String title;

	/**
	 * duration in minutes
	 */
	private int duration;

	private boolean scheduled;

	public Talk() {
		this.scheduled = false;
	}

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

	public boolean isScheduled() {
		return scheduled;
	}

	public void setScheduled(boolean scheduled) {
		this.scheduled = scheduled;
	}

	@Override
	public int compareTo(Talk o) {
		if (this.duration < o.duration)
			return -1;

		if (this.duration > o.duration)
			return 1;

		return 0;
	}

	@Override
	public String toString() {
		return this.getTitle();
	}
}
