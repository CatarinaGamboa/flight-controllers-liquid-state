package com.liquidjava.flightcontrollers.examples.mocap2;

import io.mavsdk.mocap.Mocap;

/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args ) {
	
		
		io.mavsdk.System drone = new io.mavsdk.System();
		Mocap m = drone.getMocap();
//		m.initialize();
		m.setAttitudePositionMocap(null);
		m.setVisionPositionEstimate(null);
		m.toString();
		m.dispose();
		
    }
}
