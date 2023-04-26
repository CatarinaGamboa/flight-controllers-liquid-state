package com.liquidjava.flightcontrollers.examples.example3;


// io.reactivex.Completable	formatStorage()
// io.reactivex.Flowable<Camera.CaptureInfo>	getCaptureInfo()
// io.reactivex.Flowable<java.util.List<Camera.Setting>>	getCurrentSettings()
// io.reactivex.Flowable<Camera.Information>	getInformation()
// io.reactivex.Flowable<Camera.Mode>	getMode()
// io.reactivex.Flowable<java.util.List<Camera.SettingOptions>>	getPossibleSettingOptions()
// io.reactivex.Single<Camera.Setting>	getSetting​(Camera.Setting setting)
// io.reactivex.Flowable<Camera.Status>	getStatus()
// io.reactivex.Flowable<Camera.VideoStreamInfo>	getVideoStreamInfo()	 	//
// io.reactivex.Completable	prepare()
// io.reactivex.Completable	selectCamera​(java.lang.Integer cameraId)
// io.reactivex.Completable	setSetting​(Camera.Setting setting)
@liquidjava.specification.ExternalRefinementsFor("io.mavsdk.camera.Camera")
@liquidjava.specification.StateSet({ "camUninitialized", "camInitialized", "camModeSet", "camVideoMode", "camPhotoMode" })
public interface CameraRefinements {
    // Questions:
    // dispose goes from anything to unintialize
    // since there is startVideo and startVideoStream maybe we should have 2 states for video right?
    // it doesnt make sense to call startVideo and then stopVideoStreaming or does it?
    // and the same with PhotoMode, it does not make sense to call stopPhotoStreaming after takePhoto
    // listPhotos is in videoMode?
    // getVideoStreamInfo() should be videoMode no?
    // selectCamera(id) is not in any specific stage? and does Id need to be in a specific range?
    @liquidjava.specification.StateRefinement(to = "camUninitialized(this)")
    void Camera();

    @liquidjava.specification.StateRefinement(from = "camUninitialized(this)", to = "camInitialized(this)")
    void initialize();

    @liquidjava.specification.StateRefinement(from = "!camUninitialized(this)", to = "camUninitialized(this)")
    void dispose();

    @liquidjava.specification.StateRefinement(from = "camInitialized(this)", to = "camModeSet(this)")
    io.reactivex.Completable setMode​(io.mavsdk.camera.Camera.Mode mode);

    // Video
    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camVideoMode(this)")
    io.reactivex.Completable startVideo();

    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camVideoMode(this)")
    io.reactivex.Completable startVideoStreaming();

    @liquidjava.specification.StateRefinement(from = "camVideoMode(this)")
    io.reactivex.Single<java.util.List<io.mavsdk.camera.Camera.CaptureInfo>> listPhotos​(io.mavsdk.camera.Camera.PhotosRange photosRange);

    @liquidjava.specification.StateRefinement(from = "camVideoMode(this)", to = "camModeSet(this)")
    io.reactivex.Completable stopVideo();

    @liquidjava.specification.StateRefinement(from = "camVideoMode(this)", to = "camModeSet(this)")
    io.reactivex.Completable stopVideoStreaming();

    // Photos
    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camModeSet(this)")
    io.reactivex.Completable takePhoto();

    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camPhotoMode(this)")
    io.reactivex.Completable startPhotoInterval​(java.lang.Float intervalS);

    @liquidjava.specification.StateRefinement(from = "camPhotoMode(this)", to = "camModeSet(this)")
    io.reactivex.Completable stopPhotoInterval();
}

