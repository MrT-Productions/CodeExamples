/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * Creates the Traffic Light
 * 
 * @author ttaylor11
 * @author deagle
 *
 */
public class TrafficLight extends TrafficSignal {
	
	/**
	 * Traffic Light constructor sets the initial state to Red Light
	 */
	public TrafficLight(){
		this.state = new GreenTrafficState(this);
	}

}
