package com.liquidjava.flightcontrollers.examples;

import io.mavsdk.offboard.Offboard;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@StateSet({"uninitialized", "initialized","enableSetPoint","started"})
@ExternalRefinementsFor("io.mavsdk.offboard.Offboard")
public interface OffBoardRefinements {

	@StateRefinement(to="uninitialized(this)")
	public void OffBoard();
	

	@StateRefinement(from="uninitialized(this)", to="initialized(this)")
	public void initialize();
	
	@StateRefinement(from="!uninitialized(this)", to="uninitialized(this)")
	public void dispose();

	@StateRefinement(from="enableSetPoint(this)", to="started(this)")
	public io.reactivex.Completable	start();
	
	@StateRefinement(from="started(this)", to="enableSetPoint(this)")
	public io.reactivex.Completable	stop();
	
	
	@StateRefinement(from="initialized(this)", to="enableSetPoint(this)")
	public io.reactivex.Completable	setVelocityNed​ (Offboard.VelocityNedYaw velocityNedYaw);
	
	@StateRefinement(from="initialized(this)", to="enableSetPoint(this)")
	public io.reactivex.Completable	setVelocityBody​(Offboard.VelocityBodyYawspeed velocityBodyYawspeed);	 

	@StateRefinement(from="started(this)")
	public io.reactivex.Completable	setAccelerationNed​(Offboard.AccelerationNed accelerationNed);	 
	@StateRefinement(from="started(this)")
	public io.reactivex.Completable	setActuatorControl​(Offboard.ActuatorControl actuatorControl);	 
	@StateRefinement(from="started(this)")
	public io.reactivex.Completable	setAttitude​(Offboard.Attitude attitude);
	@StateRefinement(from="started(this)")
	public io.reactivex.Completable	setAttitudeRate​(Offboard.AttitudeRate attitudeRate);
	@StateRefinement(from="started(this)")
	public io.reactivex.Completable	setPositionGlobal​(Offboard.PositionGlobalYaw positionGlobalYaw);	 
	@StateRefinement(from="started(this)")
	public io.reactivex.Completable	setPositionNed​(Offboard.PositionNedYaw positionNedYaw);	 
	@StateRefinement(from="started(this)")
	public io.reactivex.Completable	setPositionVelocityNed​(Offboard.PositionNedYaw positionNedYaw, Offboard.VelocityNedYaw velocityNedYaw);	 

	
	
	
	//	io.reactivex.Single<java.lang.Boolean>	isActive()	 
//	io.reactivex.Completable	setAccelerationNed​(Offboard.AccelerationNed accelerationNed)	 
//	io.reactivex.Completable	setActuatorControl​(Offboard.ActuatorControl actuatorControl)	 
//	io.reactivex.Completable	setAttitude​(Offboard.Attitude attitude)	 
//	io.reactivex.Completable	setAttitudeRate​(Offboard.AttitudeRate attitudeRate)	 
//	io.reactivex.Completable	setPositionGlobal​(Offboard.PositionGlobalYaw positionGlobalYaw)	 
//	io.reactivex.Completable	setPositionNed​(Offboard.PositionNedYaw positionNedYaw)	 
//	io.reactivex.Completable	setPositionVelocityNed​(Offboard.PositionNedYaw positionNedYaw, Offboard.VelocityNedYaw velocityNedYaw)	 
//	io.reactivex.Completable	setVelocityBody​(Offboard.VelocityBodyYawspeed velocityBodyYawspeed)	 
//	io.reactivex.Completable	setVelocityNed​(Offboard.VelocityNedYaw velocityNedYaw)	 

	
}
