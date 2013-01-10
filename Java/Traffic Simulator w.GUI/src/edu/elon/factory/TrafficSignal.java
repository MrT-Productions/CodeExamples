/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * Creates the Traffic Signal abstract class
 * 
 * @author ttaylor11
 * @author deagle
 * 
 */
public abstract class TrafficSignal {

	TrafficState state;
	boolean passageRequested;

	/**
	 * method that changes the state of the signal
	 */
	public void changedState() {
		state.change();
	}

	/**
	 * Returns the state of the signal
	 * 
	 * @return TrafficState of the signal
	 */
	public TrafficState getState() {
		return state;
	}

	/**
	 * Sets the state of the signal
	 * 
	 * @param state
	 *            TrafficState to set
	 */
	public void setState(TrafficState state) {
		this.state = state;
	}

	/**
	 * method to access the passageRequested attribute
	 * 
	 * @return
	 */
	public boolean getPassageRequest() {
		return passageRequested;
	}

	/**
	 * requests state to set passageRequested to true
	 */
	public void requestPassage() {
		this.passageRequested = true;
	}

	/**
	 * requests state to set passaseRequested to false
	 */
	public void passageGranted() {
		this.passageRequested = false;
	}

	/**
	 * String representation of the current state
	 * 
	 * @return String representing the current state
	 */
	public String getMessage() {
		return state.getMessage();
	}

}
