/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * @author ttaylor11
 * @author deagle
 */
public class DavesFinalApplication {

	/**
	 * Creates a model and a controller
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ModelInterface model = new TrafficModel();
		ControllerInterface controller = new TrafficController(model);

	}

}
