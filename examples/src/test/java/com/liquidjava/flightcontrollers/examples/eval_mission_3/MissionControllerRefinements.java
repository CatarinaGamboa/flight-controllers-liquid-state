package com.liquidjava.flightcontrollers.examples.eval_mission_3;

import io.mavsdk.mission.Mission.MissionPlan;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("io.mavsdk.mission.Mission")
@StateSet({"unconnected", "init", "missionUploaded", "inMission"})
public interface MissionControllerRefinements {
	
	//new
	@StateRefinement(to="unconnected(this)")
	public void Mission();
	
	
	@StateRefinement(from="unconnected(this)", to="init(this)")
	public void initialize();
	
	
	@StateRefinement(from="!unconnected(this)", to="unconnected(this)")
	public void dispose();
	
	@StateRefinement(from="missionUploaded(this) || inMission(this)", 
					 to="init(this)")
	public void clearMission();
	

	@StateRefinement(from="init(this)", to="missionUploaded(this)")
	public void uploadMission(MissionPlan missionPlan);
	
	
	@StateRefinement(from="init(this)", to="missionUploaded(this)")
	public void uploadMissionWithProgress();
	
	
	@StateRefinement(from="missionUploaded(this)", to="init(this)")
	public void cancelMissionUpload();
	
	
	@StateRefinement(from="missionUploaded(this)", to="inMission(this)")
	public void startMission();
	
	@StateRefinement(from="missionUploaded(this)")
	@StateRefinement(from="inMission(this)")
	public void downloadMission();

	
	@StateRefinement(from="inMission(this)", to="missionUploaded(this)")
	public void pauseMission();

	@StateRefinement(from="inMission(this)")
	public void getMissionProgress();

	@StateRefinement(from="inMission(this)")
	public void setCurrentMissionItem();
	
	@StateRefinement(from="inMission(this)")
	public void isMissionFinished();


}
