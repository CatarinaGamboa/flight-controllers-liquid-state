package com.liquidjava.flightcontrollers.examples;


public class MissionController1 {
    public static void main(java.lang.String[] args) {
        io.mavsdk.System drone = new io.mavsdk.System();
        io.mavsdk.mission.Mission m = drone.getMission();
        m.setReturnToLaunchAfterMission(true);
        m.uploadMission(null);
        m.startMission();
        m.downloadMission();
    }
}

