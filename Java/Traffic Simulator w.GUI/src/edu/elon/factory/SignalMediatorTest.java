/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */
package edu.elon.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SignalMediatorTest {
	
	private Time t;
	private SignalMediator sm;

	@Before
	public void setUp() throws Exception {
		t = Time.uniqueInstance();
		sm = new SignalMediator(t);
	}

	@After
	public void tearDown() throws Exception {
		sm = null;
	}

	@Test
	public void test() {
//		sm.test();
		t.run();
		assertEquals(sm.toString(), "372 Green LightGreen LightDon't WalkDon't Walkfalse");
	}

}
