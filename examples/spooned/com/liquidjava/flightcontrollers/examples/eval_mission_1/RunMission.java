package com.liquidjava.flightcontrollers.examples.eval_mission_1;


// refer to https://github.com/mavlink/MAVSDK-Java/tree/main/examples/java-client/src/main/java/io/mavsdk/example
public class RunMission {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.class);

    public static void main(java.lang.String[] args) {
        com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.logger.debug("Starting example: mission...");
        io.mavsdk.System drone = new io.mavsdk.System();
        io.reactivex.Flowable<io.mavsdk.telemetry.Telemetry.FlightMode> flightmode = drone.getTelemetry().getFlightMode();
        com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.logger.debug(("flight mode: " + flightmode));
        java.util.List<io.mavsdk.mission.Mission.MissionItem> cycle = new java.util.ArrayList<>();
        cycle.add(com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.generateMissionItem(47.39803986, 8.54557254));
        cycle.add(com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.generateMissionItem(47.39803622236247, 8.545014643942551));
        cycle.add(com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.generateMissionItem(47.397825620791885, 8.545009283016327));
        cycle.add(com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.generateMissionItem(47.39783288, 8.545594));
        java.util.List<io.mavsdk.mission.Mission.MissionItem> missionItems = new java.util.ArrayList<>();
        for (int i = 0; i < 300; i++) {
            missionItems.addAll(cycle);
        }
        io.mavsdk.mission.Mission.MissionPlan missionPlan = new io.mavsdk.mission.Mission.MissionPlan(missionItems);
        java.lang.String s = java.lang.Integer.toString(missionItems.size());
        com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.logger.debug("About to upload ".concat(s).concat(" mission items"));
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
        io.mavsdk.mission.Mission mission = drone.getMission();
        mission.setReturnToLaunchAfterMission(true);
        mission.uploadMission(missionPlan);
        com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.logger.debug("Upload succeeded");
        mission.downloadMission();
        com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.logger.debug("Downloading mission");
        com.liquidjava.flightcontrollers.examples.eval_mission_1.RunMission.logger.debug("Mission downloaded");
    }

    public static io.mavsdk.mission.Mission.MissionItem generateMissionItem(double latitudeDeg, double longitudeDeg) {
        return new io.mavsdk.mission.Mission.MissionItem(latitudeDeg, longitudeDeg, 10.0F, 10.0F, true, java.lang.Float.NaN, java.lang.Float.NaN, io.mavsdk.mission.Mission.MissionItem.CameraAction.NONE, java.lang.Float.NaN, java.lang.Double.NaN, java.lang.Float.NaN, java.lang.Float.NaN, java.lang.Float.NaN);
    }
}

