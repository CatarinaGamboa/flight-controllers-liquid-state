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
		
		
		
		//######## Examples ########
		
//		//--------- Geofence ----------
//		//Correct
//		io.mavsdk.System drone = new io.mavsdk.System();
//		Geofence g = drone.getGeofence();
//		g.initialize();
//		g.uploadGeofence(null);
//		g.clearGeofence();
//		g.uploadGeofence(null);
//		g.dispose();
		
//		//Error
//		io.mavsdk.System drone = new io.mavsdk.System();
//		Geofence g = drone.getGeofence();
//		g.initialize();
////		g.uploadGeofence(null);
//		g.clearGeofence();
//		g.uploadGeofence(null);
//		g.dispose();
		
		
		

//		//--------- Mission ----------
//		//Correct
//		io.mavsdk.System drone = new io.mavsdk.System();
//		Mission m = drone.getMission();
//		m.setReturnToLaunchAfterMission(true);
//		m.uploadMission(null);
//		m.startMission();
//		m.downloadMission();
//		
		
//		//Error
//		io.mavsdk.System drone = new io.mavsdk.System();
//		Mission m = drone.getMission();
//		m.startMission();
//		m.downloadMission();
		
		
//		//--------- Offboard ----------
//		//Correct
//		Offboard.ActuatorControl ac = null;
//		Offboard ofb = drone.getOffboard();
//		ofb.initialize();
//		ofb.setVelocityBody(null);
//		ofb.start();
//		ofb.setAttitude(null);
//		ofb.stop();
//		ofb.dispose();
		
//		//Error
//		Offboard.ActuatorControl ac = null;
//		Offboard ofb = drone.getOffboard();
//		ofb.initialize();
//		ofb.start();
		
		//Error
//		Offboard.ActuatorControl ac = null;
//		Offboard ofb = drone.getOffboard();
//		ofb.setVelocityNed(null);
    }
}
