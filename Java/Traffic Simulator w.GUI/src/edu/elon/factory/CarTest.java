/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarTest {

	private Vehicle v;

	@Before
	public void setUp() throws Exception {
		v = new Car();
	}

	@After
	public void tearDown() throws Exception {
		v = null;
	}

	@Test
	public void testGetSpeed() {
		assertEquals("0.0", Double.toString(v.getSpeed()));
	}

	@Test
	public void testGetMaxSpeed() {
		assertEquals("120.0", Double.toString(v.getMaxSpeed()));
	}

	@Test
	public void testGetLength() {
		assertEquals("6.0", Double.toString(v.getLength()));
	}

	@Test
	public void testAccelerate() {
		v.accelerate(100.0);
		assertEquals("100.0",Double.toString(v.getSpeed()));
	}

	@Test
	public void testDecelerate() {
		v.decelerate(100.0);
		assertEquals("0.0", Double.toString(v.getSpeed()));
	}

}
