/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * Interface that provides a method to update based on time
 * 
 * @author deagle
 * @author ttaylor11
 */
public interface TimeObserver {

	/**
	 * method called with each tick of the time clock
	 * 
	 * @param newTime
	 *            int elapsed time
	 */
	public void timeChanged(int newTime);

}
