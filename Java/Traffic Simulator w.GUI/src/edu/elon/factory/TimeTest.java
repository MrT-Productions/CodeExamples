/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */
package edu.elon.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	
	private static Time time;

	@Before
	public void setUp() throws Exception {
		time = Time.uniqueInstance();
	}

	@After
	public void tearDown() throws Exception {
		time = null;
	}

	@Test
	public void test1() {
		assertEquals(0, time.getTime());
	}
	
	@Test
	public void test2() {
		time.run();
		assertEquals(600, time.getTime());
	}

}
