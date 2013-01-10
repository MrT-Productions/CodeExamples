/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

/**
 * Controller implementation for the traffic flow system
 * 
 * @author ttaylor11
 * @author deagle
 */
public class TrafficController implements ControllerInterface {

	private ModelInterface model;
	private View view;

	/**
	 * Constructs the controller and creates a view
	 * 
	 * @param model
	 */
	public TrafficController(ModelInterface model) {
		this.model = model;
		view = new View(this, model);
		view.createView();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.ControllerInterface#go()
	 */
	@Override
	public void go() {
		System.out.println("Time\t\t\tEast\t\t\t\tWest\t\t\tNorth\t\tSouth");
		System.out
				.println("\t\tVehicles\tLength\t\tVehicles\tLength\t\tVehicles\tVehicles");
		model.run(view.getEndTime());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.ControllerInterface#step()
	 */
	@Override
	public void step() {
		model.step();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.elon.factory.ControllerInterface#reset()
	 */
	@Override
	public void reset() {
		model.reset(view.getEndTime());
	}

}
