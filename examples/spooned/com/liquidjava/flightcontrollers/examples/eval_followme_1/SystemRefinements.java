package com.liquidjava.flightcontrollers.examples.eval_followme_1;


@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.System")
public interface SystemRefinements {
    // ??? confirm
    @liquidjava.specification.Refinement("init(_)")
    public io.mavsdk.mission.Mission getMission();

    @liquidjava.specification.Refinement("initialized(_)")
    public io.mavsdk.offboard.Offboard getOffboard();

    @liquidjava.specification.Refinement("geoInitialized(_)")
    public io.mavsdk.geofence.Geofence getGeofence();

    @liquidjava.specification.Refinement("camInitialized(_)")
    public io.mavsdk.camera.Camera getCamera();

    @liquidjava.specification.Refinement("fmInitialized(_)")
    public io.mavsdk.follow_me.FollowMe getFollowMe();

    @liquidjava.specification.Refinement("mocapInitialized(_)")
    public io.mavsdk.mocap.Mocap getMocap();

    @liquidjava.specification.Refinement("ftpInitialized(_)")
    public io.mavsdk.ftp.Ftp getFTP();
}

