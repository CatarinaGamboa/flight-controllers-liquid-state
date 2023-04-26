package com.liquidjava.flightcontrollers.examples;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.Permission;

import org.junit.Test;

import liquidjava.api.CommandLineLauncher;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	 String testPath = "./src/test/java/com/liquidjava/flightcontrollers/examples/";
   
	 
	 
    @Test
    public void correctMissionController() {
        testCorrect(testPath + "mission_controller1");
    } 
    
    @Test
    public void errorMissionController() {
        testError(testPath + "mission_controller2");
    } 
    
    @Test
    public void correctGeofence() {
        testCorrect(testPath + "geofence1");
    } 
    
    @Test
    public void errorMissionGeofence() {
        testError(testPath + "geofence2");
    } 
    
    
    @Test
    public void correctOffboard() {
        testCorrect(testPath + "offboard1");
    } 
    
    @Test
    public void errorOffboard() {
        testError(testPath + "offboard2");
    } 
    
    @Test
    public void errorOffboard2() {
        testError(testPath + "offboard3");
    } 
    
    
    @Test
    public void correctCamera() {
        testCorrect(testPath + "camera1");
    } 
    
    
    @Test
    public void errorCamera() {
        testError(testPath + "camera2");
    } 
    
    
    @Test
    public void correctFollowMe() {
        testCorrect(testPath + "followme1");
    } 
    
    
    @Test
    public void errorFollowMe() {
        testError(testPath + "followme2");
    } 
    
    @Test
    public void correctMocap() {
        testCorrect(testPath + "mocap1");
    } 
    
    
    @Test
    public void errorMocap() {
        testError(testPath + "mocap2");
    } 
    
    
    
    @Test
    public void correctEvalMission1() {
        testCorrect(testPath + "eval_mission_1");
    } 
    
    
    @Test
    public void errorEvalCamera1() {
    	testError(testPath + "eval_camera_1");
    } 
    
    
    @Test
    public void errorEvalCamera2() {
    	testError(testPath + "eval_camera_2");
    } 
    
    @Test
    public void correctEvalFtp() {
        testCorrect(testPath + "eval_ftp_1");
    } 
    
    

    protected void testCorrect(String filename) {
        MySecurityManager secManager = new MySecurityManager();
        System.setSecurityManager(secManager);
        try {
            CommandLineLauncher.launchTest(filename);
        } catch (SecurityException e) {
            fail();
        }
    }

    protected void testError(String filename) {
        MySecurityManager secManager = new MySecurityManager();
        System.setSecurityManager(secManager);
        try {
            CommandLineLauncher.launchTest(filename);
        } catch (SecurityException e) {
            return;
        }
        fail();
    }

    class MySecurityManager extends SecurityManager {
        // Handles exit(1) when the refinements are not respected
        @Override
        public void checkExit(int status) {
            if (status == 1 || status == 2)
                throw new SecurityException("subtyping");
        }

        @Override
        public void checkPermission(Permission perm) {
            // Allow other activities by default
        }
    }
	
	
	

}
