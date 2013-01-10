/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import javax.swing.ImageIcon;

/**
 * Creates the Traffic State interface
 * 
 * @author ttaylor11
 * @author deagle
 *
 */
public interface TrafficState {
	
	/**
	 * Changes the traffic state
	 */
	void change();
	
	/**
	 * Set passageRequested to true
	 */
	void request();
	
	/**
	 * Set passageRequested to false
	 */
	void granted();
	
	/**
	 * Returns a string containing the current state
	 * 
	 * @return String
	 * 			Containing the current message of the state
	 */
	public String getMessage();
	
	/**
	 * @return
	 */
	public ImageIcon getIcon();

}
