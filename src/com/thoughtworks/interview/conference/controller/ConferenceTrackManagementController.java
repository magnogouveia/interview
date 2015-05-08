package com.thoughtworks.interview.conference.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thoughtworks.interview.conference.exception.TalkException;
import com.thoughtworks.interview.conference.model.Session;
import com.thoughtworks.interview.conference.model.Talk;
import com.thoughtworks.interview.conference.util.Util;

public class ConferenceTrackManagementController {

	public void assemblyConferrence(ArrayList<String> rowsTalks) {
		try {
			ArrayList<Talk> talks = this.loadTalks(rowsTalks);

			System.out.print("[");
			for (Talk talk : talks) {
				System.out.print(talk.getDuration() + ", ");
			}
			System.out.print("]");

			Collections.sort(talks);

			System.out.print("\n[");
			for (Talk talk : talks) {
				System.out.print(talk.getDuration() + ", ");
			}
			System.out.print("]");

			ArrayList<Session> sessions = this.loadSessions(talks);
		} catch (TalkException te) {
			te.printStackTrace();
		}

	}

	public ArrayList<Talk> loadTalks(ArrayList<String> rowsTalks)
			throws TalkException {

		ArrayList<Talk> talks = new ArrayList<Talk>();

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
				// Caso não tenha um número na string e esta termine em
				// "lightning"
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

				talks.add(talk);
			}
		}

		return talks;
	}

	public ArrayList<Session> loadSessions(List<Talk> talks) {
		ArrayList<Session> sessions = new ArrayList<Session>();

		for (Talk talk : talks) {

		}

		return null;
	}

	// private boolean relativeSubArraySum(ArrayList<Session> array[], int
	// minimumSum,
	// int maximumSum) {
	// if (!(array.length >= 1))
	// return false;
	// int currentSum = array[0], start = 0;
	//
	// for (int i = 1; i <= array.length; i++) {
	// while (currentSum > maximumSum && start < i - 1) {
	// currentSum -= array[start];
	// start++;
	// }
	//
	// if (currentSum >= minimumSum && currentSum <= maximumSum) {
	// startIndex = start;
	// endIndex = i - 1;
	// return true;
	// }
	//
	// if (i < array.length)
	// currentSum += array[i];
	// }
	//
	// return false; // No sub array found.
	// }

}
