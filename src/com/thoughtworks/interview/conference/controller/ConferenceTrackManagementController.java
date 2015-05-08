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
		Matcher matcher;
		String durationExtension;
		int durationTime;
		for (String row : rowsTalks) {
			talk = new Talk();

			matcher = Pattern.compile("\\d+").matcher(row);
			durationExtension = null;
			durationTime = 0;

			// Caso tenho um número
			if (matcher.find()) {
				durationTime = Integer.parseInt(matcher.group().trim());
				durationExtension = row.substring(matcher.end()).trim();
			} else {
				// senão, se tiver a palavra lightning
				matcher = Pattern.compile(Util.EXTENSION_LIGHTNING)
						.matcher(row);
				if (matcher.find()) {
					durationTime = Util.DURATION_MINUTES_LIGHTNING;
					durationExtension = Util.EXTENSION_LIGHTNING;
				}
			}

			// Caso a extensão não esteja preenchida, lança uma exception
			if (durationExtension == null
					|| (!durationExtension.equals(Util.EXTENSION_MINUTES) && !durationExtension
							.equals(Util.EXTENSION_LIGHTNING))) {
				throw new TalkException("Ops! Talk doesn't have a time: \""
						+ row + "\"");

			} else {

				talk.setTitle(row.substring(0, matcher.start()).trim());
				talk.setDuration(durationTime);

				talks.add(talk);
			}
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
