package com.liquidjava.flightcontrollers.examples.eval_mission_2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.mapbox.mapboxsdk.geometry.LatLng;

//import android.annotation.SuppressLint;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;

//refer to https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example
//package io.mavsdk.example;

import io.mavsdk.System;
import io.mavsdk.mission.Mission;
import io.mavsdk.mission.Mission.MissionPlan;




//https://github.com/jankrystianserafim/android-client/blob/d622b16126c2421dcff27e1be0d59c22deaab349/app/src/main/java/io/mavsdk/androidclient/MapsViewModel.java

/**
 * ViewModel to hold objects that should be persisted.
 */
public class AndroidMission /*extends ViewModel*/ {
	private static final Logger logger = LoggerFactory.getLogger(AndroidMission.class);

	private static final float MISSION_HEIGHT = 5.0f;
	private static final float MISSION_SPEED = 1.0f;

	
	////	final MutableLiveData<LatLng> currentPositionLiveData = new MutableLiveData<>();
	////	final MutableLiveData<List<LatLng>> currentMissionPlanLiveData = new MutableLiveData<>();
	//
	////	public MapsViewModel() {
	////		currentMissionPlanLiveData.postValue(new ArrayList<>());
	////	}
	//
	////	@Override
	////	protected void onCleared() {
	////		super.onCleared();
	////	}
	//
	
	/**
	 * Executes the current mission.
	 */
	void startMission() {
		System drone = new System();

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
		drone.getAction().arm();

		m.startMission();
		logger.debug("Mission started");

	}

}