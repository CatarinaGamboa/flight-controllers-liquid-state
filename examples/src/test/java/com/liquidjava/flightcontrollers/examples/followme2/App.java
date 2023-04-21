package com.liquidjava.flightcontrollers.examples.followme2;

import io.mavsdk.camera.Camera;
import io.mavsdk.follow_me.FollowMe;

/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args ) {
	
		io.mavsdk.System drone = new io.mavsdk.System();
		FollowMe fm = drone.getFollowMe();
		fm.initialize();
		fm.setConfig(null);
		fm.getConfig();
//		fm.start();
//		fm.getLastLocation();
		fm.stop();
		fm.dispose();
		
    }
}
