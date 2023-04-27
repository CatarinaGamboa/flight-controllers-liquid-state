package com.liquidjava.flightcontrollers.examples.eval_mocap_1;

import java.util.ArrayList;
import java.util.List;

// https://discuss.px4.io/t/mavsdk-python-set-px4-local-position-with-mocap-commands/16792/2
import io.mavsdk.mocap.Mocap;
import io.mavsdk.mocap.Mocap.AngleBody;
import io.mavsdk.mocap.Mocap.AttitudePositionMocap;
import io.mavsdk.mocap.Mocap.Covariance;
import io.mavsdk.mocap.Mocap.PositionBody;
import io.mavsdk.mocap.Mocap.Quaternion;
import io.mavsdk.mocap.Mocap.VisionPositionEstimate;

public class TestMocap {
	public static void main(String[] args) {
		
		io.mavsdk.System drone = new io.mavsdk.System();

		Mocap mocap = drone.getMocap();

		Quaternion q = new Quaternion(0f, 0f, 0f, 0f);
		PositionBody position_body = new PositionBody(0f, 0f, 0f);

		List<Float> lf = new ArrayList<>();
		AttitudePositionMocap message = new AttitudePositionMocap(0l, q, position_body, new Covariance(lf));
		mocap.setAttitudePositionMocap(message);
		mocap.setVisionPositionEstimate(new VisionPositionEstimate(0l, position_body, new AngleBody(0f, 0f, 0f), new Covariance(lf)));
	}


}
