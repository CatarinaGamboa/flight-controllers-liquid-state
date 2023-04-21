package com.liquidjava.flightcontrollers.examples.followme1;

import io.mavsdk.follow_me.FollowMe;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("io.mavsdk.follow_me.FollowMe")
@StateSet({"fmUninitialized", "fmInitialized", "fmConfigSet", "fmModeStarted"})
public interface FollowMeRefinements {

	//Questions:
	//does an object need to have both setConfig and setTargetLocation before starting? or just one of them?
	
	@StateRefinement(to="fmUninitialized(this)")
	void 	FollowMe();	
	
	@StateRefinement(from="fmUninitialized(this)", to="fmInitialized(this)")
	void	initialize();	
	
	@StateRefinement(from="!fmUninitialized(this)", to="fmUninitialized(this)")
	void	dispose();
	

	@StateRefinement(from="fmInitialized(this) || fmConfigSet(this)", to="fmConfigSet(this)")
	io.reactivex.Completable setConfig​(FollowMe.Config config);
	
	@StateRefinement(from="fmInitialized(this) || fmConfigSet(this)", to="fmConfigSet(this)")
	io.reactivex.Completable setTargetLocation​(FollowMe.TargetLocation location);
	
	@StateRefinement(from="fmConfigSet(this)")
	io.reactivex.Single<FollowMe.Config> getConfig();
	
	@StateRefinement(from="fmConfigSet(this)", to="fmModeStarted(this)")
	io.reactivex.Completable start();	 
	
	@StateRefinement(from="fmModeStarted(this)", to="fmConfigSet(this)")
	io.reactivex.Completable stop();
	
	@StateRefinement(from="fmModeStarted(this)")
	io.reactivex.Single<FollowMe.TargetLocation>	getLastLocation();
	

}
