// extracted from online discussion board
// https://github.com/mavlink/MAVSDK-Java/issues/27
// package io.mavsdk.example;

import io.mavsdk.System;
import io.mavsdk.action.Action;
import io.mavsdk.mission.Mission;
import io.mavsdk.offboard.Offboard;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OffboardAndMission {
  private static final Logger logger = LoggerFactory.getLogger(OffboardAndMission.class);

  public static void main(String[] args) {
    logger.debug("Starting example: takeoff and land...");

    System drone = new System();
    CountDownLatch latch = new CountDownLatch(1);

    drone.getAction().arm();
    logger.debug("Arming...");
    drone.getAction().takeoff();
    logger.debug("Taking off...");

    drone.getOffboard().setPositionNed(new Offboard.PositionNEDYaw(0f,0f,0f,0f));
    drone.getOffboard().start();
    drone.getOffboard().setPositionNed(new Offboard.PositionNEDYaw(5.0f,0f,-2.0f,0f));
     
    drone.getAction().land();
    logger.debug("Landing...");
  }
}
