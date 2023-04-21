package com.liquidjava.flightcontrollers.examples.camera2;


/**
 * Hello world!
 */
public class App {
    public static void main(java.lang.String[] args) {
        // Correct
        io.mavsdk.System drone = new io.mavsdk.System();
        io.mavsdk.camera.Camera c = drone.getCamera();
        c.initialize();
        c.setMode(null);
        // c.startVideo();
        c.stopVideo();
    }
}

