package com.liquidjava.flightcontrollers.examples.followme2;


@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.follow_me.FollowMe")
@liquidjava.specification.StateSet({ "fmUninitialized", "fmInitialized", "fmConfigSet", "fmModeStarted" })
public interface FollowMeRefinements {
    // Questions:
    // does an object need to have both setConfig and setTargetLocation before starting? or just one of them?
    @liquidjava.specification.StateRefinement(to = "fmUninitialized(this)")
    void FollowMe();

    @liquidjava.specification.StateRefinement(from = "fmUninitialized(this)", to = "fmInitialized(this)")
    void initialize();

    @liquidjava.specification.StateRefinement(from = "!fmUninitialized(this)", to = "fmUninitialized(this)")
    void dispose();

    @liquidjava.specification.StateRefinement(from = "fmInitialized(this) || fmConfigSet(this)", to = "fmConfigSet(this)")
    io.reactivex.Completable setConfig​(io.mavsdk.follow_me.FollowMe.Config config);

    @liquidjava.specification.StateRefinement(from = "fmInitialized(this) || fmConfigSet(this)", to = "fmConfigSet(this)")
    io.reactivex.Completable setTargetLocation​(io.mavsdk.follow_me.FollowMe.TargetLocation location);

    @liquidjava.specification.StateRefinement(from = "fmConfigSet(this)")
    io.reactivex.Single<io.mavsdk.follow_me.FollowMe.Config> getConfig();

    @liquidjava.specification.StateRefinement(from = "fmConfigSet(this)", to = "fmModeStarted(this)")
    io.reactivex.Completable start();

    @liquidjava.specification.StateRefinement(from = "fmModeStarted(this)", to = "fmConfigSet(this)")
    io.reactivex.Completable stop();

    @liquidjava.specification.StateRefinement(from = "fmModeStarted(this)")
    io.reactivex.Single<io.mavsdk.follow_me.FollowMe.TargetLocation> getLastLocation();
}

