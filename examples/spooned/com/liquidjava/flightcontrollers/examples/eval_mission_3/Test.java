/**
 * https://github.com/KINGPEYTON/mavlink-test/blob/b8b9704d12cc162a5591f8b70ca5395c6824586b/app/src/main/java/io/mavsdk/androidclient/MapsViewModel.java
 */
/**
 * package io.mavsdk.androidclient;
 */
/**
 * import androidx.lifecycle.MutableLiveData;
 */
/**
 * import androidx.lifecycle.ViewModel;
 */
/**
 * import com.mapbox.mapboxsdk.geometry.LatLng;
 */
package com.liquidjava.flightcontrollers.examples.eval_mission_3;


/**
 * ViewModel to hold objects that should be persisted.
 */
/**
 * Adds a waypoint to the current mission.
 *
 * @param latLng
 * 		waypoint to add
 */
// void addWaypoint(LatLng latLng) {
// List<LatLng> currentMissionItems = currentMissionPlanLiveData.getValue();
// currentMissionItems.add(latLng);
// currentMissionPlanLiveData.postValue(currentMissionItems);
// }
public class Test {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.liquidjava.flightcontrollers.examples.eval_mission_3.Test.class);

    private static final float MISSION_HEIGHT = 5.0F;

    private static final float MISSION_SPEED = 1.0F;

    // final MutableLiveData<LatLng> currentPositionLiveData = new MutableLiveData<>();
    // final MutableLiveData<List<LatLng>> currentMissionPlanLiveData = new MutableLiveData<>();
    // 
    // public MapsViewModel() {
    // currentMissionPlanLiveData.postValue(new ArrayList<>());
    // }
    // 
    // @Override
    // protected void onCleared() {
    // super.onCleared();
    // }
    /**
     * Executes the current mission.
     */
    @android.annotation.SuppressLint("CheckResult")
    void startMission(io.mavsdk.System drone) {
        // List<LatLng> latLngs = currentMissionPlanLiveData.getValue();
        // if (latLngs != null) {
        java.util.List<io.mavsdk.mission.Mission.MissionItem> missionItems = new java.util.ArrayList<>();
        io.mavsdk.mission.Mission.MissionItem missionItem = new io.mavsdk.mission.Mission.MissionItem(0.0, 0.0, com.liquidjava.flightcontrollers.examples.eval_mission_3.Test.MISSION_HEIGHT, com.liquidjava.flightcontrollers.examples.eval_mission_3.Test.MISSION_SPEED, true, java.lang.Float.NaN, java.lang.Float.NaN, io.mavsdk.mission.Mission.MissionItem.CameraAction.NONE, java.lang.Float.NaN, 1.0, java.lang.Float.NaN, java.lang.Float.NaN, java.lang.Float.NaN);
        missionItems.add(missionItem);
        io.mavsdk.mission.Mission.MissionPlan missionPlan = new io.mavsdk.mission.Mission.MissionPlan(missionItems);
        com.liquidjava.flightcontrollers.examples.eval_mission_3.Test.logger.debug("Uploading and starting mission...");
        io.mavsdk.mission.Mission m = drone.getMission();
        m.setReturnToLaunchAfterMission(true);
        m.uploadMission(missionPlan);
        com.liquidjava.flightcontrollers.examples.eval_mission_3.Test.logger.debug("Upload succeeded");
        drone.getAction().arm();
        m.startMission();
        com.liquidjava.flightcontrollers.examples.eval_mission_3.Test.logger.debug("Mission started");
    }
}

