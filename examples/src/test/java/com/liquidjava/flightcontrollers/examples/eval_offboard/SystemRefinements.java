package com.liquidjava.flightcontrollers.examples.eval_offboard;

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
	
	
	@Refinement("geoUninitialized(_)")
	public Geofence getGeofence();
	
	
	@Refinement("camUninitialized(_)")
	public Camera getCamera();
	
	@Refinement("fmUninitialized(_)")
	public FollowMe getFollowMe();
	
	
	@Refinement("mocapUninitialized(_)")
	public Mocap getMocap();
	
	
	@Refinement("ftpInitialized(_)")
	public Ftp getFTP();
	
}
