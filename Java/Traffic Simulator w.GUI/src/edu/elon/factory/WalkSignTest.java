/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Creates the Walk Sign Test
 * 
 * @author ttaylor11
 * @author deagle
 *
 */
public class WalkSignTest {

	private WalkSign ws;
	
	@Before
	public void setUp() throws Exception {
		ws = new WalkSign();
	}

	@After
	public void tearDown() throws Exception {
		ws = null;
	}

	@Test
	public void Go(){
		assertEquals(ws.getMessage(), "Walk");
	}

	@Test
	public void Caution(){
		ws.changedState();
		assertEquals(ws.getMessage(), "Flashing Don't Walk");
	}

	@Test
	public void Stop(){
		ws.changedState();
		ws.changedState();
		assertEquals(ws.getMessage(), "Don't Walk");
	}

}
