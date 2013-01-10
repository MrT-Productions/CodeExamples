/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

/**
 * 
 */
package edu.elon.factory;

/**
 * Creates the abstract Vehicle Factory class
 * 
 * @author deagle
 * @author ttaylor11
 */
public abstract class VehicleFactory {

	double chanceCar;
	double chanceBus;
	double chanceBicycle;
	double chancePedestrian;
	
	/**
	 * Default constructor initializes all parameters to default
	 * values of probability
	 */
	public VehicleFactory(){
		this(.8, .1, .1, 0);
	}

	/**
	 * Vehicle Factory constructor initializes all of the class variables
	 * 
	 * @param chanceCar
	 * @param chanceBus
	 * @param chanceBicycle
	 * @param chancePedestrian
	 */
	public VehicleFactory(double chanceCar, double chanceBus,
			double chanceBicycle, double chancePedestrian) {
		if (validChance(chanceCar, chanceBus, chanceBicycle,chancePedestrian)){
			this.chanceCar = chanceCar;
			this.chanceBus = chanceBus;
			this.chanceBicycle = chanceBicycle;
			this.chancePedestrian = chancePedestrian;	
		}
	}
	
	/**
	 * Creates a vehicle based on probabilities.
	 * 
	 * @return Vehicle
	 * 			instantiated vehicle
	 */
	public abstract Vehicle createVehicle();

	/**
	 * Ensures the probabilities sum 1 and are positive
	 * 
	 * @param d doubles to check
	 * @return
	 * 			true if valid
	 */
	public boolean validChance(double... d){
		double temp = 0;
		for(Double x : d){
			temp += x;
			if(x < 0){
				return false;
			}
		}
		if(temp > 1){
			return false;
		}
		return true;
	}
}
