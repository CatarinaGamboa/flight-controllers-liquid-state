package com.liquidjava.flightcontrollers.examples;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.Permission;

import org.junit.Test;

import liquidjava.api.CommandLineLauncher;

/**
 * Unit test for simple App.
 */
public class TestCustomExamples {

	String testPath = "./src/test/java/com/liquidjava/flightcontrollers/examples/";
	AppTests at = new AppTests();


	@Test
	public void correctMissionController() {
		at.testCorrect(testPath + "mission_controller1");
	} 

	@Test
	public void errorMissionController() {
		at.testError(testPath + "mission_controller2");
	} 

	@Test
	public void correctGeofence() {
		at.testCorrect(testPath + "geofence1");
	} 

	@Test
	public void errorMissionGeofence() {
		at.testError(testPath + "geofence2");
	} 


	@Test
	public void correctOffboard() {
		at.testCorrect(testPath + "offboard1");
	} 

	@Test
	public void errorOffboard() {
		at.testError(testPath + "offboard2");
	} 

	@Test
	public void errorOffboard2() {
		at.testError(testPath + "offboard3");
	} 


	@Test
	public void correctCamera() {
		at.testCorrect(testPath + "camera1");
	} 


	@Test
	public void errorCamera() {
		at.testError(testPath + "camera2");
	} 


	@Test
	public void correctFollowMe() {
		at.testCorrect(testPath + "followme1");
	} 


	@Test
	public void errorFollowMe() {
		at.testError(testPath + "followme2");
	} 

	@Test
	public void correctMocap() {
		at.testCorrect(testPath + "mocap1");
	} 


	@Test
	public void errorMocap() {
		at.testError(testPath + "mocap2");
	} 


}
