/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */
package edu.elon.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SignalMediatorOLDTest {

	private Time t;
	private SignalMediatorOLD snm;
	
	
	@Before
	public void setUp() throws Exception {
		t = Time.uniqueInstance();
		snm = new SignalMediatorOLD(t);
	}

	
	@After
	public void tearDown() throws Exception {
		t = null;
		snm = null;
	}

	@Test
	public void testTimeChanged() {
		snm.setWalkRequest(true);
		t.run();
		System.out.println(snm.getState().toString());
		assertEquals("MediatorState1 Green Light Green Light Don't Walk Don't Walk Walkrequest is set tofalse", snm.getState().toString());
	}

}
