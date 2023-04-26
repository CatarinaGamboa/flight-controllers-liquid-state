package com.liquidjava.flightcontrollers.examples.eval_offboard;


@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.System")
public interface SystemRefinements {
    // ??? confirm
    @liquidjava.specification.Refinement("init(_)")
    public io.mavsdk.mission.Mission getMission();

    @liquidjava.specification.Refinement("initialized(_)")
    public io.mavsdk.offboard.Offboard getOffboard();

    @liquidjava.specification.Refinement("geoUninitialized(_)")
    public io.mavsdk.geofence.Geofence getGeofence();

    @liquidjava.specification.Refinement("camUninitialized(_)")
    public io.mavsdk.camera.Camera getCamera();

    @liquidjava.specification.Refinement("fmUninitialized(_)")
    public io.mavsdk.follow_me.FollowMe getFollowMe();

    @liquidjava.specification.Refinement("mocapUninitialized(_)")
    public io.mavsdk.mocap.Mocap getMocap();

    @liquidjava.specification.Refinement("ftpInitialized(_)")
    public io.mavsdk.ftp.Ftp getFTP();
}

