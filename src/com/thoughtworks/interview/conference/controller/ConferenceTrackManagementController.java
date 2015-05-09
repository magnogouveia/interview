package com.thoughtworks.interview.conference.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.interview.conference.exception.TalkException;
import com.thoughtworks.interview.conference.model.Session;
import com.thoughtworks.interview.conference.model.Talk;
import com.thoughtworks.interview.conference.model.Track;
import com.thoughtworks.interview.conference.util.Util;

/**
 * @author felipegabardo
 *
 */
public class ConferenceTrackManagementController {

	public ArrayList<Talk> talks = new ArrayList<>();

	public void assemblyConferrence(ArrayList<String> rowsTalks) {
		try {

			this.loadTalks(rowsTalks);
			ArrayList<Session> sessions = this.loadSessions();
			ArrayList<Track> tracks = this.loadTracks(sessions);

		} catch (TalkException te) {
			System.out.println(te.getMessage());
		}

	}

	/**
	 * @param rowsTalks
	 * @return uma lista de talks desordenadas
	 * @throws TalkException
	 */
	private void loadTalks(ArrayList<String> rowsTalks) throws TalkException {

		Talk talk;

		for (String row : rowsTalks) {
			talk = new Talk();

			String title = row;
			Integer duration = null;

			Matcher matcher = Pattern.compile("\\d+").matcher(row);
			if (matcher.find()) {
				duration = Integer.parseInt(matcher.group().trim());

				if (row.endsWith(Util.EXTENSION_LIGHTNING))
					duration *= Util.DURATION_MINUTES_LIGHTNING;

				title = row.substring(0, matcher.start());

			} else if (row.endsWith(Util.EXTENSION_LIGHTNING)) {
				// caso não tenha um número e a string termine em lightning
				matcher = Pattern.compile(Util.EXTENSION_LIGHTNING)
						.matcher(row);
				if (matcher.find())
					title = row.substring(0, matcher.end());

				duration = Util.DURATION_MINUTES_LIGHTNING;
			} else {
				new TalkException("Ops! Invalid time extension.", row);
			}

			if (duration != null) {
				talk.setTitle(title.trim());
				talk.setDuration(duration);

				this.talks.add(talk);
			}
		}

		Collections.sort(this.talks);

	}

	/**
	 * 
	 * @param talks
	 * 
	 */
	private ArrayList<Session> loadSessions() {
		ArrayList<Session> sessions = new ArrayList<>();

		while (!this.talks.isEmpty()) {
			Session morningSession = new Session();
			morningSession.setType(Util.TYPE_SEESSION_MORNING);
			morningSession.setTalks(selectTalkToSession(
					Util.DURATION_MINUTES_MORNING,
					Util.DURATION_MINUTES_MORNING));
			sessions.add(morningSession);

			Session afternoonSession = new Session();
			afternoonSession.setType(Util.TYPE_SEESSION_AFTERNOON);
			afternoonSession.setTalks(selectTalkToSession(
					Util.DURATION_MIN_MINUTES_AFTERNOON,
					Util.DURATION_MAX_MINUTES_AFTERNOON));
			sessions.add(afternoonSession);
		}

		return sessions;
	}

	private ArrayList<Track> loadTracks(ArrayList<Session> sessions) {

		for (Session session : sessions) {
			System.out.println(session.getType());
			for (Talk talk : session.getTalks()) {
				System.out.println(talk.getTitle());
			}
		}

		return null;
	}

	/**
	 * 
	 * @param minimumDuration
	 * @param maximumDuration
	 * @return
	 */
	private ArrayList<Talk> selectTalkToSession(int minimumDuration,
			int maximumDuration) {
		ArrayList<Talk> selectedTalks = new ArrayList<>();

		int firstPosition = 0;
		int lastPosition = 0;

		for (Talk talk : this.talks) {
			selectedTalks.add(talk);
			lastPosition++;

			while (calculateSessionDuration(selectedTalks) > maximumDuration) {
				selectedTalks.remove(firstPosition);
				firstPosition++;
			}

			if (calculateSessionDuration(selectedTalks) >= minimumDuration
					&& calculateSessionDuration(selectedTalks) <= maximumDuration) {
				this.deleteSelectedTalks(firstPosition, lastPosition);
				return selectedTalks;
			}
		}

		return selectedTalks;

	}

	private void deleteSelectedTalks(int firstPosition, int lastPosition) {
		for (int i = firstPosition; i < lastPosition; i++) {
			this.talks.remove(i);
		}
	}

	private int calculateSessionDuration(ArrayList<Talk> talks) {
		int dutarion = 0;
		for (Talk talk : talks) {
			dutarion += talk.getDuration();
		}

		return dutarion;
	}

}
