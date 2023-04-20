package com.liquidjava.flightcontrollers.examples.mission_controller2;

import io.mavsdk.mission.Mission;

public class MissionController {
	
	public static void main(String[] args) {
		io.mavsdk.System drone = new io.mavsdk.System();
		Mission m = drone.getMission();
		m.startMission();
		m.downloadMission();
		
	}

}
