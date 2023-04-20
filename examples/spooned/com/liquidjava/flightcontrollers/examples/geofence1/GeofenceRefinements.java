package com.liquidjava.flightcontrollers.examples.geofence1;


@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.geofence.Geofence")
@liquidjava.specification.StateSet({ "geoUninitialized", "geoInitialized", "geoInPlace" })
public interface GeofenceRefinements {
    @liquidjava.specification.StateRefinement(to = "geoUninitialized(this)")
    void Geofence();

    @liquidjava.specification.StateRefinement(from = "geoUninitialized(this)", to = "geoInitialized(this)")
    void initialize();

    @liquidjava.specification.StateRefinement(from = "!geoUninitialized(this)", to = "geoUninitialized(this)")
    void dispose();

    @liquidjava.specification.StateRefinement(from = "geoInitialized(this)", to = "geoInPlace(this)")
    io.reactivex.Completable uploadGeofence​(java.util.List<io.mavsdk.geofence.Geofence.Polygon> polygons);

    @liquidjava.specification.StateRefinement(from = "geoInPlace(this)", to = "geoInitialized(this)")
    io.reactivex.Completable clearGeofence();
}

