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
public class CautionWalkState implements TrafficState {

	private TrafficSignal sign;

	/**
	 * CautionWalkState constructor
	 * 
	 * @param t
	 *            The current traffic signal the state is on
	 */
	public CautionWalkState(TrafficSignal t) {
		this.sign = t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.TrafficState#change()
	 */
	@Override
	public void change() {
		sign.setState(new StopWalkState(sign));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.TrafficState#request()
	 */
	@Override
	public void request() {
		sign.requestPassage();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.TrafficState#granted()
	 */
	@Override
	public void granted() {
		sign.passageGranted();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.TrafficState#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Flashing Don't Walk";
	}

	@Override
	public ImageIcon getIcon() {
		return null;
	}

}
