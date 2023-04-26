/**
 * extracted from online discussion board
 */
/**
 * https://github.com/mavlink/MAVSDK-Java/issues/27
 */
/**
 * package io.mavsdk.example;
 */
package com.liquidjava.flightcontrollers.examples.eval_offboard;


public class Test {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.liquidjava.flightcontrollers.examples.eval_offboard.Test.class);

    public static void main(java.lang.String[] args) {
        com.liquidjava.flightcontrollers.examples.eval_offboard.Test.logger.debug("Starting example: takeoff and land...");
        io.mavsdk.System drone = new io.mavsdk.System();
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
        io.mavsdk.action.Action a = drone.getAction();
        a.arm();
        com.liquidjava.flightcontrollers.examples.eval_offboard.Test.logger.debug("Arming...");
        a.takeoff();
        com.liquidjava.flightcontrollers.examples.eval_offboard.Test.logger.debug("Taking off...");
        io.mavsdk.offboard.Offboard of = drone.getOffboard();
        of.setPositionNed(new io.mavsdk.offboard.Offboard.PositionNedYaw(0.0F, 0.0F, 0.0F, 0.0F));
        of.start();
        of.setPositionNed(new io.mavsdk.offboard.Offboard.PositionNedYaw(5.0F, 0.0F, (-2.0F), 0.0F));
        a.land();
        com.liquidjava.flightcontrollers.examples.eval_offboard.Test.logger.debug("Landing...");
    }
}

