package com.thoughtworks.interview.conference.view;

import java.util.ArrayList;

import com.thoughtworks.interview.conference.controller.ConferenceTrackManagementController;

public class ConferenceTrackManagement {

	public static void main(String[] args) {
		ArrayList<String> rows = new ArrayList<String>();

		rows.add("Writing Fast Tests Against Enterprise Rails 60 min");
		rows.add("Overdoing it in Python 45min");
		rows.add("Lua for the Masses 30min");
		rows.add("Ruby Errors from Mismatched Gem Versions 45min");
		rows.add("Common Ruby Errors 45min");
		rows.add("Rails for Python Developers lightning");
		rows.add("Communicating Over Distance 60min");
		rows.add("Accounting-Driven Development 45min");
		rows.add("Woah 30min");
		rows.add("Sit Down and Write 30min");
		rows.add("Pair Programming vs Noise 45min");
		rows.add("Rails Magic 60min");
		rows.add("Ruby on Rails: Why We Should Move On 60min");
		rows.add("Clojure Ate Scala (on my project) 45min");
		rows.add("Programming in the Boondocks of Seattle 30min");
		rows.add("Ruby vs. Clojure for Back-End Development 30min");
		rows.add("Ruby on Rails Legacy App Maintenance 60min");
		rows.add("A World Without HackerNews 30min");
		rows.add("User Interface CSS in Rails Apps 30min");

		ConferenceTrackManagementController controller = new ConferenceTrackManagementController();

		controller.assemblyConferrence(rows);
	}

}
