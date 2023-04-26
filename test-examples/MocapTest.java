// https://discuss.px4.io/t/mavsdk-python-set-px4-local-position-with-mocap-commands/16792/2
import io.mavsdk.mocap.Mocap;
import io.mavsdk.mocap.Mocap.Quaternion;
import io.mavsdk.mocap.Mocap.AttitudePositionMocap;
import io.mavsdk.mocap.Mocap.Covariance;

public class MocapTest {
  public static void main(String[] args) {
    Mocap mocap = new Mocap();
    mocap.initialize();
    
    Quaternion q = new Quaternion(0, 0, 0, 0);
    PositionBody position_body = new PositionBody(0, 0, 0);

    AttitudePositionMocap message = new AttitudePositionMocap(0.0, q, position_body, new Covariance(null));
    mocap.setAttitudePositionMocap(0.0, q, position_body, new Covariance(null));
    mocap.set_vision_position_estimate(message);
  }
}
