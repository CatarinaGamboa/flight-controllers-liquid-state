package com.liquidjava.flightcontrollers.examples.followme1;


@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.follow_me.FollowMe")
@liquidjava.specification.StateSet({ "fmUninitialized", "fmInitialized", "fmConfigSet", "fmTargetSet", "fmConfigTargetSet", "fmModeStarted" })
public interface FollowMeRefinements {
    @liquidjava.specification.StateRefinement(to = "fmUninitialized(this)")
    void FollowMe();

    @liquidjava.specification.StateRefinement(from = "fmUninitialized(this)", to = "fmInitialized(this)")
    void initialize();

    @liquidjava.specification.StateRefinement(from = "!fmUninitialized(this)", to = "fmUninitialized(this)")
    void dispose();

    @liquidjava.specification.StateRefinement(from = "fmInitialized(this)", to = "fmConfigSet(this)")
    @liquidjava.specification.StateRefinement(from = "fmConfigSet(this)", to = "fmConfigSet(this)")
    @liquidjava.specification.StateRefinement(from = "fmTargetSet(this)", to = "fmConfigTargetSet(this)")
    @liquidjava.specification.StateRefinement(from = "fmConfigTargetSet(this)", to = "fmConfigTargetSet(this)")
    io.reactivex.Completable setConfig​(io.mavsdk.follow_me.FollowMe.Config config);

    @liquidjava.specification.StateRefinement(from = "fmInitialized(this)", to = "fmTargetSet(this)")
    @liquidjava.specification.StateRefinement(from = "fmTargetSet(this)", to = "fmTargetSet(this)")
    @liquidjava.specification.StateRefinement(from = "fmConfigSet(this)", to = "fmConfigTargetSet(this)")
    @liquidjava.specification.StateRefinement(from = "fmConfigTargetSet(this)", to = "fmConfigTargetSet(this)")
    io.reactivex.Completable setTargetLocation​(io.mavsdk.follow_me.FollowMe.TargetLocation location);

    @liquidjava.specification.StateRefinement(from = "fmConfigSet(this)", to = "fmConfigSet(this)")
    @liquidjava.specification.StateRefinement(from = "fmConfigTargetSet(this)", to = "fmConfigTargetSet(this)")
    io.reactivex.Single<io.mavsdk.follow_me.FollowMe.Config> getConfig();

    @liquidjava.specification.StateRefinement(from = "fmConfigTargetSet(this)", to = "fmModeStarted(this)")
    io.reactivex.Completable start();

    @liquidjava.specification.StateRefinement(from = "fmModeStarted(this)", to = "fmConfigTargetSet(this)")
    io.reactivex.Completable stop();

    @liquidjava.specification.StateRefinement(from = "fmModeStarted(this)")
    io.reactivex.Single<io.mavsdk.follow_me.FollowMe.TargetLocation> getLastLocation();
}

