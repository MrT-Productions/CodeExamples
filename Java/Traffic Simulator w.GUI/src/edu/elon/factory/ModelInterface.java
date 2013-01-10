/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * Interface for the model's functionality also implements the observable
 * pattern
 * 
 * @author ttaylor11
 * @author deagle
 */
public interface ModelInterface {

	/**
	 * Adds an observer to this observable
	 * 
	 * @param o
	 *            Observer to add
	 */
	void registerObserver(Observer o);

	/**
	 * Removes an observer from this observable
	 * 
	 * @param o
	 *            Observer to remove
	 */
	void removeObserver(Observer o);

	/**
	 * Runs the traffic simulation until the endTime
	 * 
	 * @param endTime
	 *            int for when the simulation ends
	 */
	void run(int endTime);

	/**
	 * Runs the simulation for one tick
	 */
	void step();

	/**
	 * Resets the simulation with the endTime provided
	 * 
	 * @param endTime
	 *            int for when the simulation should end
	 */
	void reset(int endTime);

}
