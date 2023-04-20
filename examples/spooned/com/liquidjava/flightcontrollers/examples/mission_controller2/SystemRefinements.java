package com.liquidjava.flightcontrollers.examples.mission_controller2;


@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.System")
public interface SystemRefinements {
    // ??? confirm
    @liquidjava.specification.Refinement("init(_)")
    public io.mavsdk.mission.Mission getMission();

    @liquidjava.specification.Refinement("uninitialized(_)")
    public io.mavsdk.offboard.Offboard getOffboard();

    @liquidjava.specification.Refinement("geoUninitialized(_)")
    public io.mavsdk.geofence.Geofence getGeofence();
}

