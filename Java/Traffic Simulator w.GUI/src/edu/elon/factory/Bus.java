/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import javax.swing.ImageIcon;

/**
 * Bus implementation of a vehicle. 
 * 
 * @author deagle
 * @author ttaylor11
 */
public class Bus extends Vehicle {
	
	/**
	 * Sets appropriate properties
	 */
	public Bus(){
		length = 18.0;
		maxSpeed = 92.0;
		java.net.URL imageURL = getClass().getResource("bus.gif");
		if(imageURL != null){
			icon = new ImageIcon(imageURL);	
		}
	}

}
