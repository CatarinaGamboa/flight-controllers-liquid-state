// https://github.com/mavlink/MAVSDK/blob/main/examples/follow_me/follow_me.cpp
// https://github.com/mavlink/MAVSDK/blob/main/examples/follow_me/follow_me.cpp
// https://raw.githubusercontent.com/mavlink/MAVSDK/main/examples/follow_me/follow_me.cpp
import io.mavsdk.follow_me.FollowMe.TargetLocation;
import io.mavsdk.follow_me.FollowMe.Config.FollowDirection;
import io.mavsdk.follow_me.FollowMe;
import io.mavsdk.follow_me.FollowMe.Config;

public class FollowMeTest {
  public static void main(String[] args) {
    FollowMe followMe = new FollowMe();
    followMe.initialize();
    followMe.getLastLocation();

    Config config = new Config(10.0, 10.0, FollowDirection.NONE, 0.1);
    followMe.setConfig(config);

    followMe.start();
    followMe.setTargetLocation(TargetLocation(47.39776569, 8.54553292, 0.0, 0.0, 0.0, 0.0)); // placeholder
    followMe.stop();
  
  }
}
