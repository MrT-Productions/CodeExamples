/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import javax.swing.ImageIcon;

/**
 * Bicycle implementation of a vehicle.
 * 
 * @author deagle
 * @author ttaylor11
 */
public class Bicycle extends Vehicle {
	
	/**
	 * Sets appropriate properties
	 */
	public Bicycle(){
		length = 1.5;
		maxSpeed = 25.0;
		java.net.URL imageURL = getClass().getResource("bike.gif");
		if(imageURL != null){
			icon = new ImageIcon(imageURL);	
		}
		
	}

}
