/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * Interface for the controller's functionality
 * 
 * @author ttaylor11
 * @author deagle
 */
public interface ControllerInterface {

	/**
	 * Runs the model until the end time provided by the view
	 */
	void go();

	/**
	 * Runs the model for one tick
	 */
	void step();

	/**
	 * Resets the model to the end time provided by the view
	 */
	void reset();

}
