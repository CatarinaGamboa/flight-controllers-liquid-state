package com.liquidjava.flightcontrollers.examples.followme1;

import io.mavsdk.camera.Camera;
import io.mavsdk.follow_me.FollowMe;
import io.mavsdk.geofence.Geofence;
import io.mavsdk.mission.Mission;
import io.mavsdk.offboard.Offboard;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;

@ExternalRefinementsFor("io.mavsdk.System")
public interface SystemRefinements {

	@Refinement("init(_)")//??? confirm
	public Mission getMission();
	
	@Refinement("uninitialized(_)")
	public Offboard getOffboard();
	
	
	@Refinement("geoUninitialized(_)")
	public Geofence getGeofence();
	
	
	@Refinement("camUninitialized(_)")
	public Camera getCamera();
	
	@Refinement("fmUninitialized(_)")
	public FollowMe getFollowMe();
}
