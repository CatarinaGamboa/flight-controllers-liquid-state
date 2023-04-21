package com.liquidjava.flightcontrollers.examples.camera2;

import io.mavsdk.camera.Camera;

/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args ) {
	
		//Correct
		io.mavsdk.System drone = new io.mavsdk.System();
		Camera c = drone.getCamera();
		c.initialize();
		c.setMode(null);
//		c.startVideo();
		c.stopVideo();		
		
    }
}
