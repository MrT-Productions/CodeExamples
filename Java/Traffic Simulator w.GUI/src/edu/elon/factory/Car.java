/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import javax.swing.ImageIcon;

/**
 * Car implementation of a vehicle.
 * 
 * @author deagle
 * @author ttaylor11
 */
public class Car extends Vehicle {
	
	/**
	 * Sets appropriate properties
	 */
	public Car(){
		length = 6.0;
		maxSpeed = 120.0;
		java.net.URL imageURL = getClass().getResource("car.gif");
		if(imageURL != null){
			icon = new ImageIcon(imageURL);	
		}
	}

}
