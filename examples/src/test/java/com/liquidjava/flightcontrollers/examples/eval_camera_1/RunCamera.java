package com.liquidjava.flightcontrollers.examples.eval_camera_1;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.mavsdk.System;
import io.mavsdk.camera.Camera;

//refer to https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example

public class RunCamera {
	private static final Logger logger = LoggerFactory.getLogger(RunCamera.class);

	public static void main(String[] args) {
		logger.debug("Starting example: camera...");

		System drone = new System();
		CountDownLatch latch = new CountDownLatch(1);
		Camera camera = drone.getCamera();
		//camera.setMode(Camera.Mode.PHOTO);//not in retrieved code
		camera.getCaptureInfo()
			  .subscribe( (captureInfo) ->  logger.debug(captureInfo.getFileUrl()));
		camera.takePhoto();
		logger.debug("Taking a photo...");
		camera.takePhoto();
	}
}