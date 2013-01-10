/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Abstract class that defines the properties of a vehicle. 
 * 
 * @author deagle
 * @author ttaylor11
 */

public abstract class Vehicle {
	
	double speed = 0;
	double maxSpeed;
	double length;
	ImageIcon icon;
	
	
	/**
	 * The vehicle icon
	 * 
	 * @return icon
	 * 			The icon that goes with the vehicle
	 * 			
	 */
	public ImageIcon getIcon(){
		return icon;
	}
	
	/**
	 * Returns the speed of the Vehicle
	 * 
	 * @return speed
	 * 			The speed of the vehicle
	 */
	public double getSpeed(){
		return speed;
	}
	
	/**
	 * Returns the max speed of the vehicle
	 * 
	 * @return maxSpeed
	 * 		The max speed of the vehicle
	 */
	public double getMaxSpeed(){
		return maxSpeed;
	}
	
	/**
	 * Returns the length of the vehicle
	 * 
	 * @return length
	 * 			The length of the vehicle
	 */
	public double getLength(){
		return length;
	}
	
	/**
	 * Accelerates the vehicle by a certain speed
	 * 
	 * @param d
	 * 			The amount to accelerate by
	 */
	public void accelerate(double d){
		if (speed + d < maxSpeed){
			speed += d;
		} else if (speed + d > maxSpeed){
			speed = maxSpeed;
		}
	}
	
	/**
	 * Decelerates the vehicle by a certain speed
	 * 
	 * @param d 
	 *			The speed to decelerate by
	 */
	public void decelerate(double d){
		if (speed - d > 0){
			speed -= d;
		} else if (speed - d < 0){
			speed = 0;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return speed + " " + maxSpeed + " " + length;
	}

}
