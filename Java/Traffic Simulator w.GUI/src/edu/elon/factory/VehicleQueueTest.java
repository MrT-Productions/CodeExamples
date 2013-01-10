package edu.elon.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VehicleQueueTest {

	private VehicleQueue q;
	
	@Before
	public void setUp() throws Exception {
		//q = new VehicleQueue(.5, new ConcreteVehicleFactory());
	}

	@After
	public void tearDown() throws Exception {
		q = null;
	}

	@Test
	public void testEnter() {
		q.enter();
		assertEquals(1, q.getSize());
	}

	@Test
	public void testLeave() {
		q.enter();
		q.leave();
		assertEquals((Object)0, (Object)q.getSize());
	}

	@Test
	public void testGetSize() {
		q.enter();
		assertEquals(q.getSize(), 1);
	}

	@Test
	public void testGetLength() {
		q.enter();
		assertEquals((Object)q.getLength(), (Object)6.0);
	}

}
