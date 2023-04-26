package com.liquidjava.flightcontrollers.examples.eval_camera_2;


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
@liquidjava.specification.StateSet({ "camUninitialized", "camInitialized", "camModeSet", "camVideoMode", "camVideoStreamingMode", "camPhotoIntervalMode" })
public interface CameraRefinements {
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

    @liquidjava.specification.StateRefinement(from = "camVideoMode(this)", to = "camModeSet(this)")
    io.reactivex.Completable stopVideo();

    // Video Streaming
    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camVideoStreamingMode(this)")
    io.reactivex.Completable startVideoStreaming();

    @liquidjava.specification.StateRefinement(from = "camVideoStreamingMode(this)", to = "camModeSet(this)")
    io.reactivex.Completable stopVideoStreaming();

    // Photos
    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camModeSet(this)")
    io.reactivex.Completable takePhoto();

    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camModeSet(this)")
    io.reactivex.Completable selectCamera​(java.lang.Integer cameraId);

    // Photo Interval
    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camPhotoIntervalMode(this)")
    io.reactivex.Completable startPhotoInterval​(java.lang.Float intervalS);

    @liquidjava.specification.StateRefinement(from = "camPhotoIntervalMode(this)", to = "camModeSet(this)")
    io.reactivex.Completable stopPhotoInterval();

    @liquidjava.specification.StateRefinement(from = "camPhotoIntervalMode(this)", to = "camPhotoIntervalMode(this)")
    @liquidjava.specification.StateRefinement(from = "camModeSet(this)", to = "camModeSet(this)")
    io.reactivex.Single<java.util.List<io.mavsdk.camera.Camera.CaptureInfo>> listPhotos​(io.mavsdk.camera.Camera.PhotosRange photosRange);
}

