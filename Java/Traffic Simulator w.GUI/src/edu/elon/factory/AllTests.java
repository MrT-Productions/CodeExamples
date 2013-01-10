/*
 * Copyright (c) 2012 Dan Eagle & Thonda Taylor II
 */

package edu.elon.factory;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BicycleTest.class, BusTest.class, CarTest.class,
		ConcreteVehicleFactoryTest.class, PedestrianTest.class, TimeTest.class,
		TrafficLightTest.class, WalkSignTest.class, VehicleQueueTest.class, SignalMediatorOLDTest.class })
public class AllTests {

}
