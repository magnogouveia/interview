package com.thoughtworks.interview.conference.controller;

import java.util.ArrayList;
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

			for (Talk talk : talks) {
				System.out.println(talk.getTitle() + " " + talk.getDuration());
			}

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

			int lastSpaceIndexOf = row.lastIndexOf(' ');
			talk.setTitle(row.substring(0, lastSpaceIndexOf));
			String durationTime = row.substring(lastSpaceIndexOf + 1);

			durationTime = durationTime.toLowerCase();
			if (durationTime.endsWith("lightning"))
				talk.setDuration(Util.DURATION_MINUTES_LIGHTNING);
			else if (durationTime.endsWith("min"))
				talk.setDuration(Integer.parseInt(durationTime.substring(0,
						row.indexOf(Util.EXTENSION_MINUTES))));
			else {
				new TalkException("Ops! Invalid time.");
			}

			talks.add(talk);

		}

		return talks;
	}

	public ArrayList<Session> loadSessions(ArrayList<Talk> talks) {
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
