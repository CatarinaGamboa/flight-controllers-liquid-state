package com.liquidjava.flightcontrollers.examples.eval_followme_1;

import io.mavsdk.follow_me.FollowMe;
import io.mavsdk.follow_me.FollowMe.Config;
import io.mavsdk.follow_me.FollowMe.Config.FollowDirection;
// https://github.com/mavlink/MAVSDK/blob/main/examples/follow_me/follow_me.cpp
//https://github.com/mavlink/MAVSDK/blob/main/examples/follow_me/follow_me.cpp
//https://raw.githubusercontent.com/mavlink/MAVSDK/main/examples/follow_me/follow_me.cpp
import io.mavsdk.follow_me.FollowMe.TargetLocation;


public class TestFollowMe {


	public static void main(String[] args) {
		FollowMe followMe = new FollowMe();
		followMe.initialize();
		followMe.getLastLocation();//Error should be in state fmModeStarted

		Config config = new Config( 10.0f, 10.0f,  FollowDirection.NONE, 0.1f);
		followMe.setConfig(config);

		followMe.start();
		followMe.setTargetLocation(new TargetLocation(47.39776569, 8.54553292, 0.0f, 0.0f, 0.0f, 0.0f));

	}
}

