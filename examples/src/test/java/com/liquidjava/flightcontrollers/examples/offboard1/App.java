package com.liquidjava.flightcontrollers.examples.offboard1;

import io.mavsdk.offboard.Offboard;

/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args ) {
		io.mavsdk.System drone = new io.mavsdk.System();
		Offboard ofb = drone.getOffboard();
		ofb.initialize();
		ofb.setVelocityBody(null);
		ofb.start();
		ofb.setAttitude(null);
		ofb.stop();
		ofb.dispose();
    }
}
