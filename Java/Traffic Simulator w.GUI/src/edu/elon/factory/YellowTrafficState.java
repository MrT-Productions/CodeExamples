/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import javax.swing.ImageIcon;

/**
 * Creates the Yellow Traffic State
 * 
 * @author ttaylor11
 * @author deagle
 * 
 */
public class YellowTrafficState implements TrafficState {

	private TrafficSignal sign;
	private ImageIcon icon;

	/**
	 * YellowTrafficState constructor
	 * 
	 * @param t
	 *            The current traffic signal the state is on
	 */
	public YellowTrafficState(TrafficSignal t) {
		sign = t;
		java.net.URL imageURL = getClass().getResource("yellowLightSmall.png");
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		}
	}

	/**
	 * Provides the icon for the Yellow Traffic Signal
	 * 
	 * @return
	 * 			The yellow icon
	 */
	public ImageIcon getIcon() {
		return icon;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.TrafficState#change()
	 */
	@Override
	public void change() {
		sign.setState(new RedTrafficState(sign));

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
		return "Yellow Light";
	}

}
