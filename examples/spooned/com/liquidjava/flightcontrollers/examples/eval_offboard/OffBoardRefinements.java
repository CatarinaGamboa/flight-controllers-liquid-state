package com.liquidjava.flightcontrollers.examples.eval_offboard;


// io.reactivex.Single<java.lang.Boolean>	isActive()
// io.reactivex.Completable	setAccelerationNed​(Offboard.AccelerationNed accelerationNed)
// io.reactivex.Completable	setActuatorControl​(Offboard.ActuatorControl actuatorControl)
// io.reactivex.Completable	setAttitude​(Offboard.Attitude attitude)
// io.reactivex.Completable	setAttitudeRate​(Offboard.AttitudeRate attitudeRate)
// io.reactivex.Completable	setPositionGlobal​(Offboard.PositionGlobalYaw positionGlobalYaw)
// io.reactivex.Completable	setPositionNed​(Offboard.PositionNedYaw positionNedYaw)
// io.reactivex.Completable	setPositionVelocityNed​(Offboard.PositionNedYaw positionNedYaw, Offboard.VelocityNedYaw velocityNedYaw)
// io.reactivex.Completable	setVelocityBody​(Offboard.VelocityBodyYawspeed velocityBodyYawspeed)
// io.reactivex.Completable	setVelocityNed​(Offboard.VelocityNedYaw velocityNedYaw)
@liquidjava.specification.StateSet({ "uninitialized", "initialized", "enableSetPoint", "started" })
@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.offboard.Offboard")
public interface OffBoardRefinements {
    @liquidjava.specification.StateRefinement(to = "uninitialized(this)")
    public void OffBoard();

    @liquidjava.specification.StateRefinement(from = "uninitialized(this)", to = "initialized(this)")
    public void initialize();

    @liquidjava.specification.StateRefinement(from = "!uninitialized(this)", to = "uninitialized(this)")
    public void dispose();

    @liquidjava.specification.StateRefinement(from = "enableSetPoint(this)", to = "started(this)")
    public io.reactivex.Completable start();

    @liquidjava.specification.StateRefinement(from = "started(this)", to = "enableSetPoint(this)")
    public io.reactivex.Completable stop();

    @liquidjava.specification.StateRefinement(from = "initialized(this)", to = "enableSetPoint(this)")
    public io.reactivex.Completable setVelocityNed​(io.mavsdk.offboard.Offboard.VelocityNedYaw velocityNedYaw);

    @liquidjava.specification.StateRefinement(from = "initialized(this)", to = "enableSetPoint(this)")
    public io.reactivex.Completable setVelocityBody​(io.mavsdk.offboard.Offboard.VelocityBodyYawspeed velocityBodyYawspeed);

    @liquidjava.specification.StateRefinement(from = "started(this)", to = "started(this)")
    @liquidjava.specification.StateRefinement(from = "initialized(this)", to = "enableSetPoint(this)")
    public io.reactivex.Completable setPositionGlobal​(io.mavsdk.offboard.Offboard.PositionGlobalYaw positionGlobalYaw);

    @liquidjava.specification.StateRefinement(from = "started(this)", to = "started(this)")
    @liquidjava.specification.StateRefinement(from = "initialized(this)", to = "enableSetPoint(this)")
    io.reactivex.Completable setPositionNed​(io.mavsdk.offboard.Offboard.PositionNedYaw positionNedYaw);

    @liquidjava.specification.StateRefinement(from = "started(this)", to = "started(this)")
    @liquidjava.specification.StateRefinement(from = "initialized(this)", to = "enableSetPoint(this)")
    public io.reactivex.Completable setPositionVelocityNed​(io.mavsdk.offboard.Offboard.PositionNedYaw positionNedYaw, io.mavsdk.offboard.Offboard.VelocityNedYaw velocityNedYaw);

    @liquidjava.specification.StateRefinement(from = "started(this)")
    public io.reactivex.Completable setAccelerationNed​(io.mavsdk.offboard.Offboard.AccelerationNed accelerationNed);

    @liquidjava.specification.StateRefinement(from = "started(this)")
    public io.reactivex.Completable setActuatorControl​(io.mavsdk.offboard.Offboard.ActuatorControl actuatorControl);

    @liquidjava.specification.StateRefinement(from = "started(this)")
    public io.reactivex.Completable setAttitude​(io.mavsdk.offboard.Offboard.Attitude attitude);

    @liquidjava.specification.StateRefinement(from = "started(this)")
    public io.reactivex.Completable setAttitudeRate​(io.mavsdk.offboard.Offboard.AttitudeRate attitudeRate);
}

