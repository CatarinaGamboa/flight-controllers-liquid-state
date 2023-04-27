package com.liquidjava.flightcontrollers.examples.eval_mission_3;

//https://github.com/KINGPEYTON/mavlink-test/blob/b8b9704d12cc162a5591f8b70ca5395c6824586b/app/src/main/java/io/mavsdk/androidclient/MapsViewModel.java
//package io.mavsdk.androidclient;

import android.annotation.SuppressLint;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//import com.mapbox.mapboxsdk.geometry.LatLng;
import io.mavsdk.System;
import io.mavsdk.mission.Mission;
import io.mavsdk.mission.Mission.MissionPlan;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * ViewModel to hold objects that should be persisted.
 */

public class Test {

	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	private static final float MISSION_HEIGHT = 5.0f;
	private static final float MISSION_SPEED = 1.0f;

	//final MutableLiveData<LatLng> currentPositionLiveData = new MutableLiveData<>();
	//final MutableLiveData<List<LatLng>> currentMissionPlanLiveData = new MutableLiveData<>();
	//
	//public MapsViewModel() {
	// currentMissionPlanLiveData.postValue(new ArrayList<>());
	//}
	//
	//@Override
	//protected void onCleared() {
	// super.onCleared();
	//}

	/**
	 * Executes the current mission.
	 */
	@SuppressLint("CheckResult")
	void startMission(System drone) {
		// List<LatLng> latLngs = currentMissionPlanLiveData.getValue();
		// if (latLngs != null) {
		List<Mission.MissionItem> missionItems = new ArrayList<>();
		Mission.MissionItem missionItem = new Mission.MissionItem(
				0.0,
				0.0,
				MISSION_HEIGHT,
				MISSION_SPEED,
				true,
				Float.NaN,
				Float.NaN,
				Mission.MissionItem.CameraAction.NONE,
				Float.NaN,
				1.0,
				Float.NaN,
				Float.NaN,
				Float.NaN);
		missionItems.add(missionItem);


		MissionPlan missionPlan = new MissionPlan(missionItems);

		logger.debug("Uploading and starting mission...");
		Mission m = drone.getMission();
		m.setReturnToLaunchAfterMission(true);
		m.uploadMission(missionPlan);
		logger.debug("Upload succeeded");
		drone.getAction().arm();
		m.startMission();
		logger.debug("Mission started");
	}


	/**
	 * Adds a waypoint to the current mission.
	 *
	 * @param latLng waypoint to add
	 */
	//void addWaypoint(LatLng latLng) {
	// List<LatLng> currentMissionItems = currentMissionPlanLiveData.getValue();
	// currentMissionItems.add(latLng);
	// currentMissionPlanLiveData.postValue(currentMissionItems);
	//}
}