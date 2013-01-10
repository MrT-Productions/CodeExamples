/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

/**
 * 
 */
package edu.elon.factory;

import java.util.Random;

/**
 * Implements the vehicle factory.
 * 
 * @author deagle
 * @author ttaylor11
 */
public class ConcreteVehicleFactory extends VehicleFactory{

	/**
	 * Default constructor
	 */
	public ConcreteVehicleFactory() {
		super();
	}
	
	
	/**
	 * Loaded constructor
	 * 
	 * @param chanceCar
	 * @param chanceBus
	 * @param chanceBicycle
	 * @param chancePedestrian
	 */
	public ConcreteVehicleFactory(double chanceCar, double chanceBus,
			double chanceBicycle, double chancePedestrian) {
		super(chanceCar, chanceBus, chanceBicycle, chancePedestrian);
	}


	/* (non-Javadoc)
	 * @see edu.elon.factory.VehicleFactory#createVehicle()
	 */
	@Override
	public Vehicle createVehicle() {
		Random rand = new Random();
		double r = rand.nextDouble();
		Vehicle v;
		if (r < chanceCar){
			v = new Car();
		} else if (r < chanceCar + chanceBus){
			v = new Bus();
		} else if (r < chanceCar + chanceBus + chanceBicycle){
			v = new Bicycle();
		} else {
			v = new Pedestrian();
		}
		return v;
	}

	
}
