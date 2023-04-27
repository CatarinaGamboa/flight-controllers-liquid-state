package com.liquidjava.flightcontrollers.examples.eval_camera_2;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//refer to https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example
//package io.mavsdk.example;

import io.mavsdk.System;
import io.mavsdk.camera.Camera;

public class ListPhotos {
	private static final Logger logger = LoggerFactory.getLogger(ListPhotos.class);

	public static void main(String[] args) {
		logger.debug("Starting example: taking and listing photos...");

		System drone = new System();
		CountDownLatch latch = new CountDownLatch(1);

		// Completable trying to take 50 pictures (stopping in case of error)
		Camera c = drone.getCamera();
		//c.setMode(); //missing
		c.takePhoto();
		c.listPhotos(Camera.PhotosRange.ALL);
	}
}