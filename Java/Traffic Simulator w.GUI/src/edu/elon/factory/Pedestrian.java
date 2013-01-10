/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import javax.swing.ImageIcon;

/**
 * Pedestrian implementation of a vehicle.
 * 
 * @author deagle
 * @author ttaylor11
 */
public class Pedestrian extends Vehicle {
	
	/**
	 * Sets appropriate properties
	 */
	public Pedestrian(){
		length = 0.0;
		maxSpeed = 4.0;
		java.net.URL imageURL = getClass().getResource("pedestrian.gif");
		if(imageURL != null){
			icon = new ImageIcon(imageURL);	
		}
	}

}
