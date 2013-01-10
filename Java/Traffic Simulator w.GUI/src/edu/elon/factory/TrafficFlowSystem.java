/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */
package edu.elon.factory;


/**
 * TrafficFlowSystem class is responsible for running 
 * our simulation without any input from the user.
 * 
 * @author deagle
 * @author ttaylor11
 */
public class TrafficFlowSystem implements TimeObserver {
	
	SignalMediator sm = new SignalMediator(Time.uniqueInstance());
	VehicleQueue north = new VehicleQueue(sm.getNorth(), 0.02, new ConcreteVehicleFactory(0,0,0.1,0.9), Time.uniqueInstance());
	VehicleQueue south = new VehicleQueue(sm.getSouth(), 0.02, new ConcreteVehicleFactory(0,0,0.1,0.9), Time.uniqueInstance());
	VehicleQueue east = new VehicleQueue(sm.getEast(), 0.05, new ConcreteVehicleFactory(), Time.uniqueInstance());
	VehicleQueue west = new VehicleQueue(sm.getWest(), 0.033, new ConcreteVehicleFactory(), Time.uniqueInstance());

//	/**
//	 * Main method to start  the running of the program.
//	 * 
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		TrafficFlowSystem tfs = new TrafficFlowSystem(Time.uniqueInstance());
//		System.out.println("Time\t\t\tEast\t\t\t\tWest\t\t\tNorth\t\tSouth");
//		System.out.println("\t\tVehicles\tLength\t\tVehicles\tLength\t\tVehicles\tVehicles");
//		Time.uniqueInstance().run();
//		
//	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TimeObserver#timeChanged(int)
	 */
	@Override
	public void timeChanged(int newTime) {
		System.out.println(newTime + "\t\t" + east.getSize() + "\t\t" + east.getLength()
				 + "\t\t" + west.getSize() + "\t\t" + west.getLength()
				 + "\t\t" + north.getSize() + "\t\t" + south.getSize()
				 + "\t\t" + sm.getState());
	}

	/**
	 * TrafficFlowSystem constructor that takes 
	 * in the time and adds the TrafficFlowSystem
	 * as a TimeObserver.
	 * 
	 * @param t
	 */
	public TrafficFlowSystem(Time t){
		t.addTimeObserver(this);
	}
	
	/**
	 * @return
	 */
	public int getState(){
		return sm.getState();
	}
	
	/**
	 * @return
	 */
	public int getTime(){
		return Time.uniqueInstance().getTime();
	}

}
