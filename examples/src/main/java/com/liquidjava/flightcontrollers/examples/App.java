package com.liquidjava.flightcontrollers.examples;

import io.mavsdk.geofence.Geofence;

/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args ) {
	
		
		//Correct
		io.mavsdk.System drone = new io.mavsdk.System();
		Geofence g = drone.getGeofence();
		g.initialize();
		g.uploadGeofence(null);
		g.clearGeofence();
		g.uploadGeofence(null);
		g.dispose();
		
    }
}
