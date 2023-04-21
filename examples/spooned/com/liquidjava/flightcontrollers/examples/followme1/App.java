package com.liquidjava.flightcontrollers.examples.followme1;


/**
 * Hello world!
 */
public class App {
    public static void main(java.lang.String[] args) {
        io.mavsdk.System drone = new io.mavsdk.System();
        io.mavsdk.follow_me.FollowMe fm = drone.getFollowMe();
        fm.initialize();
        fm.setConfig(null);
        fm.getConfig();
        fm.start();
        fm.getLastLocation();
        fm.stop();
        fm.dispose();
    }
}

