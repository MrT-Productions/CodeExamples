/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */
package edu.elon.factory;

import java.util.ArrayList;

/**
 * Manages a unique instance of the clock
 * 
 * @author ttaylor11
 * @author deagle
 */
public class Time {

	private static Time time;
	private int currentTime;
	private int endOfTime;
	private static ArrayList<TimeObserver> observers;

	/**
	 * Creates a new time object
	 * 
	 * @param end
	 *            time to stop clock
	 */
	private Time(int end) {
		currentTime = 0;
		endOfTime = end;
		observers = new ArrayList<TimeObserver>();
	}

	/**
	 * Factory method that insures time is a unique instance
	 * 
	 * @return Time object to run
	 */
	public static Time uniqueInstance() {
		if (time == null) {
			synchronized (Time.class) {
				if (time == null) {
					time = new Time(600);
				}
			}
		}
		return time;
	}

	/**
	 * initializes the time object
	 * 
	 * @param end
	 *            time to stop clock
	 */
	public static void init(int end) {
		ArrayList<TimeObserver> temp = observers;
		time = new Time(end);
		observers = temp;
	}

	/**
	 * method that increments time until end time and notifies observers
	 */
	public void run() {
		while (currentTime < endOfTime) {
			currentTime++;
			for (TimeObserver t : observers) {
				t.timeChanged(currentTime);
			}
		}
	}

	/**
	 * returns the currentTime
	 * 
	 * @return int currentTime
	 */
	public int getTime() {
		return currentTime;
	}

	/**
	 * Registers an observer with this observable object
	 * 
	 * @param t
	 *            TimeObserver to add
	 */
	public void addTimeObserver(TimeObserver t) {
		observers.add(t);
	}

	/**
	 * Removes an observer from this observable object
	 * 
	 * @param t
	 *            TimeObserver to remove
	 */
	public void removeTimeObserver(TimeObserver t) {
		if (observers.contains(t)) {
			observers.remove(t);
		}
	}
	
	/**
	 * Method that increments the time by one
	 */
	public void step(){
		currentTime++;
		for (TimeObserver t : observers) {
			t.timeChanged(currentTime);
		}
	}

}
