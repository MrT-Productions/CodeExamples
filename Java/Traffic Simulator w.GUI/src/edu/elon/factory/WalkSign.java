/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * Creates the WalkSign class
 * 
 * @author ttaylor11
 * @author deagle
 *
 */
public class WalkSign extends TrafficSignal {

	/**
	 * WalkSign constructor, sets the initial state to Stop
	 */
	public WalkSign(){
		this.state = new StopWalkState(this);
	}
}
