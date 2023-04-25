package com.liquidjava.flightcontrollers.examples.mocap1;

import io.mavsdk.mocap.Mocap;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("io.mavsdk.mocap.Mocap")
@StateSet({"mocapUninitialized", "mocapInitialized"})
public interface MocapRefinements {

	
	@StateRefinement(to="mocapUninitialized(this)")
	void Mocap();	
	
	@StateRefinement(from="!mocapUninitialized(this)", to="mocapUninitialized(this)")
	void	dispose();	
	
	@StateRefinement(from="mocapUninitialized(this)", to="mocapInitialized(this)")
	void	initialize();	
	
	@StateRefinement(from="mocapInitialized(this)")
	io.reactivex.Completable	setAttitudePositionMocap​(Mocap.AttitudePositionMocap attitudePositionMocap);
	
	@StateRefinement(from="mocapInitialized(this)")
	io.reactivex.Completable	setOdometry​(Mocap.Odometry odometry); 
	
	@StateRefinement(from="mocapInitialized(this)")
	io.reactivex.Completable	setVisionPositionEstimate​(Mocap.VisionPositionEstimate visionPositionEstimate);

}
