/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */
package edu.elon.factory;

import javax.swing.ImageIcon;

/**
 * Creates the Caution Walk State
 * 
 * @author ttaylor11
 * @author deagle
 *
 */
public class StopWalkState implements TrafficState {

	private TrafficSignal sign;
	
	/**
	 * StopWalkState constructor
	 * 
	 * @param t
	 * 		The current traffic signal the state is on 
	 */
	public StopWalkState(TrafficSignal t) {
		this.sign = t;
	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#change()
	 */
	@Override
	public void change() {
		sign.setState(new GoWalkState(sign));
	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#request()
	 */
	@Override
	public void request() {
		sign.requestPassage();
	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#granted()
	 */
	@Override
	public void granted() {
		sign.passageGranted();
	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Don't Walk";
	}

	@Override
	public ImageIcon getIcon() {
		return null;
	}

}
