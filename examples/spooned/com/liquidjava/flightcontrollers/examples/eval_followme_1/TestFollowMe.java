/**
 * https://github.com/mavlink/MAVSDK/blob/main/examples/follow_me/follow_me.cpp
 */
/**
 * https://github.com/mavlink/MAVSDK/blob/main/examples/follow_me/follow_me.cpp
 */
/**
 * https://raw.githubusercontent.com/mavlink/MAVSDK/main/examples/follow_me/follow_me.cpp
 */
package com.liquidjava.flightcontrollers.examples.eval_followme_1;


public class TestFollowMe {
    public static void main(java.lang.String[] args) {
        io.mavsdk.follow_me.FollowMe followMe = new io.mavsdk.follow_me.FollowMe();
        followMe.initialize();
        followMe.getLastLocation();// Error should be in state fmModeStarted

        io.mavsdk.follow_me.FollowMe.Config config = new io.mavsdk.follow_me.FollowMe.Config(10.0F, 10.0F, io.mavsdk.follow_me.FollowMe.Config.FollowDirection.NONE, 0.1F);
        followMe.setConfig(config);
        followMe.start();
        followMe.setTargetLocation(new io.mavsdk.follow_me.FollowMe.TargetLocation(47.39776569, 8.54553292, 0.0F, 0.0F, 0.0F, 0.0F));
    }
}

