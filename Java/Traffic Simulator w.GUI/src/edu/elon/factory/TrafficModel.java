/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import java.util.ArrayList;

/**
 * Model implementation for the traffic flow system
 * 
 * @author ttaylor11
 * @author deagle
 */
public class TrafficModel implements ModelInterface {

	private ArrayList<Observer> observers;
	private TrafficFlowSystem tfs;

	/**
	 * Constructs the model, initializes the list of observers and creates the
	 * simulation
	 */
	public TrafficModel() {
		observers = new ArrayList<Observer>();
		tfs = new TrafficFlowSystem(Time.uniqueInstance());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.elon.factory.ModelInterface#registerObserver(edu.elon.factory.Observer
	 * )
	 */
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.elon.factory.ModelInterface#removeObserver(edu.elon.factory.Observer)
	 */
	@Override
	public void removeObserver(Observer o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}

	/**
	 * Invokes the update method on all of the registered observers
	 */
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(tfs);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.ModelInterface#run(int)
	 */
	@Override
	public void run(int endTime) {
		reset(endTime);
		Time.uniqueInstance().run();
		notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.ModelInterface#step()
	 */
	@Override
	public void step() {
		Time.uniqueInstance().step();
		notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.ModelInterface#reset(int)
	 */
	@Override
	public void reset(int endTime) {
		Time.uniqueInstance().removeTimeObserver(tfs);
		tfs = new TrafficFlowSystem(Time.uniqueInstance());
		Time.init(endTime);
		notifyObservers();
	}

}
