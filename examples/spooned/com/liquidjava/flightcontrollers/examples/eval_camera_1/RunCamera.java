package com.liquidjava.flightcontrollers.examples.eval_camera_1;


// refer to https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example
public class RunCamera {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.liquidjava.flightcontrollers.examples.eval_camera_1.RunCamera.class);

    public static void main(java.lang.String[] args) {
        com.liquidjava.flightcontrollers.examples.eval_camera_1.RunCamera.logger.debug("Starting example: camera...");
        io.mavsdk.System drone = new io.mavsdk.System();
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
        io.mavsdk.camera.Camera camera = drone.getCamera();
        // camera.setMode(Camera.Mode.PHOTO);//not in retrieved code
        camera.getCaptureInfo().subscribe(( captureInfo) -> com.liquidjava.flightcontrollers.examples.eval_camera_1.RunCamera.logger.debug(captureInfo.getFileUrl()));
        camera.takePhoto();
        com.liquidjava.flightcontrollers.examples.eval_camera_1.RunCamera.logger.debug("Taking a photo...");
        camera.takePhoto();
    }
}

