package com.liquidjava.flightcontrollers.examples.mocap1;


@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.mocap.Mocap")
@liquidjava.specification.StateSet({ "mocapUninitialized", "mocapInitialized" })
public interface MocapRefinements {
    @liquidjava.specification.StateRefinement(to = "mocapUninitialized(this)")
    void Mocap();

    @liquidjava.specification.StateRefinement(from = "!mocapUninitialized(this)", to = "mocapUninitialized(this)")
    void dispose();

    @liquidjava.specification.StateRefinement(from = "mocapUninitialized(this)", to = "mocapInitialized(this)")
    void initialize();

    @liquidjava.specification.StateRefinement(from = "mocapInitialized(this)")
    io.reactivex.Completable setAttitudePositionMocap​(io.mavsdk.mocap.Mocap.AttitudePositionMocap attitudePositionMocap);

    @liquidjava.specification.StateRefinement(from = "mocapInitialized(this)")
    io.reactivex.Completable setOdometry​(io.mavsdk.mocap.Mocap.Odometry odometry);

    @liquidjava.specification.StateRefinement(from = "mocapInitialized(this)")
    io.reactivex.Completable setVisionPositionEstimate​(io.mavsdk.mocap.Mocap.VisionPositionEstimate visionPositionEstimate);
}

