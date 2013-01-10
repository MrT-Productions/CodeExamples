/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import javax.swing.ImageIcon;


/**
 * Creates the Red Traffic State
 * 
 * @author ttaylor11
 * @author deagle
 *
 */
public class RedTrafficState implements TrafficState {
	
	private TrafficSignal sign;
	private ImageIcon icon;
	
	/**
	 * RedTrafficState constructor
	 * 
	 * @param t
	 * 		The current traffic signal the state is on 
	 */
	public RedTrafficState(TrafficSignal t){
		sign = t;
		java.net.URL imageURL = getClass().getResource("redLightSmall.png");
		if(imageURL != null){
			icon = new ImageIcon(imageURL);	
		}
	}

	
	/**
	 * Provides the icon for the Red Traffic Signal
	 * 
	 * @return
	 * 			The red icon
	 */
	public ImageIcon getIcon(){
		return icon;
	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#change()
	 */
	@Override
	public void change() {
		sign.setState(new GreenTrafficState(sign));
	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#request()
	 */
	@Override
	public void request() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#granted()
	 */
	@Override
	public void granted() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Red Light";
	}

}
