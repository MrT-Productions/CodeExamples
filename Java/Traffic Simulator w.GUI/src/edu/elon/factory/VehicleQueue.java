/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Class responsible for representing and maintaining the line of cars in a lane
 * 
 * @author ttaylor11
 * @author deagle
 * 
 */
public class VehicleQueue implements TimeObserver {

	private Queue<Vehicle> q;
	private double queueLength = 0.0;
	private double vehiclesPerSecond;
	private VehicleFactory vf;
	private TrafficSignal ts;

	/**
	 * Instantiates the vehicle queue
	 * 
	 * @param vps
	 *            double pertaining to the number of vehicles per second
	 * @param v
	 *            VehicleFactory used to create vehicle objects
	 */
	public VehicleQueue(TrafficSignal ts, double vps, VehicleFactory v, Time t) {
		vehiclesPerSecond = vps;
		vf = v;
		q = new LinkedList<Vehicle>();
		t.addTimeObserver(this);
		this.ts = ts;
	}

	/**
	 * Randomly determines whether or not to add a vehicle ot the queue
	 */
	public void enter() {
		Random r = new Random();
		if (r.nextDouble() < vehiclesPerSecond) {
			Vehicle v = vf.createVehicle();
			if ((v instanceof Pedestrian || v instanceof Bicycle) && ts.getState() instanceof StopWalkState){
				ts.requestPassage();
			}
			q.add(v);
		}
	}

	/**
	 * Pushes the first vehicles in off the line
	 */
	public void leave() {
		q.poll();
	}

	/**
	 * Get the number of vehicles in the queue
	 * 
	 * @return int number of vehicles
	 */
	public int getSize() {
		return q.size();
	}

	/**
	 * Sums up and returns the physical length of the queue
	 * 
	 * @return double total length of vehicles
	 */
	public double getLength() {
		Iterator<Vehicle> i = q.iterator();
		double sum = 0.0;
		while (i.hasNext()) {
			sum += ((Vehicle) i.next()).getLength();
		}
		return sum;
	}

	/**
	 * Prints the vehicles in the queue for debugging
	 */
	public void list() {
		for (Vehicle v : q) {
			System.out.println(v.toString());
		}
	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TimeObserver#timeChanged(int)
	 */
	@Override
	public void timeChanged(int newTime) {
		enter();
		if (newTime % 5 == 0 && (ts.getState() instanceof GoWalkState || ts.getState() instanceof GreenTrafficState)){
			leave();
		}
		
	}
	
	public ArrayList<Vehicle> getVehicles(){
		ArrayList<Vehicle> a = new ArrayList<Vehicle>();
		a.addAll(q);
		return a;
	}

}
