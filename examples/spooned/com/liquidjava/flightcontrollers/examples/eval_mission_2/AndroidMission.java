/**
 * import com.mapbox.mapboxsdk.geometry.LatLng;
 */
/**
 *
 */
/**
 * //https://github.com/jankrystianserafim/android-client/blob/d622b16126c2421dcff27e1be0d59c22deaab349/app/src/main/java/io/mavsdk/androidclient/MapsViewModel.java
 */
/**
 *
 */
/**
 * import android.annotation.SuppressLint;
 */
/**
 * import androidx.lifecycle.MutableLiveData;
 */
/**
 * import androidx.lifecycle.ViewModel;
 */
/**
 * refer to https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example
 */
/**
 * package io.mavsdk.example;
 */
package com.liquidjava.flightcontrollers.examples.eval_mission_2;


/**
 * ViewModel to hold objects that should be persisted.
 */
/* extends ViewModel */
public class AndroidMission {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.liquidjava.flightcontrollers.examples.eval_mission_2.AndroidMission.class);

    private static final float MISSION_HEIGHT = 5.0F;

    private static final float MISSION_SPEED = 1.0F;

    // //	final MutableLiveData<LatLng> currentPositionLiveData = new MutableLiveData<>();
    // //	final MutableLiveData<List<LatLng>> currentMissionPlanLiveData = new MutableLiveData<>();
    // 
    // //	public MapsViewModel() {
    // //		currentMissionPlanLiveData.postValue(new ArrayList<>());
    // //	}
    // 
    // //	@Override
    // //	protected void onCleared() {
    // //		super.onCleared();
    // //	}
    // 
    /**
     * Executes the current mission.
     */
    void startMission() {
        io.mavsdk.System drone = new io.mavsdk.System();
        java.util.List<io.mavsdk.mission.Mission.MissionItem> missionItems = new java.util.ArrayList<>();
        io.mavsdk.mission.Mission.MissionItem missionItem = new io.mavsdk.mission.Mission.MissionItem(0.0, 0.0, com.liquidjava.flightcontrollers.examples.eval_mission_2.AndroidMission.MISSION_HEIGHT, com.liquidjava.flightcontrollers.examples.eval_mission_2.AndroidMission.MISSION_SPEED, true, java.lang.Float.NaN, java.lang.Float.NaN, io.mavsdk.mission.Mission.MissionItem.CameraAction.NONE, java.lang.Float.NaN, 1.0, null, null, null);
        missionItems.add(missionItem);
        io.mavsdk.mission.Mission.MissionPlan missionPlan = new io.mavsdk.mission.Mission.MissionPlan(missionItems);
        com.liquidjava.flightcontrollers.examples.eval_mission_2.AndroidMission.logger.debug("Uploading and starting mission...");
        io.mavsdk.mission.Mission m = drone.getMission();
        m.setReturnToLaunchAfterMission(true);
        m.uploadMission(missionPlan);
        drone.getAction().arm();
        m.startMission();
        com.liquidjava.flightcontrollers.examples.eval_mission_2.AndroidMission.logger.debug("Mission started");
    }
}

