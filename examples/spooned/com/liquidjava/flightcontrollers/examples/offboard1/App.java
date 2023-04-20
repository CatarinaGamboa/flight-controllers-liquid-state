package com.liquidjava.flightcontrollers.examples.offboard1;


/**
 * Hello world!
 */
public class App {
    public static void main(java.lang.String[] args) {
        io.mavsdk.System drone = new io.mavsdk.System();
        io.mavsdk.offboard.Offboard ofb = drone.getOffboard();
        ofb.initialize();
        ofb.setVelocityBody(null);
        ofb.start();
        ofb.setAttitude(null);
        ofb.stop();
        ofb.dispose();
    }
}

