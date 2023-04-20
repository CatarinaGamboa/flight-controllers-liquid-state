package com.liquidjava.flightcontrollers.examples.mission_controller2;


public class MissionController {
    public static void main(java.lang.String[] args) {
        io.mavsdk.System drone = new io.mavsdk.System();
        io.mavsdk.mission.Mission m = drone.getMission();
        m.startMission();
        m.downloadMission();
    }
}

