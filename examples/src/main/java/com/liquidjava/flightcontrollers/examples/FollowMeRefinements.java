package com.liquidjava.flightcontrollers.examples;

import io.mavsdk.follow_me.FollowMe;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("io.mavsdk.follow_me.FollowMe")
@StateSet({"fmUninitialized", "fmInitialized", "fmConfigSet", "fmTargetSet", "fmConfigTargetSet", "fmModeStarted"})
public interface FollowMeRefinements {

	
	@StateRefinement(to="fmUninitialized(this)")
	void 	FollowMe();	
	
	@StateRefinement(from="fmUninitialized(this)", to="fmInitialized(this)")
	void	initialize();	
	
	@StateRefinement(from="!fmUninitialized(this)", to="fmUninitialized(this)")
	void	dispose();
	

	@StateRefinement(from="fmInitialized(this)", to="fmConfigSet(this)")
	@StateRefinement(from="fmConfigSet(this)", to="fmConfigSet(this)")
	@StateRefinement(from="fmTargetSet(this)", to="fmConfigTargetSet(this)")
	@StateRefinement(from="fmConfigTargetSet(this)", to="fmConfigTargetSet(this)")
	io.reactivex.Completable setConfig​(FollowMe.Config config);
	
	
	@StateRefinement(from="fmInitialized(this)", to="fmTargetSet(this)")
	@StateRefinement(from="fmTargetSet(this)", to="fmTargetSet(this)")
	@StateRefinement(from="fmConfigSet(this)", to="fmConfigTargetSet(this)")
	@StateRefinement(from="fmConfigTargetSet(this)", to="fmConfigTargetSet(this)")
	io.reactivex.Completable setTargetLocation​(FollowMe.TargetLocation location);
	
	@StateRefinement(from="fmConfigSet(this)", to="fmConfigSet(this)")
	@StateRefinement(from="fmConfigTargetSet(this)", to="fmConfigTargetSet(this)")
	io.reactivex.Single<FollowMe.Config> getConfig();
	
	@StateRefinement(from="fmConfigTargetSet(this)", to="fmModeStarted(this)")
	io.reactivex.Completable start();	 
	
	@StateRefinement(from="fmModeStarted(this)", to="fmConfigTargetSet(this)")
	io.reactivex.Completable stop();
	
	@StateRefinement(from="fmModeStarted(this)")
	io.reactivex.Single<FollowMe.TargetLocation>	getLastLocation();

}
