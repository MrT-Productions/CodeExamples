/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;


/**
 * SignalMediator class that is responsible for queuing
 * requests and making sure that each light is green
 * for a minimum amount of time.  SignalMediator is a
 * TimeObserver in order to receive second updates.
 * 
 * @author deagle
 * @ttaylor11
 */
public class SignalMediator implements TimeObserver {

	private TrafficSignal east;
	private TrafficSignal west;
	private TrafficSignal north;
	private TrafficSignal south;
	private int stateTime;
	private int state;

	/**
	 * SignalMediator constructor that takes in time
	 * in order to add itself as a Time Observer
	 * 
	 * @param t
	 */
	public SignalMediator(Time t) {
		t.addTimeObserver(this);
		stateTime = 0;
		east = new TrafficLight();
		west = new TrafficLight();
		north = new WalkSign();
		south = new WalkSign();
		state = 1;
	}

	/* (non-Javadoc)
	 * @see edu.elon.factory.TimeObserver#timeChanged(int)
	 */
	@Override
	public void timeChanged(int newTime) {
		stateTime++;
		if (state1()) {
			if (north.passageRequested || south.passageRequested) {
				east.changedState();
				west.changedState();
				stateTime = 0;
				state = 3;
			}
		} else if (state3() || state7()) {
			east.changedState();
			west.changedState();
			stateTime = 0;
		} else if (state5() || state6()) {
			north.changedState();
			south.changedState();
			stateTime = 0;
		} else if (state4()) {
			north.changedState();
			south.changedState();
			stateTime = 0;
		}
	}

	
	/**
	 * Gets the east traffic signal
	 * 
	 * @return east
	 * 			The East traffic signal
	 */
	public TrafficSignal getEast() {
		return east;
	}

	/**
	 * Gets the west traffic signal
	 * 
	 * @return east
	 * 			The West traffic signal
	 */
	public TrafficSignal getWest() {
		return west;
	}

	/**
	 * Gets the north traffic signal
	 * 
	 * @return east
	 * 			The North traffic signal
	 */
	public TrafficSignal getNorth() {
		return north;
	}

	/**
	 * Gets the south traffic signal
	 * 
	 * @return east
	 * 			The South traffic signal
	 */
	public TrafficSignal getSouth() {
		return south;
	}

	/**
	  * Gets the east traffic signal
	 * 
	 * @return state
	 * 			The current State
	 */
	public int getState() {
		return state;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return stateTime + " " + east.getMessage() + west.getMessage()
				+ south.getMessage() + north.getMessage()
				+ north.getPassageRequest();
	}

	/**
	 * State 1 logic
	 * 
	 * @return boolean
	 */
	private boolean state1() {
		if (east.state instanceof GreenTrafficState
				&& west.state instanceof GreenTrafficState
				&& north.state instanceof StopWalkState
				&& south.state instanceof StopWalkState && stateTime > 120
				&& state == 1) {
			return true;
		}
		return false;
	}

	/**
	 * State 3 logic
	 * 
	 * @return boolean
	 */
	private boolean  state3() {
		if (east.state instanceof YellowTrafficState
				&& west.state instanceof YellowTrafficState
				&& north.state instanceof StopWalkState
				&& south.state instanceof StopWalkState
				&& (north.passageRequested || south.passageRequested)
				&& stateTime > 12 && state == 3) {
			state = 4;
			return true;
		}
		return false;
	}

	/**
	 * State 4 logic
	 * 
	 * @return boolean
	 */
	private boolean state4() {
		if (east.state instanceof RedTrafficState
				&& west.state instanceof RedTrafficState
				&& north.state instanceof StopWalkState
				&& south.state instanceof StopWalkState
				&& (north.passageRequested || south.passageRequested)
				&& stateTime > 5 && state == 4) {
			state = 5;
			return true;
		}
		return false;
	}

	/**
	 * State 5 logic
	 * 
	 * @return boolean
	 */
	private boolean state5() {
		if (east.state instanceof RedTrafficState
				&& west.state instanceof RedTrafficState
				&& north.state instanceof GoWalkState
				&& south.state instanceof GoWalkState
				&& (!north.passageRequested && !south.passageRequested)
				&& stateTime > 60 && state == 5) {
			state = 6;
			return true;
		}
		return false;
	}

	/**
	 * State 6 logic
	 * 
	 * @return boolean
	 */
	private boolean state6() {
		if (east.state instanceof RedTrafficState
				&& west.state instanceof RedTrafficState
				&& north.state instanceof CautionWalkState
				&& south.state instanceof CautionWalkState
				&& (!north.passageRequested && !south.passageRequested)
				&& stateTime > 20 && state == 6) {
			state = 7;
			return true;
		}
		return false;
	}

	/**
	 * State 7 logic
	 * 
	 * @return boolean
	 */
	private boolean state7() {
		if (state == 7 && stateTime > 5) {
			state = 1;
			return true;
		}
		return false;
	}
}
