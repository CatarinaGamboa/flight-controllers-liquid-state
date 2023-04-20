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

    protected void testCorrect(String filename) {
        MySecurityManager secManager = new MySecurityManager();
        System.setSecurityManager(secManager);
        try {
            CommandLineLauncher.launchTest(filename);
        } catch (SecurityException e) {
            fail();
        }
    }

    protected void testWrong(String filename) {
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
