package com.liquidjava.flightcontrollers.examples;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestEval {

	String testPath = "./src/test/java/com/liquidjava/flightcontrollers/examples/";
	AppTests at = new AppTests();

	//---------- Evaluation ------------

	@Test
	public void correctEvalMission1() {
		at.testCorrect(testPath + "eval_mission_1");
	} 


	@Test
	public void errorEvalCamera1() {
		at.testError(testPath + "eval_camera_1");
	} 


	@Test
	public void errorEvalCamera2() {
		at.testError(testPath + "eval_camera_2");
	} 

	@Test
	public void errorEvalFtp() {
		at.testError(testPath + "eval_ftp_1");
	} 


	@Test
	public void correctEvalOffBoard() {
		at.testCorrect(testPath + "eval_offboard");
	} 

	@Test
	public void errorEvalFollowMe() {
		at.testError(testPath + "eval_followme_1");
	} 

	@Test
	public void correctEvalGeofence() {
		at.testCorrect(testPath + "eval_geofence");
	} 

	@Test
	public void correctEvalMocap() {
		at.testCorrect(testPath + "eval_mocap");
	} 

	@Test
	public void correctEvalMission2() {
		at.testCorrect(testPath + "eval_mission_2");
	} 







}
