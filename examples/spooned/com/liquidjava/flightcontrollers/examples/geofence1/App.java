package com.liquidjava.flightcontrollers.examples.geofence1;


/**
 * Hello world!
 */
public class App {
    public static void main(java.lang.String[] args) {
        io.mavsdk.System drone = new io.mavsdk.System();
        io.mavsdk.geofence.Geofence g = drone.getGeofence();
        g.initialize();
        g.uploadGeofence(null);
        g.clearGeofence();
        g.uploadGeofence(null);
        g.dispose();
    }
}

