package com.liquidjava.flightcontrollers.examples.mocap2;


/**
 * Hello world!
 */
public class App {
    public static void main(java.lang.String[] args) {
        io.mavsdk.System drone = new io.mavsdk.System();
        io.mavsdk.mocap.Mocap m = drone.getMocap();
        // m.initialize();
        m.setAttitudePositionMocap(null);
        m.setVisionPositionEstimate(null);
        m.toString();
        m.dispose();
    }
}

