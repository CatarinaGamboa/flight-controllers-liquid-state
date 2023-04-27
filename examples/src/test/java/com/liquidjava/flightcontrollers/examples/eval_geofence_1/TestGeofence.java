package com.liquidjava.flightcontrollers.examples.eval_geofence_1;

//https://github.com/mavlink/MAVSDK/blob/main/examples/geofence/geofence.cpp

import java.util.ArrayList;
import java.util.List;

import io.mavsdk.geofence.Geofence;
import io.mavsdk.geofence.Geofence.Point;
import io.mavsdk.geofence.Geofence.Polygon;
import io.mavsdk.geofence.Geofence.Polygon.FenceType;
import io.mavsdk.telemetry.Telemetry;
import io.reactivex.Completable;


public class TestGeofence {


	public static void usage(String binName) {
		String c = "Usage : ".concat(binName).concat(" connection url");
		System.err.println(c);

	}

	public static void main(String[] args) throws InterruptedException {

		if (args.length != 2) {
			usage(args[0]);
		}

		//connection
		io.mavsdk.System drone = new io.mavsdk.System();
		Telemetry telemetry = drone.getTelemetry();
		Geofence geofence = drone.getGeofence();


		while (!telemetry.getHealthAllOk().blockingSingle()) {
			System.err.println("Waiting for system to be ready");
			Thread.sleep(1000);
		}

		System.out.println("System Ready");
		System.out.println("Creating and uploading geofences");

		List<Polygon> polygons = new ArrayList<>();
		
		//reusable variables
		List<Point> points;
		Polygon p;

	    // Polygon inclusion
		points = new ArrayList<>();
		points.add(addPoint(47.40029181357694, 8.540208324993841));
		points.add(addPoint(47.400173434578114, 8.547689686153717));
		points.add(addPoint(47.39677781722575, 8.547444838745832));
		points.add(addPoint(47.39709351430107, 8.539753608416305));
		p = new Polygon(points, FenceType.INCLUSION);
		polygons.add(p);
		
	    // Polygon exclusion
		points = new ArrayList<>();
		points.add(addPoint(47.39845295869903, 8.543682820794851));
		points.add(addPoint(47.39837403681116, 8.545066315854541));
		points.add(addPoint(47.39759073790796, 8.544926413920791));
		points.add(addPoint(47.39762230688655, 8.543531259263398));
       
		p = new Polygon(points, FenceType.EXCLUSION);
		polygons.add(p);
		
	
		Completable result = geofence.uploadGeofence(polygons);
		if(result.blockingGet() != null) {
			System.err.println("Geodence upload failed".concat(result.toString()));
			return;
		}
		
		System.out.println("Geofence uploaded");
	}



	public static Point addPoint(double latitude_deg, double longitude_deg) {
		return new Point(latitude_deg, longitude_deg);
	}

}
