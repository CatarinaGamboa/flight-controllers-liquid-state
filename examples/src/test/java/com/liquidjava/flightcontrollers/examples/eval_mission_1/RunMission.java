package com.liquidjava.flightcontrollers.examples.eval_mission_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//refer to https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example
//package io.mavsdk.example;

import io.mavsdk.System;
import io.mavsdk.mission.Mission;
import io.mavsdk.telemetry.Telemetry;
import io.mavsdk.telemetry.Telemetry.FlightMode;
import io.reactivex.Flowable;

public class RunMission {
	private static final Logger logger = LoggerFactory.getLogger(RunMission.class);

	public static void main(String[] args) {
		logger.debug("Starting example: mission...");

		System drone = new System();

		Flowable<FlightMode> flightmode = drone.getTelemetry().getFlightMode();
		logger.debug("flight mode: " + flightmode);

		List<Mission.MissionItem> cycle = new ArrayList<>();
		cycle.add(generateMissionItem(47.398039859999997, 8.5455725400000002));
		cycle.add(generateMissionItem(47.398036222362471, 8.5450146439425509));
		cycle.add(generateMissionItem(47.397825620791885, 8.5450092830163271));
		cycle.add(generateMissionItem(47.397832880000003, 8.5455939999999995));

		List<Mission.MissionItem> missionItems = new ArrayList<>();
		for (int i = 0; i < 300; i++) {
			missionItems.addAll(cycle);
		}

		Mission.MissionPlan missionPlan = new Mission.MissionPlan(missionItems);
//		logger.debug("About to upload " + missionItems.size() + " mission items");

		CountDownLatch latch = new CountDownLatch(1);
		Mission mission = drone.getMission();
		mission.setReturnToLaunchAfterMission(true);
		mission.uploadMission(missionPlan);
		logger.debug("Upload succeeded");
		mission.downloadMission();
		logger.debug("Downloading mission");
		logger.debug("Mission downloaded");

	}

	public static Mission.MissionItem generateMissionItem(double latitudeDeg, double longitudeDeg) {
		return new Mission.MissionItem(
				latitudeDeg,
				longitudeDeg,
				10f,
				10f,
				true,
				Float.NaN,
				Float.NaN,
				Mission.MissionItem.CameraAction.NONE,
				Float.NaN,
				Double.NaN,
				Float.NaN,
				Float.NaN,
				Float.NaN);
	}
}
