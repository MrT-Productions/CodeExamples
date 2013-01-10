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
public class GreenTrafficState implements TrafficState {
	
	private TrafficSignal sign;
	private ImageIcon icon;
	
	/**
	 * GreenTrafficState constructor
	 * 
	 * @param t
	 * 		The current traffic signal the state is on 
	 */
	public GreenTrafficState(TrafficSignal t){
		sign = t;
		java.net.URL imageURL = getClass().getResource("greenLightSmall.png");
		if(imageURL != null){
			icon = new ImageIcon(imageURL);	
		}
	}

	
	/**
	 * Provides the icon for the Green Traffic Signal
	 * 
	 * @return
	 * 			The green icon
	 */			
	public ImageIcon getIcon(){
		return icon;
	}
	/* (non-Javadoc)
	 * @see edu.elon.factory.TrafficState#change()
	 */
	@Override
	public void change() {
		sign.setState(new YellowTrafficState(sign));
		granted();
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
		return "Green Light";
	}

}
