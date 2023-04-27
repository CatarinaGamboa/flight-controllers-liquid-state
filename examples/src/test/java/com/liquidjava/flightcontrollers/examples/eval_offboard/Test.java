package com.liquidjava.flightcontrollers.examples.eval_offboard;


import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//extracted from online discussion board
//https://github.com/mavlink/MAVSDK-Java/issues/27
//package io.mavsdk.example;

import io.mavsdk.System;
import io.mavsdk.action.Action;
import io.mavsdk.offboard.Offboard;
import io.mavsdk.offboard.Offboard.PositionNedYaw;


public class Test {

	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		logger.debug("Starting example: takeoff and land...");

		System drone = new System();
		CountDownLatch latch = new CountDownLatch(1);

		Action a = drone.getAction();
		a.arm();
		logger.debug("Arming...");
		a.takeoff();
		logger.debug("Taking off...");

		Offboard of = drone.getOffboard();
		of.setPositionNed(new PositionNedYaw(0f,0f,0f,0f));
		of.start();
		of.setPositionNed(new PositionNedYaw(5.0f,0f,-2.0f,0f));

		a.land();
		logger.debug("Landing...");
	}
}
