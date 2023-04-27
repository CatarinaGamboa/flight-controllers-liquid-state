import io.mavsdk.geofence.Geofence;
import io.mavsdk.geofence.GeofencePolygon;
import io.mavsdk.geofence.Geofence.Polygon.FenceType;
public class GeoFenceTest {
  public static void main(String[] args) {
    Geofence geofence = new Geofence();
    geofence.initialize();

    GeofencePolygon pol
        = new GeofencePolygon(new double[] {47.39776569, 8.54553292, 0.0, 0.0, 0.0, 0.0}, FenceType.INCLUSION);

    geofence.uploadGeofence(pol);
  }
}
