package com.liquidjava.flightcontrollers.examples;

import io.mavsdk.geofence.Geofence;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("io.mavsdk.geofence.Geofence")
@StateSet({"geoUninitialized", "geoInitialized", "geoInPlace"})
public interface GeofenceRefinements {

	@StateRefinement(to="geoUninitialized(this)")
	void Geofence();	
	
	@StateRefinement(from="geoUninitialized(this)", to="geoInitialized(this)")
	void	initialize();	
	
	@StateRefinement(from="!geoUninitialized(this)", to="geoUninitialized(this)")
	void	dispose();
	

	@StateRefinement(from="geoInitialized(this)", to="geoInPlace(this)")	
	io.reactivex.Completable	uploadGeofence​(java.util.List<Geofence.Polygon> polygons);

	
	@StateRefinement(from="geoInPlace(this)", to="geoInitialized(this)")
	io.reactivex.Completable	clearGeofence();	 

}
