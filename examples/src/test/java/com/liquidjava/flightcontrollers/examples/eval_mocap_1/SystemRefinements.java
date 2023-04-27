package com.liquidjava.flightcontrollers.examples.eval_mocap_1;

import io.mavsdk.camera.Camera;
import io.mavsdk.follow_me.FollowMe;
import io.mavsdk.ftp.Ftp;
import io.mavsdk.geofence.Geofence;
import io.mavsdk.mission.Mission;
import io.mavsdk.mocap.Mocap;
import io.mavsdk.offboard.Offboard;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;

@ExternalRefinementsFor("io.mavsdk.System")
public interface SystemRefinements {

	@Refinement("init(_)")//??? confirm
	public Mission getMission();
	
	@Refinement("initialized(_)")
	public Offboard getOffboard();
	
	
	@Refinement("geoInitialized(_)")
	public Geofence getGeofence();
	
	
	@Refinement("camInitialized(_)")
	public Camera getCamera();
	
	@Refinement("fmInitialized(_)")
	public FollowMe getFollowMe();
	
	
	@Refinement("mocapInitialized(_)")
	public Mocap getMocap();
	
	
	@Refinement("ftpInitialized(_)")
	public Ftp getFTP();
	
}
