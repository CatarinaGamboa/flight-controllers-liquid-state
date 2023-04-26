package com.liquidjava.flightcontrollers.examples.mocap1;


/**
 * Hello world!
 */
public class App {
    public static void main(java.lang.String[] args) {
        // Correct
        io.mavsdk.System drone = new io.mavsdk.System();
        io.mavsdk.mocap.Mocap m = drone.getMocap();
        m.initialize();
        m.setAttitudePositionMocap(null);
        m.setVisionPositionEstimate(null);
        m.toString();
        m.dispose();
    }
}

