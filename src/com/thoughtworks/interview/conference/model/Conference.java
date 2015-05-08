package com.thoughtworks.interview.conference.model;

import java.util.ArrayList;

/**
 * @author magnogouveia
 *         <p>
 *         Evento em si. Conjunto de tracks
 *         </p>
 */
public class Conference {
	
	private ArrayList<Track> tracks;

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}
}