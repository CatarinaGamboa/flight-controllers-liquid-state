/**
 * refer to https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example
 */
/**
 * package io.mavsdk.example;
 */
package com.liquidjava.flightcontrollers.examples.example3;


public class ListPhotos {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.liquidjava.flightcontrollers.examples.example3.ListPhotos.class);

    public static void main(java.lang.String[] args) {
        com.liquidjava.flightcontrollers.examples.example3.ListPhotos.logger.debug("Starting example: taking and listing photos...");
        io.mavsdk.System drone = new io.mavsdk.System();
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
        // Completable trying to take 50 pictures (stopping in case of error)
        io.mavsdk.camera.Camera c = drone.getCamera();
        // c.setMode(); //missing
        c.takePhoto();
        c.listPhotos(io.mavsdk.camera.Camera.PhotosRange.ALL);
    }
}

