/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConcreteVehicleFactoryTest {
	
	private ConcreteVehicleFactory f;

	@Before
	public void setUp() throws Exception {
		f = new ConcreteVehicleFactory();
	}

	@After
	public void tearDown() throws Exception {
		f = null;
	}

	@Test
	public void testCreateVehicle() {
		Vehicle v = f.createVehicle();
		if (v.equals(new Car())){
			assertEquals(new Car().toString(), v.toString());
		} else if (v.equals(new Bus())){
			assertEquals(new Bus().toString(), v.toString());
		} else if (v.equals(new Bicycle())){
			assertEquals(new Bicycle().toString(), v.toString());
		} else if (v.equals(new Pedestrian())){
			assertEquals(new Pedestrian().toString(), v.toString());
		}
	}

}
