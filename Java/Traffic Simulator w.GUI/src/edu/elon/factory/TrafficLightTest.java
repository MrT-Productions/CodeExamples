/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */
package edu.elon.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Creates the Traffic Light Test
 * 
 * @author ttaylor11
 * @author deagle
 *
 */
public class TrafficLightTest {

	private TrafficLight tl;

	@Before
	public void setUp() throws Exception {
		tl = new TrafficLight();
	}

	@After
	public void tearDown() throws Exception {
		tl = null;
	}

	@Test
	public void testRed() {
		assertEquals("Red Light", tl.getMessage());
	}

	@Test
	public void testGreen() {
		tl.changedState();
		assertEquals("Green Light", tl.getMessage());
	}
	
	@Test
	public void testYellow() {
		tl.changedState();
		tl.changedState();
		assertEquals("Yellow Light", tl.getMessage());
	}

}
