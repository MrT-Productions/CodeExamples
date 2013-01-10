/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * SignalMediator that is responsible for queuing requests and making sure that
 * each light is green for a minimum amount of time. SignalMediator is also a
 * TimeObserver to recieve second updates.
 * 
 * @author ttaylor11
 * @author deagle
 */
public class SignalMediatorOLD implements TimeObserver {

	private MediatorState state;
	private Time t;
	private boolean walkRequest;

	/**
	 * Instantiates the signal mediator and registers it as an observer to time
	 * 
	 * @param t
	 */
	public SignalMediatorOLD(Time t) {
		state = new MediatorState1();
		this.t = t;
		t.addTimeObserver(this);
		walkRequest = false;
	}

	/**
	 * Pedestrian request to walk
	 * 
	 * @param tf
	 *            boolean true if request to walk
	 */
	public void setWalkRequest(boolean tf) {
		this.walkRequest = tf;
	}

	/**
	 * Gets the traffic pattern state
	 * 
	 * @return MediatorState current traffic state
	 */
	public MediatorState getState() {
		return this.state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.TimeObserver#timeChanged(int)
	 */
	@Override
	public void timeChanged(int newTime) {
		state.time++;
		if (state instanceof MediatorState1 && state.time > 120 && walkRequest) {
			state = new MediatorState2();
			walkRequest = true;
		} else if (state instanceof MediatorState2) {
			state = new MediatorState3();
			walkRequest = true;
		} else if (state instanceof MediatorState3 && state.time == 12) {
			state = new MediatorState4();
			walkRequest = true;
		} else if (state instanceof MediatorState4 && state.time == 5) {
			state = new MediatorState5();
			walkRequest = false;
		} else if (state instanceof MediatorState5 && state.time == 60) {
			state = new MediatorState6();
			walkRequest = false;
		} else if (state instanceof MediatorState6 && state.time == 20) {
			state = new MediatorState7();
			walkRequest = false;
		} else if (state instanceof MediatorState7 && state.time == 5) {
			state = new MediatorState1();
			walkRequest = false;
		}
	}

	/**
	 * Creates the state parameters
	 * 
	 * @author ttaylor11
	 * @author deagle
	 * 
	 */
	public class MediatorState {
		TrafficSignal east = new TrafficLight();
		TrafficSignal west = new TrafficLight();
		TrafficSignal north = new WalkSign();
		TrafficSignal south = new WalkSign();
		boolean walkRequest;
		int time;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return this.getClass().getSimpleName() + " " + east.getMessage()
					+ " " + west.getMessage() + " " + north.getMessage() + " "
					+ south.getMessage() + " Walkrequest is set to"
					+ walkRequest;
		}
	}

	/**
	 * Instantiates state 1
	 * 
	 * @author ttaylor11
	 * @author deagle
	 * 
	 */
	public class MediatorState1 extends MediatorState {
		public MediatorState1() {
			east.setState(new GreenTrafficState(east));
			west.setState(new GreenTrafficState(west));
			north.setState(new StopWalkState(north));
			south.setState(new StopWalkState(south));
			time = 0;
		}
	}

	/**
	 * Instantiates state 2
	 * 
	 * @author ttaylor11
	 * @author deagle
	 * 
	 */
	public class MediatorState2 extends MediatorState {
		public MediatorState2() {
			east.setState(new GreenTrafficState(east));
			west.setState(new GreenTrafficState(west));
			north.setState(new StopWalkState(north));
			south.setState(new StopWalkState(south));
			time = 0;
		}
	}

	/**
	 * Instantiates state 3
	 * 
	 * @author ttaylor11
	 * @author deagle
	 * 
	 */
	public class MediatorState3 extends MediatorState {
		public MediatorState3() {
			east.setState(new YellowTrafficState(east));
			west.setState(new YellowTrafficState(west));
			north.setState(new StopWalkState(north));
			south.setState(new StopWalkState(south));
			time = 0;
		}
	}

	/**
	 * Instantiates state 4
	 * 
	 * @author ttaylor11
	 * @author deagle
	 * 
	 */
	public class MediatorState4 extends MediatorState {
		public MediatorState4() {
			east.setState(new GreenTrafficState(east));
			west.setState(new GreenTrafficState(west));
			north.setState(new StopWalkState(north));
			south.setState(new StopWalkState(south));
			time = 0;
		}
	}

	/**
	 * Instantiates state 5
	 * 
	 * @author ttaylor11
	 * @author deagle
	 * 
	 */
	public class MediatorState5 extends MediatorState {
		public MediatorState5() {
			east.setState(new RedTrafficState(east));
			west.setState(new RedTrafficState(west));
			north.setState(new GoWalkState(north));
			south.setState(new GoWalkState(south));
			time = 0;
		}
	}

	/**
	 * Instantiates state 6
	 * 
	 * @author ttaylor11
	 * @author deagle
	 * 
	 */
	public class MediatorState6 extends MediatorState {
		public MediatorState6() {
			east.setState(new RedTrafficState(east));
			west.setState(new RedTrafficState(west));
			north.setState(new CautionWalkState(north));
			south.setState(new CautionWalkState(south));
			time = 0;
		}
	}

	/**
	 * Instantiates state 7
	 * 
	 * @author ttaylor11
	 * @author deagle
	 * 
	 */
	public class MediatorState7 extends MediatorState {
		public MediatorState7() {
			east.setState(new RedTrafficState(east));
			west.setState(new RedTrafficState(west));
			north.setState(new StopWalkState(north));
			south.setState(new StopWalkState(south));
			time = 0;
		}
	}
}
