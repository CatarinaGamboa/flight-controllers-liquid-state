package com.liquidjava.flightcontrollers.examples.mission_controller1;

import io.mavsdk.mission.Mission;

public class MissionController1 {
	
	public static void main(String[] args) {
		io.mavsdk.System drone = new io.mavsdk.System();
		Mission m = drone.getMission();
		m.setReturnToLaunchAfterMission(true);
		m.uploadMission(null);
		m.startMission();
		m.downloadMission();
		
	}

}
