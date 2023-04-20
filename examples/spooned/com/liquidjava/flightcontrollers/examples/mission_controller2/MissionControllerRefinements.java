package com.liquidjava.flightcontrollers.examples.mission_controller2;


@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.mission.Mission")
@liquidjava.specification.StateSet({ "unconnected", "init", "missionUploaded", "inMission" })
public interface MissionControllerRefinements {
    // new
    @liquidjava.specification.StateRefinement(to = "unconnected(this)")
    public void Mission();

    @liquidjava.specification.StateRefinement(from = "unconnected(this)", to = "init(this)")
    public void initialize();

    @liquidjava.specification.StateRefinement(from = "!unconnected(this)", to = "unconnected(this)")
    public void dispose();

    @liquidjava.specification.StateRefinement(from = "missionUploaded(this) || inMission(this)", to = "init(this)")
    public void clearMission();

    @liquidjava.specification.StateRefinement(from = "init(this)", to = "missionUploaded(this)")
    public void uploadMission(io.mavsdk.mission.Mission.MissionPlan missionPlan);

    @liquidjava.specification.StateRefinement(from = "init(this)", to = "missionUploaded(this)")
    public void uploadMissionWithProgress();

    @liquidjava.specification.StateRefinement(from = "missionUploaded(this)", to = "init(this)")
    public void cancelMissionUpload();

    @liquidjava.specification.StateRefinement(from = "missionUploaded(this)", to = "inMission(this)")
    public void startMission();

    @liquidjava.specification.StateRefinement(from = "missionUploaded(this)")
    @liquidjava.specification.StateRefinement(from = "inMission(this)")
    public void downloadMission();

    @liquidjava.specification.StateRefinement(from = "inMission(this)", to = "missionUploaded(this)")
    public void pauseMission();

    @liquidjava.specification.StateRefinement(from = "inMission(this)")
    public void getMissionProgress();

    @liquidjava.specification.StateRefinement(from = "inMission(this)")
    public void setCurrentMissionItem();

    @liquidjava.specification.StateRefinement(from = "inMission(this)")
    public void isMissionFinished();
}

